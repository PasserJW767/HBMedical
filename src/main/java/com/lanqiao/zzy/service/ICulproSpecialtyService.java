package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseMedicine;
import com.lanqiao.zzy.domain.CulproSpecialty;

import java.util.List;

/**
*
*/

public interface ICulproSpecialtyService {
    /*查询医院用于首页*/
    public Page<CulproSpecialty> selectSpecialtyForHome(int pageNum, int pageSize);

    public Page<CulproSpecialty> selectForCulproSpecialtyList(CulproSpecialty culproSpecialty, int pageNum, int pageSize);
    public List<CulproChineseMedicine> selectCulproChineseMedicineMapperByDeptCode(String itemcode);
    public List<String> selectCulproSpecialtyCity();
    public List<String> selectCulproSpecialtySpecialtyName();
    public Integer selectPageNum(Integer itemid);

}
