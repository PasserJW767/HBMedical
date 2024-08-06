package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareFamPre;

import java.util.List;

/**
*
*/
public interface IHealthCareFamPreService {
    /**
     * 首页：国医健康
     */
    Page<HealthCareFamPre> selectHealthCareFamPreForHome(int pageNum, int pageSize);

    public Page<HealthCareFamPre> selectAll(int pageNum, int pageSize);

    public HealthCareFamPre selectDoctorDetailById(Integer itemId);

    public List<HealthCareFamPre> selectAllDoctorDetail();

}
