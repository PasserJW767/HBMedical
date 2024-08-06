package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseMedicine;
import com.lanqiao.zzy.domain.CulproHosp;
import com.lanqiao.zzy.domain.CulproSpecialty;
import com.lanqiao.zzy.mapper.CulproChineseMedicineMapper;
import com.lanqiao.zzy.service.ICulproChineseMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 莫起润
 * @date : 2021/8/1/12:32
 */
@Service("CulproChineseMedicineService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CulproChineseMedicineServiceImpl implements ICulproChineseMedicineService {

    @Autowired
    CulproChineseMedicineMapper culproChineseMedicineMapper;

    @Override
    public Page<CulproChineseMedicine> selectDoctorForHome(int pageNum, int pageSize) {
        Page<CulproChineseMedicine> culproChineseMedicines = this.culproChineseMedicineMapper.selectDoctorForHome( pageNum, pageSize);
        return culproChineseMedicines;

    }
    public Page<CulproChineseMedicine> selectForCulproChineseMedicineList(CulproChineseMedicine culproChineseMedicine, int pageNum, int pageSize) {
        Page<CulproChineseMedicine> culproChineseMedicines = this.culproChineseMedicineMapper.selectForCulproChineseMedicineList(culproChineseMedicine, pageNum, pageSize);
        return culproChineseMedicines;

    }

    /**
     * 查询医生表所属的医院
     * @return
     */
    @Override
    public List<CulproHosp> selectAllHospital(){
        List<CulproHosp> culproHosps = culproChineseMedicineMapper.selectAllHospital();
        return culproHosps;
    }

    /**
     * 查询医生表所属的科室
     * @return
     */
    @Override
    public List<CulproSpecialty> selectAllSpecialty(){
        List<CulproSpecialty> culproSpecialties = culproChineseMedicineMapper.selectAllSpecialty();
        return culproSpecialties;
    }


    /**
     * 根据itemid查询页码
     * @param itemid
     * @return
     */
    @Override
    public Integer selectPageNum(Integer itemid){
        return culproChineseMedicineMapper.selectPageNum(itemid);
    }
}
