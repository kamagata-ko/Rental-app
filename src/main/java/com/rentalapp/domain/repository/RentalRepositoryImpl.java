package com.rentalapp.domain.repository;

import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.domain.model.RentalBooksModel;
import com.rentalapp.exception.DomainException;
import com.rentalapp.infrastructure.helper.TBookModelHelperImpl;
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
    private final TBookModelHelperImpl bookModelHelper;

    @Override
    public int doRental(RentalInfo info) {
        /* ローカル変数準備 */
        Integer customerId = info.getCustomerId(); // パラメータから顧客IDを取得。
        List<Integer> bookIds = info.getBookIds(); // パラメータから本IDを取得。
        LocalDateTime now = LocalDateTime.now(); // 現在時刻を取得。
        final int STATUS_RENTAL = 1; // レンタル中。

        if (customerId == 1) throw new DomainException("現在借りている本が１０冊以上のためこれ以上借りれません。"); // TODO サンプル。

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
    public void doReturn(RentalInfo info) {
        List<Integer> rentalId = info.getRentalId();
        LocalDateTime now = LocalDateTime.now();
        final int STATUS_IN_STOCK = 0; // 在庫あり。

        // リクエスト内のレンタルIDの数だけ以下を実行する。
        rentalId.forEach(e -> {
            /* レンタルテーブル更新 */
            var model = TRentalModel.builder()
                    .id(e)
                    .returnCompletionDate(now)
                    .build();
            rentalMapper.doReturn(model);

            // 本テーブル更新
            Integer bookId = rentalMapper.select(e).getBookId(); // 対象レンタル情報に紐づく本IDを取得する
            var book = TBookModel.builder()
                    .id(bookId)
                    .status(STATUS_IN_STOCK)
                    .updateDate(now)
                    .build();
            bookMapper.updateByPrimaryKeySelective(book);
        });
    }

    @Override
    public List<RentalBooksModel> fetchRentingBooks(Integer customerId) {
        // 顧客IDからレンタル情報を取得
        List<TRentalModel> tRentalModels = rentalMapper.selectByCustomerId(Integer.toString(customerId));

        // 取得したレンタル情報内の本IDから本の情報を取得しレンタルしている本の情報を取得
        List<RentalBooksModel> rbModels = new ArrayList<>();
        tRentalModels.forEach(e -> {
            RentalBooksModel rbModel = RentalBooksModel.builder()
                    .rentalId(e.getId())
                    .bookModel(bookModelHelper.toModel(bookMapper.selectOne(e.getBookId())))
                    .build();

            rbModels.add(rbModel);
        });
        return rbModels;
    }
}
