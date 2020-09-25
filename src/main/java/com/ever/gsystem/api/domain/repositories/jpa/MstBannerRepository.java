package com.ever.gsystem.api.domain.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ever.gsystem.api.domain.entities.MstBanner;
import com.ever.gsystem.api.domain.repositories.fieldinfo.EntityFiledInfo;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;

/**
 * {@linkplain MstBanner BannerMst} Repository.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Repository // Make it a repository layer class in SpringMVC
public interface MstBannerRepository extends JpaRepository<MstBanner, Long> {
    /** {@linkplain MstBanner MstBanner} entities. */
    FiledControllable ENTITY_FILED_INFO = new EntityFiledInfo<>(MstBanner.class);

    /**
     * BannerMst檢索 ：bannerId.
     * <p>
     * {@link MstBanner BannerMst}テーブルを、1レコード取得する。
     * </p>
     *
     * @param  bannerId 欲檢索的bannerId
     * @return        檢索結果。{@link MstBanner}回傳物件
     */
    MstBanner findFirstByBannerId(String bannerId);
}
