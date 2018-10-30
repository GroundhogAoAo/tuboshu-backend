package com.tuboshu.dao;

import com.tuboshu.bean.TbsMessageVerification;
import com.tuboshu.bean.TbsMessageVerificationQuery;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TbsMessageVerificationDao {
    int countByExample(TbsMessageVerificationQuery example);

    int deleteByExample(TbsMessageVerificationQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(TbsMessageVerification record);

    int insertSelective(TbsMessageVerification record);

    List<TbsMessageVerification> selectByExample(TbsMessageVerificationQuery example);

    TbsMessageVerification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbsMessageVerification record, @Param("example") TbsMessageVerificationQuery example);

    int updateByExample(@Param("record") TbsMessageVerification record, @Param("example") TbsMessageVerificationQuery example);

    int updateByPrimaryKeySelective(TbsMessageVerification record);

    int updateByPrimaryKey(TbsMessageVerification record);
}