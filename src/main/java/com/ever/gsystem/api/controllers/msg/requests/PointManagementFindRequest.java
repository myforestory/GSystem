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
 * [檢索用]點數管理Master畫面REQUEST MESSAGE.
 * <p>
 * Variable names of search entity items (other than pagination items and sort condition items) are <br>
 * Must match {@link com.ever.gsystem.api.domain.entities.MstPointManagement Store Master}. <br>
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
                        ApiDocMsg.API_POINT_MANAGEMENT_ROOT_MSG + ApiDocMsg.REQ_MSG) // For Swagger API documentation
public class PointManagementFindRequest implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 3489906489974998272L;

    // 檢索entities項目 ============================================================
    /** 點數管理ID. */
    @ApiModelProperty(value = "點數管理ID", position = 1)
    private List<@Min(GetRequestLimit.NUM_MIN) @Max(GetRequestLimit.NUM_MAX) Long> pointManagementId;

    /** 會員ID. */
    @FiledOrder(2)
    @Size(min = GetRequestLimit.TEXT_MIN, max = GetRequestLimit.TEXT_MAX)
    @ApiModelProperty(value = "會員ID('memberType'+';'+'memberAccount')", position = 2)
    private String memberId;

    /** 到期日. */
    @FiledOrder(3)
    @ApiModelProperty(value = "到期日", position = 3)
    private List<@Min(GetRequestLimit.LIST_MIN) @Max(GetRequestLimit.LIST_MAX) Integer> expiredDay;

    /** 到期通知. */
    @FiledOrder(4)
    @ApiModelProperty(value = "到期通知", position = 4)
    private List<@Min(GetRequestLimit.LIST_MIN) @Max(GetRequestLimit.LIST_MAX) Integer> alert;

    /** 姓名. */
    @FiledOrder(5)
    @Size(min = GetRequestLimit.TEXT_MIN, max = GetRequestLimit.TEXT_MAX)
    @ApiModelProperty(value = "姓名", position = 5)
    private String name;

    /** 手機. */
    @FiledOrder(6)
    @Size(min = GetRequestLimit.TEXT_MIN, max = GetRequestLimit.TEXT_MAX)
    @ApiModelProperty(value = "手機", position = 6)
    private String mobile;

    /** 到期提醒_日. */
    @FiledOrder(7)
    @ApiModelProperty(value = "到期提醒_日", position = 7)
    private List<@Min(GetRequestLimit.LIST_MIN) @Max(GetRequestLimit.LIST_MAX) Integer> alertDay;

    /** 到期提醒_時. */
    @FiledOrder(8)
    @ApiModelProperty(value = "到期提醒_時", position = 8)
    private List<@Min(GetRequestLimit.LIST_MIN) @Max(GetRequestLimit.LIST_MAX) Integer> alertHour;

    /** 到期提醒_分. */
    @FiledOrder(9)
    @ApiModelProperty(value = "到期提醒_分", position = 9)
    private List<@Min(GetRequestLimit.LIST_MIN) @Max(GetRequestLimit.LIST_MAX) Integer> alertMin;
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
