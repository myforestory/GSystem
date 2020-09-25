package com.ever.gsystem.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * カバレッジに含めない注釈.
 * <p>
 * このアノテーションを付けることによって、JaCoCoカバレッジに含めないようにできる。<br>
 * メインクラス等、単体テストで実行したない箇所に付ける。<br>
 * 単体テストできるクラスに付けるのは禁止！<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/12/22
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Retention(RetentionPolicy.CLASS) // アノテーションを保持する範囲
@Documented                       // Javadocでアノテーションを出力してもらう
public @interface Generated {/* 空 */}
