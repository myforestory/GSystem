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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * MemberMaster.<br>
 * 會員之TABLE。<br>
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
@ApiModel (description = ApiDocMsg.API_MEMBER_ROOT_MSG) // For Swagger API documentation
public class MstMember implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = -6108752084272552872L;

    /**
     * 會員ID.<br>
     * ('memberType'+';'+'memberAccount')<br>
     * (ex: FB;0934300300)
     */
    @Id
    @FiledOrder(1)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "會員ID", position = 1)
    private String memberId;

    /**
     * 會員類別.
     */
    @FiledOrder(2)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "會員類別", position = 2)
    private String memberType;

    /**
     * 會員帳號.
     */
    @FiledOrder(3)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "會員帳號", position = 3)
    private String memberAccount;

    /**
     * 會員密碼.<br>
     * (暗碼處理)
     */
    @FiledOrder(4)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "會員帳號", position = 4)
    private String password;

    /**
     * 姓名.
     */
    @FiledOrder(5)
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "姓名", position = 5)
    private String name;

    /**
     * 手機.<br>
     * (ex：0934300300)
     */
    @FiledOrder(6)
    @Size(min = 1, max = 20)
    @ApiModelProperty(value = "手機", position = 6)
    private String mobile;

    /**
     * 性別.
     */
    @FiledOrder(7)
    @Size(min = 1, max = 10)
    @ApiModelProperty(value = "性別", position = 7)
    private String sex;

    /**
     * 生日.<br>
     * (ex：19920101)
     */
    @FiledOrder(8)
    @Min(0)
    @Max(20)
    @ApiModelProperty(value = "生日", position = 8)
    private Long birth;

    /**
     * 地址.
     */
    @FiledOrder(9)
    @Size(min = 1, max = 1000)
    @ApiModelProperty(value = "地址", position = 9)
    private String address;

    /**
     * 認證狀態.<br>
     * 0.未認證 1.已認證
     */
    @FiledOrder(10)
    @Min(0)
    @Max(2)
    @ApiModelProperty(value = "認證狀態", position =10)
    private Byte permission;

    /**
     * 停權狀態.<br>
     * 0.未停權 1.已停權
     */
    @FiledOrder(11)
    @Min(0)
    @Max(2)
    @ApiModelProperty(value = "停權狀態", position = 11)
    private Byte banned;

    /**
     * 重發簡訊.<br>
     * 0.未發送 1.已發送
     */
    @FiledOrder(12)
    @Min(0)
    @Max(2)
    @ApiModelProperty(value = "重發簡訊", position = 12)
    private Byte reMessage;
}
