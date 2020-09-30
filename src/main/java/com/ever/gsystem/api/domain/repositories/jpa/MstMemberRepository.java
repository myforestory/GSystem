package com.ever.gsystem.api.domain.repositories.jpa;

import com.ever.gsystem.api.domain.entities.MstMember;
import com.ever.gsystem.api.domain.repositories.fieldinfo.EntityFiledInfo;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@linkplain MstMember MemberMst} Repository.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Repository // Make it a repository layer class in SpringMVC
public interface MstMemberRepository extends JpaRepository<MstMember, Long> {
    /** {@linkplain MstMember MstMember} entities. */
    FiledControllable ENTITY_FILED_INFO = new EntityFiledInfo<>(MstMember.class);

    /**
     * MemberMst檢索 ：memberId.
     * <p>
     * {@link MstMember MemberMst}テーブルを、1レコード取得する。
     * </p>
     *
     * @param  memberId 欲檢索的memberId
     * @return        檢索結果。{@link MstMember}回傳物件
     */
    MstMember findFirstByMemberId(String memberId);
}
