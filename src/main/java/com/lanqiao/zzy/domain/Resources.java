package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author 黄舒帆
 * @create 2021/7/23 15:46
 */
@Data
@ToString
public class Resources {
    private Integer itemID;
    private String itemCode;
    private String culName;
    private String culContent;
    private String culSource;
    private String culAuthor;
    private Integer visitNum;
    private String culType;
    private String culStatus;
    private String creater;
    private Date itemCreateAt;
    private String updater;
    private Date itemUpdateAt;
    private CulproFile culproFile;
}
