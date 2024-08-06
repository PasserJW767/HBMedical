package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopCooExc;
import org.apache.ibatis.annotations.Param;

public interface ITbIndustrialDevelopCooExcService {
    Page<TbIndustrialDevelopCooExc> selectForPage(int pageNum,  int pageSize);
    TbIndustrialDevelopCooExc selectByPrimaryKey(TbIndustrialDevelopCooExc key);
    TbIndustrialDevelopCooExc selectByitemid(int itemid);
    Page<TbIndustrialDevelopCooExc> selectByTitle( int pageNum,  int pageSize,
                                                 TbIndustrialDevelopCooExc cooexc);
}
