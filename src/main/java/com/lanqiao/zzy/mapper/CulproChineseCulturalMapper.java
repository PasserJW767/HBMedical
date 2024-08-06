package com.lanqiao.zzy.mapper;


import com.lanqiao.zzy.domain.CulproChineseCultural;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseCultural;
import org.apache.ibatis.annotations.Param;
/*import org.w3c.dom.stylesheets.LinkStyle;*/

import java.util.List;

/**
* @Entity com.lanqiao.zzy.domain.CulproChineseCultural
*/

@Mapper
public interface CulproChineseCulturalMapper {

    //    查询在首页展示的健康旅游6条数据
    List<CulproChineseCultural> selectForHomeHealthTravel();

    public Page<CulproChineseCultural> selectGjForPage(@Param("pageNum") int pageNum,
                                                       @Param("pageSize") int pageSize);

    public Page<CulproChineseCultural> selectCgForPage(@Param("pageNum") int pageNum,
                                                       @Param("pageSize") int pageSize);

    public Page<CulproChineseCultural> selectYcForPage(@Param("pageNum") int pageNum,
                                                       @Param("pageSize") int pageSize);

    public Page<CulproChineseCultural> selectDyForPage(@Param("pageNum") int pageNum,
                                                       @Param("pageSize") int pageSize);

    public Page<CulproChineseCultural> selectDmForPage(@Param("pageNum") int pageNum,
                                                       @Param("pageSize") int pageSize);

    public Page<CulproChineseCultural> selectMhForPage(@Param("pageNum") int pageNum,
                                                       @Param("pageSize") int pageSize);

    public Page<CulproChineseCultural> selectLyForPage(@Param("pageNum") int pageNum,
                                                       @Param("pageSize") int pageSize);

    public List<CulproChineseCultural> selectAllDetails(String type);
    public CulproChineseCultural selectDetailsById(Integer itemId);
}
