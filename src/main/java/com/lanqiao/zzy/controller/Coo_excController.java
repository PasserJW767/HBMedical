package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;

import com.lanqiao.zzy.domain.TbIndustrialDevelopCooExc;
import com.lanqiao.zzy.domain.TbIndustrialDevelopTalRec;
import com.lanqiao.zzy.service.ITbIndustrialDevelopCooExcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cooexc")
public class Coo_excController {
    @Autowired
    ITbIndustrialDevelopCooExcService tbIndustrialDevelopCooExcService;
    @GetMapping("/cooexcList")
    public String selectTalrecPage(Integer pageNum, Model model,HttpSession session) {
        if (pageNum == null) {
            pageNum=1;
        }
        Page<TbIndustrialDevelopCooExc> cooExcPage = tbIndustrialDevelopCooExcService.selectForPage(pageNum, 3);
        TbIndustrialDevelopCooExc curentSerch = (TbIndustrialDevelopCooExc) session.getAttribute("curentSerch1");
        if (curentSerch != null) {
            cooExcPage = tbIndustrialDevelopCooExcService.selectByTitle(pageNum, 3, curentSerch);
        }
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("cooExcPage", cooExcPage);
       return "cooexc/cooexcList";
    }

    @GetMapping("/cooexcDetail")
    public String selectTalrecByPriKey(TbIndustrialDevelopCooExc cooExc, Model model, Integer pageNum) {
        TbIndustrialDevelopCooExc tbIndustrialDevelopCooExc = tbIndustrialDevelopCooExcService.selectByPrimaryKey(cooExc);
        TbIndustrialDevelopCooExc before = tbIndustrialDevelopCooExcService.selectByitemid(cooExc.getItemid() - 1);
        TbIndustrialDevelopCooExc after = tbIndustrialDevelopCooExcService.selectByitemid(cooExc.getItemid() +1);
        model.addAttribute("before", before);
        model.addAttribute("after", after);
        model.addAttribute("cooExc", tbIndustrialDevelopCooExc);
        model.addAttribute("pageNum", pageNum);
        return "cooexc/cooexcDetails";
    }
    @GetMapping("/serchByTitel")
    public String selectByTitle(TbIndustrialDevelopCooExc tbIndustrialDevelopCooExc, Integer pageNum, Model model,HttpSession session) {
        if (pageNum == null) {
            pageNum=1;
        }
        session.setAttribute("curentSerch1", tbIndustrialDevelopCooExc);
        Page<TbIndustrialDevelopCooExc> tbIndustrialDevelopCooExcs = tbIndustrialDevelopCooExcService.selectByTitle(pageNum, 3, tbIndustrialDevelopCooExc);
        model.addAttribute("cooExcPage",tbIndustrialDevelopCooExcs);
        return "cooexc/cooexcList";
    }
}
