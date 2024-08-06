package com.lanqiao.zzy.service;

import com.lanqiao.zzy.domain.Organization;

import java.util.List;
import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.Organization;
import java.util.List;
public interface IOrganizationService {
    List<Organization> selectAll();
    public List<Organization> selectNumofOrgByLocal();
    public Page<Organization> selectOrgList(Organization org, int pageNum, int pageSize);
    public List<Organization> selectLocate();
    public List<Organization> selectIdentify();
    public Organization selectorgDetail(String orgName);
    public int selectTotalnum();
    public Organization selectbyOrgCode(String orgcode);
}

