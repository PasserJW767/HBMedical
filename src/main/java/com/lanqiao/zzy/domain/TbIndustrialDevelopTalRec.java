package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * tb_industrial_develop_tal_rec
 * @author 
 */
@Data
@ToString
public class TbIndustrialDevelopTalRec implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;
    /**
     * 招聘标题
     */
    private String recruitmentTitle;

    /**
     * 招聘职位
     */
    private String recruitmentPosition;

    /**
     * 招聘数量
     */
    private String recruitmentCount;

    /**
     * 薪资
     */
    private String salary;

    /**
     * 工作地点
     */
    private String workplace;

    /**
     * 学历要求
     */
    private String education;

    /**
     * 投递邮箱
     */
    private String emali;

    /**
     * 职位要求
     */
    private String postDuty;

    /**
     * 职位描述
     */
    private String postDescr;

    /**
     * 数据状态
     */
    private String status;

    /**
     * 发布单位编码
     */
    private String orgCode;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 创建时间
     */
    private Date itemcreateat;

    /**
     * 修改人
     */
    private String updater;

    /**
     * 修改时间
     */
    private Date itemupdateat;

    private static final long serialVersionUID = 1L;
}