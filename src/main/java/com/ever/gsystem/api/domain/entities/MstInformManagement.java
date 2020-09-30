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
 * InformManagementMaster.<br>
 * 最新消息/訊息通知之類別管理TABLE。<br>
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
@IdClass(MstInformManagement.PrimaryKeys.class)  // Define a dedicated class because there are multiple primary keys
@ApiModel (description = ApiDocMsg.API_INFORM_MANAGEMENT_ROOT_MSG) // For Swagger API documentation
public class MstInformManagement implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 2515522551076359199L;


    /**
     * PRIMARY KEY.
     */
    @Data
    public static class PrimaryKeys implements Serializable {
        /** Serial version UID (change value if this class changes). */
        private static final long serialVersionUID = 4994237165603294818L;

        /** informManagementID. */
        private Long informManagementId;
        /** 訊息類別種類. */
        private Byte informType;
    }

    /**
     * informManagementID.
     */
    @Id
    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(Long.MAX_VALUE)
    @ApiModelProperty(value = "informManagementID", position = 1)
    private Long informManagementId;

    /**
     * 訊息類別種類.<br>
     * 1.最新消息 2.訊息通知
     */
    @FiledOrder(2)
    @Id
    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(value = "訊息類別種類", position = 2)
    private Byte informType;

    /**
     * 訊息類別名稱.
     */
    @FiledOrder(3)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 200)
    @ApiModelProperty(value = "訊息類別名稱", position = 3)
    private String name;
}
