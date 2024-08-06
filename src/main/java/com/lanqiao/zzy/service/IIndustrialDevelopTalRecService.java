package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.IndustrialDevelopTalRec;

import java.util.List;

public interface IIndustrialDevelopTalRecService {
    //    选出最新的3条用于首页展示
    List<IndustrialDevelopTalRec> selectForHome();
}
