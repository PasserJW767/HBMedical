package com.lanqiao.zzy.controller;

import com.lanqiao.zzy.domain.HealthCareFamPre;
import com.lanqiao.zzy.domain.HealthCareSciKnow;
import com.lanqiao.zzy.service.IHealthCareFamPreService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * CREATE BY 覃宝莹 ON 2021/07/24 19:55 星期六
 * DESC:
 */
@Controller
@SessionAttributes
@Slf4j
//@RequestMapping("/doctor_health")
public class DoctorHealthController {
    @Autowired
    IHealthCareFamPreService healthCareFamPreService;

    @GetMapping("/doctor/list")
    public String selectForPage(Model model, HttpSession session, @RequestParam(value = "pageNum", required = false) Integer pageNum) {

        List<HealthCareFamPre> healthCareFamPresList = this.healthCareFamPreService.selectAll(pageNum, 5);
        model.addAttribute("healthCareFamPresList", healthCareFamPresList);
        System.out.println(healthCareFamPresList);
        return "doctor_health_list";
    }


    @GetMapping("/doctor_health_detail")
    public String selectSciDetailById(Model model,
                                      @RequestParam(value = "itemId", required = false) Integer itemId,
                                      @Param(value = "pageNum") Integer pageNum,
                                      HttpSession session) {
        if (pageNum == null) {
            pageNum = 1;
        }

        HealthCareFamPre detailPre = null;
        HealthCareFamPre detailNext = null;
        HealthCareFamPre detail = this.healthCareFamPreService.selectDoctorDetailById(itemId);
        List<HealthCareFamPre> detailList = this.healthCareFamPreService.selectAllDoctorDetail();
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

        model.addAttribute("detailPre",detailPre);
        model.addAttribute("detailNext",detailNext);
        model.addAttribute("detail", detail);
        model.addAttribute("detailList",detailList);

        return "doctor_health_detail";
    }
}
