package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import java.util.HashMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 箱番号自動採番設定.
 *
 * @since   1.0.4
 * @since   2020/07/23
 * @version 1.0.4
 * @author  Shizu Taniyama
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.BOX_NO_STR)   // applicationプロパティから取得
public class BoxNoSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 2242204293163363269L;

    /** 箱番号のカウンタマスタのキーサフィックスのプレースホルダ. */
    public static final String PLACEHOLDER_KEY_SUFFIX = "KEY_SUFFIX";
    /** 箱番号の採番後フォーマットのプレースホルダ. */
    public static final String PLACEHOLDER_DATE       = "DATE";
    /** 箱番号の採番後フォーマットのプレースホルダ. */
    public static final String PLACEHOLDER_COUNTER    = "COUNTER";

    /**
     * 採番後フォーマット.
     * <p>
     * タスク明細に設定する箱番号のフォーマットの設定を行う。<br>
     * </p>
     */
    private String stringFormat;

    /**
     * キーのプレフィックス .
     * <p>
     * カウンタマスタの箱番号採番時のキーのプレフィックスの設定を行う。<br>
     * </p>
     */
    private String keyPrefix;

    /**
     * カウンタ名 .
     * <p>
     * カウンタマスタの箱番号採番時のカウンタ名の設定を行う。<br>
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

    /**
     * 日付フォーマット.
     * <p>
     * 箱番号採番時の日付の形式の設定を行う。<br>
     * </p>
     */
    private HashMap<String, String> dateFormat;

    /**
     * タイムゾーン.
     * <p>
     * 日付取得時のタイムゾーンの設定を行う。<br>
     * </p>
     */
    private String dateTimeZone;
}
