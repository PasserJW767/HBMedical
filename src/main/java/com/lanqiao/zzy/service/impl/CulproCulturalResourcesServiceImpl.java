package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.domain.CulproCulturalResources;
import com.lanqiao.zzy.mapper.CulproCulturalResourcesMapper;
import com.lanqiao.zzy.service.ICulproCulturalResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("culproCulturalResourcesService")
public class CulproCulturalResourcesServiceImpl implements ICulproCulturalResourcesService {

    @Autowired
    CulproCulturalResourcesMapper culproCulturalResourcesMapper;


    @Override
    public List<CulproCulturalResources> selectForHomeHistoricalDoc() {
        return this.culproCulturalResourcesMapper.selectForHomeHistoricalDoc();
    }

    @Override
    public List<CulproCulturalResources> selectForHomeTCMAcademic() {
        return this.culproCulturalResourcesMapper.selectForHomeTCMAcademic();
    }
}
