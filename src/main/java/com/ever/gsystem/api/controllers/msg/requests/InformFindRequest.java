package com.ever.gsystem.api.controllers.msg.requests;

import com.ever.gsystem.annotations.FiledOrder;
import com.ever.gsystem.constants.api.ApiDocMsg;
import com.ever.gsystem.constants.api.CmnFiledInfo;
import com.ever.gsystem.constants.api.GetRequestLimit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * [檢索用]通知消息Master畫面REQUEST MESSAGE.
 * <p>
 * Variable names of search entity items (other than pagination items and sort condition items) are <br>
 * Must match {@link com.ever.gsystem.api.domain.entities.MstBanner Store Master}. <br>
 * </p>
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
@ApiModel(description = ApiDocMsg.FIND_TAG +
                        ApiDocMsg.API_INFORM_ROOT_MSG + ApiDocMsg.REQ_MSG) // For Swagger API documentation
public class InformFindRequest implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 5341877110042930669L;

    // 檢索entities項目 ============================================================
    /** informID. */
    @FiledOrder(1)
    @ApiModelProperty(value = "informID", position = 1)
    private List<@Min(GetRequestLimit.NUM_MIN) @Max(GetRequestLimit.NUM_MAX) Long> informId;

    /** informManagementID. */
    @FiledOrder(2)
    @ApiModelProperty(value = "informManagementID", position = 2)
    private List<@Min(GetRequestLimit.NUM_MIN) @Max(GetRequestLimit.NUM_MAX) Long> informManagementId;

    /** 訊息類別種類. */
    @FiledOrder(3)
    @ApiModelProperty(value = "訊息類別種類", position = 3)
    private List<@Min(GetRequestLimit.LIST_MIN) @Max(GetRequestLimit.LIST_MAX) Integer> informType;

    /** 訊息名稱. */
    @FiledOrder(4)
    @Size(min = GetRequestLimit.TEXT_MIN, max = GetRequestLimit.TEXT_MAX)
    @ApiModelProperty(value = "訊息名稱", position = 4)
    private String name;

    /** 訊息狀態. */
    @FiledOrder(5)
    @ApiModelProperty(value = "訊息狀態", position = 5)
    private List<@Min(GetRequestLimit.LIST_MIN) @Max(GetRequestLimit.LIST_MAX) Integer> status;

    /** 推播內容. */
    @FiledOrder(6)
    @ApiModelProperty(value = "推播內容", position = 6)
    private List<@Min(GetRequestLimit.LIST_MIN) @Max(GetRequestLimit.LIST_MAX) Integer> text;

    // =================================================================================

    /** 取得資料開始位置（分頁用）. */
    @FiledOrder(CmnFiledInfo.OFFSET_VARIABLE_POSITION)
    @Min(GetRequestLimit.NUM_MIN)
    @Max(GetRequestLimit.NUM_MAX)
    @ApiModelProperty(value = ApiDocMsg.OFFSET_NAME, position = CmnFiledInfo.OFFSET_VARIABLE_POSITION)
    private Long offset;

    /** 取得資料數量（分頁用）. */
    @FiledOrder(CmnFiledInfo.LIMIT_VARIABLE_POSITION)
    @Min(GetRequestLimit.LIMIT_MIN)
    @Max(GetRequestLimit.LIMIT_MAX)
    @ApiModelProperty(value = ApiDocMsg.LIMIT_NAME, position = CmnFiledInfo.LIMIT_VARIABLE_POSITION)
    private Integer limit;

    /** 排序條件. */
    @FiledOrder(CmnFiledInfo.SORT_VARIABLE_POSITION)
    @ApiModelProperty(value = ApiDocMsg.SORT_NAME, position = CmnFiledInfo.SORT_VARIABLE_POSITION)
    private List<String> sort;
}
