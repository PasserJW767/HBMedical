package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.domain.IndustrialDevelopCooExc;
import com.lanqiao.zzy.mapper.IndustrialDevelopCooExcMapper;
import com.lanqiao.zzy.service.IIndustrialDevelopCooExcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("industrialDevelopCooExcService")
public class IndustrialDevelopCooExcServiceImpl implements IIndustrialDevelopCooExcService {

    @Autowired
    IndustrialDevelopCooExcMapper industrialDevelopCooExcMapper;

    //    选出最新的四条用于首页展示
    @Override
    public List<IndustrialDevelopCooExc> selectForHome() {
        return industrialDevelopCooExcMapper.selectForHome();
    }
}
