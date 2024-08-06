package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopMedMat;

import java.util.List;

public interface ITbIndustrialDevelopMedMatService {
    List<TbIndustrialDevelopMedMat> selectBypalce(String placeName);
    List<TbIndustrialDevelopMedMat> selectNum();
    TbIndustrialDevelopMedMat selectByOrgCodeAndNameName(TbIndustrialDevelopMedMat medMat);
    List<TbIndustrialDevelopMedMat> selectByLocate();
    List<TbIndustrialDevelopMedMat> selectByName();
    Page<TbIndustrialDevelopMedMat> selectMedMatList(TbIndustrialDevelopMedMat med, int pageNum, int pageSize);
    List<TbIndustrialDevelopMedMat> selectByorgcode(String orgcode);
}
