package com.ever.gsystem.api.controllers.msg.responses;

import com.ever.gsystem.api.domain.entities.MstInformManagement;
import com.ever.gsystem.api.domain.entities.MstTableManagement;
import com.ever.gsystem.constants.api.ApiDocMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * [檢索用]訊息類別管理Master畫面RESPONSE MESSAGE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Value                      // Lombok automatically generates a constructor with arguments to set getter / equals / hashCode / toString for all fields and values for all fields
@Builder (toBuilder = true) // Automatically generate builder pattern with Lombok
@ApiModel(description = ApiDocMsg.FIND_TAG +
                        ApiDocMsg.API_INFORM_MANAGEMENT_ROOT_MSG + ApiDocMsg.RES_MSG) //For Swagger API documentation
public class InformManagementFindResponse implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = -2883902516623235629L;

    /** InformManagementMaster. */
    @ApiModelProperty(value = ApiDocMsg.INFORM_MANAGEMENT_NAME + "（複數有）", position = 1)
    private final List<MstInformManagement> mstInformManagement;

    /** Table管理Master. */
    @ApiModelProperty(value = ApiDocMsg.TABLE_MANAGEMENT_NAME
            + "（複數有）", position = 2)
    private final List<MstTableManagement> mstTableManagement;
}
