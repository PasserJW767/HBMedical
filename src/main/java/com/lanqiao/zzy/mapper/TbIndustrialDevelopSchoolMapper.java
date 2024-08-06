package com.lanqiao.zzy.mapper;

import  com.lanqiao.zzy.domain.TbIndustrialDevelopSchool;

public interface TbIndustrialDevelopSchoolMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopSchool key);

    int insert(TbIndustrialDevelopSchool record);

    int insertSelective(TbIndustrialDevelopSchool record);

    TbIndustrialDevelopSchool selectByPrimaryKey(TbIndustrialDevelopSchool key);

    int updateByPrimaryKeySelective(TbIndustrialDevelopSchool record);

    int updateByPrimaryKey(TbIndustrialDevelopSchool record);
}