package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.domain.TbCulproFile;
import com.lanqiao.zzy.mapper.TbCulproFileMapper;
import com.lanqiao.zzy.service.ITbCulproFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tbCulproFileService")
public class TbCulproFileServiceImpl implements ITbCulproFileService {
@Autowired
TbCulproFileMapper tbCulproFileMapper;
    @Override
    public List<TbCulproFile> selectByOrgCode(String OrgCode) {
        return tbCulproFileMapper.selectByOrgCode(OrgCode);
    }
}
