package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopTalRec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TbIndustrialDevelopTalRecMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopTalRec key);

    int insert(TbIndustrialDevelopTalRec record);

    int insertSelective(TbIndustrialDevelopTalRec record);

    TbIndustrialDevelopTalRec selectByPrimaryKey(TbIndustrialDevelopTalRec talRec);

    int updateByPrimaryKeySelective(TbIndustrialDevelopTalRec record);

    int updateByPrimaryKey(TbIndustrialDevelopTalRec record);
    Page<TbIndustrialDevelopTalRec> selectForPages(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    Page<TbIndustrialDevelopTalRec> selectByTitle(@Param("talrec") TbIndustrialDevelopTalRec talrec,
                                                                @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}