package com.gzbeishan.service;


import com.gzbeishan.config.BasicResult;
import com.gzbeishan.po.ViolationOffSiteEntity;
import com.gzbeishan.po.ViolationSiteEntity;
import com.gzbeishan.vo.CarDO;

import java.util.List;

/**
 * Created by zhangyong on 2017/12/1.
 */
public interface ViolationService {

    /**
     * 获取处罚订单(现场-非现场 api接口调用)
     * @param carDO
     * @return
     */
    BasicResult getOrder(CarDO carDO) ;

    /**
     * 提交现场处罚未支付订单
     * @param cheyouViolationSiteEntity
     * @return
     */
    BasicResult addOrderBySite(List<ViolationSiteEntity> cheyouViolationSiteEntity);

    /**
     * 更新现场处罚未支付订单
     * @param cheyouViolationSiteEntity
     * @return
     */
    BasicResult updateOrderBySite(List<ViolationSiteEntity> cheyouViolationSiteEntity);

    /**
     * 提交非现场处罚未支付订单
     * @param cheyouViolationOffSiteEntity
     * @return
     */
    BasicResult addOrderByOffSite(List<ViolationOffSiteEntity> cheyouViolationOffSiteEntity);

    /**
     * 更新非现场处罚未支付订单
     * @param cheyouViolationOffSiteEntity
     * @return
     */
    BasicResult updateOrderByOffSite(List<ViolationOffSiteEntity> cheyouViolationOffSiteEntity);


    BasicResult ass(String numer);

    BasicResult findAll();

    /**
     * 获取用户openId
     * @param code
     * @param state
     * @return
     */
    String getOpenId(String code, String state);
}
