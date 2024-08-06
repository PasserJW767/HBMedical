package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproHosp;
import com.lanqiao.zzy.mapper.CulproHospMapper;
import com.lanqiao.zzy.service.ICulproHospService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 莫起润
 * @date : 2021/8/1/17:25
 */
@Service("CulproHospService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CulproHospServiceImpl implements ICulproHospService {
    @Autowired
    CulproHospMapper culproHospMapper;

    /**
     * 首页医院数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<CulproHosp> selectHospitalForHome(Integer pageNum, Integer pageSize) {
        return culproHospMapper.selectHospitalForHome(pageNum,pageSize);
    }

    /**
     * 根据条件查询“医院”
     * @param culproHosp
     * @return
     */
    @Override
    public Page<CulproHosp> selectHospitalByCondiction(CulproHosp culproHosp, Integer pageNum, Integer pageSize){
        Page<CulproHosp> culproHosps = culproHospMapper.selectHospitalByCondiction(culproHosp, pageNum, pageSize);
        return culproHosps;
    }

    /**
     * 查询医院所有的市
     * @return
     */
    public List<String> selectHospitalCity(){
        List<String> strings = culproHospMapper.selectHospitalCity();
        return strings;
    }



    /**
     * 根据id查页号
     * @param itemid
     * @return
     */
    public Integer selectPageNum(Integer itemid){
        return culproHospMapper.selectPageNum(itemid);
    }

}
