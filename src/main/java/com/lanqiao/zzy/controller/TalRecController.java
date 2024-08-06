package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopTalRec;
import com.lanqiao.zzy.service.ITbIndustrialDevelopTalRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/talrec")
public class TalRecController {
    @Autowired
    ITbIndustrialDevelopTalRecService tbIndustrialDevelopTalRecService;

    @GetMapping("/talrecList")
    public String selectTalrecPage(Integer pageNum, Model model,HttpSession session) {
        if (pageNum == null) {
            pageNum=1;
        }
        TbIndustrialDevelopTalRec curentSerch = (TbIndustrialDevelopTalRec)session.getAttribute("curentSerch2");
        Page<TbIndustrialDevelopTalRec> TalRecPage = tbIndustrialDevelopTalRecService.selectForPages(pageNum, 3);
        if ( curentSerch!= null) {
            TalRecPage=tbIndustrialDevelopTalRecService.selectByTitle(curentSerch,pageNum,3);
        }
        model.addAttribute("TalRecPage", TalRecPage);
        return "IndustrialDevelopment/TalReclist";
    }

    @GetMapping("/talrecDetail")
    public String selectTalrecByPriKey(TbIndustrialDevelopTalRec talRec,Model model,Integer pageNum) {
        TbIndustrialDevelopTalRec tbIndustrialDevelopTalRec = tbIndustrialDevelopTalRecService.selectByPrimaryKey(talRec);
        model.addAttribute("talrec", tbIndustrialDevelopTalRec);
        model.addAttribute("pageNum", pageNum);
        return "IndustrialDevelopment/TalReclDetail";
    }

    @GetMapping("/serchByTitel")
    public String selectByTitle(TbIndustrialDevelopTalRec talrec, Integer pageNum, Model model, HttpSession session) {
        if (pageNum == null) {
            pageNum=1;
        }
        session.setAttribute("curentSerch2", talrec);
        Page<TbIndustrialDevelopTalRec> TalRecPage = tbIndustrialDevelopTalRecService.selectByTitle(talrec, pageNum, 3);
        model.addAttribute("TalRecPage", TalRecPage);
        return "IndustrialDevelopment/TalReclist";
    }
}
