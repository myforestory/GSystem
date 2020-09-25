package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * カウンタ設定.
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
@ConfigurationProperties(prefix = ApplicationValue.COUNTER_SETTING_STR)   // applicationプロパティから取得
public class CounterSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 8568660882467645039L;

    /**
     * デバイスID 自動採番設定.
     * <p>
     * デバイスIDのカウンタ設定。<br>
     * </p>
     */
    private List<DeviceIdSetting> deviceId;

    /**
     * 箱番号自動採番設定.
     * <p>
     * 箱番号のカウンタ設定。<br>
     * </p>
     */
    private BoxNoSetting boxNo;
}
