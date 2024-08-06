package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseMedicine;
import com.lanqiao.zzy.domain.CulproSpecialty;
import com.lanqiao.zzy.service.ICulproSpecialtyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : 莫起润
 * @date : 2021/7/24/12:11
 */
@Controller
@Slf4j
@RequestMapping("/culproSpecialties")
public class CulproSpecialtyController {
    @Autowired
    ICulproSpecialtyService specialtyService;

    @GetMapping
    public String selectCulproSpecialties(Model model, CulproSpecialty culproSpecialty,
                                         Integer pageNum,Integer pageSize,Integer pages,
                                         HttpSession session) {
        /*当没有设置每页显示多少条数据，并且上一次查询的pageSize没有记录则默认为10条/页并记录此次查询的pageSize
         *当有设置页显示多少条数据时，记录此次的pageSize
         */
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

        /*默认从第一页查*/
        if (pageNum == null) {
            pageNum = 1;
            session.setAttribute("culproSpecialty", culproSpecialty);
        } else {
            /*当输入跳转页面的数值大于查寻的总页数时，限制查询为最大页*/
            if (pages != null) {
                if (pageNum>pages) {
                    pageNum = pages;
                }
            }

            if ((CulproSpecialty) session.getAttribute("culproSpecialty") != null) {
                culproSpecialty = (CulproSpecialty) session.getAttribute("culproSpecialty");
            }
        }
        Page<CulproSpecialty> culproSpecialtieList = specialtyService.selectForCulproSpecialtyList(culproSpecialty, pageNum, pageSize);
        model.addAttribute("culproSpecialtieList", culproSpecialtieList);
        return "medical_service/culproSpecialty_list";
    }


    @GetMapping("/detail")
    public String selectCulproSpecialtyByItemcode(CulproSpecialty culproSpecialty, Model model,Integer pageNum,String itemcode,Integer itemid,Integer pages) {

        /*当从列表点击进来时判断该数据是哪一页的*/
        if (pageNum == null) {
            Integer count = this.specialtyService.selectPageNum(itemid);
            pageNum = count + 1;
        } else {
            if (pages != null) {
                if (pageNum>pages) {
                    pageNum = pages;
                }
            }
        }


        /*本详情数据(一页一条数据)*/
        Page<CulproSpecialty> culproSpecialtyDetails = this.specialtyService.selectForCulproSpecialtyList(culproSpecialty, pageNum, 1);


        /*根据itemCode的值与医生表里的deptCode对应查询*/
        List<CulproChineseMedicine> culproChineseMedicines = this.specialtyService.selectCulproChineseMedicineMapperByDeptCode(itemcode);

        /*当页码为1，则只有下一页，查询下一页用于显示页面下一篇的名字
        * 当页码>1，则查询下一页和上一页用于各自显示页面的上一篇和下一篇的名字
        */
        if (pageNum <= 1) {
            Page<CulproSpecialty> nextCulproSpecialtyDetails = this.specialtyService.selectForCulproSpecialtyList(culproSpecialty, (pageNum+1), 1);
            model.addAttribute("nextCulproSpecialtyDetails", nextCulproSpecialtyDetails);
        } else {
            Page<CulproSpecialty> preCulproSpecialtyDetails = this.specialtyService.selectForCulproSpecialtyList(culproSpecialty, (pageNum-1), 1);
            model.addAttribute("preCulproSpecialtyDetails", preCulproSpecialtyDetails);
            Page<CulproSpecialty> nextCulproSpecialtyDetails = this.specialtyService.selectForCulproSpecialtyList(culproSpecialty, (pageNum+1), 1);
            model.addAttribute("nextCulproSpecialtyDetails", nextCulproSpecialtyDetails);

        }


        model.addAttribute("culproChineseMedicines", culproChineseMedicines);
        model.addAttribute("culproSpecialtyDetails", culproSpecialtyDetails);
        return "medical_service/culproSpecialty_detail";
    }


    @GetMapping("/cities")
    @ResponseBody
    public List<String> selectHCulproSpecialtyCity(){
        List<String> cities = specialtyService.selectCulproSpecialtyCity();
        return cities;
    }

    @GetMapping("/departments")
    @ResponseBody
    public List<String> selectCulproSpecialtyDepartment(){
        List<String> departments = specialtyService.selectCulproSpecialtySpecialtyName();
        return departments;
    }

}
