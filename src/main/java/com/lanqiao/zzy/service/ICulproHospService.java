package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproHosp;

import java.util.List;

public interface ICulproHospService {


    /**
     * 首页医院数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<CulproHosp> selectHospitalForHome(Integer pageNum, Integer pageSize);

    /**
     * 根据条件分页查询“医院”
     * @param culproHosp
     * @return
     */
    Page<CulproHosp> selectHospitalByCondiction(CulproHosp culproHosp, Integer pageNum, Integer pageSize);

    /**
     * 查询医院所有的市
     * @return
     */
    List<String> selectHospitalCity();


    /**
     * 根据itemid查询页码
     * @param itemid
     * @return
     */
    public Integer selectPageNum(Integer itemid);

}