package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_culpro_cultural_resources
 * @author 
 */
@Data
@ToString
public class CulproCulturalResources extends CulproCulturalResourcesKey implements Serializable {
    /**
     * 中医文化名称
     */
    private String chineseCulturalName;

    /**
     * 正文
     */
    private String chineseCulturalContent;

    /**
     * 来源
     */
    private String chineseCulturalSource;

    /**
     * 作者
     */
    private String chineseCulturalAuthor;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    /**
     * 数据类型（区分数据类别）
     */
    private String chineseCulturalType;

    /**
     * 数据状态
     */
    private String chineseCulturalStatus;

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

//    用于存放需要的图片的路径，没有则为NULL
    private String imgPath;

    private static final long serialVersionUID = 1L;
}