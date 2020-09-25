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
 * 商品スキャン設定.
 *
 * @since   1.0.0
 * @since   2020/05/15
 * @version 1.0.5
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.ITEM_SCAN_SETTING_STR)   // applicationプロパティから取得
public class ItemScanSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 513384994326713663L;

    /** スキャンモード. */
    private ScanMode scanMode;

    /** TCモードのタスクタイプ. */
    private Byte tcTaskType;

    /** Item Code切り出しルールリスト. */
    private List<ItemCodeeMidRule> rules;

    /** スキャンモード. */
    public enum ScanMode {
        /** スキャンコードモード. */
        SCAN_CODE_MODE,
        /** TCモード. */
        TC_MODE
    }
}
