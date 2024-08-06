package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproFamPre;
import com.lanqiao.zzy.domain.HealthCareFamPre;
import com.lanqiao.zzy.domain.HealthCareSciKnow;
import com.lanqiao.zzy.service.ICulproFamPreService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * CREATE BY 覃宝莹 ON 2021/07/26 10:57 星期一
 * DESC:
 */
@Controller
@SessionAttributes
@Slf4j
public class CulproFamPreController {

    @Autowired
    ICulproFamPreService iCulproFamPreService;

    @GetMapping("/fam/list")
    public String selectAllForFamPre(Model model, HttpSession session, @RequestParam(value = "pageNum",required = false) Integer pageNum) {

        Page<CulproFamPre> culproFamPreList = this.iCulproFamPreService.selectAllForFamPre(pageNum,5);
        model.addAttribute("culproFamPreList", culproFamPreList);
        System.out.println(culproFamPreList);
        return "history_famous_methods";
    }


    @GetMapping("/fam/detail")
    public String selectSciDetailById(Model model,
                                      @RequestParam(value = "itemId", required = false) Integer itemId,
                                      @Param(value = "pageNum") Integer pageNum,
                                      HttpSession session) {
        if (pageNum == null) {
            pageNum = 1;
        }
        CulproFamPre detailPre = null;
        CulproFamPre detailNext = null;
        CulproFamPre detail = this.iCulproFamPreService.selectHistoryFamPreById(itemId);
        List<CulproFamPre> detailList = this.iCulproFamPreService.selectAllFamPreDetail();
        // System.out.println(detailList);
        for (int i = 0; i < detailList.size(); i++) {
            if(i>0 && detailList.get(i).getItemid().equals(itemId)){
                detailPre = detailList.get(i-1);
                System.out.println(detailList.get(i-1));
            }
        }
        for(int j=0;j<detailList.size();j++){
            if(j<detailList.size()-1 && detailList.get(j).getItemid().equals(itemId)){
                detailNext = detailList.get(j+1);
            }
        }
        model.addAttribute("detailPre",detailPre);
        model.addAttribute("detailNext",detailNext);
        model.addAttribute("detail", detail);
        model.addAttribute("detailList",detailList);
        return "history_famme_detail";
    }
}
