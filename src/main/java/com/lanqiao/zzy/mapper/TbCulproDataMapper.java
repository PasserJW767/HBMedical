package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbCulproData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TbCulproDataMapper {
    int deleteByPrimaryKey(TbCulproData key);

    int insert(TbCulproData record);
    int insertSelective(TbCulproData record);
    int updateByPrimaryKeySelective(TbCulproData record);
    int updateByPrimaryKey(TbCulproData record);


    /*通知公告*/
    TbCulproData selectByPrimaryKey(TbCulproData key);
    Page<TbCulproData> selectFoPages(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    TbCulproData selectBefore(TbCulproData tbCulproData);
    TbCulproData selectAfter(TbCulproData tbCulproData);
    /*新闻*/
    TbCulproData selectByPrimaryKeyNew(TbCulproData key);
    Page<TbCulproData> selectFoPagesNew(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    TbCulproData selectBeforeNew(TbCulproData tbCulproData);
    TbCulproData selectAfterNew(TbCulproData tbCulproData);
    /*办事指南*/
    TbCulproData selectByPrimaryKeyServiceguide(TbCulproData key);
    Page<TbCulproData> selectFoPagesServiceguide(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    TbCulproData selectBeforeServiceguide(TbCulproData tbCulproData);
    TbCulproData selectAfterServiceguide(TbCulproData tbCulproData);
}