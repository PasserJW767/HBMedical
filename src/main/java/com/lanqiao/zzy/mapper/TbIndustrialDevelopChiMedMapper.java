package com.lanqiao.zzy.mapper;

import  com.lanqiao.zzy.domain.TbIndustrialDevelopChiMed;


public interface TbIndustrialDevelopChiMedMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopChiMed key);

    int insert(TbIndustrialDevelopChiMed record);

    int insertSelective(TbIndustrialDevelopChiMed record);

    TbIndustrialDevelopChiMed selectByPrimaryKey(TbIndustrialDevelopChiMed key);

    int updateByPrimaryKeySelective(TbIndustrialDevelopChiMed record);

    int updateByPrimaryKey(TbIndustrialDevelopChiMed record);
}