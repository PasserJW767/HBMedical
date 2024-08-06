package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.TbIndustrialDevelopSaleDrug;

import java.util.List;

public interface ITbIndustrialDevelopSaleDrugService {
    TbIndustrialDevelopSaleDrug selectSalMedAndFile(TbIndustrialDevelopSaleDrug saleDrug);
    List<TbIndustrialDevelopSaleDrug> selectByOrgcode(String OrgCode);
}
