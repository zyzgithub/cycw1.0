package com.gzbeishan.repository;

import com.gzbeishan.po.TestSa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhangyong on 2017/12/18.
 */
public interface TestJpa extends JpaRepository<TestSa,Integer> {
}
