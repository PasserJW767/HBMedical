package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.domain.IndustrialDevelopTalRec;
import com.lanqiao.zzy.mapper.IndustrialDevelopTalRecMapper;
import com.lanqiao.zzy.service.IIndustrialDevelopTalRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("industrialDevelopTalRecService")
public class IndustrialDevelopTalRecServiceImpl implements IIndustrialDevelopTalRecService {

    @Autowired
    IndustrialDevelopTalRecMapper industrialDevelopTalRecMapper;

    @Override
    public List<IndustrialDevelopTalRec> selectForHome() {
        return this.industrialDevelopTalRecMapper.selectForHome();
    }
}
