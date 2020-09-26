package com.ever.gsystem.api.controllers.msg.requests;

import com.ever.gsystem.api.domain.entities.MstInformManagement;
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
import java.util.List;

/**
 * [複數]訊息類別管理Master畫面REQUEST MESSAGE.
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
@ApiModel(description = ApiDocMsg.MULTI_TAG +
                        ApiDocMsg.API_INFORM_MANAGEMENT_ROOT_MSG + ApiDocMsg.REQ_MSG) // For Swagger API documentation
public class InformManagementMultiRequest implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = -9154662994090280377L;

    /** InformManagementMaster. */
    @Valid
    @ApiModelProperty(value = ApiDocMsg.INFORM_MANAGEMENT_NAME + "（複數可）", position = 1)
    private List<MstInformManagement> mstInformManagement;
}
