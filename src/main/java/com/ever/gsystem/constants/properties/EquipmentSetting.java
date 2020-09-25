package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 機器（ロボット）設定.
 *
 * @since   1.0.0
 * @since   2020/05/16
 * @version 1.0.0
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.EQUIPMENT_SETTING_STR)   // applicationプロパティから取得
public class EquipmentSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 344001143756095098L;

    /** 傾き設定元. */
    private TileAngleSetting tileAngleSettingSource;
    /** デフォルトの傾き（度）. */
    private Short            defaultTileAngle;

    /** 傾き設定. */
    public enum TileAngleSetting {
        /** デフォルト値. */
        DEFAULT,
        /**
         * 商品マスタテーブル.
         * <p>
         * 商品マスタテーブルの傾き列を設定。<br>
         * </p>
         */
        MST_ITEM_TABLE
    }
}
