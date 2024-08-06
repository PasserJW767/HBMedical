package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbCulproData;
import org.apache.ibatis.annotations.Param;

public interface ITbCulproDataService {
    /*通知公告*/
        Page<TbCulproData> selectFoPages(int pageNum, int pageSize);
        TbCulproData selectByPrimaryKey(TbCulproData tbCulproData);
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

