package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproData;
import com.lanqiao.zzy.domain.HomePageSearch;
import com.lanqiao.zzy.domain.TbCulproData;
import com.lanqiao.zzy.service.ICulproDataService;
import com.lanqiao.zzy.service.IHomePageSearchService;
//import com.sun.org.apache.xpath.internal.operations.Mod;
import com.lanqiao.zzy.service.ITbCulproDataService;
import com.lanqiao.zzy.service.impl.CulproDataServiceImpl;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/search")
@Slf4j
public class HomePageSearchController {
    @Autowired
    IHomePageSearchService homePageSearchService;
    @Autowired
    ICulproDataService culproDataService;
    @Autowired
    ITbCulproDataService tbCulproDataService;

    @GetMapping("")
    public String searchInfo(Model model,
                             @RequestParam("searchInfo") String searchInfo,
                             @RequestParam(value = "pageNum",required = false) Integer pageNum,
                             HttpSession session){
        if(pageNum==null){
            //提交的是查询表单
            pageNum=1;
            //保留当前的查询条件。供接下来点击分页链接时使用
            session.setAttribute("searchInfoCondition",searchInfo);
        }else {
            //点击分页链接时取回查询条件
            searchInfo= (String) session.getAttribute("searchInfoCondition");
        }

        final Page<HomePageSearch> homePageSearchList = this.homePageSearchService.selectBySearchInfo(searchInfo, pageNum, 10);

        for (HomePageSearch search : homePageSearchList) {
            final String dataContent = search.getDataContent();
            if(dataContent != null)
            {
                final Document parse = Jsoup.parse(dataContent);
                parse.select("img").remove(); //去掉DataContent中的img标签  用的库：jsoup
                search.setDataContent(parse.toString());
            }
        }

        model.addAttribute("homePageSearchList",homePageSearchList);
        model.addAttribute("searchInfo",searchInfo);
        return "homepage/search";
    }

    @GetMapping("/searchInfoDetail")
    public String searchDeatil(Model model,
                           @RequestParam(value = "itemid")   Integer itemid,
                             @RequestParam(value = "dataType") String dataType,@RequestParam(value = "itemcode") String itemcode){
        if("政策法规".equals(dataType)){
            final CulproData culproData = this.culproDataService.selectByItemId(itemid);
            model.addAttribute("culproData",culproData);
            return "Policies_regulations/regulationDetail";
        }


        TbCulproData tbCulproData = new TbCulproData();
        tbCulproData.setItemid(itemid);
        tbCulproData.setItemcode(itemcode);
        if("新闻".equals(dataType)){
            TbCulproData newsDetial = tbCulproDataService.selectByPrimaryKeyNew(tbCulproData);
            model.addAttribute("newsDetial", newsDetial);
            TbCulproData After = tbCulproDataService.selectAfterNew(newsDetial);
            TbCulproData Before = tbCulproDataService.selectBeforeNew(newsDetial);
            model.addAttribute("before", Before);
            model.addAttribute("after", After);
            return "NewsAnnouncement/NewsAnnouncementDetail";
        }


        if("通知公告".equals(dataType)){

        TbCulproData noticeDetial = tbCulproDataService.selectByPrimaryKey(tbCulproData);
        model.addAttribute("noticeDetial", noticeDetial);
        TbCulproData After = tbCulproDataService.selectAfter(noticeDetial);
        TbCulproData Before = tbCulproDataService.selectBefore(noticeDetial);
        model.addAttribute("before", Before);
        model.addAttribute("after", After);
        return "NoticeAnnouncement/NoticeDetail";
    }


        if("办事指南".equals(dataType)){
        TbCulproData znDetial = tbCulproDataService.selectByPrimaryKeyServiceguide(tbCulproData);
        model.addAttribute("znDetial", znDetial);
        TbCulproData After = tbCulproDataService.selectAfterServiceguide(znDetial);
        TbCulproData Before = tbCulproDataService.selectBeforeServiceguide(znDetial);
        model.addAttribute("before", Before);
        model.addAttribute("after", After);
        return "HandlingGuidelineAnnouncement/HandlingGuidelineDetail";
        }

        return null;
    }

}
