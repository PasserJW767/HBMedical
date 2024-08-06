package com.lanqiao.zzy.mapper;

import com.lanqiao.zzy.domain.IndustrialDevelopTalRec;
import com.lanqiao.zzy.domain.IndustrialDevelopTalRecKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndustrialDevelopTalRecMapper {
    int deleteByPrimaryKey(IndustrialDevelopTalRecKey key);

    int insert(IndustrialDevelopTalRec record);

    int insertSelective(IndustrialDevelopTalRec record);

    IndustrialDevelopTalRec selectByPrimaryKey(IndustrialDevelopTalRecKey key);

    int updateByPrimaryKeySelective(IndustrialDevelopTalRec record);

    int updateByPrimaryKey(IndustrialDevelopTalRec record);

//    选出最新的3条用于首页展示
    List<IndustrialDevelopTalRec> selectForHome();
}