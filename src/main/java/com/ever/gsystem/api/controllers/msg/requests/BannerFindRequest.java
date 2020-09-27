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

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * [檢索用]首頁BannerMaster畫面REQUEST MESSAGE.
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
                        ApiDocMsg.API_BANNER_ROOT_MSG + ApiDocMsg.REQ_MSG) // For Swagger API documentation
public class BannerFindRequest implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 7969860000718904370L;

    // 檢索entities項目 ============================================================
    /** bannerID. */
    @FiledOrder(1)
    @ApiModelProperty(value = "bannerID", position = 1)
    private List<@Min(GetRequestLimit.NUM_MIN) @Max(GetRequestLimit.NUM_MAX) Long> bannerId;

    /** banner標題. */
    @FiledOrder(2)
    @Size(min = GetRequestLimit.TEXT_MIN, max = GetRequestLimit.TEXT_MAX)
    @ApiModelProperty(value = "banner標題", position = 2)
    private String name;

    /** banner上傳圖片. */
    @FiledOrder(3)
    @Size(min = GetRequestLimit.LIMIT_MAX, max = GetRequestLimit.LIMIT_MIN)
    @ApiModelProperty(value = "banner上傳圖片", position = 3)
    private byte[] image;

    /** banner上架時間. */
    @FiledOrder(CmnFiledInfo.UPLOAD_TIME_POSITION)
    @JsonFormat(pattern = EntityDateFormat.UPLOAD_TIME_FORMAT)
    @DateTimeFormat(pattern = EntityDateFormat.INSERT_TIME_FORMAT)
    @ApiModelProperty(value = ApiDocMsg.UPLOAD_TIME_NAME, example = ApiDocMsg.UPLOAD_TIME_EXAMPLE, position = CmnFiledInfo.UPLOAD_TIME_POSITION)
    private List<java.util.Date> uploadTime;

    /** banner下架時間. */
    @FiledOrder(CmnFiledInfo.REMOVE_TIME_POSITION)
    @JsonFormat(pattern = EntityDateFormat.REMOVE_TIME_FORMAT)
    @DateTimeFormat(pattern = EntityDateFormat.REMOVE_TIME_FORMAT)
    @ApiModelProperty(value = ApiDocMsg.REMOVE_TIME_NAME, example = ApiDocMsg.REMOVE_TIME_EXAMPLE, position = CmnFiledInfo.REMOVE_TIME_POSITION)
    private List<java.util.Date> removeTime;
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
