package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.IndustrialDevelopSciAchi;

import java.util.List;

public interface IIndustrialDevelopSciAchiService {
    //    查出4条供首页展示
    List<IndustrialDevelopSciAchi> selectForHome();
}
