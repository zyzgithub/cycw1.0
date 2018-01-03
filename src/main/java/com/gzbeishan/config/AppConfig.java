package com.gzbeishan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by zhangyong on 2017/12/22.
 */
@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Value("${app.url}")
    private String appUrl;

    public String getAppUrl() {
        return appUrl;
    }
}
