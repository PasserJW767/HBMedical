package com.lanqiao.zzy.mapper;

import com.lanqiao.zzy.domain.IndustrialDevelopSciAchi;
import com.lanqiao.zzy.domain.IndustrialDevelopSciAchiKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndustrialDevelopSciAchiMapper {
    int deleteByPrimaryKey(IndustrialDevelopSciAchiKey key);

    int insert(IndustrialDevelopSciAchi record);

    int insertSelective(IndustrialDevelopSciAchi record);

    IndustrialDevelopSciAchi selectByPrimaryKey(IndustrialDevelopSciAchiKey key);

    int updateByPrimaryKeySelective(IndustrialDevelopSciAchi record);

    int updateByPrimaryKey(IndustrialDevelopSciAchi record);

//    查出4条供首页展示
    List<IndustrialDevelopSciAchi> selectForHome();
}