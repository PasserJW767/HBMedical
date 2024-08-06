package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * 用户表
 * @TableName user
 */
@Data
@ToString
public class User implements Serializable {
    /**
     * 
     */
    private Integer itemid;

    /**
     * 唯一标识UUID
     */
    private String itemcode;

    /**
     * 机构id(关联organization表中的itemID）
     */
    private String orgCode;

    /**
     * 登陆账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 身份证件类型
     */
    private String idcardType;

    /**
     * 证件号码
     */
    private String idcardNo;

    /**
     * email
     */
    private String email;

    /**
     * 
     */
    private String state;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 电话号码
     */
    private String mobilephone;

    /**
     * 创建人
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
     * 地级机构id
     */
    private String cityid;

    /**
     * 类型（0：普通，1：管理员）
     */
    private Integer type;

    /**
     * 肖像
     */
    private byte[] portrait;

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
        User other = (User) that;
        return (this.getItemid() == null ? other.getItemid() == null : this.getItemid().equals(other.getItemid()))
            && (this.getItemcode() == null ? other.getItemcode() == null : this.getItemcode().equals(other.getItemcode()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getIdcardType() == null ? other.getIdcardType() == null : this.getIdcardType().equals(other.getIdcardType()))
            && (this.getIdcardNo() == null ? other.getIdcardNo() == null : this.getIdcardNo().equals(other.getIdcardNo()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
            && (this.getMobilephone() == null ? other.getMobilephone() == null : this.getMobilephone().equals(other.getMobilephone()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getItemcreateat() == null ? other.getItemcreateat() == null : this.getItemcreateat().equals(other.getItemcreateat()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getItemupdateat() == null ? other.getItemupdateat() == null : this.getItemupdateat().equals(other.getItemupdateat()))
            && (this.getCityid() == null ? other.getCityid() == null : this.getCityid().equals(other.getCityid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (Arrays.equals(this.getPortrait(), other.getPortrait()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemid() == null) ? 0 : getItemid().hashCode());
        result = prime * result + ((getItemcode() == null) ? 0 : getItemcode().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getIdcardType() == null) ? 0 : getIdcardType().hashCode());
        result = prime * result + ((getIdcardNo() == null) ? 0 : getIdcardNo().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getContacts() == null) ? 0 : getContacts().hashCode());
        result = prime * result + ((getMobilephone() == null) ? 0 : getMobilephone().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getItemcreateat() == null) ? 0 : getItemcreateat().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getItemupdateat() == null) ? 0 : getItemupdateat().hashCode());
        result = prime * result + ((getCityid() == null) ? 0 : getCityid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + (Arrays.hashCode(getPortrait()));
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
        sb.append(", orgCode=").append(orgCode);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", idcardType=").append(idcardType);
        sb.append(", idcardNo=").append(idcardNo);
        sb.append(", email=").append(email);
        sb.append(", state=").append(state);
        sb.append(", contacts=").append(contacts);
        sb.append(", mobilephone=").append(mobilephone);
        sb.append(", creater=").append(creater);
        sb.append(", itemcreateat=").append(itemcreateat);
        sb.append(", updater=").append(updater);
        sb.append(", itemupdateat=").append(itemupdateat);
        sb.append(", cityid=").append(cityid);
        sb.append(", type=").append(type);
        sb.append(", portrait=").append(portrait);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}