package com.candymanage.candy.common.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

/**
 * @Author hyb
 * @Description blog
 * @Date 2019/08/30 15:33
 * @Dec http请求工具类
 */
public class HttpUtil {
    private static final RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000).setConnectionRequestTimeout(6000).build();
    public static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String httpPostJson(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            StringEntity se = new StringEntity(json, "UTF-8");
            httpPost.setEntity(se);
            response = httpClient.execute(httpPost);
            int status = response.getStatusLine().getStatusCode();
            //
            if (200 == status) {
                result = EntityUtils.toString(response.getEntity());
            } else {
                logger.info("连接失败，状态码为" + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e) {
                logger.error("关闭失败");
            }
        }
        return result;
    }


    public static String httpGetJson(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        CloseableHttpResponse response = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url + json);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.setConfig(requestConfig);
            httpGet.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response = httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();
            //
            if (200 == status) {
                result = EntityUtils.toString(response.getEntity());
            } else {
                logger.info("连接失败，状态码为" + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e) {
                logger.error("关闭失败");
            }
        }
        return result;
    }

  /* public static void main(String[] args) {

        String responses = httpGetJson("https://gaode.com/service/weather", adcode+"341000");
        System.out.println(responses);
    }
*/
}
