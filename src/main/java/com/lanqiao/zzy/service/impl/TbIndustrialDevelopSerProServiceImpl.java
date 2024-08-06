package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.domain.TbIndustrialDevelopSerPro;
import com.lanqiao.zzy.domain.TbIndustrialDevelopTecSerOrg;
import com.lanqiao.zzy.mapper.TbIndustrialDevelopSerProMapper;
import com.lanqiao.zzy.service.ITbIndustrialDevelopSerProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("tbIndustrialDevelopSerProService")
public class TbIndustrialDevelopSerProServiceImpl implements ITbIndustrialDevelopSerProService {
    @Autowired
    TbIndustrialDevelopSerProMapper tbIndustrialDevelopSerProMapper;
    @Override
    public List<TbIndustrialDevelopSerPro> selectByorgCode(TbIndustrialDevelopSerPro tbIndustrialDevelopSerPro) {
        return tbIndustrialDevelopSerProMapper.selectByorgCode(tbIndustrialDevelopSerPro);
    }

    @Override
    public TbIndustrialDevelopSerPro selectByPk(TbIndustrialDevelopSerPro tbIndustrialDevelopSerPro) {
        return tbIndustrialDevelopSerProMapper.selectByPk(tbIndustrialDevelopSerPro);
    }

    @Override
    public TbIndustrialDevelopSerPro selectBefore(int itemid) {
        return tbIndustrialDevelopSerProMapper.selectBefore(itemid);
    }

    @Override
    public TbIndustrialDevelopSerPro selectAfter(int itemid) {
        return tbIndustrialDevelopSerProMapper.selectAfter(itemid);
    }
}
