package com.lanqiao.zzy.controller;


import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.*;
import com.lanqiao.zzy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ICulproDataService culproDataService;

    @Autowired
    ICulproHospService hospService;

    @Autowired
    ICulproChineseMedicineService culproChineseMedicineService;

    @Autowired
    ICulproSpecialtyService culproSpecialtyService;

    @Autowired
    IHealthCareFamPreService healthCareFamPreService;

    @Autowired
    IHealthCareSciKnowService healthCareSciKnowService;

    @Autowired
    ICulproFamPreService culproFamPreService;

    @Autowired
    IHomePageCenterDevelopService homePageCenterDevelopService;

    @Autowired
    IIndustrialDevelopSciAchiService industrialDevelopSciAchiService;

    @Autowired
    IIndustrialDevelopTalRecService industrialDevelopTalRecService;

    @Autowired
    IIndustrialDevelopCooExcService industrialDevelopCooExcService;

    @Autowired
    ICulproCulturalResourcesService culproCulturalResourcesService;

    @Autowired
    ICulproChineseCulturalService culproChineseCulturalService;



    @GetMapping("/")
    public String showHomePage(Model model){

        final int home_dev_1= this.homePageCenterDevelopService.calCountByOrgidentify("中药材种植园");
        final int home_dev_2 = this.homePageCenterDevelopService.calCountByOrgidentify("中药材加工企业");
        final int home_dev_3 = this.homePageCenterDevelopService.calCountByOrgidentify("中药材制药企业");
        final int home_dev_4 = this.homePageCenterDevelopService.calCountByOrgidentify("中医医疗机构");
        final int home_dev_5 = this.homePageCenterDevelopService.calCountByOrgidentify("科研院所");
        final int home_dev_6 = this.homePageCenterDevelopService.calCountByOrgidentify("高等医学院校");
        int[] resDev={home_dev_1,home_dev_2,home_dev_3,home_dev_4,home_dev_5,home_dev_6};
        model.addAttribute("resDev",resDev);

        //新闻
        Page<CulproData> newsList = culproDataService.selectNews(1, 5);
        model.addAttribute("newsList",newsList);

        //通知公告
        Page<CulproData> noticeList = culproDataService.selectNotice(1, 5);
        model.addAttribute("noticeList",noticeList);

        //政策法规
        Page<CulproData> policyList = culproDataService.selectPolicies(1, 5);
        model.addAttribute("policyList",policyList);

        //办事指南
        Page<CulproData> serviceGuideList = culproDataService.selectServiceGuide(1, 5);
        model.addAttribute("serviceGuideList",serviceGuideList);

        //医院
        Page<CulproHosp> hospitalForHomeList = hospService.selectHospitalForHome(1, 2);
        model.addAttribute("hospitalForHomeList",hospitalForHomeList);

        //内外科
        Page<CulproSpecialty> specialtyForHomeList = culproSpecialtyService.selectSpecialtyForHome(1, 2);
        model.addAttribute("specialtyForHomeList",specialtyForHomeList);

        //医生
        Page<CulproChineseMedicine> doctorForHomeList = culproChineseMedicineService.selectDoctorForHome(1, 2);
        model.addAttribute("doctorForHomeList",doctorForHomeList);

        //科普知识
        Page<HealthCareSciKnow> healthCareSciKnowForHomeList = healthCareSciKnowService.selectHealthCareSciKnowForHome(1, 5);
        model.addAttribute("healthCareSciKnowForHomeList",healthCareSciKnowForHomeList);

        //历史名方
        Page<CulproFamPre> culproFamPreForHomeList = culproFamPreService.selectCulproFamPreForHome(1, 5);
        model.addAttribute("culproFamPreForHomeList",culproFamPreForHomeList);

        //国医话健康
        Page<HealthCareFamPre> healthCareFamPreForHomeList = healthCareFamPreService.selectHealthCareFamPreForHome(1, 5);
        model.addAttribute("healthCareFamPreForHomeList", healthCareFamPreForHomeList);

        //        获得科研成果的数据
        List<IndustrialDevelopSciAchi> industrialDevelopSciAchis = this.industrialDevelopSciAchiService.selectForHome();
        model.addAttribute("industrialDevelopSciAchis", industrialDevelopSciAchis);

        //        获得合作交流的数据
        List<IndustrialDevelopCooExc> industrialDevelopCooExcs = this.industrialDevelopCooExcService.selectForHome();
        model.addAttribute("industrialDevelopCooExcs", industrialDevelopCooExcs);

        //        获得人才招聘的数据
        List<IndustrialDevelopTalRec> industrialDevelopTalRecs = this.industrialDevelopTalRecService.selectForHome();
        model.addAttribute("industrialDevelopTalRecs", industrialDevelopTalRecs);

        //        获得历代名医的数据
        List<CulproCulturalResources> culproCulturalResources = this.culproCulturalResourcesService.selectForHomeHistoricalDoc();
        model.addAttribute("culproCulturalResources", culproCulturalResources);

        //        获得中医流派的数据
        List<CulproCulturalResources> culproCulturalResources1 = this.culproCulturalResourcesService.selectForHomeTCMAcademic();
        model.addAttribute("culproCulturalResources1",culproCulturalResources1);

        //        获得健康旅游的数据
        List<CulproChineseCultural> culproChineseCulturals = this.culproChineseCulturalService.selectForHomeHealthTravel();
        model.addAttribute("culproChineseCulturals", culproChineseCulturals);



        return "homepage/main";

    }
}
