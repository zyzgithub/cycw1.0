package com.gzbeishan.repository;


import com.gzbeishan.po.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangyong on 2017/12/13.
 */
@Repository
public interface CarJpaRepository extends JpaRepository<CarEntity,Integer> {

}
