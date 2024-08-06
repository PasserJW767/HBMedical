package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareSciKnow;

import java.util.List;

/**
*
*/
public interface IHealthCareSciKnowService {
    /*首页：科普知识*/
    Page<HealthCareSciKnow> selectHealthCareSciKnowForHome(int pageNum, int pageSize);

    public Page<HealthCareSciKnow> selectAllForSciKnow(int pageNum, int pageSize);

    public HealthCareSciKnow selectSciDetailById(Integer itemId);

    public List<HealthCareSciKnow> selectSciAllDetail();
}
