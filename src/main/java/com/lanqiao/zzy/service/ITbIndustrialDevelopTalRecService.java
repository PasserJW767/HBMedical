package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopTalRec;

public interface ITbIndustrialDevelopTalRecService {
    Page<TbIndustrialDevelopTalRec> selectForPages(int pageNum, int pageSize);
    TbIndustrialDevelopTalRec selectByPrimaryKey(TbIndustrialDevelopTalRec talRec);
    Page<TbIndustrialDevelopTalRec> selectByTitle(TbIndustrialDevelopTalRec talrec,int pageNum,int pageSize);
}
