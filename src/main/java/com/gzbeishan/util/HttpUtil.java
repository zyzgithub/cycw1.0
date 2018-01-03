package com.gzbeishan.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

/**
 * Created by zhangyong on 2017/12/23.
 */
public class HttpUtil {
    public static JSONObject sendGet(String url, JSONObject params) {
        return HttpUtils.get(url, params);
    }

    public static JSONObject get(String url, Object objects) {
        String requestJson = JSONObject.toJSON(objects).toString();
        JSONObject jsonObject = HttpUtils.get(url, JSON.parseObject(requestJson));
        return jsonObject;
    }


    public static JSONObject post(String url, Object objects) {
        String requestJson = JSONObject.toJSON(objects).toString();
        JSONObject jsonObject = HttpUtils.postForm(url, JSON.parseObject(requestJson));
        return jsonObject;
    }

    public static String postXml(String requestUrl, String xml) {
        String respStr = "";
        try {
            URL url = new URL(requestUrl);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Pragma:", "no-cache");
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "text/xml");
            OutputStreamWriter out = new OutputStreamWriter(con
                    .getOutputStream());
            out.write(new String(xml.getBytes("UTF-8")));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con
                    .getInputStream()));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                respStr = respStr + line;
            }
//            logger.info(respStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respStr;
    }

    public static String postParams(String url, String params) {

        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);

            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            System.out.println(params);

            out.print(params);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            result = URLDecoder.decode(result, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        return result;
    }
}
