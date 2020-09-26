package com.ever.gsystem.api.domain.repositories.jpa;

import com.ever.gsystem.api.domain.entities.MstInformManagement;
import com.ever.gsystem.api.domain.repositories.fieldinfo.EntityFiledInfo;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@linkplain MstInformManagement InformManagementMst} Repository.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Repository // Make it a repository layer class in SpringMVC
public interface MstInformManagementRepository extends JpaRepository<MstInformManagement, MstInformManagement.PrimaryKeys> {
    /** {@linkplain MstInformManagement MstInformManagement} entities. */
    FiledControllable ENTITY_FILED_INFO = new EntityFiledInfo<>(MstInformManagement.class);

    /**
     * InformManagementMst檢索 ：informManagementId.
     * <p>
     * {@link MstInformManagement InformManagementMst}テーブルを、1レコード取得する。
     * </p>
     *
     * @param  informManagementId 欲檢索的informManagementId
     * @return        檢索結果。{@link MstInformManagement}回傳物件
     */
    MstInformManagement findFirstByInformManagementId(String informManagementId);
}
