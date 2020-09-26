package com.ever.gsystem.api.domain.services;

import com.ever.gsystem.api.controllers.msg.requests.InformFindRequest;
import com.ever.gsystem.api.controllers.msg.requests.InformMultiRequest;
import com.ever.gsystem.api.controllers.msg.requests.InformSingleRequest;
import com.ever.gsystem.api.controllers.msg.responses.InformFindResponse;
import com.ever.gsystem.api.controllers.msg.responses.InformSingleResponse;
import com.ever.gsystem.api.domain.entities.MstInform;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions.TableCondition;
import com.ever.gsystem.api.domain.repositories.jpa.MstInformRepository;
import com.ever.gsystem.api.domain.repositories.mabatis.MstInformRepositoryMybatis;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知消息Master畫面SERVICE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor    // Automatically generate a constructor with arguments to set values in required fields (final fields) in Lombok
@ToString                   // Automatically generate toString with Lombok
@Service                    // Make it a service layer class in Spring MVC
public class InformService {
    /** InformMaster Repository（Mybatis）. */
    final private MstInformRepositoryMybatis<InformFindRequest> mstInformRepositoryMyb;
    /** InformMaster Repository. */
    final private MstInformRepository mstInformRepository;

    /** [共通]Table管理Master Service. */
    final private TableManagementSharedService tableManagementSharedService;

    /**
     * 檢索.
     * <ol type="1">
     * <li>先取出Request Message Sort的條件，再追加Primary Key。</li>
     * <li>{@link MstInform InformMaster}用Mybatis來檢索Table。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    public InformFindResponse find(final InformFindRequest req) {
        // [MySQL-specific] If the ORDER BY key is not a unique key, the order is not guaranteed, so put the primary key at the end. ================================
        final InformFindRequest plusReq;
        if (req == null) {
            plusReq = new InformFindRequest();
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
        sorts.add(MstInform.Fields.informId);
        // ==============================================================================================================================================

        // 用從Table管理畫面的Get Request來做成檢索條件
        final TableCondition<InformFindRequest> condition = new TableCondition<>(plusReq,  // Use the request message as the source of SQL conditions
                this.tableManagementSharedService.findByTableNo(MstInform.class),  // Get table information of master from table management master
                MstInformRepositoryMybatis.ENTITY_FILED_INFO);                     // Entity field information

        // 檢索＆Response做成
        return InformFindResponse.builder()
                .mstInform(this.mstInformRepositoryMyb.selectAll(condition))
                .mstTableManagement(condition.getTm()).build();
    }

    /**
     * 新增 or 更新.
     * <ol type="1">
     * <li>{@link MstInform InformMaster}對Table中的一筆資料進行更新。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    @Transactional
    public InformSingleResponse save(final InformSingleRequest req) {
        // 更新＆Response做成
        final InformSingleResponse res = InformSingleResponse.builder()
                .mstInform(this.mstInformRepository.save(req.getMstInform()))  // InformMaster中一筆資料更新
                .build();
        this.mstInformRepository.flush();
        return res;
    }

    /**
     * 刪除.
     * <ol type="1">
     * <li>{@link MstInform InformMaster}對Table中的一筆資料進行刪除。</li>
     * </ol>
     *
     * @param req RequestMessage
     */
    @Transactional
    public void delete(final InformMultiRequest req) {
        // 刪除
        this.mstInformRepository.deleteInBatch(req.getMstInform());
    }
}
