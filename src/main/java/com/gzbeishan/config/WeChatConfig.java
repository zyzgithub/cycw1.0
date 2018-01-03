package com.gzbeishan.config;

/**
 * Created by zhangyong on 2017/12/21.
 */

import com.gzbeishan.util.MD5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.UnsupportedEncodingException;

/**
 * 微信开发者账号配置
 */
@Configuration
@PropertySource("classpath:weChat.properties")
public class WeChatConfig {

    //微信公众号appid
    @Value("${wechat.gzh.appid}")
    private String wxGzhAppid;
    //微信公众号secret
    @Value("${wechat.gzh.appsercret}")
    private String wxGzhSecret;
    //微信公众号获取codeUrl
    @Value("${wechat.gzh.code.url}")
    private String wxGzhCodeUrl;
    //微信公众号根据code获取openId
    @Value("${wechat.gzh.openid.url}")
    private String wxGzhOpenIdUrl;


    public String getAuthCodeUrl(String redirectUrl) {
        String state = MD5Util.md5(redirectUrl + wxGzhSecret);
        String callBackUrl = "";
        try {
            callBackUrl = java.net.URLEncoder
                    .encode(redirectUrl
                            , "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return wxGzhCodeUrl.replace("APPID", wxGzhAppid)
                .replace("REDIRECT_URI", callBackUrl)
                .replace("STATE", state);
    }

    public String getAccessTokenUrl(String code) {
        return wxGzhOpenIdUrl.replace("APPID", wxGzhAppid)
                .replace("SECRET", wxGzhSecret)
                .replace("CODE", code);
    }





    public String getAuthCodeParam(String redirectUri) {
        return "appid=" + getWxGzhAppid() + "&scope=snsapi_base"
                + "&redirect_uri=" + redirectUri;
    }
    public String getWxGzhAppid() {
        return wxGzhAppid;
    }

    public String getWxGzhSecret() {
        return wxGzhSecret;
    }

    public String getWxGzhCodeUrl() {
        return wxGzhCodeUrl;
    }

    public String getWxGzhOpenIdUrl() {
        return wxGzhOpenIdUrl;
    }
}
