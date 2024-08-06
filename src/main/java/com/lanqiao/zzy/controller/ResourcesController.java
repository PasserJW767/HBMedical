package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.Resources;
import com.lanqiao.zzy.service.IResourcesService;
import com.lanqiao.zzy.util.DelTagsUtil;
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
 * @create 2021/7/23 16:27
 */
@Controller
@RequestMapping("/chmedicineculs")
@Slf4j
public class ResourcesController {
    @Autowired
    IResourcesService resourcesService;

    @GetMapping("/zyys")
    public String selectYsForPage(Model model, Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
       Page<Resources> histories =this.resourcesService.selectYsForPage(pageNum,5);
       DelTagsUtil delTagsUtil = new DelTagsUtil();
       model.addAttribute("histories",histories);
       model.addAttribute("delTagsUtil1",delTagsUtil);
       return "medicine-culture/cultural_resources_zyys";
    }


    @GetMapping("/zylp")
    public String selectLpForPage(Model model,Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Page<Resources> schools = this.resourcesService.selectLpForPage(pageNum,5);//中医流派
        DelTagsUtil delTagsUtil = new DelTagsUtil();
        model.addAttribute("delTagsUtil",delTagsUtil);
        model.addAttribute("schools",schools);
        return "medicine-culture/cultural_resources_zylp";
    }

   @GetMapping("/ldmj")
    public String selectMjForPage(Model model,Integer pageNum){
       if (pageNum == null){
           pageNum=1;
       }
       Page<Resources> doctors = this.resourcesService.selectMjForPage(pageNum,8);
       DelTagsUtil delTagsUtil = new DelTagsUtil();
       model.addAttribute("delTagsUtil",delTagsUtil);
       model.addAttribute("doctors",doctors);
       return "medicine-culture/cultural_resources_ldmj";

   }

   @RequestMapping("/details")
    public String selectDetialsById(Model model,
                                @RequestParam(value = "itemId", required= false)Integer itemId,
                                @Param(value = "pageNum") Integer pageNum,
                                HttpSession session){
       if(pageNum==null){
           pageNum=1;
       }
       Resources detailpre = null;
       Resources detailnext = null;
       Resources detail = this.resourcesService.selectDetialsById(itemId);
       List<Resources> detaillist = this.resourcesService.selectAllDetails(detail.getCulType());
       for (int i = 0; i < detaillist.size(); i++) {
           if(i>0 && detaillist.get(i).getItemID().equals(itemId)){
               detailpre = detaillist.get(i-1);

           }
       }

       for(int j=0;j<detaillist.size();j++){
           if(j<detaillist.size()-1 && detaillist.get(j).getItemID().equals(itemId)){
               detailnext = detaillist.get(j+1);

           }
       }

       model.addAttribute("detailpre",detailpre);
       model.addAttribute("detailnext",detailnext);
       model.addAttribute("detail",detail);
       model.addAttribute("detaillist",detaillist);
       return "medicine-culture/cultural_resources_detail";
   }
}
