package Utils.util;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpClient {
    private static int TIMEOUT = 10000;

    public static String doPostByForm(String url, Map<String, Object> params, Map<String, String> header) {
        return doRequest(url, params, MediaType.APPLICATION_FORM_URLENCODED, header, HttpMethod.POST,TIMEOUT, false);
    }
    
    public static String doPostByForm(String url, Map<String, Object> params) {
        return doRequest(url, params, MediaType.APPLICATION_FORM_URLENCODED, null, HttpMethod.POST, TIMEOUT,false);
    }

    public static String doPostByFormWithFileUpload(String url, Map<String, Object> params) {
        return doRequest(url, params, MediaType.APPLICATION_FORM_URLENCODED, null, HttpMethod.POST, TIMEOUT,true);
    }

    public static String doPostByJson(String url, Map<String, Object> params) {
        return doRequest(url, params, MediaType.APPLICATION_JSON_UTF8, null,HttpMethod.POST,TIMEOUT, false);
    }
    public static String doPutByJson(String url, Map<String, Object> params) {
    	return doRequest(url, params, MediaType.APPLICATION_JSON_UTF8, null, HttpMethod.PUT, TIMEOUT,false);
    }
    public static String doDeleteByJson(String url, Map<String, Object> params) {
    	return doRequest(url, params, MediaType.APPLICATION_JSON_UTF8, null, HttpMethod.DELETE,TIMEOUT, false);
    }
    
    public static String doGet(String url) {
    	 RestTemplate template = new RestTemplate();
         LogUtils.info("http request: " + url);
         ResponseEntity<String> response = template.getForEntity(url, String.class);
//         LogUtils.info("http request: " + url + " result:" + response.getBody());
         if(response.getStatusCode() == HttpStatus.OK) {
             return response.getBody();
         }
         LogUtils.error("Wrong http request, code:{}, body:{}", response.getStatusCodeValue(), response.getBody());
         return null;
    }
    
    private static String doRequest(String url, Map<String, Object> params, MediaType contentType, Map<String, String> header, HttpMethod method, Integer timeout,boolean withFileUpload) {
        long startTime = System.currentTimeMillis();
        HttpHeaders headers = new HttpHeaders();
        if(header != null) {
            for(Map.Entry<String, String> entry : header.entrySet()) {
                headers.add(entry.getKey(), entry.getValue());
            }
        }
        if (!withFileUpload) {
            headers.setContentType(contentType);
        }
        //默认为 application/json
        HttpEntity<Object> httpEntity = new HttpEntity<>(params, headers);
        if(contentType.equals(MediaType.APPLICATION_FORM_URLENCODED)) {
            MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
            for(Map.Entry<String, Object> entry : params.entrySet()) {
                if (withFileUpload) {
                    multiValueMap.add(entry.getKey(), entry.getValue());
                } else {
                    multiValueMap.add(entry.getKey(), entry.getValue().toString());
                }
            }
            httpEntity = new HttpEntity<>(multiValueMap, headers);
        }
        if(contentType.equals(MediaType.APPLICATION_JSON_UTF8)) {
            httpEntity = new HttpEntity<>(params, headers);
        }
        RestTemplate client = createRestTemplate(timeout);
        LogUtils.info("==============================================");
        LogUtils.info("Http request! Url :" + url + " method:"  + method + " params:" + params);
        ResponseEntity<String> response = client.exchange(url, method, httpEntity, String.class);
        long endTime = System.currentTimeMillis();
		LogUtils.info("Http request! Url: "+ url + " params:" + params + " time:" + (endTime - startTime) + "ms");
        return response.getBody();
    }

    public static String doPost(String url, Map<String, Object> params) {
        return doRequest(url, params, MediaType.APPLICATION_JSON_UTF8, null, HttpMethod.POST,TIMEOUT,false);
    }

    private static RestTemplate createRestTemplate(Integer timeout) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(timeout);    //连接时间
        requestFactory.setReadTimeout(timeout);
        RestTemplate template = new RestTemplate(requestFactory);
        template.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));   //设置编码方式
        return template;
    }
}
