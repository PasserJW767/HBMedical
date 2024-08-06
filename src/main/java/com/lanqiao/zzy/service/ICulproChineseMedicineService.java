package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseMedicine;
import com.lanqiao.zzy.domain.CulproHosp;
import com.lanqiao.zzy.domain.CulproSpecialty;

import java.util.List;


public interface ICulproChineseMedicineService {

     Page<CulproChineseMedicine> selectDoctorForHome(int pageNum, int pageSize);

     public Page<CulproChineseMedicine> selectForCulproChineseMedicineList(CulproChineseMedicine culproChineseMedicine, int pageNum, int pageSize);
     /**
      * 查询医生表所属的医院
      * @return
      */
     List<CulproHosp> selectAllHospital();

     /**
      * 查询医生表所属的科室
      * @return
      */
     List<CulproSpecialty> selectAllSpecialty();

     /**
      * 根据itemid查询页码
      * @param itemid
      * @return
      */
     public Integer selectPageNum(Integer itemid);
}

