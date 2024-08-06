package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareFamPre;
import com.lanqiao.zzy.mapper.HealthCareFamPreMapper;
import com.lanqiao.zzy.service.IHealthCareFamPreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
*
*/
@Service("healthCareFamPreService")
// 支持事务，增加、删除、更新操作单独使用 propagation = Propagation.REQUIRED
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class HealthCareFamPreServiceImpl implements IHealthCareFamPreService {

    @Autowired
    HealthCareFamPreMapper healthCareFamPreMapper;


    /**
     * 首页：国医健康
     */
    @Override
    public Page<HealthCareFamPre> selectHealthCareFamPreForHome(int pageNum, int pageSize) {
        return healthCareFamPreMapper.selectHealthCareFamPreForHome(pageNum, pageSize);
    }
    @Override
    public Page<HealthCareFamPre> selectAll(int pageNum, int pageSize) {
        return this.healthCareFamPreMapper.selectAll(pageNum,  pageSize);
    }

    @Override
    public HealthCareFamPre selectDoctorDetailById(Integer itemId){
        return this.healthCareFamPreMapper.selectDoctorDetailById(itemId);
    }

    @Override
    public List<HealthCareFamPre> selectAllDoctorDetail() {
        return this.healthCareFamPreMapper.selectAllDoctorDetail();
    }
}
