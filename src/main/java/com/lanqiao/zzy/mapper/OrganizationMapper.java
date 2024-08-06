package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    List<Organization> selectAll();

    public List<Organization> selectNumofOrgByLocal();
    public Page<Organization> selectOrgList(@Param("org") Organization org,
                                            @Param("pageNum") int pageNum,
                                            @Param("pageSize") int pageSize );
    public List<Organization> selectLocate();
    public List<Organization> selectIdentify();
    public Organization selectorgDetail(String orgName);
    public int selectTotalnum();
    public Organization selectbyOrgCode(String orgcode);

}