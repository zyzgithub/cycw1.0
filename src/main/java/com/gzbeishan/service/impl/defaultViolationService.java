package com.gzbeishan.service.impl;


import com.alibaba.fastjson.JSONObject;

import com.gzbeishan.config.BasicResult;
import com.gzbeishan.po.TestSa;
import com.gzbeishan.repository.TestJpa;
import com.gzbeishan.repository.ViolationOffSiteJpaRepository;
import com.gzbeishan.repository.ViolationSiteJpaRepository;
import com.gzbeishan.org.tempuri.IVehicleGZQueryServiceProxy;
import com.gzbeishan.po.ViolationOffSiteEntity;
import com.gzbeishan.po.ViolationSiteEntity;
import com.gzbeishan.service.ViolationService;
import com.gzbeishan.vo.CarDO;
import com.gzbeishan.vo.ViolationDO;
import com.gzbeishan.vo.ViolationWSResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by zhangyong on 2017/12/1.
 */
@Service
public class defaultViolationService implements ViolationService {



    @Autowired
    private ViolationOffSiteJpaRepository cheyouViolationOffSiteJpa;

    @Autowired
    private ViolationSiteJpaRepository violationSiteJpaRepository;

    @Autowired
    private TestJpa testJpa;
//
//    @Autowired
//    private ViolationSiteJpaRepository cheyouViolationSiteJpa;

    private static IVehicleGZQueryServiceProxy proxy =new IVehicleGZQueryServiceProxy();

//    private Logger logger = LoggerFactory.getLogger(defaultViolationService.class);
    public BasicResult getOrder(CarDO carDO) {
        try {
            String response = proxy.getViolationQuery(carDO.getPlateNum(), carDO.getPlateType(), carDO.getEngine(), carDO.getVin());
            ViolationWSResp car = JSONObject.parseObject(response, ViolationWSResp.class);
            List<ViolationDO> violation=car.getOffSite();
            List<ViolationDO> violationa=car.getSite();
            if(violation.size()>0){
                return BasicResult.createSuccessResultWithDatas("请求车辆违章查询成功_非现场处罚",violation);
            }else if(violationa.size()>0){
                return BasicResult.createSuccessResultWithDatas("请求车辆违章查询成功_非现场处罚",violationa);
            }else if(violation.size()>0&&violationa.size()>0){
                violation.addAll(violationa);
                return BasicResult.createSuccessResultWithDatas("请求车辆违章查询成功_非现场处罚",violation);
            }

//            logger.info("请求车辆违章查询成功_非现场处罚");

        } catch (RemoteException e) {
            e.printStackTrace();
//            logger.error("查询车辆违章数据出现异常",e);
        }
        return BasicResult.createFailResult("查询数据出现异常");
    }


    @Override
    public BasicResult ass(String numer) {
        return null;
    }

    @Override
    public BasicResult findAll() {
       List<TestSa> lst= testJpa.findAll();


        return BasicResult.createSuccessResultWithDatas("保存现场违章订单成功",lst);
    }

    @Override
    public BasicResult addOrderBySite(List<ViolationSiteEntity> violationSiteEntity) {

        for(ViolationSiteEntity violationSiteEntity1  : violationSiteEntity){
            violationSiteJpaRepository.save(violationSiteEntity1);
        }
        return BasicResult.createSuccessResult("保存现场违章订单成功");
    }

    @Override
    public BasicResult updateOrderBySite(List<ViolationSiteEntity> cheyouViolationSiteEntity) {
        for(ViolationSiteEntity violationSiteEntity : cheyouViolationSiteEntity){
            ViolationSiteEntity cheyouViolationSiteEntity1=violationSiteJpaRepository.findByDecisionNumber(violationSiteEntity.getDecisionNumber());
            //更新当前订单状态wei为已支付
            cheyouViolationSiteEntity1.setValid(0);
            violationSiteJpaRepository.save(cheyouViolationSiteEntity);
        }
        return BasicResult.createSuccessResult("更新现场违章订单成功");
    }

    @Override
    public BasicResult addOrderByOffSite(List<ViolationOffSiteEntity> cheyouViolationOffSiteEntity) {
        for(ViolationOffSiteEntity violationOffSiteEntity : cheyouViolationOffSiteEntity){
            cheyouViolationOffSiteJpa.save(violationOffSiteEntity);
        }
        return BasicResult.createSuccessResult("保存非现场违章订单成功");
    }

    @Override
    public BasicResult updateOrderByOffSite(List<ViolationOffSiteEntity> cheyouViolationOffSiteEntity) {
        for(ViolationOffSiteEntity violationOffSiteEntity : cheyouViolationOffSiteEntity){
            cheyouViolationOffSiteJpa.save(violationOffSiteEntity);ViolationOffSiteEntity cheyouViolationOffSiteEntity1=cheyouViolationOffSiteJpa.findByDecisionNumber(violationOffSiteEntity.getDecisionNumber());
            cheyouViolationOffSiteEntity1.setValid(0);
        }
        return BasicResult.createSuccessResult("更新非现场违章订单成功");
    }
}
