package com.aichat.dao.genrated.dao;

import com.aichat.dao.genrated.model.UserToUserRecordEntity;
import com.aichat.dao.genrated.model.UserToUserRecordEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserToUserRecordEntityMapper {
    long countByExample(UserToUserRecordEntityExample example);

    int deleteByExample(UserToUserRecordEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserToUserRecordEntity record);

    int insertSelective(UserToUserRecordEntity record);

    List<UserToUserRecordEntity> selectByExample(UserToUserRecordEntityExample example);

    UserToUserRecordEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserToUserRecordEntity record, @Param("example") UserToUserRecordEntityExample example);

    int updateByExample(@Param("record") UserToUserRecordEntity record, @Param("example") UserToUserRecordEntityExample example);

    int updateByPrimaryKeySelective(UserToUserRecordEntity record);

    int updateByPrimaryKey(UserToUserRecordEntity record);
}