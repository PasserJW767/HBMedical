package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareSciKnow;
import com.lanqiao.zzy.service.IHealthCareSciKnowService;
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
 * CREATE BY 覃宝莹 ON 2021/07/26 08:18 星期一
 * DESC:
 */
@Controller
@SessionAttributes
@RequestMapping("/healthcare")
@Slf4j
public class SciKnowController {

    @Autowired
    IHealthCareSciKnowService healthCareSciKnowService;

    @GetMapping("/science/list")
    public String selectAllForSciKnow(Model model, HttpSession session, @RequestParam(value = "pageNum",required = false) Integer pageNum) {

        if (pageNum == null) {
            pageNum = 1;
        }
        Page<HealthCareSciKnow> healthCareSciKnowList = this.healthCareSciKnowService.selectAllForSciKnow(pageNum,5);
        model.addAttribute("healthCareSciKnowList", healthCareSciKnowList);
        System.out.println(healthCareSciKnowList);
        return "science_knowledge";
    }

    @GetMapping("sciknow_detail")
    public String selectSciDetailById(Model model,
                                      @RequestParam(value = "itemId", required= false)Integer itemId,
                                      @Param(value = "pageNum") Integer pageNum,
                                      HttpSession session){
        if(pageNum==null){
            pageNum=1;
        }
        HealthCareSciKnow detailPre = null;
        HealthCareSciKnow detailNext = null;
        HealthCareSciKnow detail = this.healthCareSciKnowService.selectSciDetailById(itemId);
        List<HealthCareSciKnow> detailList = this.healthCareSciKnowService.selectSciAllDetail();
       // System.out.println(detailList);
        for (int i = 0; i < detailList.size(); i++) {
            if(i>0 && detailList.get(i).getItemid().equals(itemId)){
                detailPre = detailList.get(i-1);

            }
        }

        for(int j=0;j<detailList.size();j++){
            if(j<detailList.size()-1 && detailList.get(j).getItemid().equals(itemId)){
                detailNext = detailList.get(j+1);

            }
        }
        model.addAttribute("detail",detail);
        model.addAttribute("detailPre",detailPre);
        model.addAttribute("detailNext",detailNext);
        model.addAttribute("detailList",detailList);
        return "sciknow_detail";
    }
}
