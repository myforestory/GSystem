package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * デバイス自動採番設定.
 *
 * @since   1.0.4
 * @since   2020/07/27
 * @version 1.0.4
 * @author  Zeng YanYun
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
public class DeviceIdSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 168912389921612919L;

    /**
     * デバイスのタイプ .
     * <p>
     * デバイスマスタのタイプ。<br>
     * </p>
     */
    private Byte deviceType;

    /**
     * キーのプレフィックス .
     * <p>
     * デバイスマスタのデバイス採番時のキーのプレフィックスの設定を行う。<br>
     * </p>
     */
    private String keyPrefix;

    /**
     * カウンタ名 .
     * <p>
     * デバイスマスタのデバイス採番時のカウンタ名の設定を行う。<br>
     * </p>
     */
    private String counterName;

    /**
     * 最大値.
     * <p>
     * カウンタマスタの箱番号の最大値の設定を行う。<br>
     * </p>
     */
    private Long maxValue;
}
