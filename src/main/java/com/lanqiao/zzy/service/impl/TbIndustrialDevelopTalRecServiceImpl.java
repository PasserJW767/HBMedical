package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopTalRec;
import com.lanqiao.zzy.mapper.TbIndustrialDevelopTalRecMapper;
import com.lanqiao.zzy.service.ITbIndustrialDevelopTalRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tbIndustrialDevelopTalRecService")
public class TbIndustrialDevelopTalRecServiceImpl implements ITbIndustrialDevelopTalRecService {
    @Autowired
    TbIndustrialDevelopTalRecMapper tbIndustrialDevelopTalRecMapper;
    @Override
    public Page<TbIndustrialDevelopTalRec> selectForPages(int pageNum, int pageSize) {
        return tbIndustrialDevelopTalRecMapper.selectForPages(pageNum, pageSize);
    }

    @Override
    public TbIndustrialDevelopTalRec selectByPrimaryKey(TbIndustrialDevelopTalRec talRec) {
        return tbIndustrialDevelopTalRecMapper.selectByPrimaryKey(talRec);
    }

    @Override
    public Page<TbIndustrialDevelopTalRec> selectByTitle(TbIndustrialDevelopTalRec talrec, int pageNum, int pageSize) {
        return tbIndustrialDevelopTalRecMapper.selectByTitle(talrec, pageNum, pageSize);  }


}
