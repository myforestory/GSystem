package com.ever.gsystem.api.domain.repositories.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ever.gsystem.api.domain.entities.MstTableManagement;

/**
 * {@linkplain MstTableManagement テーブル管理マスタ}リポジトリ.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/10/03
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Repository // Spring MVCでリポジトリ層のクラスとする
public interface MstTableManagementRepository extends JpaRepository<MstTableManagement, MstTableManagement.PrimaryKeys> {
    /**
     * テーブル管理マスタ テーブル番号検索＆項目順序列ソート.
     * <p>
     * {@link MstTableManagement テーブル管理マスタ}テーブルを、複数レコード取得する。
     * </p>
     *
     * @param  tableNo 検索したいテーブル番号
     * @return         検索結果。{@link MstTableManagement テーブル管理マスタ}テーブルの複数レコード
     */
    List<MstTableManagement> findByTableNoOrderByItemOrderAsc(final String tableNo);
}

