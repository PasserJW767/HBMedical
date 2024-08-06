package com.lanqiao.zzy.service;


import com.lanqiao.zzy.domain.CulproChineseCultural;

import java.util.List;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseCultural;

import java.util.List;

/**
*
*/
public interface ICulproChineseCulturalService {
    //    查询在首页展示的健康旅游6条数据
    List<CulproChineseCultural> selectForHomeHealthTravel();

    public Page<CulproChineseCultural> selectGjForPage(Integer pageNum, Integer pageSize);
    public Page<CulproChineseCultural> selectCgForPage(Integer pageNum, Integer pageSize);
    public Page<CulproChineseCultural> selectYcForPage(Integer pageNum, Integer pageSize);
    public Page<CulproChineseCultural> selectDyForPage(Integer pageNum, Integer pageSize);
    public Page<CulproChineseCultural> selectDmForPage(Integer pageNum, Integer pageSize);
    public Page<CulproChineseCultural> selectMhForPage(Integer pageNum, Integer pageSize);
    public Page<CulproChineseCultural> selectLyForPage(Integer pageNum, Integer pageSize);
    public List<CulproChineseCultural> selectAllDetails(String type);
    public CulproChineseCultural selectDetailsById(Integer itemId);
}
