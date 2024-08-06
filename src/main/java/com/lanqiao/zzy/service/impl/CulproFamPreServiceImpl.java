package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproFamPre;
import com.lanqiao.zzy.mapper.CulproFamPreMapper;
import com.lanqiao.zzy.service.ICulproFamPreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
// 支持事务，增加、删除、更新操作单独使用 propagation = Propagation.REQUIRED
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CulproFamPreServiceImpl implements ICulproFamPreService {
    @Autowired
    CulproFamPreMapper culproFamPreMapper;

    @Override
    public Page<CulproFamPre> selectCulproFamPreForHome(int pageNum, int pageSize) {
        return culproFamPreMapper.selectCulproFamPreForHome(pageNum, pageSize);
    }
    public Page<CulproFamPre> selectAllForFamPre(int pageNum, int pageSize) {
        return this.culproFamPreMapper.selectAllForFamPre(pageNum,pageSize);
    }

    @Override
    public CulproFamPre selectHistoryFamPreById(Integer itemId){
        return this.culproFamPreMapper.selectHistoryFamPreById(itemId);
    }

    @Override
    public List<CulproFamPre> selectAllFamPreDetail() {
        return this.culproFamPreMapper.selectAllFamPreDetail();
    }
}
