package com.lanqiao.zzy.mapper;

import com.lanqiao.zzy.domain.IndustrialDevelopCooExc;
import com.lanqiao.zzy.domain.IndustrialDevelopCooExcKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndustrialDevelopCooExcMapper {
    int deleteByPrimaryKey(IndustrialDevelopCooExcKey key);

    int insert(IndustrialDevelopCooExc record);

    int insertSelective(IndustrialDevelopCooExc record);

    IndustrialDevelopCooExc selectByPrimaryKey(IndustrialDevelopCooExcKey key);

    int updateByPrimaryKeySelective(IndustrialDevelopCooExc record);

    int updateByPrimaryKey(IndustrialDevelopCooExc record);

//    选出最新的3条用于首页展示
    List<IndustrialDevelopCooExc> selectForHome();
}