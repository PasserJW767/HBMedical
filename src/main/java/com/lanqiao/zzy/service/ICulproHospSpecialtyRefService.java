package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.CulproHospSpecialtyRef;
import com.lanqiao.zzy.mapper.CulproHospSpecialtyRefMapper;

import java.util.List;

/**
 * @author : 莫起润
 * @date : 2021/8/1/20:57
 */
public interface ICulproHospSpecialtyRefService {
    public List<CulproHospSpecialtyRef> selectCulproSpecialtyByHospCode(String itemcode);
}
