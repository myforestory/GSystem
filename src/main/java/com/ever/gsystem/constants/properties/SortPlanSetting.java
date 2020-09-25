package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 仕分けプラン設定.
 *
 * @since   1.0.0-SNAPSHOT
 * @since   2020/05/13
 * @version 1.0.0-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.SORT_PLAN_SETTING_STR)   // applicationプロパティから取得
public class SortPlanSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -2538966841912199970L;

    /** バッチ番号の仕分けプランキー名のプレースホルダ. */
    public static final String PLACEHOLDER_SORT_PLAN_KEY = "SORT_PLAN_KEY";

    /**
     * 仕分けプラン発送キー名.
     * <p>
     * バッチ番号の発送キー名として使用。<br>
     * </p>
     */
    private String sortPlanSendKeyName;

    /**
     * 仕分けプラン到着キー名.
     * <p>
     * バッチ番号の発送キー名として使用。<br>
     * </p>
     */
    private String sortPlanArrivalKeyName;

    /** バッチ番号フォーマット. */
    private String batchNoFormat;

    /**
     * バッチ番号内の日付フォーマット.
     * <p>
     * キー：プレースフォルダの囲み文字無し文字列。<br>
     * 値：{@link SimpleDateFormat}の指定形式。<br>
     * <br>
     * 例）「2019年1月2日 3時4分5秒6ミリ秒」を例にします。<br>
     * yyyyMMdd_HHmmss_SSS：20190102_030405_006<br>
     * yyMd_Hms_S：1912_345_6（一桁系は0埋めしなくなる。また、年の場合は2桁「yy」までとなる）<br>
     * </p>
     */
    private HashMap<String, String> batchNoDateFormat;

    /**
     * バッチ番号内の日付タイムゾーン.
     * <p>
     * 日付のタイムゾーンを指定する。<br>
     * </p>
     */
    private String batchNoDateTimeZone;
}
