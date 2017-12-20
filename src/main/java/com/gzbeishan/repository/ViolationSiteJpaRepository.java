package com.gzbeishan.repository;

import com.gzbeishan.po.ViolationSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangyong on 2017/12/13.
 */
@Repository
public interface ViolationSiteJpaRepository extends JpaRepository<ViolationSiteEntity,Integer> {

    /**
     * 根据订单号获取订单信息
     * @param decisionNumber
     * @return
     */
    ViolationSiteEntity findByDecisionNumber(String decisionNumber);
}
