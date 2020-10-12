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
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * InformMaster.<br>
 * 最新消息/訊息通知之TABLE。<br>
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
@ApiModel (description = ApiDocMsg.API_INFORM_ROOT_MSG) // For Swagger API documentation
public class MstInform implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 8345256759805513717L;

    /**
     * informID.
     */
    @Id
    @FiledOrder(1)
    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(Long.MAX_VALUE)
    @ApiModelProperty(value = "informID", position = 1)
    private Long informId;

    /**
     * informManagementID.
     */
    @FiledOrder(2)
    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(Long.MAX_VALUE)
    @ApiModelProperty(value = "informManagementID", position = 2)
    private Long informManagementId;

    /**
     * 訊息類別種類.<br>
     * 1.最新消息 2.訊息通知
     */
    @FiledOrder(3)
    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(value = "訊息類別種類", position = 3)
    private Byte informType;

    /**
     * 訊息名稱.
     */
    @FiledOrder(4)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "訊息類別名稱", position = 4)
    private String name;

    /**
     * 訊息狀態.<br>
     * 1.簡訊推播兩者 2.簡訊 3.推播
     */
    @FiledOrder(5)
    @Min(0)
    @Max(3)
    @ApiModelProperty(value = "訊息狀態", position = 5)
    private Byte status;

    /**
     * 首頁彈跳視窗.<br>
     * 1.不顯示 2.顯示
     */
    @FiledOrder(6)
    @Min(0)
    @Max(2)
    @ApiModelProperty(value = "首頁彈跳視窗", position = 6)
    private Byte popup;

    /**
     * 推播內容.
     */
    @FiledOrder(7)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 10000)
    @ApiModelProperty(value = "推播內容", position = 7)
    private String text;

    /** 發送時間. */
    @FiledOrder(CmnFiledInfo.UPDATE_TIME_POSITION)
    @LastModifiedDate
    @JsonFormat(pattern = EntityDateFormat.UPDATE_TIME_FORMAT)
    @DateTimeFormat(pattern = EntityDateFormat.UPDATE_TIME_FORMAT)
    @ApiModelProperty(value = ApiDocMsg.UPDATE_TIME_NAME, example = ApiDocMsg.UPDATE_TIME_EXAMPLE, position = CmnFiledInfo.UPDATE_TIME_POSITION)
    private java.util.Date podcastTime;
}
