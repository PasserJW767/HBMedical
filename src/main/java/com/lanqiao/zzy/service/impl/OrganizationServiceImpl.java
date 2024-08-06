package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.Organization;
import com.lanqiao.zzy.mapper.OrganizationMapper;
import com.lanqiao.zzy.service.IOrganizationService;
import  com.lanqiao.zzy.mapper.OrganizationMapper;
import  com.lanqiao.zzy.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("organizationService")
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public List<Organization> selectAll() {
        return this.organizationMapper.selectAll();
    }
    @Override
    public List<Organization> selectNumofOrgByLocal() {
        return organizationMapper.selectNumofOrgByLocal();
    }

    @Override
    public Page<Organization> selectOrgList(Organization org, int pageNum, int pageSize) {
        return organizationMapper.selectOrgList(org, pageNum, pageSize);
    }

    @Override
    public List<Organization> selectLocate() {
        return organizationMapper.selectLocate();
    }

    @Override
    public List<Organization> selectIdentify() {
        return organizationMapper.selectIdentify();
    }

    @Override
    public Organization selectorgDetail(String orgName) {
        return organizationMapper.selectorgDetail(orgName);
    }

    @Override
    public int selectTotalnum() {
        return organizationMapper.selectTotalnum();
    }

    @Override
    public Organization selectbyOrgCode(String orgcode) {
        return organizationMapper.selectbyOrgCode(orgcode);
    }
}
