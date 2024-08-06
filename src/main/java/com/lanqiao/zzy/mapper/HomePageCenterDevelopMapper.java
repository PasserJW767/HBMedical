package com.lanqiao.zzy.mapper;


/**
 * @Entity com.lanqiao.zzy.domain.User
*/

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HomePageCenterDevelopMapper {

    public int calCountByOrgidentify(@Param("orgidentify") String orgidentify);

}
