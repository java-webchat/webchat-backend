package com.aichat.dao.genrated.dao;

import com.aichat.dao.genrated.model.UserGroupRelationEntity;
import com.aichat.dao.genrated.model.UserGroupRelationEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupRelationEntityMapper {
    long countByExample(UserGroupRelationEntityExample example);

    int deleteByExample(UserGroupRelationEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserGroupRelationEntity record);

    int insertSelective(UserGroupRelationEntity record);

    List<UserGroupRelationEntity> selectByExample(UserGroupRelationEntityExample example);

    UserGroupRelationEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserGroupRelationEntity record, @Param("example") UserGroupRelationEntityExample example);

    int updateByExample(@Param("record") UserGroupRelationEntity record, @Param("example") UserGroupRelationEntityExample example);

    int updateByPrimaryKeySelective(UserGroupRelationEntity record);

    int updateByPrimaryKey(UserGroupRelationEntity record);
}