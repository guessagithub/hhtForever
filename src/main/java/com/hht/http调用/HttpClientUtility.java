package com.hht.http调用;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import com.hht.common.UtilString;

import net.sf.json.JSONObject;

/**
 * 需要引入包：httpclient-4.5.6.jar、httpcore-4.4.10.jar、fastjson-1.2.9.jar
 * 
 * @author xn088608
 */
@SuppressWarnings("deprecation")
public final class HttpClientUtility {
	private HttpClientUtility() {}

	// 静态内部类保证线程安全
	private static class HttpClientUtilityHolder {
		private static final HttpClientUtility instance = new HttpClientUtility();
	}

	public static HttpClientUtility getInstance() {
		return HttpClientUtilityHolder.instance;
	}

	/**
	 * 
	 * @param url	发送请求URL
	 * @param map	请求参数
	 * @param charset	编码集
	 * @return	1.如果请求返回状态码值不是200，结果为{"code":"2000001","msg":"详细错误报告"}<br/>
	 * 			2.如果状态码为200，则正常解析
	 */
	public static String doPost(String url, Map<?, ?> map, String charset) {
		HttpPost httpPost = null;
		String result = null;
		try {
			String json =  JSONObject.fromObject(map).toString();
			System.out.println("目标URL：{" + url + "},传输的Json：{" + json + "}");
			
			HttpClient httpClient = HttpClients.createDefault();
			// 设置超时时间及其数据传输时间
			httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);// 连接时间
			httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);// 数据传输时间
			httpPost = new HttpPost(url);
			StringEntity entity = new StringEntity(json, "UTF-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				// 返回值不是200，进行错误处理
				if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
					Map<String, String> errorMap = new HashMap<String, String>();
					errorMap.put("code", "400");
					errorMap.put("msg", response.getStatusLine().toString());
					result = JSONObject.fromObject(errorMap).toString();
				} else {
					HttpEntity resEntity = response.getEntity();
					if (resEntity != null) {
						result = EntityUtils.toString(resEntity, charset);
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("code", "400");
			errorMap.put("msg", ex.getMessage());
			result = JSONObject.fromObject(errorMap).toString();
			System.out.println("发送请求发生异常,URL:{" + url + "},参数:{" + map + "},异常信息:{" + ex.getMessage() + "}");
		} finally {
			if (httpPost != null) {
				httpPost.abort();
			}
		}
		return result;
	}
	
	
	public static String doPost(String url, String params, String contentType){
        CloseableHttpClient client = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(300).setConnectTimeout(300).build();//设置请求和传输超时时间

        String strResult = null;
        try {
            HttpPost post = new HttpPost(url);
            post.setConfig(requestConfig);
            if (UtilString.isNotEmpty(contentType)) {
                post.setHeader("Content-Type", contentType);
            }
            StringEntity se = new StringEntity(params);
            post.setEntity(se);

            HttpResponse response = client.execute(post);

            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && response.getEntity() != null){
                HttpEntity entity = response.getEntity();
                strResult = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
        	System.out.println("http post error : " + e.getMessage());
            return null;
        }
        return strResult;
    }
	
	
	public static void main(String[] args) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("applyNo", "tst-1000000001");
		params.put("productCode", "Test");
		params.put("ruleCode", "Test543260957949952");
		params.put("jsonData", "{\"age\":23}");
		

		String result1 = doPost("http://10.18.13.181:8080/decisionapply/apply", JSONObject.fromObject(params).toString(), "application/json;charset=UTF-8");
		System.out.println(result1);
		
//		String result2 = doPost("http://10.18.13.181:8080/decisionapply/apply", params, "UTF-8");
//		System.out.println(result2);
	}
	
	
	
}


