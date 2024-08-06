package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HomePageSearch {

    private Integer itemid;
    private String itemcode;
    /**
     * 新闻轮播、新闻、政策法规、规章制度、领导讲话、办事流程标题；公告名称
     */
    private String dataTitle;

    /**
     * 数据类型(用来区分）
     */
    private String dataType;

    /*
    * 属于政策法规的哪一个小类
    * */
    private String dataFileType;

    /**
     * 正文
     */
    private String dataContent;

    private static final long serialVersionUID = 1L;

}
