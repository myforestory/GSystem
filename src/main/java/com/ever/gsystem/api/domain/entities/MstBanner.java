package com.ever.gsystem.api.domain.entities;

import com.ever.gsystem.annotations.FiledOrder;
import com.ever.gsystem.constants.api.ApiDocMsg;
import com.ever.gsystem.constants.api.CmnFiledInfo;
import com.ever.gsystem.constants.api.EntityDateFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * BannerMaster.<br>
 * 首頁Banner管理新增刪除修改TABLE。<br>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Data                       // Lombok automatically generates getter / setter / equals / canEqual / hashCode / toString for all fields
@Accessors (chain = true)   // Use Lombok to make setters for all fields method chains
@FieldNameConstants         // Constantize the variable name of the field with Lombok. You can statically access field names in [Class] .Fields. [Variable Name]. Example) "productNo" can be retrieved with MstItem.Fields.productNo.
@NoArgsConstructor          // Lombok automatically generates default constructor
@AllArgsConstructor         // Lombok automatically generates a constructor with arguments to set the values of all fields
@Builder (toBuilder = true) // Automatically generate builder pattern with Lombok
@EntityListeners (AuditingEntityListener.class) // Registration date and time and update date and time are automatically registered / updated in the DB
@Entity                     // Specify as entity class in JPA
@ApiModel (description = ApiDocMsg.BANNER_NAME) // For Swagger API documentation
public class MstBanner implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 3215114886808058696L;

    /**
     * bannerID.
     */
    @FiledOrder(1)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    @Min(0)
    @Max(Long.MAX_VALUE)
    @ApiModelProperty(value = "bannerID", position = 1)
    private Long bannerId;

    /**
     * banner標題.
     */
    @FiledOrder(2)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "banner標題", position = 2)
    private String name;

    /**
     * banner上傳圖片.
     */
    @FiledOrder(3)
    @Column(nullable = false)
    @Lob
    @ApiModelProperty(value = "banner上傳圖片", position = 3)
    private byte[] image;

    /** banner上架時間. */
    @FiledOrder(CmnFiledInfo.UPLOAD_TIME_POSITION)
    @CreatedDate
    @JsonFormat(pattern = EntityDateFormat.UPLOAD_TIME_FORMAT)
    @DateTimeFormat(pattern = EntityDateFormat.INSERT_TIME_FORMAT)
    @ApiModelProperty(value = ApiDocMsg.UPLOAD_TIME_NAME, example = ApiDocMsg.UPLOAD_TIME_EXAMPLE, position = CmnFiledInfo.UPLOAD_TIME_POSITION)
    private java.util.Date uploadTime;

    /** banner下架時間. */
    @FiledOrder(CmnFiledInfo.REMOVE_TIME_POSITION)
    @CreatedDate
    @JsonFormat(pattern = EntityDateFormat.REMOVE_TIME_FORMAT)
    @DateTimeFormat(pattern = EntityDateFormat.REMOVE_TIME_FORMAT)
    @ApiModelProperty(value = ApiDocMsg.REMOVE_TIME_NAME, example = ApiDocMsg.REMOVE_TIME_EXAMPLE, position = CmnFiledInfo.REMOVE_TIME_POSITION)
    private java.util.Date removeTime;
}
