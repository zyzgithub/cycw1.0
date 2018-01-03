package com.gzbeishan.controller;


import com.gzbeishan.config.AppConfig;
import com.gzbeishan.config.BasicResult;
import com.gzbeishan.config.ViolationCostant;
import com.gzbeishan.config.WeChatConfig;
import com.gzbeishan.repository.TestJpa;
import com.gzbeishan.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zhangyong on 2017/10/8.
 */
@RestController
public class MainController {


    @Autowired
    private ViolationService violationService;

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private AppConfig appConfig;

    /**
     * index授权回调
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){


        ModelAndView modelAndView = new ModelAndView("index");
        return  modelAndView;
    }

    @RequestMapping("show")
    public ModelAndView show(){
        String redirectUri = appConfig.getAppUrl() + ViolationCostant.MAIN_CALLBACK_URL ;
        String params = weChatConfig.getAuthCodeParam(redirectUri);
        ModelAndView modelAndView = new ModelAndView("auth_code");
        modelAndView.addObject("params", params);
        return modelAndView;
    }
    /**
     * 微信授权回调
     */
    @RequestMapping("main/authorization")
    public ModelAndView authorization( String code, String state) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String openId = violationService.getOpenId(code, state);
        modelAndView.setViewName("index");
        modelAndView.addObject("openId", openId);
        System.out.println(openId);
        return modelAndView;
    }


//    @RequestMapping("/")
//    public BasicResult hello(){
//        return violationService.findAll();
//    }

}
