package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseMedicine;
import com.lanqiao.zzy.domain.CulproHosp;
import com.lanqiao.zzy.domain.CulproSpecialty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CulproChineseMedicineMapper {

    Page<CulproChineseMedicine> selectDoctorForHome(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    public Page<CulproChineseMedicine> selectForCulproChineseMedicineList(CulproChineseMedicine culproChineseMedicine, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
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