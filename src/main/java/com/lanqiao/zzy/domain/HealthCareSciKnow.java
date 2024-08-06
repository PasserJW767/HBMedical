package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 科普知识数据记录表
 * tb_health_care_sci_know
 * @author
 */
@Data
@ToString
public class HealthCareSciKnow  implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;

    /**
     * 科普知识名称
     */
    private String scienceKnowledgeName;

    /**
     * 科普知识来源
     */
    private String scienceKnowledgeSource;

    /**
     * 作者
     */
    private String scienceKnowledgeAuthor;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    /**
     * 正文
     */
    private String content;

    /**
     * 数据状态
     */
    private String scienceKnowledgeStatus;

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