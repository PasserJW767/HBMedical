package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareSciKnow;
import com.lanqiao.zzy.mapper.HealthCareSciKnowMapper;
import com.lanqiao.zzy.service.IHealthCareSciKnowService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class HealthCareSciKnowServiceImpl implements IHealthCareSciKnowService {
    @Autowired
    HealthCareSciKnowMapper healthCareSciKnowMapper;

    @Override
    public Page<HealthCareSciKnow> selectHealthCareSciKnowForHome(int pageNum, int pageSize) {
        return healthCareSciKnowMapper.selectHealthCareSciKnowForHome(pageNum, pageSize);
    }

    public Page<HealthCareSciKnow> selectAllForSciKnow(int pageNum, int pageSize) {
        return this.healthCareSciKnowMapper.selectAllForSciKnow(pageNum, pageSize);
    }

    @Override
    public HealthCareSciKnow selectSciDetailById(Integer itemId) {
        return this.healthCareSciKnowMapper.selectSciDetailById(itemId);
    }

    @Override
    public List<HealthCareSciKnow> selectSciAllDetail() {
        return this.healthCareSciKnowMapper.selectSciAllDetail();
    }
}
