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
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepositoryImpl implements RentalRepository {
    private final RentalMapper rentalHistoryMapper;
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
        for (Integer bookId : bookIds) {
            // 対象の本のレンタル期間を取得
            int rentalPeriod = 7; // TODO 本によってレンタル期間を可変にする。

            // 履歴情報作成・追加
            TRentalModel rhm = TRentalModel.builder()
                    .customerId(customerId)
                    .bookId(bookId)
                    .rentalStartDate(now)
                    .scheduledReturnDate(now.plusDays(rentalPeriod))
                    .build();

            rentalHistoryMapper.insert(rhm);

            // 対象本ステータスをレンタル中に変更
            TBookModel bm = TBookModel.builder()
                    .id(bookId)
                    .status(STATUS_RENTAL)
                    .updateDate(now)
                    .build();

            bookMapper.updateByPrimaryKeySelective(bm);
        }

        return 0;
    }
}
