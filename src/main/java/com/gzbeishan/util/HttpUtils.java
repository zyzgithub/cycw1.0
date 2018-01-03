package com.gzbeishan.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import okhttp3.*;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyong on 2017/12/23.
 */
public class HttpUtils {
    public static final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
    public static OkHttpClient client;
    public static OkHttpClient httpsClient;

    public HttpUtils() {
    }

    public static String encodUrl(String url, JSONObject params) throws UnsupportedEncodingException {
        if(null != params) {
            StringBuilder sb = new StringBuilder();
            Iterator var3 = params.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var3.next();
                sb.append("&").append((String)entry.getKey()).append("=").append(entry.getValue());
            }

            if(sb.length() > 0) {
                sb.deleteCharAt(0);
                url = url + "?" + URLEncoder.encode(sb.toString(), "utf-8");
            }
        }

        return url;
    }

    public static String getStr(String url, Map<String, Object> params) {
        return getStr(url, JSON.parseObject(JSON.toJSONString(params)), false);
    }

    public static JSONObject get(String url, JSONObject params) {
        String ret = getStr(url, params);
        return null == ret?null:(JSONObject)JSON.parseObject(ret, JSONObject.class);
    }

    public static String get(String url) {
        return getStr(url, (Map)null);
    }

    public static String getStr(String url, JSONObject params, boolean useHttps) {
        try {
            long start = System.currentTimeMillis();
            url = buildGetUrl(url, params);
            Request request = (new Request.Builder()).url(url).build();
            Response response;
            if(useHttps) {
                response = httpsClient.newCall(request).execute();
            } else {
                response = client.newCall(request).execute();
            }

            String ret = response.body().string();
//            if(logger.isInfoEnabled()) {
//                logger.info("【get({}ms)】 url------>{} result------>{}", new Object[]{Long.valueOf(System.currentTimeMillis() - start), url, ret});
//            }

            return ret;
        } catch (Exception var8) {
//            logger.warn("错误请求 url:{},params:{} 异常:{}", new Object[]{url, params == null?"":params.toJSONString(), var8});
            return null;
        }
    }

    public static String getRetryStr(String url, JSONObject params, int reTry, boolean useHttps) {
        int i = 0;

        while(i < reTry) {
            try {
                String ret = getStr(url, params, useHttps);
                return ret;
            } catch (Exception var7) {
//                logger.warn("错误请求 次数:{} url:{},params:{} 异常:{}", new Object[]{Integer.valueOf(i), url, params.toJSONString(), var7});
                ++i;
            }
        }

        return null;
    }

    public static String buildGetUrl(String url, JSONObject params) {
        if(null != params) {
            StringBuilder sb = new StringBuilder();
            Iterator var3 = params.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var3.next();
                sb.append("&").append((String)entry.getKey()).append("=").append(entry.getValue());
            }

            if(sb.length() > 0) {
                sb.deleteCharAt(0);
                if(url.contains("?")) {
                    url = url + "&" + sb.toString();
                } else {
                    url = url + "?" + sb.toString();
                }
            }
        }

        return url;
    }

    public static void getStrAsyn(String url, JSONObject params, boolean useHttps) {
        final long start = System.currentTimeMillis();
        url = buildGetUrl(url, params);
        Request request = (new Request.Builder()).url(url).build();
        client.newCall(request).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
//                if(response.isSuccessful() && HttpUtils.logger.isInfoEnabled()) {
//                    HttpUtils.logger.info("【get({}ms)】  url------>{}", Long.valueOf(System.currentTimeMillis() - start), url);
//                }

            }

            public void onFailure(Call call, IOException e) {
//                if(HttpUtils.logger.isInfoEnabled()) {
//                    HttpUtils.logger.info("【get({}ms)】  url------>{}   exception------>{}", new Object[]{Long.valueOf(System.currentTimeMillis() - start), url, e});
//                }

            }
        });
    }

    public static JSONObject post(String url, JSONObject params, boolean isFrom) {
        return (JSONObject)post(url, params, isFrom, JSONObject.class, false);
    }

    public static JSONObject post(String url, JSONObject params, boolean isFrom, boolean showLog) {
        return (JSONObject)post(url, params, isFrom, JSONObject.class, false, showLog);
    }

    public static <T> T post(String url, JSONObject params, boolean isFrom, Class<T> c, boolean useHttps) {
        String retStr = postStr(url, params, isFrom, false, true);

        try {
            return JSON.parseObject(retStr, c);
        } catch (Exception var7) {
//            logger.warn("错误请求 url:{},params:{} 异常:{}", new Object[]{url, params.toJSONString(), var7});
            return null;
        }
    }

    public static <T> T post(String url, JSONObject params, boolean isFrom, Class<T> c, boolean useHttps, boolean showLog) {
        String retStr = postStr(url, params, isFrom, false, showLog);

        try {
            return JSON.parseObject(retStr, c);
        } catch (Exception var8) {
//            logger.warn("错误请求 url:{},params:{} 异常:{}", new Object[]{url, params.toJSONString(), var8});
            return null;
        }
    }

    public static JSONObject postForm(String url, JSONObject params) {
        return post(url, params, true);
    }

    public static JSONObject postBody(String url, JSONObject params) {
        return post(url, params, false);
    }

    public static String postStr(String url, JSONObject params, boolean isFrom, boolean useHttps, boolean showLog) {
        try {
            long start = System.currentTimeMillis();
            RequestBody body = buildBody(url, params, isFrom);
            Request request = (new Request.Builder()).url(url).post(body).build();
            Response response = client.newCall(request).execute();
            String ret = response.body().string();
//            if(logger.isInfoEnabled() && showLog) {
//                logger.info("【post({}ms)】  url------>{}  params------>{}  result------> {}", new Object[]{Long.valueOf(System.currentTimeMillis() - start), url, params, ret});
//            }

            return ret;
        } catch (Exception var11) {
//            logger.warn("错误请求 url:{},params:{} 异常:{}", new Object[]{url, params.toJSONString(), var11});
            return null;
        }
    }

    public static RequestBody buildBody(String url, JSONObject params, boolean isFrom) {
        if(!isFrom) {
            String body = buildNotNullString(params);
            return RequestBody.create(mediaType, body);
        } else {
            okhttp3.FormBody.Builder fbuilder = new okhttp3.FormBody.Builder();
            Iterator var4 = params.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var4.next();
                fbuilder.add((String)entry.getKey(), String.valueOf(entry.getValue()));
            }

            return fbuilder.build();
        }
    }

    public static String buildNotNullString(Object o) {
        return JSON.toJSONString(o, new SerializerFeature[]{SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue});
    }

    public static void postStrAsyc(final String url, final JSONObject params, boolean isFrom, boolean useHttps) {
        final long start = System.currentTimeMillis();
        RequestBody body = buildBody(url, params, isFrom);
        Request request = (new Request.Builder()).url(url).post(body).build();
        client.newCall(request).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
//                HttpUtils.logger.info("【post({}ms)】  url------>{}  params------>{}  result------> {}", new Object[]{Long.valueOf(System.currentTimeMillis() - start), url, params, response.body().string()});
            }

            public void onFailure(Call call, IOException e) {
//                HttpUtils.logger.warn("【post({}ms)】  url------>{}  params------>{}  exception------> {}", new Object[]{Long.valueOf(System.currentTimeMillis() - start), url, params, e});
            }
        });
    }

    public static String toRequestPrams(String jsonStr) {
        jsonStr = jsonStr.replace("{\"", "").replace("\",\"", "&").replace("\":\"", "=");
        jsonStr = jsonStr.replace(",\"", "&").replace("\":", "=");
        jsonStr = jsonStr.substring(0, jsonStr.length() - 2);
        return jsonStr;
    }

    public static String toRequestPrams(Map<String, Object> params) {
        String paramStr = "";

        String key;
        Object value;
        for(Iterator var2 = params.keySet().iterator(); var2.hasNext(); paramStr = paramStr + "&" + key + "=" + value) {
            key = (String)var2.next();
            value = params.get(key);
        }

        if(paramStr.contains("&")) {
            paramStr = paramStr.substring(1);
        }

        return paramStr;
    }

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(20);
        client = (new OkHttpClient()).newBuilder().readTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).dispatcher(dispatcher).build();
        ConnectionSpec allSpec = (new okhttp3.ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)).allEnabledTlsVersions().allEnabledCipherSuites().build();
        httpsClient = (new OkHttpClient()).newBuilder().readTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionSpecs(Arrays.asList(new ConnectionSpec[]{allSpec})).build();
    }
}
