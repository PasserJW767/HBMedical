package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.TbIndustrialDevelopSerPro;
import com.lanqiao.zzy.domain.TbIndustrialDevelopTecSerOrg;

import java.util.List;

public interface ITbIndustrialDevelopSerProService {
    public List<TbIndustrialDevelopSerPro> selectByorgCode(TbIndustrialDevelopSerPro tbIndustrialDevelopSerPro);
    public TbIndustrialDevelopSerPro selectByPk(TbIndustrialDevelopSerPro tbIndustrialDevelopSerPro);
    public TbIndustrialDevelopSerPro selectBefore(int itemid);
    public TbIndustrialDevelopSerPro selectAfter(int itemid);
}
