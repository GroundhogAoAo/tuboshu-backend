package com.tuboshu.dao;

import com.tuboshu.bean.TbsCountry;
import com.tuboshu.bean.TbsCountryQuery;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TbsCountryDao {
    int countByExample(TbsCountryQuery example);

    int deleteByExample(TbsCountryQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbsCountry record);

    int insertSelective(TbsCountry record);

    List<TbsCountry> selectByExample(TbsCountryQuery example);

    TbsCountry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbsCountry record, @Param("example") TbsCountryQuery example);

    int updateByExample(@Param("record") TbsCountry record, @Param("example") TbsCountryQuery example);

    int updateByPrimaryKeySelective(TbsCountry record);

    int updateByPrimaryKey(TbsCountry record);
}