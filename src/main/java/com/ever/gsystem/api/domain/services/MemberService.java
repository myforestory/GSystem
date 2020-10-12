package com.ever.gsystem.api.domain.services;

import com.ever.gsystem.api.controllers.msg.requests.MemberFindRequest;
import com.ever.gsystem.api.controllers.msg.requests.MemberMultiRequest;
import com.ever.gsystem.api.controllers.msg.requests.MemberSingleRequest;
import com.ever.gsystem.api.controllers.msg.responses.MemberFindResponse;
import com.ever.gsystem.api.controllers.msg.responses.MemberSingleResponse;
import com.ever.gsystem.api.domain.entities.MstMember;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions.TableCondition;
import com.ever.gsystem.api.domain.repositories.jpa.MstMemberRepository;
import com.ever.gsystem.api.domain.repositories.mabatis.MstMemberRepositoryMybatis;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 會員Master畫面SERVICE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor    // Automatically generate a constructor with arguments to set values in required fields (final fields) in Lombok
@ToString                   // Automatically generate toString with Lombok
@Service                    // Make it a service layer class in Spring MVC
public class MemberService {
    /** MemberMaster Repository（Mybatis）. */
    final private MstMemberRepositoryMybatis<MemberFindRequest> mstMemberRepositoryMyb;
    /** MemberMaster Repository. */
    final private MstMemberRepository mstMemberRepository;

    /** [共通]Table管理Master Service. */
    final private TableManagementSharedService tableManagementSharedService;

    /**
     * 檢索.
     * <ol type="1">
     * <li>先取出Request Message Sort的條件，再追加Primary Key。</li>
     * <li>{@link MstMember MemberMaster}用Mybatis來檢索Table。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    public MemberFindResponse find(final MemberFindRequest req) {
        // [MySQL-specific] If the ORDER BY key is not a unique key, the order is not guaranteed, so put the primary key at the end. ================================
        final MemberFindRequest plusReq;
        if (req == null) {
            plusReq = new MemberFindRequest();
        } else {
            plusReq = req;
        }
        final List<String> sorts;
        if (plusReq.getSort() == null) {
            sorts = new ArrayList<>();
            plusReq.setSort(sorts);
        } else {
            sorts = plusReq.getSort();
        }
        sorts.add(MstMember.Fields.memberId);
        // ==============================================================================================================================================

        // 用從Table管理畫面的Get Request來做成檢索條件
        final TableCondition<MemberFindRequest> condition = new TableCondition<>(plusReq,  // Use the request message as the source of SQL conditions
                this.tableManagementSharedService.findByTableNo(MstMember.class),  // Get table information of master from table management master
                MstMemberRepositoryMybatis.ENTITY_FILED_INFO);                     // Entity field information

        // 檢索＆Response做成
        return MemberFindResponse.builder()
                .mstMember(this.mstMemberRepositoryMyb.selectAll(condition))
                .mstTableManagement(condition.getTm()).build();
    }

    /**
     * 新增 or 更新.
     * <ol type="1">
     * <li>{@link MstMember MemberMaster}對Table中的一筆資料進行更新。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    @Transactional
    public MemberSingleResponse save(final MemberSingleRequest req) {
        String memberId = req.getMstMember().getMemberType() +";"+ req.getMstMember().getMemberAccount();
        req.setMstMember(req.getMstMember().setMemberId(memberId));
        // 更新＆Response做成
        final MemberSingleResponse res = MemberSingleResponse.builder()
                .mstMember(this.mstMemberRepository.save(req.getMstMember()))  // MemberMaster中一筆資料更新
                .build();
        this.mstMemberRepository.flush();
        return res;
    }

    /**
     * 刪除.
     * <ol type="1">
     * <li>{@link MstMember MemberMaster}對Table中的一筆資料進行刪除。</li>
     * </ol>
     *
     * @param req RequestMessage
     */
    @Transactional
    public void delete(final MemberMultiRequest req) {
        // 刪除
        this.mstMemberRepository.deleteInBatch(req.getMstMember());
    }
}
