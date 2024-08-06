package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.TbCulproFile;

import java.util.List;

public interface ITbCulproFileService {

    public List<TbCulproFile> selectByOrgCode(String OrgCode);
}
