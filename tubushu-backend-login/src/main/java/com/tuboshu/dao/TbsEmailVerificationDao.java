package com.tuboshu.dao;

import com.tuboshu.bean.TbsEmailVerification;
import com.tuboshu.bean.TbsEmailVerificationQuery;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TbsEmailVerificationDao {
    int countByExample(TbsEmailVerificationQuery example);

    int deleteByExample(TbsEmailVerificationQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(TbsEmailVerification record);

    int insertSelective(TbsEmailVerification record);

    List<TbsEmailVerification> selectByExample(TbsEmailVerificationQuery example);

    TbsEmailVerification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbsEmailVerification record, @Param("example") TbsEmailVerificationQuery example);

    int updateByExample(@Param("record") TbsEmailVerification record, @Param("example") TbsEmailVerificationQuery example);

    int updateByPrimaryKeySelective(TbsEmailVerification record);

    int updateByPrimaryKey(TbsEmailVerification record);
}