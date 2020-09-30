package com.ever.gsystem.api.domain.services;

import com.ever.gsystem.api.controllers.msg.requests.PointManagementFindRequest;
import com.ever.gsystem.api.controllers.msg.requests.PointManagementMultiRequest;
import com.ever.gsystem.api.controllers.msg.requests.PointManagementSingleRequest;
import com.ever.gsystem.api.controllers.msg.responses.PointManagementFindResponse;
import com.ever.gsystem.api.controllers.msg.responses.PointManagementSingleResponse;
import com.ever.gsystem.api.domain.entities.MstPointManagement;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions.TableCondition;
import com.ever.gsystem.api.domain.repositories.jpa.MstPointManagementRepository;
import com.ever.gsystem.api.domain.repositories.mabatis.MstPointManagementRepositoryMybatis;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 點數管理Master畫面SERVICE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor    // Automatically generate a constructor with arguments to set values in required fields (final fields) in Lombok
@ToString                   // Automatically generate toString with Lombok
@Service                    // Make it a service layer class in Spring MVC
public class PointManagementService {
    /** PointManagementMaster Repository（Mybatis）. */
    final private MstPointManagementRepositoryMybatis<PointManagementFindRequest> mstPointManagementRepositoryMyb;
    /** PointManagementMaster Repository. */
    final private MstPointManagementRepository mstPointManagementRepository;

    /** [共通]Table管理Master Service. */
    final private TableManagementSharedService tableManagementSharedService;

    /**
     * 檢索.
     * <ol type="1">
     * <li>先取出Request Message Sort的條件，再追加Primary Key。</li>
     * <li>{@link MstPointManagement PointManagementMaster}用Mybatis來檢索Table。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    public PointManagementFindResponse find(final PointManagementFindRequest req) {
        // [MySQL-specific] If the ORDER BY key is not a unique key, the order is not guaranteed, so put the primary key at the end. ================================
        final PointManagementFindRequest plusReq;
        if (req == null) {
            plusReq = new PointManagementFindRequest();
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
        sorts.add(MstPointManagement.Fields.pointManagementId);
        // ==============================================================================================================================================

        // 用從Table管理畫面的Get Request來做成檢索條件
        final TableCondition<PointManagementFindRequest> condition = new TableCondition<>(plusReq,  // Use the request message as the source of SQL conditions
                this.tableManagementSharedService.findByTableNo(MstPointManagement.class),  // Get table information of master from table management master
                MstPointManagementRepositoryMybatis.ENTITY_FILED_INFO);                     // Entity field information

        // 檢索＆Response做成
        return PointManagementFindResponse.builder()
                .mstPointManagement(this.mstPointManagementRepositoryMyb.selectAll(condition))
                .mstTableManagement(condition.getTm()).build();
    }

    /**
     * 新增 or 更新.
     * <ol type="1">
     * <li>{@link MstPointManagement PointManagementMaster}對Table中的一筆資料進行更新。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    @Transactional
    public PointManagementSingleResponse save(final PointManagementSingleRequest req) {
        // 更新＆Response做成
        final PointManagementSingleResponse res = PointManagementSingleResponse.builder()
                .mstPointManagement(this.mstPointManagementRepository.save(req.getMstPointManagement()))  // PointManagementMaster中一筆資料更新
                .build();
        this.mstPointManagementRepository.flush();
        return res;
    }

    /**
     * 刪除.
     * <ol type="1">
     * <li>{@link MstPointManagement PointManagementMaster}對Table中的一筆資料進行刪除。</li>
     * </ol>
     *
     * @param req RequestMessage
     */
    @Transactional
    public void delete(final PointManagementMultiRequest req) {
        // 刪除
        this.mstPointManagementRepository.deleteInBatch(req.getMstPointManagement());
    }
}
