package com.ever.gsystem.api.domain.repositories.fieldinfo;

import java.util.List;
import lombok.ToString;

/**
 * エンティティのフィールド情報を管理するクラス.
 *
 * @param   <T> エンティティクラスの仮型
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@ToString
public class EntityFiledInfo<T> implements FiledControllable {
    /** クラス名. */
    private final String       CLASS_NAME;
    /** 変数名をスネークケース化した配列. */
    private final List<String> VARIABLE_SNAKE_CASE_NAMES_ARRAY;

    /**
     * コンストラクタ.
     *
     * @param clazz エンティティのクラス
     */
    public EntityFiledInfo(final Class<T> clazz) {
        this.CLASS_NAME                      = clazz.getSimpleName();
        this.VARIABLE_SNAKE_CASE_NAMES_ARRAY = FiledControllable.newFiledOrderVariableSnakeCaseNamesArray(clazz);
    }

    /** エンティティの{@inheritDoc} */
    @Override
    public String getClassName() {
        return this.CLASS_NAME;
    }

    /** エンティティの{@inheritDoc} */
    @Override
    public List<String> getFiledOrderVariableSnakeCaseNamesArray() {
        return this.VARIABLE_SNAKE_CASE_NAMES_ARRAY;
    }
}
