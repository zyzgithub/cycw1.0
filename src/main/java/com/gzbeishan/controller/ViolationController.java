package com.gzbeishan.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.gzbeishan.config.BasicResult;
import com.gzbeishan.config.ViolationCostant;
import com.gzbeishan.po.ViolationSiteEntity;
import com.gzbeishan.service.ViolationService;
import com.gzbeishan.vo.CarDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhangyong on 2017/12/1.
 */
@Controller
public class ViolationController {

    @Autowired
    private ViolationService violationService;
    /**
     * 根据车辆信息查询处罚订单信息
     * @return
     */
    @RequestMapping(value = ViolationCostant.SEARCH_URL,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BasicResult getViolationListByOffSite(String carDo){

        CarDO carDO= JSONObject.parseObject(carDo,CarDO.class);
//        carDO.setPlateNum("粤E208J2");
//        carDO.setPlateType("02");
//        carDO.setEngine("538337");
//        carDO.setVin("897586");
        return violationService.getOrder(carDO);
    }


    /**
     * 保存现场处罚未支付订单
     * @param orderInfo
     * @return
     */
    @RequestMapping(value = ViolationCostant.SAVE_SITE_VIOLATION,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BasicResult saveSiteViolation(String orderInfo){

        List<ViolationSiteEntity> lst= JSONArray.parseArray(orderInfo.replaceAll("null","\"\""),ViolationSiteEntity.class);
        return violationService.addOrderBySite(lst);
    }

}
