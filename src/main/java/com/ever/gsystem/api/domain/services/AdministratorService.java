package com.ever.gsystem.api.domain.services;

import com.ever.gsystem.api.controllers.msg.requests.AdministratorFindRequest;
import com.ever.gsystem.api.controllers.msg.requests.AdministratorMultiRequest;
import com.ever.gsystem.api.controllers.msg.requests.AdministratorSingleRequest;
import com.ever.gsystem.api.controllers.msg.responses.AdministratorFindResponse;
import com.ever.gsystem.api.controllers.msg.responses.AdministratorSingleResponse;
import com.ever.gsystem.api.domain.entities.MstAdministrator;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions.TableCondition;
import com.ever.gsystem.api.domain.repositories.jpa.MstAdministratorRepository;
import com.ever.gsystem.api.domain.repositories.mabatis.MstAdministratorRepositoryMybatis;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 系統管理者Master畫面SERVICE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor    // Automatically generate a constructor with arguments to set values in required fields (final fields) in Lombok
@ToString                   // Automatically generate toString with Lombok
@Service                    // Make it a service layer class in Spring MVC
public class AdministratorService {
    /** AdministratorMaster Repository（Mybatis）. */
    final private MstAdministratorRepositoryMybatis<AdministratorFindRequest> mstAdministratorRepositoryMyb;
    /** AdministratorMaster Repository. */
    final private MstAdministratorRepository mstAdministratorRepository;

    /** [共通]Table管理Master Service. */
    final private TableManagementSharedService tableManagementSharedService;

    /**
     * 檢索.
     * <ol type="1">
     * <li>先取出Request Message Sort的條件，再追加Primary Key。</li>
     * <li>{@link MstAdministrator AdministratorMaster}用Mybatis來檢索Table。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    public AdministratorFindResponse find(final AdministratorFindRequest req) {
        // [MySQL-specific] If the ORDER BY key is not a unique key, the order is not guaranteed, so put the primary key at the end. ================================
        final AdministratorFindRequest plusReq;
        if (req == null) {
            plusReq = new AdministratorFindRequest();
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
        sorts.add(MstAdministrator.Fields.administratorId);

        Class<com.ever.gsystem.api.domain.entities.MstAdministrator> a = MstAdministrator.class;
        // ==============================================================================================================================================

        // 用從Table管理畫面的Get Request來做成檢索條件
        final TableCondition<AdministratorFindRequest> condition = new TableCondition<>(plusReq,  // Use the request message as the source of SQL conditions
                this.tableManagementSharedService.findByTableNo(MstAdministrator.class),  // Get table information of master from table management master
                MstAdministratorRepositoryMybatis.ENTITY_FILED_INFO);                     // Entity field information

        // 檢索＆Response做成
        return AdministratorFindResponse.builder()
                .mstAdministrator(this.mstAdministratorRepositoryMyb.selectAll(condition))
                .mstTableManagement(condition.getTm()).build();
    }

    /**
     * 新增 or 更新.
     * <ol type="1">
     * <li>{@link MstAdministrator AdministratorMaster}對Table中的一筆資料進行更新。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    @Transactional
    public AdministratorSingleResponse save(final AdministratorSingleRequest req) {
        // 更新＆Response做成
        final AdministratorSingleResponse res = AdministratorSingleResponse.builder()
                .mstAdministrator(this.mstAdministratorRepository.save(req.getMstAdministrator()))  // AdministratorMaster中一筆資料更新
                .build();
        this.mstAdministratorRepository.flush();
        return res;
    }

    /**
     * 刪除.
     * <ol type="1">
     * <li>{@link MstAdministrator AdministratorMaster}對Table中的一筆資料進行刪除。</li>
     * </ol>
     *
     * @param req RequestMessage
     */
    @Transactional
    public void delete(final AdministratorMultiRequest req) {
        // 刪除
        this.mstAdministratorRepository.deleteInBatch(req.getMstAdministrator());
    }
}
