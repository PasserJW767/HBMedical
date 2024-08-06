package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.*;
import com.lanqiao.zzy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    IOrganizationService organizationService;
    @Autowired
    ITbCulproFileService tbCulproFileService;
    @Autowired
    ITbIndustrialDevelopSciAchiService tbIndustrialDevelopSciAchiService;
    @Autowired
    ITbIndustrialDevelopSerProService tbIndustrialDevelopSerProService;
    @Autowired
    ITbIndustrialDevelopSaleDrugService tbIndustrialDevelopSaleDrugService;
    @Autowired
    ITbIndustrialDevelopMedMatService tbIndustrialDevelopMedMatService;
    //加载地区机构数量表
    @GetMapping("/lodorgnum")
    @ResponseBody
    public List<Organization> selectNumbyLocal(Model model) {
        List<Organization> organizations = this.organizationService.selectNumofOrgByLocal();
        return organizations;
    }

    //机构列表
    @GetMapping("/orglist")
    public String selectOrgList(Model model,Integer pageNum,Organization org) {
        if (pageNum == null) {
            pageNum=1;
        }
        Page<Organization> organizationPage = organizationService.selectOrgList(org, pageNum, 9);
        model.addAttribute("curentOrgLocate", org.getOrgLocate());
        model.addAttribute("curentOrgIdentify", org.getOrgIdentify());
        model.addAttribute("curentorgName", org.getOrgName());
        model.addAttribute("organizationPage", organizationPage);
        model.addAttribute("pageNum", pageNum);
        return "IndustrialDevelopment/Orglist";
    }

    //加载城市选项
    @GetMapping("/loadLocate")
    @ResponseBody
    public List<Organization> selectLocate(Model model) {
        return organizationService.selectLocate();
    }

    //加载机构类型选项
    @GetMapping("/loadIdentify")
    @ResponseBody
    public List<Organization> selectIdentify() {
        return organizationService.selectIdentify();
    }

    //机构详情
        @GetMapping("/orgDetail")
        public String selectorgDetail(String orgName,Model model,Integer pageNum) {
            Organization organizationDetail = organizationService.selectorgDetail(orgName);
            model.addAttribute("orgDetail", organizationDetail);
            model.addAttribute("pageNum", pageNum);
            List<TbCulproFile> tbCulproFiles = tbCulproFileService.selectByOrgCode(organizationDetail.getOrgCode());
            model.addAttribute("Imgfile", tbCulproFiles);
            //在售药材和药品 可能需要修改
            if ("中药材种植园".equals(organizationDetail.getOrgIdentify()) | "中药材加工企业".equals(organizationDetail.getOrgIdentify())) {
                List<TbIndustrialDevelopMedMat> Meds = tbIndustrialDevelopMedMatService.selectByorgcode(organizationDetail.getOrgCode());
                model.addAttribute("Med", Meds);
            }
            if ("中药材制药企业".equals(organizationDetail.getOrgIdentify()) | "中药材销售企业".equals(organizationDetail.getOrgIdentify())) {
                List<TbIndustrialDevelopSaleDrug> saleDrugs = tbIndustrialDevelopSaleDrugService.selectByOrgcode(organizationDetail.getOrgCode());
                model.addAttribute("saleDrus", saleDrugs);
            }
            if ( "高等医学院校".equals(organizationDetail.getOrgIdentify()) | "科研院所".equals(organizationDetail.getOrgIdentify())) {
                TbIndustrialDevelopSciAchi tbIndustrialDevelopSciAchi = new TbIndustrialDevelopSciAchi();
                tbIndustrialDevelopSciAchi.setOrgCode(organizationDetail.getOrgCode());
                List<TbIndustrialDevelopSciAchi> tbIndustrialDevelopSciAchis = tbIndustrialDevelopSciAchiService.selectByorgCode(tbIndustrialDevelopSciAchi);
                model.addAttribute("tbIndustrialDevelopSciAchis", tbIndustrialDevelopSciAchis);
            }
            if ("技术服务机构".equals(organizationDetail.getOrgIdentify())) {
                TbIndustrialDevelopSerPro tbIndustrialDevelopSerPro = new TbIndustrialDevelopSerPro();
                tbIndustrialDevelopSerPro.setOrgCode(organizationDetail.getOrgCode());
                List<TbIndustrialDevelopSerPro> tbIndustrialDevelopSerPros = tbIndustrialDevelopSerProService.selectByorgCode(tbIndustrialDevelopSerPro);
                model.addAttribute("tbIndustrialDevelopSerPros", tbIndustrialDevelopSerPros);
            }
            return "IndustrialDevelopment/OrgDetail";
        }

    //药品详情
    @GetMapping("/SaleDrugDetail")
    public String selectSalMedAndFile(TbIndustrialDevelopSaleDrug saleDrug, Model model) {
        TbIndustrialDevelopSaleDrug tbIndustrialDevelopSaleDrug = tbIndustrialDevelopSaleDrugService.selectSalMedAndFile(saleDrug);
        model.addAttribute("saleDrug", tbIndustrialDevelopSaleDrug);
        Organization organization = organizationService.selectbyOrgCode(saleDrug.getOrgCode());
        model.addAttribute("organzation", organization);
        return "IndustrialDevelopment/SaleDrugDetail";
    }

    //药材详情
    @GetMapping("/MedMatDetail")
    public String selectMedByOrgCodeAndNameName(TbIndustrialDevelopMedMat medMat, Model model,Integer pageNum) {
        Organization organization = organizationService.selectbyOrgCode(medMat.getOrgCode());
        model.addAttribute("organzation", organization);
        TbIndustrialDevelopMedMat tbIndustrialDevelopMedMat = tbIndustrialDevelopMedMatService.selectByOrgCodeAndNameName(medMat);
        model.addAttribute("MedMat", tbIndustrialDevelopMedMat);
        model.addAttribute("pageNum", pageNum);
        return "IndustrialDevelopment/MedMatDetail";
    }

    //加载药材所在地
    @GetMapping("/loadMedMatLocate")
    @ResponseBody
    public List<TbIndustrialDevelopMedMat> loadMedMatLocate() {
        return tbIndustrialDevelopMedMatService.selectByLocate();
    }
    //加载药材类型
    @GetMapping("/loadMedMatIndentify")
    @ResponseBody
    public List<TbIndustrialDevelopMedMat> loadMedMatIndentify() {
        return tbIndustrialDevelopMedMatService.selectByName();
    }

    //药材列表
    @GetMapping("/MedMatlist")
    public String MedMatList(TbIndustrialDevelopMedMat med,Integer pageNum,Model model) {
        if (pageNum == null) {
            pageNum=1;
        }
        model.addAttribute("curentMedName", med.getName());
        model.addAttribute("curentMedplace", med.getPlace());
        Page<TbIndustrialDevelopMedMat> tbIndustrialDevelopMedMats = tbIndustrialDevelopMedMatService.selectMedMatList(med, pageNum, 2);
        model.addAttribute("MedPage", tbIndustrialDevelopMedMats);
        model.addAttribute("pageNum", pageNum);
        return "IndustrialDevelopment/MedMatlist";
    }

    @GetMapping("/serproDetail")
    public String SerProDetail(TbIndustrialDevelopSerPro serPro, Model model) {
        TbIndustrialDevelopSerPro SerPro = tbIndustrialDevelopSerProService.selectByPk(serPro);
        TbIndustrialDevelopSerPro After = tbIndustrialDevelopSerProService.selectAfter(serPro.getItemid());
        TbIndustrialDevelopSerPro Before = tbIndustrialDevelopSerProService.selectBefore(serPro.getItemid());
        Organization organization = organizationService.selectbyOrgCode(serPro.getOrgCode());
        model.addAttribute("org", organization);
        model.addAttribute("SerPro", SerPro);
        model.addAttribute("after", After);
        model.addAttribute("before", Before);
        return "IndustrialDevelopment/serProDetail";
    }
}
