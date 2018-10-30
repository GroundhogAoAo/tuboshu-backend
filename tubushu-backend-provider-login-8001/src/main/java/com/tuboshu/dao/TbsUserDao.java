package com.tuboshu.dao;

import com.tuboshu.bean.TbsUser;
import com.tuboshu.bean.TbsUserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbsUserDao {
    int countByExample(TbsUserQuery example);

    int deleteByExample(TbsUserQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(TbsUser record);

    int insertSelective(TbsUser record);

    List<TbsUser> selectByExample(TbsUserQuery example);

    TbsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbsUser record, @Param("example") TbsUserQuery example);

    int updateByExample(@Param("record") TbsUser record, @Param("example") TbsUserQuery example);

    int updateByPrimaryKeySelective(TbsUser record);

    int updateByPrimaryKey(TbsUser record);
}