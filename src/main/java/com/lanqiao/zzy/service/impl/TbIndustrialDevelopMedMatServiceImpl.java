package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopMedMat;
import com.lanqiao.zzy.mapper.TbIndustrialDevelopMedMatMapper;
import com.lanqiao.zzy.service.ITbIndustrialDevelopMedMatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("tbIndustrialDevelopMedMatService")
public class TbIndustrialDevelopMedMatServiceImpl implements ITbIndustrialDevelopMedMatService {
    @Autowired
    TbIndustrialDevelopMedMatMapper tbIndustrialDevelopMedMatMapper;
    @Override
    public List<TbIndustrialDevelopMedMat> selectBypalce(String placeName) {
        return tbIndustrialDevelopMedMatMapper.selectByplace(placeName);
    }

    @Override
    public List<TbIndustrialDevelopMedMat> selectNum() {
        return tbIndustrialDevelopMedMatMapper.selectNum();
    }

    @Override
    public TbIndustrialDevelopMedMat selectByOrgCodeAndNameName(TbIndustrialDevelopMedMat medMat) {
        return tbIndustrialDevelopMedMatMapper.selectByOrgCodeAndNameName(medMat);
    }

    @Override
    public List<TbIndustrialDevelopMedMat> selectByLocate() {
        return tbIndustrialDevelopMedMatMapper.selectByLocate();
    }

    @Override
    public List<TbIndustrialDevelopMedMat> selectByName() {
        return tbIndustrialDevelopMedMatMapper.selectByName();
    }

    @Override
    public Page<TbIndustrialDevelopMedMat> selectMedMatList(TbIndustrialDevelopMedMat med, int pageNum, int pageSize) {
        return tbIndustrialDevelopMedMatMapper.selectMedMatList(med, pageNum, pageSize);
    }

    @Override
    public List<TbIndustrialDevelopMedMat> selectByorgcode(String orgcode) {
        return tbIndustrialDevelopMedMatMapper.selectByorgcode(orgcode);
    }
}
