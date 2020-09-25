package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * cronスケジュール設定.
 * <p>
 * 秒/分/時/日/月/曜日でスケジュールを指定する。<br>
 * 【指定できる数値一覧】<br>
 * 秒(0-59)<br>
 * 分(0-59)<br>
 * 時(0-23)<br>
 * 日(1-31)<br>
 * 月(1-12)<br>
 * 曜日(0:日、1:月、2:火、3:水、4:木、5:金、6:土、7:日)<br>
 * <br>
 * 例1）"30 * * * * *" → 秒指定。毎分30秒で実行。<br>
 * 例2）"4 5 * * * *" → 分指定。毎時5分4秒で実行。<br>
 * 例3）"35 15 18 * * *" → 時指定。毎日18時15分35秒で実行。<br>
 * 例4）"0 0 1 5 * *" → 日指定。毎月5日、1時0分0秒で実行。<br>
 * 例5）"1 2 3 4 5 *" → 月指定。毎年5月4日 3時2分1秒で実行。<br>
 * 例6）"0 0 23 * * 3" → 曜日指定。毎週水曜日の23時0分0秒で実行。<br>
 * 以下特殊な指定。<br>
 * 例7）"0 0 9-18 * * 1-5" → 「-」で範囲指定可能。月～金曜日（1-5）の9時から18時の0分0秒で実行。<br>
 * 例8）"1,31 * * * * *" → 「,」で複数指定可能。毎時1秒と31秒で実行。<br>
 * 例9）"0 0 12 *{@literal /}5 * *" → 「*{@literal /}n」で間隔n（n倍）指定可能。毎月5の倍数の日の12時0分0秒で実行。<br>
 * 注意：通常のLinux系で使用できるcrontabと違い、月末指定が存在しない。そのため月の1日指定とするか、以下の方法で月末指定を行う。<br>
 * <a href=
 * "https://stackoverflow.com/questions/31445395/cron-expression-is-not-working-for-last-day-of-the-month">Cron
 * Expression is not working for last day of the month</a><br>
 * <br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/02/05
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
public class Cron implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 1113927089114940747L;

    /** タスク履歴退避スケジュール. */
    private String taskHistoryBackupSchedule;

    /** タスク実績ファイル自動出力スケジュール. */
    private String taskResultFileAutoOutputSchedule;

    /** タスク実績ファイル削除スケジュール. */
    private String taskResultFileRemoveSchedule;
}
