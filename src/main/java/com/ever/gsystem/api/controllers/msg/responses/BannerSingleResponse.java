package com.ever.gsystem.api.controllers.msg.responses;

import java.io.Serializable;
import com.ever.gsystem.api.domain.entities.MstBanner;
import com.ever.gsystem.constants.api.ApiDocMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Value;

/**
 * [單體]BannerMaster畫面Response Message.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Value                      // Lombok automatically generates a constructor with arguments to set getter / equals / hashCode / toString for all fields and values ​​for all fields
@Builder (toBuilder = true) // Automatically generate builder pattern with Lombok
@ApiModel(description = ApiDocMsg.SINGLE_TAG +
                        ApiDocMsg.API_BANNER_ROOT_MSG + ApiDocMsg.RES_MSG) //For Swagger API documentation
public class BannerSingleResponse implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 482835585926427251L;

    /** BannerMaster. */
    @ApiModelProperty(value = ApiDocMsg.BANNER_NAME, position = 1)
    private final MstBanner mstBanner;
}
