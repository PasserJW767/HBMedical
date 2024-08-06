package com.lanqiao.zzy.service.impl;



import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareChineseMedicine;
import com.lanqiao.zzy.mapper.HealthCareChineseMedicineMapper;
import com.lanqiao.zzy.service.IHealthCareChineseMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class HealthCareChineseMedicineServiceImpl implements IHealthCareChineseMedicineService {

    @Autowired
    HealthCareChineseMedicineMapper healthCareChineseMedicineMapper;

    @Override
    public Page<HealthCareChineseMedicine> selectForFirst(int pageNum, int pageSize) {
        return this.healthCareChineseMedicineMapper.selectForFirst(pageNum,pageSize);
    }

    @Override
    public Page<HealthCareChineseMedicine> selectForSecond(int pageNum, int pageSize) {
        return this.healthCareChineseMedicineMapper.selectForSecond(pageNum,pageSize);
    }

    @Override
    public HealthCareChineseMedicine selectForSearch(String chineseMedicineName) {
        return this.healthCareChineseMedicineMapper.selectForSearch(chineseMedicineName);
    }

    @Override
    public HealthCareChineseMedicine selectForDetailById(Integer itemId) {
        return this.healthCareChineseMedicineMapper.selectForDetailById(itemId);
    }

    @Override
    public List<HealthCareChineseMedicine> selectForAll() {
        return this.healthCareChineseMedicineMapper.selectForAll();
    }

    @Override
    public String selectForImage(Integer itemId) {
        return this.healthCareChineseMedicineMapper.selectForImage(itemId);
    }
}
