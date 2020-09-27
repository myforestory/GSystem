package com.ever.gsystem.api.controllers.msg.requests;

import com.ever.gsystem.annotations.FiledOrder;
import com.ever.gsystem.constants.api.ApiDocMsg;
import com.ever.gsystem.constants.api.CmnFiledInfo;
import com.ever.gsystem.constants.api.EntityDateFormat;
import com.ever.gsystem.constants.api.GetRequestLimit;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * [單體]首頁BannerMaster畫面REQUEST MESSAGE.
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
                        ApiDocMsg.API_BANNER_ROOT_MSG + ApiDocMsg.REQ_MSG) //For Swagger API documentation
public class BannerSingleRequest implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = -3261714019247385250L;

    /** banner標題. */
    @FiledOrder(1)
    @Size(min = GetRequestLimit.TEXT_MIN, max = GetRequestLimit.TEXT_MAX)
    @ApiModelProperty(value = "banner標題", position = 2)
    private String name;

    /** banner上架時間. */
    @FiledOrder(CmnFiledInfo.UPLOAD_TIME_POSITION)
    @JsonFormat(pattern = EntityDateFormat.UPLOAD_TIME_FORMAT)
    @DateTimeFormat(pattern = EntityDateFormat.INSERT_TIME_FORMAT)
    @ApiModelProperty(value = ApiDocMsg.UPLOAD_TIME_NAME, example = ApiDocMsg.UPLOAD_TIME_EXAMPLE, position = CmnFiledInfo.UPLOAD_TIME_POSITION)
    private Date uploadTime;

    /** banner下架時間. */
    @FiledOrder(CmnFiledInfo.REMOVE_TIME_POSITION)
    @JsonFormat(pattern = EntityDateFormat.REMOVE_TIME_FORMAT)
    @DateTimeFormat(pattern = EntityDateFormat.REMOVE_TIME_FORMAT)
    @ApiModelProperty(value = ApiDocMsg.REMOVE_TIME_NAME, example = ApiDocMsg.REMOVE_TIME_EXAMPLE, position = CmnFiledInfo.REMOVE_TIME_POSITION)
    private Date removeTime;
}
