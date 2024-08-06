package com.lanqiao.zzy.service.impl;


import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproSpecialty;
import com.lanqiao.zzy.mapper.CulproSpecialtyMapper;
import com.lanqiao.zzy.service.ICulproSpecialtyService;
import com.lanqiao.zzy.domain.CulproChineseMedicine;
import com.lanqiao.zzy.domain.CulproSpecialty;
import com.lanqiao.zzy.mapper.CulproChineseMedicineMapper;
import com.lanqiao.zzy.mapper.CulproSpecialtyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
*
*/
@Service("culproSpecialtyService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CulproSpecialtyServiceImpl implements ICulproSpecialtyService {
    @Autowired
    CulproSpecialtyMapper culproSpecialtyMapper;

    /**
     * 查询医院用于首页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<CulproSpecialty> selectSpecialtyForHome(int pageNum, int pageSize){
        return culproSpecialtyMapper.selectSpecialtyForHome(pageNum, pageSize);
    }

    @Override
    public Page<CulproSpecialty> selectForCulproSpecialtyList(CulproSpecialty culproSpecialty,int pageNum,int pageSize) {
        Page<CulproSpecialty> culproSpecialties = this.culproSpecialtyMapper.selectForCulproSpecialtyList(culproSpecialty,pageNum, pageSize);
        return culproSpecialties;
    }
    @Override
    public List<CulproChineseMedicine> selectCulproChineseMedicineMapperByDeptCode(String itemcode) {
        List<CulproChineseMedicine> culproChineseMedicines = this.culproSpecialtyMapper.selectCulproChineseMedicineMapperByDeptCode(itemcode);
        return culproChineseMedicines;
    }
    @Override
    public List<String> selectCulproSpecialtyCity() {
        List<String> CulproSpecialtyCitys = this.culproSpecialtyMapper.selectCulproSpecialtyCity();
        return CulproSpecialtyCitys;
    }
    @Override
    public List<String> selectCulproSpecialtySpecialtyName() {
        List<String> CulproSpecialtySpecialtyNames = this.culproSpecialtyMapper.selectCulproSpecialtySpecialtyName();
        return CulproSpecialtySpecialtyNames;
    }


    @Override
    public Integer selectPageNum(Integer itemid) {
        Integer count = this.culproSpecialtyMapper.selectPageNum(itemid);
        return count;
    }
}
