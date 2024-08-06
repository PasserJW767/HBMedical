package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_industrial_develop_tal_rec
 * @author 
 */
@Data
@ToString
public class IndustrialDevelopTalRec extends IndustrialDevelopTalRecKey implements Serializable {
    /**
     * 工作地点
     */
    private String workplace;

    /**
     * 招聘数量
     */
    private String recruitmentCount;

    /**
     * 职业要求
     */
    private String postDuty;

    /**
     * 职业描述
     */
    private String postDescr;

    /**
     * 薪资
     */
    private String salary;

    /**
     * 数据状态
     */
    private String status;

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

    /**
     * 标题
     */
    private String recruitmentTitle;

    /**
     * 招聘职位
     */
    private String recruitmentPosition;

    /**
     * 学历要求
     */
    private String education;

    /**
     * 投递邮箱
     */
    private String emali;

    /**
     * 用户机构Code
     */
    private String orgCode;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    private Organization organization;

    private static final long serialVersionUID = 1L;
}