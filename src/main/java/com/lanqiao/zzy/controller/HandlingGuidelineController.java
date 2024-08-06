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
@RequestMapping("/hg")
public class HandlingGuidelineController {
    @Autowired
    ITbCulproDataService tbCulproDataService;
//    @Autowired
//    ITbCulproFileService tbCulproFileService;
        @RequestMapping("/handlingguidelinelist")
    public String selectforPage(Integer pageNum, Model model) {
        if (pageNum == null) {
            pageNum=1;
        }
        Page<TbCulproData> znPage =  tbCulproDataService.selectFoPagesServiceguide(pageNum, 3);
        for (TbCulproData tbCulproData :znPage) {
            String textFromHtml = DelTagsUtil.getTextFromHtml(tbCulproData.getDataContent());
            tbCulproData.setContent(textFromHtml);
        }
        model.addAttribute("znPage",znPage);

        return "HandlingGuidelineAnnouncement/HandlingGuidelineList";
    }

    @RequestMapping("/HandlingGuidelinedetail")
    public String selectDetail(TbCulproData tbCulproData, Model model, Integer pageNum) {
        if (pageNum == null) {
            pageNum=1;
        }
        TbCulproData znDetial = tbCulproDataService.selectByPrimaryKeyServiceguide(tbCulproData);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("znDetial", znDetial);
        TbCulproData After = tbCulproDataService.selectAfterServiceguide(znDetial);
        TbCulproData Before = tbCulproDataService.selectBeforeServiceguide(znDetial);
        model.addAttribute("before", Before);
        model.addAttribute("after", After);
        return "HandlingGuidelineAnnouncement/HandlingGuidelineDetail";
    }
}
