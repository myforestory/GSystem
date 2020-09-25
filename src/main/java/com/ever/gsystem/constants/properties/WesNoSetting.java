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
 * WES No自動採番設定.
 *
 * @since   1.1.0
 * @since   2020/09/08
 * @version 1.1.0
 * @author  Zeng YanYun
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.WES_NO_STR)   // applicationプロパティから取得
public class WesNoSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 2242204293163363269L;

    /** 箱番号の採番後フォーマットのプレースホルダ. */
    public static final String PLACEHOLDER_COUNTER = "COUNTER";

    /**
     * キー名 .
     * <p>
     * カウンタマスタのWES No採番時のキー名の設定を行う。<br>
     * </p>
     */
    private String keyName;

    /**
     * カウンタ名 .
     * <p>
     * カウンタマスタのWES No採番時のカウンタ名の設定を行う。<br>
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
