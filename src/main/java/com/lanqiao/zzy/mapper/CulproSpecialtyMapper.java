package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseMedicine;
import com.lanqiao.zzy.domain.CulproSpecialty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 * @Entity com.lanqiao.zzy.domain.CulproSpecialty
 */
@Mapper
public interface CulproSpecialtyMapper  {

    public Page<CulproSpecialty> selectSpecialtyForHome(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    public Page<CulproSpecialty> selectForCulproSpecialtyList(CulproSpecialty culproSpecialty, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    public Integer selectPageNum(Integer itemid);
    public List<CulproChineseMedicine> selectCulproChineseMedicineMapperByDeptCode(String itemcode);
    public List<String> selectCulproSpecialtyCity();
    public List<String> selectCulproSpecialtySpecialtyName();
}

