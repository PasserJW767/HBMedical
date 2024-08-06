package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproFamPre;
import com.lanqiao.zzy.domain.HealthCareChineseMedicine;
import com.lanqiao.zzy.service.IHealthCareChineseMedicineService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * CREATE BY 覃宝莹 ON 2021/07/29 14:33 星期四
 * DESC:
 */
@Controller
@SessionAttributes
@Slf4j
public class ChineseMedicineController {

    @Autowired
    IHealthCareChineseMedicineService healthCareChineseMedicineService;

    @GetMapping("/medicine/list")
    public String selectAllForFirst(Model model, HttpSession session, @RequestParam(value = "pageNum",required = false) Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        }
        Page<HealthCareChineseMedicine> firstChineseMedicinesList = this.healthCareChineseMedicineService.selectForFirst(pageNum,15);
        Page<HealthCareChineseMedicine> secondChineseMedicinesList = this.healthCareChineseMedicineService.selectForSecond(pageNum, 15);
        model.addAttribute("firstChineseMedicinesList", firstChineseMedicinesList);
        model.addAttribute("secondChineseMedicinesList", secondChineseMedicinesList);
        System.out.println(firstChineseMedicinesList);
        return "chinese_medicine_list";
    }

    @GetMapping("/medicine/detail")
    public String selectSciDetailById(Model model,
                                      @RequestParam(value = "itemId", required = false) Integer itemId,
                                      @Param(value = "pageNum") Integer pageNum,
                                      HttpSession session) {
        if (pageNum == null) {
            pageNum = 1;
        }
        HealthCareChineseMedicine detailPre = null;
        HealthCareChineseMedicine detailNext = null;
        HealthCareChineseMedicine detail = this.healthCareChineseMedicineService.selectForDetailById(itemId);
        List<HealthCareChineseMedicine> detailList = this.healthCareChineseMedicineService.selectForAll();
        String src = this.healthCareChineseMedicineService.selectForImage(itemId);
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
        model.addAttribute("src",src);
        return "chinese_medicine_detail";
    }

    @PostMapping("/medicine/search")
    public String selectForSearch(@RequestParam(value = "chineseMedicineName") String chineseMedicineName, Model model, RedirectAttributes attr){

        HealthCareChineseMedicine searchResult = this.healthCareChineseMedicineService.selectForSearch(chineseMedicineName);
        Integer itemId = searchResult.getItemid();
        HealthCareChineseMedicine detailPre = null;
        HealthCareChineseMedicine detailNext = null;
        List<HealthCareChineseMedicine> detailList = this.healthCareChineseMedicineService.selectForAll();
        String src = this.healthCareChineseMedicineService.selectForImage(itemId);
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
        model.addAttribute("searchResult",searchResult);
        model.addAttribute("detailNext",detailNext);
        model.addAttribute("detailList",detailList);
        model.addAttribute("src",src);

        //System.out.println(searchResult);
        if (searchResult != null) {
            return "chinese_medicine_searchdetail";
        }else
            return "chinese_medicine_list";
    }


}
