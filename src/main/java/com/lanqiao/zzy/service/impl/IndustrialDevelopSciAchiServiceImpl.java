package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.domain.IndustrialDevelopSciAchi;
import com.lanqiao.zzy.mapper.IndustrialDevelopSciAchiMapper;
import com.lanqiao.zzy.service.IIndustrialDevelopSciAchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("industrialDevelopSciAchiService")
public class IndustrialDevelopSciAchiServiceImpl implements IIndustrialDevelopSciAchiService {

    @Autowired
    IndustrialDevelopSciAchiMapper industrialDevelopSciAchiMapper;

    @Override
    public List<IndustrialDevelopSciAchi> selectForHome() {
        return this.industrialDevelopSciAchiMapper.selectForHome();
    }
}
