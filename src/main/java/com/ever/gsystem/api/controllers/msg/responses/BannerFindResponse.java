package com.ever.gsystem.api.controllers.msg.responses;

import com.ever.gsystem.api.domain.entities.MstBanner;
import com.ever.gsystem.api.domain.entities.MstTableManagement;
import com.ever.gsystem.constants.api.ApiDocMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * [檢索用]首頁BannerMaster畫面RESPONSE MESSAGE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Value                      // Lombok automatically generates a constructor with arguments to set getter / equals / hashCode / toString for all fields and values for all fields
@Builder (toBuilder = true) // Automatically generate builder pattern with Lombok
@ApiModel(description = ApiDocMsg.FIND_TAG +
                        ApiDocMsg.API_BANNER_ROOT_MSG + ApiDocMsg.RES_MSG) //For Swagger API documentation
public class BannerFindResponse implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = -2034844295626756942L;

    /** BannerMaster. */
    @ApiModelProperty(value = ApiDocMsg.BANNER_NAME + "（複數有）", position = 1)
    private final List<MstBanner> mstBanner;

    /** Table管理Master. */
    @ApiModelProperty(value = ApiDocMsg.TABLE_MANAGEMENT_NAME
            + "（複數有）", position = 2)
    private final List<MstTableManagement> mstTableManagement;
}
