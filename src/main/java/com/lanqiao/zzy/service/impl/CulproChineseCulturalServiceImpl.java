package com.lanqiao.zzy.service.impl;


import com.lanqiao.zzy.domain.CulproChineseCultural;
import com.lanqiao.zzy.mapper.CulproChineseCulturalMapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseCultural;
import com.lanqiao.zzy.mapper.CulproChineseCulturalMapper;
import com.lanqiao.zzy.service.ICulproChineseCulturalService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service("culproChineseCulturalService")
public class CulproChineseCulturalServiceImpl implements ICulproChineseCulturalService {
    @Autowired
    CulproChineseCulturalMapper culproChineseCulturalMapper;

    @Override
    public Page<CulproChineseCultural> selectGjForPage(Integer pageNum, Integer pageSize) {
        return this.culproChineseCulturalMapper.selectGjForPage(pageNum,pageSize);
    }

    @Override
    public Page<CulproChineseCultural> selectCgForPage(Integer pageNum, Integer pageSize) {
        return this.culproChineseCulturalMapper.selectCgForPage(pageNum,pageSize);
    }

    @Override
    public Page<CulproChineseCultural> selectYcForPage(Integer pageNum, Integer pageSize) {
        return this.culproChineseCulturalMapper.selectYcForPage(pageNum,pageSize);
    }

    @Override
    public Page<CulproChineseCultural> selectDyForPage(Integer pageNum, Integer pageSize) {
        return this.culproChineseCulturalMapper.selectDyForPage(pageNum,pageSize);
    }

    @Override
    public Page<CulproChineseCultural> selectDmForPage(Integer pageNum, Integer pageSize) {
        return this.culproChineseCulturalMapper.selectDmForPage(pageNum,pageSize);
    }

    @Override
    public Page<CulproChineseCultural> selectMhForPage(Integer pageNum, Integer pageSize) {
        return this.culproChineseCulturalMapper.selectMhForPage(pageNum,pageSize);
    }

    @Override
    public Page<CulproChineseCultural> selectLyForPage(Integer pageNum, Integer pageSize) {
        return this.culproChineseCulturalMapper.selectLyForPage(pageNum,pageSize);
    }

    @Override
    public List<CulproChineseCultural> selectForHomeHealthTravel() {
        return this.culproChineseCulturalMapper.selectForHomeHealthTravel();
    }
    @Override
    public List<CulproChineseCultural> selectAllDetails(String type) {
        return this.culproChineseCulturalMapper.selectAllDetails(type);
    }

    @Override
    public CulproChineseCultural selectDetailsById(Integer itemId) {
        return this.culproChineseCulturalMapper.selectDetailsById(itemId);
    }
}
