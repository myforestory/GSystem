package com.ever.gsystem.api.domain.repositories.mabatis;

import com.ever.gsystem.api.domain.entities.MstMember;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions.TableCondition;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.sql.SqlProvider;
import com.ever.gsystem.api.domain.repositories.fieldinfo.EntityFiledInfo;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@linkplain MstMember MemberMaster}REPOSITORY（Mybatis版）.
 * <p>
 * Complex SQL that cannot be realized by JPA is managed here.
 * </p>
 *
 * @param   <T> Table管理畫面 模擬GET Request Message
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Repository // Make it a repository layer class with Spring MVC
@Mapper     // Use Mybatis
public interface MstMemberRepositoryMybatis<T> {
    /** {@linkplain MstMember MemberMaster}之entity情報. */
    FiledControllable ENTITY_FILED_INFO = new EntityFiledInfo<>(MstMember.class);

    /**
     * MemberMaster Table檢索＋sort.
     * <p>
     * {@link MstMember MemberMaster}Table取得複數筆資料。
     * </p>
     *
     * @param  condition 檢索條件
     * @return           檢索結果。{@link MstMember MemberMaster}Table複數筆資料
     */
    @SelectProvider(type = SqlProvider.class, method = SqlProvider.SELET_ALL)
    List<MstMember> selectAll(TableCondition<T> condition);
}
