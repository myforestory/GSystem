package com.ever.gsystem.api.domain.services;

import com.ever.gsystem.api.controllers.msg.requests.BannerFindRequest;
import com.ever.gsystem.api.controllers.msg.requests.BannerMultiRequest;
import com.ever.gsystem.api.controllers.msg.requests.BannerSingleRequest;
import com.ever.gsystem.api.controllers.msg.responses.BannerFindResponse;
import com.ever.gsystem.api.controllers.msg.responses.BannerSingleResponse;
import com.ever.gsystem.api.domain.entities.MstBanner;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions.TableCondition;
import com.ever.gsystem.api.domain.repositories.jpa.MstBannerRepository;
import com.ever.gsystem.api.domain.repositories.mabatis.MstBannerRepositoryMybatis;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 首頁BannerMaster畫面SERVICE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor    // Automatically generate a constructor with arguments to set values in required fields (final fields) in Lombok
@ToString                   // Automatically generate toString with Lombok
@Service                    // Make it a service layer class in Spring MVC
@Slf4j
public class BannerService {
    /** BannerMaster Repository（Mybatis）. */
    final private MstBannerRepositoryMybatis<BannerFindRequest> mstBannerRepositoryMyb;
    /** BannerMaster Repository. */
    final private MstBannerRepository mstBannerRepository;

    /** [共通]Table管理Master Service. */
    final private TableManagementSharedService tableManagementSharedService;

    /**
     * 檢索.
     * <ol type="1">
     * <li>先取出Request Message Sort的條件，再追加Primary Key。</li>
     * <li>{@link MstBanner BannerMaster}用Mybatis來檢索Table。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    public BannerFindResponse find(final BannerFindRequest req) {
        // [MySQL-specific] If the ORDER BY key is not a unique key, the order is not guaranteed, so put the primary key at the end. ================================
        final BannerFindRequest plusReq;
        if (req == null) {
            plusReq = new BannerFindRequest();
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
        sorts.add(MstBanner.Fields.bannerId);
        // ==============================================================================================================================================

        // 用從Table管理畫面的Get Request來做成檢索條件
        final TableCondition<BannerFindRequest> condition = new TableCondition<>(plusReq,  // Use the request message as the source of SQL conditions
                this.tableManagementSharedService.findByTableNo(MstBanner.class),  // Get table information of master from table management master
                MstBannerRepositoryMybatis.ENTITY_FILED_INFO);                     // Entity field information

        // 檢索＆Response做成
        return BannerFindResponse.builder()
                .mstBanner(this.mstBannerRepositoryMyb.selectAll(condition))
                .mstTableManagement(condition.getTm()).build();
    }

    /**
     * 新增 or 更新.
     * <ol type="1">
     * <li>{@link MstBanner BannerMaster}對Table中的一筆資料進行更新。</li>
     * </ol>
     *
     * @param  reqFile   首頁BannerMst畫面REQUEST(image)
     * @param  reqBanner 首頁BannerMst畫面REQUEST(name, uploadTime, removeTime)
     * @return           ResponseMessage
     */
    @Transactional
    public BannerSingleResponse save(final MultipartFile reqFile, final BannerSingleRequest reqBanner) {
        if (reqFile.getSize() == 0 || !reqFile.getContentType().contains("image")) {
            // 0 byte file uploaded or file type is not image
            log.debug("0 byte file uploaded or file type is not image");
            return BannerSingleResponse.builder().build();
        }

        final MstBanner banner = createMstBanner(reqFile, reqBanner);

        // 更新＆Response做成
        final BannerSingleResponse res = BannerSingleResponse.builder()
                .mstBanner(this.mstBannerRepository.save(banner))  // BannerMaster中一筆資料更新
                .build();
        this.mstBannerRepository.flush();
        return res;
    }

    /**
     * 刪除.
     * <ol type="1">
     * <li>{@link MstBanner BannerMaster}對Table中的一筆資料進行刪除。</li>
     * </ol>
     *
     * @param req RequestMessage
     */
    @Transactional
    public void delete(final BannerMultiRequest req) {
        // 刪除
        this.mstBannerRepository.deleteInBatch(req.getMstBanner());
    }

    private MstBanner createMstBanner(final MultipartFile reqFile, final BannerSingleRequest reqBanner) {
        final MstBanner banner = new MstBanner();

        try {
            banner.setImage(reqFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        banner.setName(reqBanner.getName());
        banner.setUploadTime(reqBanner.getUploadTime());
        banner.setRemoveTime(reqBanner.getRemoveTime());

        return banner;
    }
}
