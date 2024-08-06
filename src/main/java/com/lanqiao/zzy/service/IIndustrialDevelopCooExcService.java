package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.IndustrialDevelopCooExc;

import java.util.List;

public interface IIndustrialDevelopCooExcService {
    //    选出最新的四条用于首页展示
    List<IndustrialDevelopCooExc> selectForHome();
}
