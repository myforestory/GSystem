package com.ever.gsystem.api.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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

/**
 * Table操作管理Master. <br>
 * Master table that manages DB columns in the intermediate system as records. <br>
 * Has the header and data type of the table management screen. <br>
 * <br>
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
@AllArgsConstructor         // Lombok automatically generates a constructor with arguments to set the values ​​of all fields
@Builder (toBuilder = true) // Automatically generate builder pattern with Lombok
@EntityListeners(AuditingEntityListener.class) // Registration date and time and update date and time are automatically registered / updated in the DB
@Entity                     // Specify as entity class in JPA
@IdClass(MstTableManagement.PrimaryKeys.class)  // Define a dedicated class because there are multiple primary keys
@ApiModel (description = ApiDocMsg.BANNER_NAME) // For Swagger API documentation
public class MstTableManagement implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = -6024679184282897822L;

    /**
     * Primary Key.
     */
    @Data
    public static class PrimaryKeys implements Serializable {
        /** Serial version UID (change value if this class changes). */
        private static final long serialVersionUID = -3762743866002529331L;

        /** Table No. */
        private String tableNo;
        /** Item No. */
        private String isItemNo;
    }

    /**
     * Table No.<br>
     * テーブルを一意に特定する文字列。各テーブルの物理名が格納される。<br>
     */
    @FiledOrder(1)
    @Id
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 32)
    @ApiModelProperty(value = "テーブル番号", position = 1)
    private String tableNo;

    /**
     * 中間システム項目番号.<br>
     * 各テーブルカラムの物理名が格納される。<br>
     */
    @FiledOrder(2)
    @Id
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 32)
    @ApiModelProperty(value = "中間システム項目番号", position = 2)
    private String isItemNo;

    /**
     * 項目順序.<br>
     * 各テーブルの列の順序。1始まり。<br>
     */
    @FiledOrder(3)
    @Min(1)
    @Max(2000000000)
    @ApiModelProperty(value = "項目順序", position = 3)
    private Integer itemOrder;

    /**
     * テーブル名.<br>
     * 各テーブルの論理名が格納される。<br>
     */
    @FiledOrder(4)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 100)
    @ApiModelProperty(value = "テーブル名", position = 4)
    private String tableName;

    /**
     * 項目名.<br>
     * 各テーブルの列（カラム）名。<br>
     * 画面に表示するラベル。<br>
     */
    @FiledOrder(5)
    @Column(nullable = false)
    @NotBlank()
    @Size(min = 1, max = 64)
    @ApiModelProperty(value = "項目名", position = 5)
    private String itemName;

    /**
     * データタイプ.<br>
     * 0：テキスト、1：数値、2：リスト、3：日時。<br>
     */
    @FiledOrder(6)
    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(3)
    @ApiModelProperty(value = "データタイプ", position = 6)
    private Byte dataType;

    /**
     * 表示フラグ.<br>
     * 0：非表示、1：表示。<br>
     */
    @FiledOrder(7)
    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(value = "表示フラグ", position = 7)
    private Byte displayFlag;
}
