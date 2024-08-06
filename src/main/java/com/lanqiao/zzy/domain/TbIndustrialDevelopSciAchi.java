package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * tb_industrial_develop_sci_achi
 * @author 
 */
@Data
@ToString
public class TbIndustrialDevelopSciAchi implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;
    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 科研成果名称
     */
    private String industrialDevelopName;

    /**
     * 主研人
     */
    private String industrialDevelopLeader;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 成果简介
     */
    private String context;

    /**
     * 数据状态
     */
    private String industrialDevelopStatus;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    /**
     * 用户机构code
     */
    private String orgCode;

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
    //机构
    Organization organization;
// 附件
    TbCulproFile tbCulproFile;
    private static final long serialVersionUID = 1L;
}