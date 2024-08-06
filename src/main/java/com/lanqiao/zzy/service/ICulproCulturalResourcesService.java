package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.CulproCulturalResources;

import java.util.List;

public interface ICulproCulturalResourcesService {
    //    为首页选出三个历代名医用于展示
    List<CulproCulturalResources> selectForHomeHistoricalDoc();
    //    为首页选出五个中医流派用于展示
    List<CulproCulturalResources> selectForHomeTCMAcademic();
}
