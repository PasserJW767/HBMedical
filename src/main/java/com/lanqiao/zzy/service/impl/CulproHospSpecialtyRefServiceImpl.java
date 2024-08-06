package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.domain.CulproHospSpecialtyRef;
import com.lanqiao.zzy.mapper.CulproHospSpecialtyRefMapper;
import com.lanqiao.zzy.service.ICulproHospSpecialtyRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 莫起润
 * @date : 2021/8/1/20:58
 */
@Service("CulproHospSpecialtyRefService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CulproHospSpecialtyRefServiceImpl implements ICulproHospSpecialtyRefService {

    @Autowired
    CulproHospSpecialtyRefMapper culproHospSpecialtyRefMapper;
    @Override
    public List<CulproHospSpecialtyRef> selectCulproSpecialtyByHospCode(String itemcode) {
        List<CulproHospSpecialtyRef> culproHospSpecialtyRefs = this.culproHospSpecialtyRefMapper.selectCulproSpecialtyByHospCode(itemcode);
        return culproHospSpecialtyRefs;
    }
}
