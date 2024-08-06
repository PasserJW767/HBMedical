package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopCooExc;
import com.lanqiao.zzy.mapper.TbIndustrialDevelopCooExcMapper;
import com.lanqiao.zzy.service.ITbIndustrialDevelopCooExcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tbIndustrialDevelopCooExcService")
public class TbIndustrialDevelopCooExcServiceImpl implements ITbIndustrialDevelopCooExcService {
    @Autowired
    TbIndustrialDevelopCooExcMapper tbIndustrialDevelopCooExcMapper;
    @Override
    public Page<TbIndustrialDevelopCooExc> selectForPage(int pageNum, int pageSize) {
        return tbIndustrialDevelopCooExcMapper.selectForPage(pageNum, pageSize);
    }

    @Override
    public TbIndustrialDevelopCooExc selectByPrimaryKey(TbIndustrialDevelopCooExc key) {
        return tbIndustrialDevelopCooExcMapper.selectByPrimaryKey(key);
    }

    @Override
    public TbIndustrialDevelopCooExc selectByitemid(int itemid) {
        return tbIndustrialDevelopCooExcMapper.selectByitemid(itemid);
    }

    @Override
    public Page<TbIndustrialDevelopCooExc> selectByTitle(int pageNum, int pageSize, TbIndustrialDevelopCooExc cooexc) {
        return tbIndustrialDevelopCooExcMapper.selectByTitle(pageNum, pageSize, cooexc);
    }
}
