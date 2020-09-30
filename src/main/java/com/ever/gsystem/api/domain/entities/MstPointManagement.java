package com.ever.gsystem.api.domain.entities;

import com.ever.gsystem.annotations.FiledOrder;
import com.ever.gsystem.constants.api.ApiDocMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * PointManagementMaster.<br>
 * 系統管理者之TABLE。<br>
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
@ApiModel (description = ApiDocMsg.API_POINT_MANAGEMENT_ROOT_MSG) // For Swagger API documentation
public class MstPointManagement implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 7151807991843232010L;

    /**
     * 點數管理ID.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(Long.MAX_VALUE)
    @ApiModelProperty(value = "點數管理ID", position = 1)
    private Long pointManagementId;

    /**
     * 會員ID.<br>
     * ("member_type"+";"+"member_account")<br>
     * (ex: FB;0934300300)
     */
    @FiledOrder(2)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "會員ID", position = 2)
    private String member_id;

    /**
     * 到期日.<br>
     * (ex：101)
     */
    @FiledOrder(3)
    @Min(0)
    @Max(3)
    @ApiModelProperty(value = "到期日", position = 3)
    private Integer expiredDay;

    /**
     * 到期通知.<br>
     * 0.不啟用 1.啟用
     */
    @FiledOrder(4)
    @Min(0)
    @Max(2)
    @ApiModelProperty(value = "到期通知", position = 4)
    private Byte alert;

    /**
     * 說明文字.
     */
    @FiledOrder(5)
    @Size(min = 1, max = 2000)
    @ApiModelProperty(value = "說明文字", position = 5)
    private String descriptionText;

    /**
     * 通知文字.
     */
    @FiledOrder(6)
    @Size(min = 1, max = 2000)
    @ApiModelProperty(value = "通知文字", position = 6)
    private String informText;

    /**
     * 到期提醒_日.<br>
     * (ex：101)
     */
    @FiledOrder(7)
    @Min(0)
    @Max(3)
    @ApiModelProperty(value = "到期提醒_日", position = 7)
    private Integer alertDay;

    /**
     * 到期提醒_時.<br>
     * (ex：11)
     */
    @FiledOrder(8)
    @Min(0)
    @Max(3)
    @ApiModelProperty(value = "到期提醒_時", position = 8)
    private Integer alertHour;

    /**
     * 到期提醒_分.<br>
     * (ex：11)
     */
    @FiledOrder(9)
    @Min(0)
    @Max(3)
    @ApiModelProperty(value = "到期提醒_分", position = 9)
    private Integer alertMin;
}
