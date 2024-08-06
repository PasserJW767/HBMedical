package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareChineseMedicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity .domain.com.lanqiao.zzy.domain.HealthCareChineseMedicine
*/
public interface HealthCareChineseMedicineMapper  {

    public Page<HealthCareChineseMedicine> selectForFirst(@Param("pageNum" )int pageNum, @Param("pageSize") int pageSize);


    public Page<HealthCareChineseMedicine> selectForSecond(@Param("pageNum" )int pageNum, @Param("pageSize") int pageSize);

    public HealthCareChineseMedicine selectForSearch(String chineseMedicineName);

    public HealthCareChineseMedicine selectForDetailById(Integer itemId);

    public List<HealthCareChineseMedicine> selectForAll();

    public String selectForImage(Integer itemId);



}
