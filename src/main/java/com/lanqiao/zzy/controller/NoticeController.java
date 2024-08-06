package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbCulproData;
import com.lanqiao.zzy.service.ITbCulproDataService;
import com.lanqiao.zzy.service.ITbCulproFileService;
import com.lanqiao.zzy.util.DelTagsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    ITbCulproDataService tbCulproDataService;
@Autowired
    ITbCulproFileService tbCulproFileService;
    @RequestMapping("/noticelist")
    public String selectforPage(Integer pageNum, Model model) {
        if (pageNum == null) {
            pageNum=1;
        }
        Page<TbCulproData> noticePage =  tbCulproDataService.selectFoPages(pageNum, 3);
        for (TbCulproData tbCulproData : noticePage) {
            String textFromHtml = DelTagsUtil.getTextFromHtml(tbCulproData.getDataContent());
            tbCulproData.setContent(textFromHtml);
        }
        model.addAttribute("noticePage", noticePage);

        return "NoticeAnnouncement/NoticeAnnouncementList";
    }

    @RequestMapping("/noticedetail")
    public String selectDetail(TbCulproData tbCulproData,Model model,Integer pageNum) {
        if (pageNum == null) {
            pageNum=1;
        }
        TbCulproData noticeDetial = tbCulproDataService.selectByPrimaryKey(tbCulproData);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("noticeDetial", noticeDetial);
        TbCulproData After = tbCulproDataService.selectAfter(noticeDetial);
        TbCulproData Before = tbCulproDataService.selectBefore(noticeDetial);
        model.addAttribute("before", Before);
        model.addAttribute("after", After);
        return "NoticeAnnouncement/NoticeDetail";
    }

}
