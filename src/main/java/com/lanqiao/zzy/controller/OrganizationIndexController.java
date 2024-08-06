package com.lanqiao.zzy.controller;

import com.lanqiao.zzy.domain.Organization;
import com.lanqiao.zzy.domain.TbIndustrialDevelopMedMat;
import com.lanqiao.zzy.service.IOrganizationService;
import com.lanqiao.zzy.service.ITbIndustrialDevelopMedMatService;
import com.lanqiao.zzy.util.PinyinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/org")
public class OrganizationIndexController {
    @Autowired
    IOrganizationService organizationService;
    @Autowired
    ITbIndustrialDevelopMedMatService tbIndustrialDevelopMedMatService;
    @RequestMapping("/index")
    public String index(Model model) {
            List<Organization> organizations = organizationService.selectNumofOrgByLocal();
        Map<String,Organization> orgMap = new HashMap<String ,Organization>();
        //存入地区机构总数
        for (Organization organization : organizations) {
            orgMap.put(PinyinUtil.getPinyin(organization.getOrgLocate()), organization);
        }
        model.addAttribute("orgMap",orgMap );
        //机构总数
        int total = organizationService.selectTotalnum();
        model.addAttribute("total",total);
        //存入地区药材总数
        List<TbIndustrialDevelopMedMat> tbIndustrialDevelopMedMats = tbIndustrialDevelopMedMatService.selectNum();
        Map<String,TbIndustrialDevelopMedMat> MedMatMap=new HashMap<String,TbIndustrialDevelopMedMat>();
        for (TbIndustrialDevelopMedMat tbIndustrialDevelopMedMat : tbIndustrialDevelopMedMats) {
                MedMatMap.put(PinyinUtil.getPinyin(tbIndustrialDevelopMedMat.getPlace()),tbIndustrialDevelopMedMat);
        }
        model.addAttribute("MedMatMap",MedMatMap);
        return "IndustrialDevelopment/IndustrialDevelopmentIndex";
    }

    @GetMapping("/MedMat")
    @ResponseBody
    public List<TbIndustrialDevelopMedMat> selectByplace(String placename) {
        List<TbIndustrialDevelopMedMat> tbIndustrialDevelopMedMats = tbIndustrialDevelopMedMatService.selectBypalce(placename);
        return  tbIndustrialDevelopMedMats;
    }

}
