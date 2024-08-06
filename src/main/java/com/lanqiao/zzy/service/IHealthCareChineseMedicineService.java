package com.lanqiao.zzy.service;


import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareChineseMedicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
*
*/
public interface IHealthCareChineseMedicineService {

    public Page<HealthCareChineseMedicine> selectForFirst(int pageNum, int pageSize);


    public Page<HealthCareChineseMedicine> selectForSecond(int pageNum, int pageSize);

    public HealthCareChineseMedicine selectForSearch(String chineseMedicineName);

    public HealthCareChineseMedicine selectForDetailById(Integer itemId);

    public List<HealthCareChineseMedicine> selectForAll();

    public String selectForImage(Integer itemId);
}
