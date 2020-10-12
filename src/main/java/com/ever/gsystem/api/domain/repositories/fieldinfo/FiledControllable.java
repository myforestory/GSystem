package com.ever.gsystem.api.domain.repositories.fieldinfo;

import com.ever.gsystem.annotations.FiledOrder;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * フィールド管理インターフェース.
 * <p>
 * フィールド情報を管理することができるようにするインターフェース。<br>
 * このインターフェースを継承すると、クラスの持っているフィールド情報（フィールド変数名情報、フィールドの数など）を管理することができるようになる。<br>
 * {@link FiledOrder}アノテーションを付けたクラスに対しての情報も取得するため、そちらのJavadocも参照すること。<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/10/23
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
public interface FiledControllable {
    /**
     * クラス名取得.
     * <p>
     * クラス名を取得する。<br>
     * テーブル名として使うことができるが、アッパーキャメルケースとなっていることに注意する。<br>
     * 例）◎ MstItem（アッパーキャメルケース）、× mstItem（ローワキャメルケース）、× mst_item（スネークケース）<br>
     * クラス名をテーブル名として使いたい場合は、別途アッパーキャメルケース→スネークケースへの変換をかける必要がある。<br>
     * 変換する際は、Guavaの{@link CaseFormat#UPPER_CAMEL}→{@link CaseFormat#LOWER_UNDERSCORE}がお勧め。<br>
     * </p>
     *
     * @return 変数名マップ（キー：連番、値：変数名）
     */
    String getClassName();

    /**
     * 変数名スネークケースリスト取得.
     *
     * @return スネークケースに変換後のリスト
     * @see    #newFiledOrderVariableSnakeCaseNamesArray(Class)
     */
    List<String> getFiledOrderVariableSnakeCaseNamesArray();

    /**
     * 変数名スネークケースリスト作成.
     * <p>
     * ！！注意：{@literal @}{@link FiledOrder}アノテーションが付いていないエンティティの変数は取得されない！！<br>
     * メンバ変数名をスネークケースに変換し、String配列で返却。<br>
     * 取得した配列は変数名がスネークケースとなっているため、SELECT文として利用できる。<br>
     * 例：変数名=fieldA、fieldBを持ったクラスを渡すと、["field_a", "field_b"]の配列を返す。<br>
     * </p>
     *
     * @param  clazz 取得したいエンティティのクラス
     * @return       スネークケースに変換後の配列
     */
    static List<String> newFiledOrderVariableSnakeCaseNamesArray(final Class<?> clazz) {
        // メンバ変数から変数名を取得し、マップに詰める
        final List<String> variableNames = new ArrayList<>();
        // 並び替え後の配列を取得し、ループする
        for (final Field field : sort(clazz)) {
            field.setAccessible(true);
            final FiledOrder order = field.getAnnotation(FiledOrder.class);
            if (order != null) {
                // フィールドの変数名をDB側の名前にする（ローワキャメルケースからスネークケースにする）
                variableNames.add(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
                                                            field.getName()));
            }
        }
        return variableNames;
    }

    /**
     * メンバ変数名ソート.
     * <p>
     * フィールド配列を{@link FiledOrder#value()}の数値の昇順にソートする。<br>
     * 比較ルール：{@link FiledOrder#value()}が1、2、3の順で並べていく。<br>
     * アノテーションが付いていないフィールドに関しては、一番後ろに並べていく。
     * </p>
     *
     * @param  clazz ソートしたいエンティティのクラス
     * @return       並び替え後の{@link Field}配列
     */
    static Field[] sort(final Class<?> clazz) {
        // クラスのメンバ変数情報をすべて取得
        final Field[] fields = clazz.getDeclaredFields();
        // メンバ変数順序アノテーションに基づいてソート
        return sort(sort(fields));
    }

    /**
     * メンバ変数名ソート.
     * <p>
     * フィールド配列を{@link FiledOrder#value()}の数値の昇順にソートする。<br>
     * 比較ルール：{@link FiledOrder#value()}が1、2、3の順で並べていく。<br>
     * アノテーションが付いていないフィールドに関しては、一番後ろに並べていく。
     * </p>
     *
     * @param  fields {@link Field}配列
     * @return        並び替え後の{@link Field}配列
     */
    static Field[] sort(final Field[] fields) {
        Arrays.sort(fields, (src, dest) -> {
            final FiledOrder orderSrcComp  = src.getAnnotation(FiledOrder.class);
            final FiledOrder orderDestComp = dest.getAnnotation(FiledOrder.class);
            // 比較
            if (orderSrcComp != null) {
                if (orderDestComp != null) {
                    // 比較してどちらもアノテーションがある場合は以下を返却
                    // 比較元 < 比較先 : 負（昇順にしたいので、自分（比較元）の方が小さい負を返す）
                    // 比較元 = 比較先 : 0
                    // 比較元 > 比較先 : 正（昇順にしたいので、自分（比較元）の方が大きい正を返す）
                    return orderSrcComp.value() - orderDestComp.value();
                }
                // 比較先のアノテーションがなかった場合は負を返却（比較先を後ろに持っていくため、自分（比較元）の方が小さい値を返す）
                return -1;
            }
            if (orderDestComp != null) {
                // 比較元のアノテーションがなかった場合は正を返却（比較先を前に持っていくため、自分（比較元）の方が大きい値を返す）
                return 1;
            }
            // アノテーションがどちらもない場合は、変数名で並べる
            return src.getName().compareTo(dest.getName());
        });
        return fields;
    }

    /**
     * POJOからマップへ変換.
     * <p>
     * ！！注意：{@literal @}{@link FiledOrder}アノテーションが付いていないエンティティの変数は取得されない！！<br>
     * メンバ変数名のキーが「変数名」、値が「変数の値」の{@link Map}を取得する。<br>
     * </p>
     *
     * @param  <T>      エンティティクラスの仮型
     * @param  Clazz    取得したいエンティティのクラス
     * @param  instance 取得したいエンティティ
     * @return          POJOマップ（キー：変数名、値：変数の値）
     */
    static <T> Map<String, Object> pojoToMap(final Class<?> Clazz,
                                             final T instance) {
        // メンバ変数から変数名と値を取得し、マップに詰める
        final Map<String, Object> variableNames = Maps.newLinkedHashMapWithExpectedSize(32); // デフォルトだと小さすぎるてパフォーマンスがよくないため、初期容量を32とする
        for (final Field field : sort(Clazz)) {
            field.setAccessible(true);
            final FiledOrder order = field.getAnnotation(FiledOrder.class);
            if (order != null) {
                variableNames.put(field.getName(),
                                  getVariableValue(field, instance));
            }
        }
        return variableNames;
    }

    /**
     * 変数の値を取得.
     * <p>
     * {@link Field#get(Object)}で値を取得。<br>
     * </p>
     *
     * @param  <T>      エンティティクラスの仮型
     * @param  field    {@linkplain Field}
     * @param  instance 値を取得したいインスタンス
     * @return          取得した値
     */
    static <T> Object getVariableValue(final Field field, final T instance) {
        try {
            return field.get(instance);
        } catch (@SuppressWarnings("unused") final IllegalArgumentException
                                                   | IllegalAccessException e) {
            return null;
        }
    }

    /**
     * 主キー変数リスト作成.
     * <p>
     * メンバ変数名をスネークケースに変換し、String配列で返却。<br>
     * 取得した配列は変数名がスネークケースとなっているため、SELECT文として利用できる。<br>
     * 例：変数名=fieldA、fieldBを持ったクラスを渡すと、["field_a", "field_b"]の配列を返す。<br>
     * </p>
     *
     * @param  clazz 取得したいエンティティのクラス
     * @return       スネークケースに変換後の配列
     */
    static List<String> newPrimaryKeyVariableArray(final Class<?> clazz) {
        // メンバ変数から変数名を取得し、マップに詰める
        final List<String> variableNames = new ArrayList<>();
        // 並び替え後の配列を取得し、ループする
        for (final Field field : sort(clazz)) {
            field.setAccessible(true);
            final javax.persistence.Id primaryKeyAnnotation = field.getAnnotation(javax.persistence.Id.class);
            if (primaryKeyAnnotation != null) {
                // フィールドの変数名をDB側の名前にする（ローワキャメルケースからスネークケースにする）
                variableNames.add(field.getName());
            }
        }
        return variableNames;
    }
}
