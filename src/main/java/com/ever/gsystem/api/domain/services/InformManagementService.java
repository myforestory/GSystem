package com.ever.gsystem.api.domain.services;

import com.ever.gsystem.api.controllers.msg.requests.InformManagementFindRequest;
import com.ever.gsystem.api.controllers.msg.requests.InformManagementMultiRequest;
import com.ever.gsystem.api.controllers.msg.requests.InformManagementSingleRequest;
import com.ever.gsystem.api.controllers.msg.responses.InformManagementFindResponse;
import com.ever.gsystem.api.controllers.msg.responses.InformManagementSingleResponse;
import com.ever.gsystem.api.domain.entities.MstInformManagement;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions.TableCondition;
import com.ever.gsystem.api.domain.repositories.jpa.MstInformManagementRepository;
import com.ever.gsystem.api.domain.repositories.mabatis.MstInformManagementRepositoryMybatis;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 訊息類別管理Master畫面SERVICE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor    // Automatically generate a constructor with arguments to set values in required fields (final fields) in Lombok
@ToString                   // Automatically generate toString with Lombok
@Service                    // Make it a service layer class in Spring MVC
public class InformManagementService {
    /** InformManagementMaster Repository（Mybatis）. */
    final private MstInformManagementRepositoryMybatis<InformManagementFindRequest> mstInformManagementRepositoryMyb;
    /** InformManagementMaster Repository. */
    final private MstInformManagementRepository mstInformManagementRepository;

    /** [共通]Table管理Master Service. */
    final private TableManagementSharedService tableManagementSharedService;

    /**
     * 檢索.
     * <ol type="1">
     * <li>先取出Request Message Sort的條件，再追加Primary Key。</li>
     * <li>{@link MstInformManagement InformManagementMaster}用Mybatis來檢索Table。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    public InformManagementFindResponse find(final InformManagementFindRequest req) {
        // [MySQL-specific] If the ORDER BY key is not a unique key, the order is not guaranteed, so put the primary key at the end. ================================
        final InformManagementFindRequest plusReq;
        if (req == null) {
            plusReq = new InformManagementFindRequest();
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
        sorts.add(MstInformManagement.Fields.informManagementId);
        // ==============================================================================================================================================

        // 用從Table管理畫面的Get Request來做成檢索條件
        final TableCondition<InformManagementFindRequest> condition = new TableCondition<>(plusReq,  // Use the request message as the source of SQL conditions
                this.tableManagementSharedService.findByTableNo(MstInformManagement.class),  // Get table information of master from table management master
                MstInformManagementRepositoryMybatis.ENTITY_FILED_INFO);                     // Entity field information

        // 檢索＆Response做成
        return InformManagementFindResponse.builder()
                .mstInformManagement(this.mstInformManagementRepositoryMyb.selectAll(condition))
                .mstTableManagement(condition.getTm()).build();
    }

    /**
     * 新增 or 更新.
     * <ol type="1">
     * <li>{@link MstInformManagement InformManagementMaster}對Table中的一筆資料進行更新。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    @Transactional
    public InformManagementSingleResponse save(final InformManagementSingleRequest req) {
        // 更新＆Response做成
        final InformManagementSingleResponse res = InformManagementSingleResponse.builder()
                .mstInformManagement(this.mstInformManagementRepository.save(req.getMstInformManagement()))  // InformManagementMaster中一筆資料更新
                .build();
        this.mstInformManagementRepository.flush();
        return res;
    }

    /**
     * 刪除.
     * <ol type="1">
     * <li>{@link MstInformManagement InformManagementMaster}對Table中的一筆資料進行刪除。</li>
     * </ol>
     *
     * @param req RequestMessage
     */
    @Transactional
    public void delete(final InformManagementMultiRequest req) {
        // 刪除
        this.mstInformManagementRepository.deleteInBatch(req.getMstInformManagement());
    }
}
