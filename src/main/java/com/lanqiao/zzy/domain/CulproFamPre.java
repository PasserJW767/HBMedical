package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**历史名方数据记录表
 * tb_culpro_fam_pre
 * @author
 */
@Data
@ToString
public class CulproFamPre  implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;

    /**
     * 方名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 来源
     */
    private String famsource;

    /**
     * 出处
     */
    private String source;

    /**
     * 处方
     */
    private String prescription;

    /**
     * 正文
     */
    private String content;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    /**
     * 数据状态
     */
    private String status;

    /**
     * 剂型
     */
    private String type;

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