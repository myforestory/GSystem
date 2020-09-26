package com.ever.gsystem.api.domain.repositories.jpa;

import com.ever.gsystem.api.domain.entities.MstInform;
import com.ever.gsystem.api.domain.repositories.fieldinfo.EntityFiledInfo;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@linkplain MstInform InformMst} Repository.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Repository // Make it a repository layer class in SpringMVC
public interface MstInformRepository extends JpaRepository<MstInform, Long> {
    /** {@linkplain MstInform MstInform} entities. */
    FiledControllable ENTITY_FILED_INFO = new EntityFiledInfo<>(MstInform.class);

    /**
     * InformMst檢索 ：informId.
     * <p>
     * {@link MstInform InformMst}テーブルを、1レコード取得する。
     * </p>
     *
     * @param  informId 欲檢索的informId
     * @return        檢索結果。{@link MstInform}回傳物件
     */
    MstInform findFirstByInformId(String informId);
}
