package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * 中医文化、科普知识数据记录表
 * @TableName tb_culpro_chinese_cultural
 */
@Data
@ToString
public class CulproChineseCultural implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;

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
     * 数据类型（区分数据类别）;
1.文化古迹;
2.非物质文化遗产;
3.文化场馆;
1.电视电影;
2.动漫游戏;
3.漫画典故;
健康旅游信息;
     */
    private String chineseCulturalType;

    /**
     * 数据状态：
1、上架中
2、已下架
3、待上架
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


    private CulturalFacilities culturalFacilities;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CulproChineseCultural other = (CulproChineseCultural) that;
        return (this.getItemid() == null ? other.getItemid() == null : this.getItemid().equals(other.getItemid()))
            && (this.getItemcode() == null ? other.getItemcode() == null : this.getItemcode().equals(other.getItemcode()))
            && (this.getChineseCulturalName() == null ? other.getChineseCulturalName() == null : this.getChineseCulturalName().equals(other.getChineseCulturalName()))
            && (this.getChineseCulturalContent() == null ? other.getChineseCulturalContent() == null : this.getChineseCulturalContent().equals(other.getChineseCulturalContent()))
            && (this.getChineseCulturalSource() == null ? other.getChineseCulturalSource() == null : this.getChineseCulturalSource().equals(other.getChineseCulturalSource()))
            && (this.getChineseCulturalAuthor() == null ? other.getChineseCulturalAuthor() == null : this.getChineseCulturalAuthor().equals(other.getChineseCulturalAuthor()))
            && (this.getVisitNum() == null ? other.getVisitNum() == null : this.getVisitNum().equals(other.getVisitNum()))
            && (this.getChineseCulturalType() == null ? other.getChineseCulturalType() == null : this.getChineseCulturalType().equals(other.getChineseCulturalType()))
            && (this.getChineseCulturalStatus() == null ? other.getChineseCulturalStatus() == null : this.getChineseCulturalStatus().equals(other.getChineseCulturalStatus()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getItemcreateat() == null ? other.getItemcreateat() == null : this.getItemcreateat().equals(other.getItemcreateat()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getItemupdateat() == null ? other.getItemupdateat() == null : this.getItemupdateat().equals(other.getItemupdateat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemid() == null) ? 0 : getItemid().hashCode());
        result = prime * result + ((getItemcode() == null) ? 0 : getItemcode().hashCode());
        result = prime * result + ((getChineseCulturalName() == null) ? 0 : getChineseCulturalName().hashCode());
        result = prime * result + ((getChineseCulturalContent() == null) ? 0 : getChineseCulturalContent().hashCode());
        result = prime * result + ((getChineseCulturalSource() == null) ? 0 : getChineseCulturalSource().hashCode());
        result = prime * result + ((getChineseCulturalAuthor() == null) ? 0 : getChineseCulturalAuthor().hashCode());
        result = prime * result + ((getVisitNum() == null) ? 0 : getVisitNum().hashCode());
        result = prime * result + ((getChineseCulturalType() == null) ? 0 : getChineseCulturalType().hashCode());
        result = prime * result + ((getChineseCulturalStatus() == null) ? 0 : getChineseCulturalStatus().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getItemcreateat() == null) ? 0 : getItemcreateat().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getItemupdateat() == null) ? 0 : getItemupdateat().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemid=").append(itemid);
        sb.append(", itemcode=").append(itemcode);
        sb.append(", chineseCulturalName=").append(chineseCulturalName);
        sb.append(", chineseCulturalContent=").append(chineseCulturalContent);
        sb.append(", chineseCulturalSource=").append(chineseCulturalSource);
        sb.append(", chineseCulturalAuthor=").append(chineseCulturalAuthor);
        sb.append(", visitNum=").append(visitNum);
        sb.append(", chineseCulturalType=").append(chineseCulturalType);
        sb.append(", chineseCulturalStatus=").append(chineseCulturalStatus);
        sb.append(", creater=").append(creater);
        sb.append(", itemcreateat=").append(itemcreateat);
        sb.append(", updater=").append(updater);
        sb.append(", itemupdateat=").append(itemupdateat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}