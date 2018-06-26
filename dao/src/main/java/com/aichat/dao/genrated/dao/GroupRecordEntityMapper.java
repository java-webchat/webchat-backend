package com.aichat.dao.genrated.dao;

import com.aichat.dao.genrated.model.GroupRecordEntity;
import com.aichat.dao.genrated.model.GroupRecordEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupRecordEntityMapper {
    long countByExample(GroupRecordEntityExample example);

    int deleteByExample(GroupRecordEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupRecordEntity record);

    int insertSelective(GroupRecordEntity record);

    List<GroupRecordEntity> selectByExample(GroupRecordEntityExample example);

    GroupRecordEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupRecordEntity record, @Param("example") GroupRecordEntityExample example);

    int updateByExample(@Param("record") GroupRecordEntity record, @Param("example") GroupRecordEntityExample example);

    int updateByPrimaryKeySelective(GroupRecordEntity record);

    int updateByPrimaryKey(GroupRecordEntity record);
}