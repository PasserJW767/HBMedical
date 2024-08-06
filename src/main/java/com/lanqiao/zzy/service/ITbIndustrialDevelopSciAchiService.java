package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopSciAchi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITbIndustrialDevelopSciAchiService {
    List<TbIndustrialDevelopSciAchi> selectByorgCode(TbIndustrialDevelopSciAchi tbIndustrialDevelopSciAchi);
    Page<TbIndustrialDevelopSciAchi> selectForPage( int pageNum,  int pageSize);
    TbIndustrialDevelopSciAchi selectByPrimaryKey(TbIndustrialDevelopSciAchi key);
    TbIndustrialDevelopSciAchi selectByitemId(int itemid);
    Page<TbIndustrialDevelopSciAchi> selectByTitle(int pageNum, int pageSize,
                                                  TbIndustrialDevelopSciAchi sci);
}
