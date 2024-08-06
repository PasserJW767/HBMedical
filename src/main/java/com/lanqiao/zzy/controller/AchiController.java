package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopCooExc;
import com.lanqiao.zzy.domain.TbIndustrialDevelopSciAchi;
import com.lanqiao.zzy.domain.TbIndustrialDevelopTalRec;
import com.lanqiao.zzy.service.ITbIndustrialDevelopSciAchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * File:
 * Author:@LJade
 * Time: 2021/8/1.
 */
@Controller
@RequestMapping("/achi")
public class AchiController {
    @Autowired
    ITbIndustrialDevelopSciAchiService tbIndustrialDevelopSciAchiService;
    @GetMapping("/achiList")
    public String selectTalrecPage(Integer pageNum, Model model,HttpSession session) {
        if (pageNum == null) {
            pageNum=1;
        }
        Page<TbIndustrialDevelopSciAchi> tbIndustrialDevelopSciAchis = tbIndustrialDevelopSciAchiService.selectForPage(pageNum, 3);
        TbIndustrialDevelopSciAchi curentSerch = (TbIndustrialDevelopSciAchi) session.getAttribute("curentSerch");
        if (curentSerch != null) {
            tbIndustrialDevelopSciAchis = tbIndustrialDevelopSciAchiService.selectByTitle(pageNum, 3, curentSerch);
        }
        model.addAttribute("SciPage", tbIndustrialDevelopSciAchis);
        return "achi/achiList";
    }

    @GetMapping("/achiDetail")
    public String selectTalrecByPriKey(TbIndustrialDevelopSciAchi sciAchi, Model model, Integer pageNum) {
        TbIndustrialDevelopSciAchi tbIndustrialDevelopSciAchi = tbIndustrialDevelopSciAchiService.selectByPrimaryKey(sciAchi);
        TbIndustrialDevelopSciAchi before = tbIndustrialDevelopSciAchiService.selectByitemId(sciAchi.getItemid() - 1);
        TbIndustrialDevelopSciAchi after= tbIndustrialDevelopSciAchiService.selectByitemId(sciAchi.getItemid() +1);
        model.addAttribute("before", before);
        model.addAttribute("after", after);
        model.addAttribute("sci", tbIndustrialDevelopSciAchi);
        model.addAttribute("pageNum", pageNum);
        return "achi/achiDetails";
    }
    @GetMapping("/serchByTitel")
    public String selectByTitle(TbIndustrialDevelopSciAchi sciAchi, Integer pageNum, Model model,HttpSession session) {
        if (pageNum == null) {
            pageNum=1;
        }
        session.setAttribute("curentSerch", sciAchi);
        Page<TbIndustrialDevelopSciAchi> tbIndustrialDevelopSciAchis= tbIndustrialDevelopSciAchiService.selectByTitle(pageNum, 3, sciAchi);
        model.addAttribute("SciPage",tbIndustrialDevelopSciAchis);
        return "achi/achiList";
    }

}
