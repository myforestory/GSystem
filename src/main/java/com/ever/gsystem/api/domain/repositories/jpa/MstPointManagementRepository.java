package com.ever.gsystem.api.domain.repositories.jpa;

import com.ever.gsystem.api.domain.entities.MstPointManagement;
import com.ever.gsystem.api.domain.repositories.fieldinfo.EntityFiledInfo;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@linkplain MstPointManagement PointManagementMst} Repository.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Repository // Make it a repository layer class in SpringMVC
public interface MstPointManagementRepository extends JpaRepository<MstPointManagement, Long> {
    /** {@linkplain MstPointManagement MstPointManagement} entities. */
    FiledControllable ENTITY_FILED_INFO = new EntityFiledInfo<>(MstPointManagement.class);

    /**
     * PointManagementMst檢索 ：pointManagementId.
     * <p>
     * {@link MstPointManagement PointManagementMst}テーブルを、1レコード取得する。
     * </p>
     *
     * @param  pointManagementId 欲檢索的pointManagementId
     * @return        檢索結果。{@link MstPointManagement}回傳物件
     */
    MstPointManagement findFirstByPointManagementId(String pointManagementId);
}
