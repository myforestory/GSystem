package com.ever.gsystem.api.controllers.msg.requests;

import com.ever.gsystem.api.domain.entities.MstInform;
import com.ever.gsystem.constants.api.ApiDocMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * [單體]通知消息Master畫面REQUEST MESSAGE.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Data                       // Lombok automatically generates getter / setter / equals / canEqual / hashCode / toString for all fields
@Accessors (chain = true)   // Use Lombok to make setters for all fields method chains
@NoArgsConstructor          // Lombok automatically generates default constructor
@AllArgsConstructor         // Lombok automatically generates a constructor with arguments to set the values of all fields
@Builder (toBuilder = true) // Automatically generate builder pattern with Lombok
@ApiModel(description = ApiDocMsg.SINGLE_TAG +
                        ApiDocMsg.API_INFORM_ROOT_MSG + ApiDocMsg.REQ_MSG) //For Swagger API documentation
public class InformSingleRequest implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = -7971217819803383211L;

    /** InformMaster. */
    @Valid
    @ApiModelProperty(position = 1)
    private MstInform mstInform;
}
