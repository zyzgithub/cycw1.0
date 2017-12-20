package com.gzbeishan.repository;

import com.gzbeishan.po.ViolationOffSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangyong on 2017/12/13.
 */
@Repository
public interface ViolationOffSiteJpaRepository extends JpaRepository<ViolationOffSiteEntity,Integer> {

    /**
     * 根据订单号更新获取违章订单信息
     * @param decisionNumber
     * @return
     */
    ViolationOffSiteEntity findByDecisionNumber(String decisionNumber);

}
