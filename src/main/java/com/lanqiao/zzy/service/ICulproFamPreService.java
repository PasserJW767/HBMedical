package com.lanqiao.zzy.service;


import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproFamPre;

import java.util.List;

/**
*
*/
public interface ICulproFamPreService {
    /*首页：历史名方 */
    Page<CulproFamPre> selectCulproFamPreForHome(int pageNum, int pageSize);

    public Page<CulproFamPre> selectAllForFamPre(int pageNum, int pageSize);

    public CulproFamPre selectHistoryFamPreById(Integer itemId);

    public List<CulproFamPre> selectAllFamPreDetail();

}
