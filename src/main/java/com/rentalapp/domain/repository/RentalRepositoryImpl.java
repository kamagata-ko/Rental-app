package com.rentalapp.domain.repository;

import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.infrastructure.helper.TRentalHistoryHelperImpl;
import com.rentalapp.infrastructure.mapper.BookMapper;
import com.rentalapp.infrastructure.mapper.RentalHistoryMapper;
import com.rentalapp.infrastructure.model.TBookModel;
import com.rentalapp.infrastructure.model.TRentalHistoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepositoryImpl implements RentalRepository {
    private final RentalHistoryMapper rentalHistoryMapper;
    private final BookMapper bookMapper;
    private final TRentalHistoryHelperImpl helper;

    @Override
    public int doRental(RentalInfo info) {
        /* ローカル変数準備 */
        Integer customerId = info.getCustomerId(); // パラメータから顧客IDを取得。
        List<Integer> bookIds = info.getBookId(); // パラメータから本IDを取得。
        LocalDateTime now = LocalDateTime.now(); // 現在時刻を取得。
        final int STATUS_RENTAL = 1; // レンタル中。

        // リクエスト内の本IDの数だけ履歴情報を作成しDBに登録する。
        for (Integer bookId : bookIds) {
            // 履歴情報作成・追加
            TRentalHistoryModel model = new TRentalHistoryModel();
            model.setCustomerId(customerId);
            model.setBookId(bookId);
            model.setRentalStartDate(now);
            model.setScheduledReturnDate(now); // TODO 返却予定日を１週間後とかにする。（本テーブルに情報持たせてもいいかも）

            rentalHistoryMapper.insert(model);

            // 本ステータスをレンタル中に変更
            TBookModel bm = new TBookModel();
            bm.setId(bookId);
            bm.setStatus(STATUS_RENTAL);
            bm.setUpdateDate(now);

            bookMapper.updateByPrimaryKeySelective(bm);
        }

        return 0;
    }
}
