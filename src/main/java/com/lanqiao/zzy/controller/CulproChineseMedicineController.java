package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproChineseMedicine;
import com.lanqiao.zzy.domain.CulproHosp;
import com.lanqiao.zzy.domain.CulproSpecialty;
import com.lanqiao.zzy.service.ICulproChineseMedicineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : 莫起润
 * @date : 2021/8/1/12:39
 */
@Controller
@Slf4j
@RequestMapping("/culproChineseMedicines")
public class CulproChineseMedicineController {
    @Autowired
    ICulproChineseMedicineService chineseMedicineService;

    @GetMapping
    public String selectCulproSpecialties(Model model, CulproChineseMedicine culproChineseMedicine,
                                          Integer pageNum, Integer pageSize, Integer pages,
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
            session.setAttribute("culproChineseMedicine", culproChineseMedicine);
        } else {
            /*当输入跳转页面的数值大于查寻的总页数时，限制查询为最大页*/
            if (pages != null) {
                if (pageNum>pages) {
                    pageNum = pages;
                }
            }

            if ((CulproChineseMedicine) session.getAttribute("culproChineseMedicine") != null) {
                culproChineseMedicine = (CulproChineseMedicine) session.getAttribute("culproChineseMedicine");
            }
        }
        Page<CulproChineseMedicine> culproChineseMedicines = this.chineseMedicineService.selectForCulproChineseMedicineList(culproChineseMedicine, pageNum, pageSize);
        model.addAttribute("culproChineseMedicines", culproChineseMedicines);
        return "medical_service/chineseMedicine_list";
    }


    /**
     * 根据id查询医院详情
     * @param model
     * @param itemid
     * @return
     */
    @GetMapping("/detail")
    public String hospitalDetail(Model model, CulproChineseMedicine culproChineseMedicine,
                                 Integer pageNum, Integer pages,Integer itemid,
                                 HttpSession session){

        /*根据id获取当前页码*/
        if (pageNum == null) {
            Integer count = this.chineseMedicineService.selectPageNum(itemid);
            pageNum = count +1;
        }else {
            if (pages != null) {
                if (pageNum>pages) {
                    pageNum = pages;
                }
            }
        }
        /*当前页数据*/
        Page<CulproChineseMedicine> culproChineseMedicineDetails = this.chineseMedicineService.selectForCulproChineseMedicineList(culproChineseMedicine, pageNum, 1);

        /*当页码=1，则只有下一页*/
        if (pageNum <= 1) {
            Page<CulproChineseMedicine> nextCulproChineseMedicineDetails = this.chineseMedicineService.selectForCulproChineseMedicineList(culproChineseMedicine, (pageNum+1), 1);
            model.addAttribute("nextCulproChineseMedicineDetails", nextCulproChineseMedicineDetails);
            /*当页码>1 且<总页码，有上一篇和下一篇的名字 */
        } else {
            Page<CulproChineseMedicine> preCulproChineseMedicineDetails = this.chineseMedicineService.selectForCulproChineseMedicineList(culproChineseMedicine, (pageNum-1), 1);
            model.addAttribute("preCulproChineseMedicineDetails", preCulproChineseMedicineDetails);
            Page<CulproChineseMedicine> nextCulproChineseMedicineDetails = this.chineseMedicineService.selectForCulproChineseMedicineList(culproChineseMedicine, (pageNum+1), 1);
            model.addAttribute("nextCulproChineseMedicineDetails", nextCulproChineseMedicineDetails);
            /*当页码>=count，则只有上一页*/
        }
        model.addAttribute("culproChineseMedicineDetails",culproChineseMedicineDetails);
        return"medical_service/chineseMedicine_detail";
    }


    /**
     * 查询医生表里面所有的科
     * @return
     */
    @GetMapping("/all_specialties")
    @ResponseBody
    public List<CulproSpecialty> selectAllSpecialty(){
        List<CulproSpecialty> specialties = chineseMedicineService.selectAllSpecialty();
        return specialties;
    }

    /**
     * 查询医生表里面所有的医院
     * @return
     */
    @GetMapping("/all_hospitals")
    @ResponseBody
    public List<CulproHosp> selectAllHospital(){
        List<CulproHosp> hospitals = chineseMedicineService.selectAllHospital();
        return hospitals;
    }
}
