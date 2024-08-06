package com.lanqiao.zzy.mapper;

import com.lanqiao.zzy.domain.CulproCulturalResources;
import com.lanqiao.zzy.domain.CulproCulturalResourcesKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CulproCulturalResourcesMapper {
    int deleteByPrimaryKey(CulproCulturalResourcesKey key);

    int insert(CulproCulturalResources record);

    int insertSelective(CulproCulturalResources record);

    CulproCulturalResources selectByPrimaryKey(CulproCulturalResourcesKey key);

    int updateByPrimaryKeySelective(CulproCulturalResources record);

    int updateByPrimaryKey(CulproCulturalResources record);

    //    为首页选出三个历代名医用于展示
    List<CulproCulturalResources> selectForHomeHistoricalDoc();

    //    为首页选出五个中医流派用于展示
    List<CulproCulturalResources> selectForHomeTCMAcademic();
}