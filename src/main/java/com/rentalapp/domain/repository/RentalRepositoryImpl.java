package com.rentalapp.domain.repository;

import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.infrastructure.helper.TRentalHistoryHelperImpl;
import com.rentalapp.infrastructure.mapper.BookMapper;
import com.rentalapp.infrastructure.mapper.RentalMapper;
import com.rentalapp.infrastructure.model.TBookModel;
import com.rentalapp.infrastructure.model.TRentalModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepositoryImpl implements RentalRepository {
    private final RentalMapper rentalMapper;
    private final BookMapper bookMapper;
    private final TRentalHistoryHelperImpl helper;

    @Override
    public int doRental(RentalInfo info) {
        /* ローカル変数準備 */
        Integer customerId = info.getCustomerId(); // パラメータから顧客IDを取得。
        List<Integer> bookIds = info.getBookIds(); // パラメータから本IDを取得。
        LocalDateTime now = LocalDateTime.now(); // 現在時刻を取得。
        final int STATUS_RENTAL = 1; // レンタル中。

        // リクエスト内の本IDの数だけ履歴情報を作成しDBに登録する。
        bookIds.forEach(e -> {
                    // 対象の本のレンタル期間を取得
                    int rentalPeriod = 7; // TODO 本によってレンタル期間を可変にする。

                    // 履歴情報作成・追加
                    var rental = TRentalModel.builder()
                            .customerId(customerId)
                            .bookId(e)
                            .rentalStartDate(now)
                            .scheduledReturnDate(now.plusDays(rentalPeriod))
                            .build();
                    rentalMapper.insert(rental);

                    // 対象本ステータスをレンタル中に変更
                    var book = TBookModel.builder()
                            .id(e)
                            .status(STATUS_RENTAL)
                            .updateDate(now).build();
                    bookMapper.updateByPrimaryKeySelective(book);
                }
        );

        return 0;
    }

    @Override
    public List<String> doReturn(RentalInfo info) {
        List<Integer> rentalId = info.getRentalId();
        List<String> messageList = new ArrayList<>(); // 返却メッセージ用リスト
        LocalDateTime now = LocalDateTime.now();
        final int STATUS_IN_STOCK = 0; // 在庫あり。

        // リクエスト内のレンタルIDの数だけ以下を実行する。
        rentalId.forEach(e -> {
            /* レンタルテーブル更新 */
            var retunModel = TRentalModel.builder()
                    .id(e)
                    .returnCompletionDate(now)
                    .build();
            int returnNum = rentalMapper.doReturn(retunModel);

            if (returnNum > 0) {
                /* 本テーブル更新 */
                Integer bookId = rentalMapper.select(e).getBookId(); // 対象レンタル情報に紐づく本IDを取得する
                var book = TBookModel.builder()
                        .id(bookId)
                        .status(STATUS_IN_STOCK)
                        .updateDate(now)
                        .build();
                bookMapper.updateByPrimaryKeySelective(book);

                // 返却完了メッセージをメッセージに追加
                messageList.add("返却処理が完了しました。");
            } else {
                // レンタルテーブルの更新件数が０件の場合、レンタル処理を行わない旨をメッセージに追加
                messageList.add("返却済み、または対象レンタル情報がありません。対象レンタルID【" + e + "】");
            }
        });
        return messageList;
    }
}
