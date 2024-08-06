package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproHosp;
import com.lanqiao.zzy.domain.CulproHospSpecialtyRef;
import com.lanqiao.zzy.service.ICulproHospSpecialtyRefService;
import com.lanqiao.zzy.service.ICulproHospService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/hospitals")
public class CulproHospController {

    @Autowired
    ICulproHospService hospService;

    @Autowired
    ICulproHospSpecialtyRefService refService;

    /**
     * 根据查询条件页码查询医院列表
     */
    @GetMapping
    public String hospitalList(Model model ,
                               CulproHosp culproHosp,
                               @RequestParam(value = "pageNum",required = false) Integer pageNum,
                               @RequestParam(value = "pageSize",required = false) Integer pageSize,
                               @RequestParam(value = "pages",required = false)  Integer pages,
                               HttpSession session){
        if (pageSize == null) {
            if ((Integer)session.getAttribute("pageSize")!=null){
                pageSize = (Integer) session.getAttribute("pageSize");
            }else {
                pageSize = 10;
                session.setAttribute("pageSize",pageSize);
            }
        }else {
            session.setAttribute("pageSize",pageSize);
        }
        if (pageNum == null) {
            pageNum = 1;
            session.setAttribute("culproHosp", culproHosp);
        } else {
            if (pages != null && pageNum>pages) {
                pageNum = pages;
            }

            if ((CulproHosp) session.getAttribute("culproHosp") != null) {
                culproHosp = (CulproHosp) session.getAttribute("culproHosp");
            }
        }

        Page<CulproHosp> culproHospList = hospService.selectHospitalByCondiction(culproHosp, pageNum, pageSize);
        //存入model
        model.addAttribute("culproHospList",culproHospList);
        return "medical_service/hospital_list";
    }

    /**
     * 根据id查询医院详情
     * @param model
     * @param itemid
     * @return
     */
    @GetMapping("/detail")
    public String hospitalDetail(Model model, CulproHosp culproHosp,Integer pages,String itemcode,
                                 @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                 @RequestParam(name = "itemid",required = false) Integer itemid) {
        /*根据id获取当前页码*/
        if (pageNum == null) {
            Integer count = this.hospService.selectPageNum(itemid);
            pageNum = count + 1;
        } else {
            if (pages != null) {
                if (pageNum > pages) {
                    pageNum = pages;
                }
            }
        }

        /*当前页数据*/
        Page<CulproHosp> hospitalDetails = this.hospService.selectHospitalByCondiction(culproHosp, pageNum, 1);

        /*根据itemCode的值与查询对应的科室*/
        List<CulproHospSpecialtyRef> culproSpecialtyOfHosps = this.refService.selectCulproSpecialtyByHospCode(itemcode);
        /*当页码<=1，则只有下一页*/
        if (pageNum <= 1) {
            pageNum = 1;
            Page<CulproHosp> nextHospitalDetails = this.hospService.selectHospitalByCondiction(culproHosp, (pageNum + 1), 1);
            model.addAttribute("nextHospitalDetails", nextHospitalDetails);
            /*当页码>1 且<总页码，有上一篇和下一篇的名字 */
        } else {
            Page<CulproHosp> preHospitalDetails = this.hospService.selectHospitalByCondiction(culproHosp, (pageNum - 1), 1);
            model.addAttribute("preHospitalDetails", preHospitalDetails);
            Page<CulproHosp> nextHospitalDetails = this.hospService.selectHospitalByCondiction(culproHosp, (pageNum + 1), 1);
            model.addAttribute("nextHospitalDetails", nextHospitalDetails);
            /*当页码>=count，则只有上一页*/
        }
        model.addAttribute("hospitalDetails", hospitalDetails);
        model.addAttribute("culproSpecialtyOfHosps", culproSpecialtyOfHosps);
        return "medical_service/hospital_detail";
    }
    /**
     * 查询医院所有的市
     * @return
     */
    @GetMapping("/cities")
    @ResponseBody
    public List<String> selectHospitalCity(){
        List<String> cities = hospService.selectHospitalCity();
        return cities;
    }
}