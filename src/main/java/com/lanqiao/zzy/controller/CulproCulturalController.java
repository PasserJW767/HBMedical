package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseCultural;
import com.lanqiao.zzy.domain.Resources;
import com.lanqiao.zzy.service.ICulproChineseCulturalService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author 黄舒帆
 * @create 2021/7/29 1:00
 */
@Controller
@RequestMapping("/chmedicineculs")
@Slf4j
public class CulproCulturalController {
    @Autowired
    ICulproChineseCulturalService culproChineseCulturalService;

    @GetMapping("/whgj")
    public String selectGjForPage(Model model, Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Page<CulproChineseCultural> sites = this.culproChineseCulturalService.selectGjForPage(pageNum,6);
        model.addAttribute("sites",sites);
        return "medicine-culture/cultural_facilities_whgj";
    }

    @GetMapping("/whcg")
    public String selectCgForPage(Model model, Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Page<CulproChineseCultural> venues = this.culproChineseCulturalService.selectCgForPage(pageNum,6);
        model.addAttribute("venues",venues);
        return "medicine-culture/cultural_facilities_whcg";
    }

    @GetMapping("/whyc")
    public String selectYcForPage(Model model, Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Page<CulproChineseCultural> heritage = this.culproChineseCulturalService.selectYcForPage(pageNum,6);
        model.addAttribute("heritage",heritage);
        return "medicine-culture/cultural_facilities_whyc";
    }

    @GetMapping("/dsdy")
    public String selectDyForPage(Model model, Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Page<CulproChineseCultural> movies = this.culproChineseCulturalService.selectDyForPage(pageNum,8);
        model.addAttribute("movies",movies);
        return "medicine-culture/cultural_products_dsdy";
    }

    @GetMapping("/dmyx")
    public String selectDmForPage(Model model, Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Page<CulproChineseCultural> cartoon = this.culproChineseCulturalService.selectDmForPage(pageNum,8);
        model.addAttribute("cartoon",cartoon);
        return "medicine-culture/cultural_products_dmyx";
    }

    @GetMapping("/mhdg")
    public String selectMhForPage(Model model, Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Page<CulproChineseCultural> allusions = this.culproChineseCulturalService.selectMhForPage(pageNum,8);
        model.addAttribute("allusions",allusions);
        return "medicine-culture/cultural_products_mhdg";
    }

    @GetMapping("/jkly")
    public String selectLyForPage(Model model, Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Page<CulproChineseCultural> travel = this.culproChineseCulturalService.selectLyForPage(pageNum,6);
        model.addAttribute("travel",travel);
        return "medicine-culture/cultural_healthy_travel";
    }



    @RequestMapping("/facilities_detail")
    public String selectDetailsById(Model model,
                                    @RequestParam(value = "itemId", required= false)Integer itemId,
                                    @Param(value = "pageNum") Integer pageNum,
                                    HttpSession session){
        if(pageNum==null){
            pageNum=1;
        }
        CulproChineseCultural detailpre = null;
        CulproChineseCultural detailnext = null;
        CulproChineseCultural detail = this.culproChineseCulturalService.selectDetailsById(itemId);
        List<CulproChineseCultural> detaillist = this.culproChineseCulturalService.selectAllDetails(detail.getChineseCulturalType());
        for (int i = 0; i < detaillist.size(); i++) {
            if(i>0 && detaillist.get(i).getItemid().equals(itemId)){
                detailpre = detaillist.get(i-1);

            }
        }

        for(int j=0;j<detaillist.size();j++){
            if(j<detaillist.size()-1 && detaillist.get(j).getItemid().equals(itemId)){
                detailnext = detaillist.get(j+1);

            }
        }

        model.addAttribute("detailpre",detailpre);
        model.addAttribute("detailnext",detailnext);
        model.addAttribute("detail",detail);
        model.addAttribute("detaillist",detaillist);
        return "medicine-culture/cultural_factilites_detail";
    }
}
