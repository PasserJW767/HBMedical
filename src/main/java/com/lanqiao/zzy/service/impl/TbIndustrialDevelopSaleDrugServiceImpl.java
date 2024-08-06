package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.domain.TbIndustrialDevelopSaleDrug;
import com.lanqiao.zzy.mapper.TbIndustrialDevelopSaleDrugMapper;
import com.lanqiao.zzy.service.ITbIndustrialDevelopSaleDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tbIndustrialDevelopSaleDrugService")
public class TbIndustrialDevelopSaleDrugServiceImpl implements ITbIndustrialDevelopSaleDrugService {
    @Autowired
    TbIndustrialDevelopSaleDrugMapper tbIndustrialDevelopSaleDrugMapper;
    @Override
    public TbIndustrialDevelopSaleDrug selectSalMedAndFile(TbIndustrialDevelopSaleDrug saleDrug) {
        return tbIndustrialDevelopSaleDrugMapper.selectSalMedAndFile(saleDrug);
    }

    @Override
    public List<TbIndustrialDevelopSaleDrug> selectByOrgcode(String OrgCode) {
        return tbIndustrialDevelopSaleDrugMapper.selectByOrgcode(OrgCode);
    }
}
