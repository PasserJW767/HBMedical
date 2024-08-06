package com.lanqiao.zzy.controller;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproData;
import com.lanqiao.zzy.service.ICulproDataService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 贾媛晴
 * @date
 */
@Controller
@RequestMapping("/regulatoryDocuments")
public class RegulatoryDocumentController {
    @Autowired
    ICulproDataService culproDataService;

    /**
     * 根据政策法规的类别来查
     * @author 王欢
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/regulation")
    public String selectRegulations(Model model,
                                    @RequestParam("datatype") String datatype,
                                    @RequestParam(value = "pageNum", required = false) Integer pageNum){
        if(pageNum==null){
            pageNum=1;
        }
        final Page<CulproData> regulationList = this.culproDataService.selectByDatatype(datatype, pageNum, 3);
        for (CulproData regulation : regulationList) {
            final String dataContent = regulation.getDataContent();
            if(dataContent!=null){
                //去掉DataContent中的img标签
                final Document parse = Jsoup.parse(dataContent);
                parse.select("img").remove();
                regulation.setDataContent(parse.toString());
            }
        }

        model.addAttribute("regulationList",regulationList);
        model.addAttribute("pageNum",pageNum);
        return "Policies_regulations/regulatoryDocuments";
    }

    /**
     *
     * 根据itemid找出政策法规对象
     * @author 王欢
     * @param model
     * @param itemid
     * @return
     */
    @GetMapping("/regulationDetail")
    public String getRegulationDetailByItemId(Model model,
                                              @RequestParam("itemid") Integer itemid,
                                              @RequestParam("pageNum") Integer pageNum){
        final CulproData culproData = this.culproDataService.selectByItemId(itemid);

        if(pageNum == -1){
//            说明此时是从regulation进来的，我们要从数据库中查到具体的pageNum值
            pageNum = this.culproDataService.selectLocationByItemId(itemid);
        }
//        根据itemId和pageNum获得所有文章的列表值
        Page<CulproData> pagers = this.culproDataService.selectAllTypeByItemId(itemid, pageNum);
//        获取当前的itemCode和itemId
        Integer currentItemId = pagers.getResult().get(0).getItemid();
        String currentItemCode = pagers.getResult().get(0).getItemcode();
//        获取文件的具体的路径信息
        String filePath = this.culproDataService.selectFile(currentItemId, currentItemCode);
//        定义上一页和下一页对象的两个变量
        CulproData preCulProData = null;
        CulproData nextCulProData = null;
//        如果当前页值大于1的话
        if(pagers.getPageNum() > 1){
            Page<CulproData> culproData1 = this.culproDataService.selectAllTypeByItemId(itemid, pageNum - 1);
            preCulProData = culproData1.getResult().get(0);
        }
//        如果当前页值小于最大数量的话
        if(pagers.getPageNum() < pagers.getPages() ){
            Page<CulproData> culproData1 = this.culproDataService.selectAllTypeByItemId(itemid, pageNum + 1);
            nextCulProData = culproData1.getResult().get(0);
        }
        model.addAttribute("preCulProData",preCulProData);
        model.addAttribute("culproData",culproData);
        model.addAttribute("filePath",filePath);
        model.addAttribute("nextCulProData",nextCulProData);
        model.addAttribute("pagers", pagers);

        return "Policies_regulations/regulatoryDocumentDetail";
    }
}
