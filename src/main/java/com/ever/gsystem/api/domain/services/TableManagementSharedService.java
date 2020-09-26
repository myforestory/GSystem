package com.ever.gsystem.api.domain.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.base.CaseFormat;
import com.ever.gsystem.api.controllers.msg.requests.TableManagementMultiRequest;
import com.ever.gsystem.api.controllers.msg.responses.TableManagementMultiResponse;
import com.ever.gsystem.api.domain.entities.MstTableManagement;
import com.ever.gsystem.api.domain.repositories.jpa.MstTableManagementRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * [共有]Table管理畫面SERVICE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor    // Automatically generate a constructor with arguments to set values in required fields (final fields) in Lombok
@ToString                   // Automatically generate toString with Lombok
@Service                    // Spring MVC as a service layer class
@ Slf4j                     // Automatically generate code that defines a logger in Lombok. Classes with this annotation can access the logger with a variable called "log"
public class TableManagementSharedService {
    /** Table管理Master Repository. */
    final private MstTableManagementRepository mstTableManagementRepository;

    /**
     * 檢索條件.
     * <ol type="1">
     * <li>{@link MstTableManagement Table管理Master}用該筆資料進行檢索。</li>
     * </ol>
     *
     * @param  clazz 欲取得的Table Entity Class
     * @return       檢索結果。{@link MstTableManagement Table管理Master}Table中的一筆資料
     */
    public List<MstTableManagement> findByTableNo(final Class<?>... clazz) {
        final List<MstTableManagement> list = new ArrayList<>();
        // Loop for the passed class
        for (final Class<?> c : clazz) {
            final String tableNo = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,
                                                             c.getSimpleName());
            log.debug("Table管理Master之TableNo：{}", tableNo);
            list.addAll(this.mstTableManagementRepository.findByTableNoOrderByItemOrderAsc(tableNo));
        }
        return list;
    }

    /**
     * 更新.
     * <ol type="1">
     * <li>{@link MstTableManagement Table管理Master}對Table中的複數筆資料進行更新。</li>
     * </ol>
     *
     * @param  req RequestMessage
     * @return     ResponseMessage
     */
    @Transactional
    public TableManagementMultiResponse save(final TableManagementMultiRequest req) {
        // 更新
        final List<MstTableManagement> result = this.mstTableManagementRepository.saveAll(req.getMstTableManagement()); // Table管理Master中的複數筆資料進行更新
        // Response做成
        final TableManagementMultiResponse res = TableManagementMultiResponse.builder()
                                                                             .mstTableManagement(result)
                                                                             .build();
        this.mstTableManagementRepository.flush();
        return res;
    }
}
