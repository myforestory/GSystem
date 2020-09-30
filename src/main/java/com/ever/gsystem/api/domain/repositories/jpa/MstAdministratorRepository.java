package com.ever.gsystem.api.domain.repositories.jpa;

import com.ever.gsystem.api.domain.entities.MstAdministrator;
import com.ever.gsystem.api.domain.repositories.fieldinfo.EntityFiledInfo;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@linkplain MstAdministrator AdministratorMst} Repository.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Repository // Make it a repository layer class in SpringMVC
public interface MstAdministratorRepository extends JpaRepository<MstAdministrator, Long> {
    /** {@linkplain MstAdministrator MstAdministrator} entities. */
    FiledControllable ENTITY_FILED_INFO = new EntityFiledInfo<>(MstAdministrator.class);

    /**
     * AdministratorMst檢索 ：administratorId.
     * <p>
     * {@link MstAdministrator AdministratorMst}テーブルを、1レコード取得する。
     * </p>
     *
     * @param  administratorId 欲檢索的administratorId
     * @return        檢索結果。{@link MstAdministrator}回傳物件
     */
    MstAdministrator findFirstByAdministratorId(String administratorId);
}
