package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 名老中医信息记录表
 * @TableName tb_culpro_chinese_medicine
 */
@Data
@ToString
public class CulproChineseMedicine implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;

    /**
     * 中医名称
     */
    private String chineseMedicineName;

    /**
     * 荣誉称号（国医大师）
     */
    private String chineseMedicineType;

    /**
     * 职称
     */
    private String chineseMedicineTitle;

    /**
     * 所在科室（科室表的code）
     */
    private String deptCode;

    /**
     * 出诊地点（医院code）
     */
    private String hospCode;

    /**
     * 出诊时间
     */
    private String visitTime;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 专家简介
     */
    private String expertBriefIntroduce;

    /**
     * 专家介绍
     */
    private String expertIntroduce;

    /**
     * 主要就诊
     */
    private String mainVisit;

    /**
     * 重点医案
     */
    private String medicineRecords;

    /**
     * 数据状态
     */
    private String chineseMedicineStatus;

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

    private CulproSpecialty culproSpecialty;
    private CulproHosp culproHosp;
    private CulproFile culproFile;
}