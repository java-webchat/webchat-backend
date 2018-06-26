package com.aichat.dao.genrated.dao;

import com.aichat.dao.genrated.model.UserUserRelationEntity;
import com.aichat.dao.genrated.model.UserUserRelationEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserUserRelationEntityMapper {
    long countByExample(UserUserRelationEntityExample example);

    int deleteByExample(UserUserRelationEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserUserRelationEntity record);

    int insertSelective(UserUserRelationEntity record);

    List<UserUserRelationEntity> selectByExample(UserUserRelationEntityExample example);

    UserUserRelationEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserUserRelationEntity record, @Param("example") UserUserRelationEntityExample example);

    int updateByExample(@Param("record") UserUserRelationEntity record, @Param("example") UserUserRelationEntityExample example);

    int updateByPrimaryKeySelective(UserUserRelationEntity record);

    int updateByPrimaryKey(UserUserRelationEntity record);
}