package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopSciAchi;
import com.lanqiao.zzy.mapper.TbIndustrialDevelopSciAchiMapper;
import com.lanqiao.zzy.service.ITbIndustrialDevelopSciAchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tbIndustrialDevelopSciAchiService")
public class TbIndustrialDevelopSciAchiServiceImpl implements ITbIndustrialDevelopSciAchiService {
    @Autowired
    TbIndustrialDevelopSciAchiMapper tbIndustrialDevelopSciAchiMapper;

    @Override
    public List<TbIndustrialDevelopSciAchi> selectByorgCode(TbIndustrialDevelopSciAchi tbIndustrialDevelopSciAchi) {
        return tbIndustrialDevelopSciAchiMapper.selectByorgCode(tbIndustrialDevelopSciAchi);
    }

    @Override
    public Page<TbIndustrialDevelopSciAchi> selectForPage(int pageNum, int pageSize) {
        return tbIndustrialDevelopSciAchiMapper.selectForPage(pageNum, pageSize);
    }

    @Override
    public TbIndustrialDevelopSciAchi selectByPrimaryKey(TbIndustrialDevelopSciAchi key) {
        return tbIndustrialDevelopSciAchiMapper.selectByPrimaryKey(key);
    }

    @Override
    public TbIndustrialDevelopSciAchi selectByitemId(int itemid) {
        return tbIndustrialDevelopSciAchiMapper.selectByitemId(itemid);
    }

    @Override
    public Page<TbIndustrialDevelopSciAchi> selectByTitle(int pageNum, int pageSize, TbIndustrialDevelopSciAchi sci) {
        return tbIndustrialDevelopSciAchiMapper.selectByTitle(pageNum, pageSize, sci);
    }
}
