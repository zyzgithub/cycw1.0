package com.gzbeishan.controller;


import com.gzbeishan.config.BasicResult;
import com.gzbeishan.repository.TestJpa;
import com.gzbeishan.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zhangyong on 2017/10/8.
 */
@RestController
public class MainController {


    @Autowired
    private ViolationService testJpa;
    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping("/")
    public BasicResult hello(){


        return testJpa.findAll();
    }
}
