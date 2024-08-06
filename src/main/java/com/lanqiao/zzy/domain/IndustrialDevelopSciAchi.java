package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_industrial_develop_sci_achi
 * @author 
 */
@Data
@ToString
public class IndustrialDevelopSciAchi extends IndustrialDevelopSciAchiKey implements Serializable {
    /**
     * 科研成果名称
     */
    private String industrialDevelopName;

    /**
     * 主研人
     */
    private String industrialDevelopLeader;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    /**
     * 数据状态
     */
    private String industrialDevelopStatus;

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
     * 成果简介
     */
    private String context;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 用户机构code
     */
    private String orgCode;

    private Organization organization;

    private static final long serialVersionUID = 1L;
}