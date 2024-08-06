package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareFamPre;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * @Entity .domain.TbHealthCareFamPre
 */
@Mapper
public interface HealthCareFamPreMapper {

    /**
     * 首页：国医健康
     */
   Page<HealthCareFamPre> selectHealthCareFamPreForHome(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    public Page<HealthCareFamPre> selectAll(@Param("pageNum" )int pageNum, @Param("pageSize") int pageSize);

    public HealthCareFamPre selectDoctorDetailById(Integer itemId);

    public List<HealthCareFamPre> selectAllDoctorDetail();
}
