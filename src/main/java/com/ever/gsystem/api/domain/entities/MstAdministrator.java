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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * AdministratorMaster.<br>
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
@ApiModel (description = ApiDocMsg.API_ADMINISTRATOR_ROOT_MSG) // For Swagger API documentation
public class MstAdministrator implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 6639010342270169350L;

    /**
     * 系統管理者帳號.
     */
    @Id
    @FiledOrder(1)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "系統管理者帳號", position = 1)
    private String administratorId;

    /**
     * 系統管理者密碼.
     */
    @FiledOrder(2)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "系統管理者密碼", position = 2)
    private String password;

    /**
     * 權限.<br>
     * 權限(待查證)
     */
    @FiledOrder(3)
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "權限", position = 3)
    private String authorization;
}
