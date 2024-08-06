package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproFamPre;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * @Entity .domain.com.lanqiao.zzy.domain.TbCulproFamPre
 */
@Mapper
public interface CulproFamPreMapper {
    /*首页：历史名方 */
    Page<CulproFamPre> selectCulproFamPreForHome(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    public Page<CulproFamPre> selectAllForFamPre(@Param("pageNum" )int pageNum, @Param("pageSize") int pageSize);

    public CulproFamPre selectHistoryFamPreById(Integer itemId);

    public List<CulproFamPre> selectAllFamPreDetail();

}