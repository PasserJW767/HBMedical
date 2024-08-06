package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbCulproData;
import com.lanqiao.zzy.service.ITbCulproDataService;
import com.lanqiao.zzy.util.DelTagsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    ITbCulproDataService tbCulproDataService;
//    @Autowired
//    ITbCulproFileService tbCulproFileService;
    @RequestMapping("/newslist")
    public String selectforPage(Integer pageNum, Model model) {
        if (pageNum == null) {
            pageNum=1;
        }
        Page<TbCulproData> newsPage =  tbCulproDataService.selectFoPagesNew(pageNum, 3);
        for (TbCulproData tbCulproData : newsPage) {
            String textFromHtml = DelTagsUtil.getTextFromHtml(tbCulproData.getDataContent());
            tbCulproData.setContent(textFromHtml);
        }
        model.addAttribute("newsPage", newsPage);

        return "NewsAnnouncement/NewsAnnouncementList";
    }

    @RequestMapping("/newsdetail")
    public String selectDetail(TbCulproData tbCulproData, Model model, Integer pageNum) {
        if (pageNum == null) {
            pageNum=1;
        }
        TbCulproData newsDetial = tbCulproDataService.selectByPrimaryKeyNew(tbCulproData);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("newsDetial", newsDetial);
        TbCulproData After = tbCulproDataService.selectAfterNew(newsDetial);
        TbCulproData Before = tbCulproDataService.selectBeforeNew(newsDetial);
        model.addAttribute("before", Before);
        model.addAttribute("after", After);
        return "NewsAnnouncement/NewsAnnouncementDetail";
    }

}
