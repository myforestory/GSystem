package com.ever.gsystem.api.controllers.msg.responses;

import com.ever.gsystem.api.domain.entities.MstMember;
import com.ever.gsystem.constants.api.ApiDocMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * [單體]會員Master畫面Response Message.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Value                      // Lombok automatically generates a constructor with arguments to set getter / equals / hashCode / toString for all fields and values for all fields
@Builder (toBuilder = true) // Automatically generate builder pattern with Lombok
@ApiModel(description = ApiDocMsg.SINGLE_TAG +
                        ApiDocMsg.API_MEMBER_ROOT_MSG + ApiDocMsg.RES_MSG) //For Swagger API documentation
public class MemberSingleResponse implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = -6277030838018258096L;

    /** MemberMaster. */
    @ApiModelProperty(value = ApiDocMsg.MEMBER_NAME, position = 1)
    private final MstMember mstMember;
}
