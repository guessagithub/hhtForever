package com.hht.http调用;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.hht.common.UtilString;

import net.sf.json.JSONObject;

/**
 * 
 * 需要引入包：httpclient-4.5.6.jar、httpcore-4.4.10.jar、fastjson-1.2.9.jar
 * 
 */
public class HttpClient_1 {

	private HttpClient_1() {}

	// 静态内部类保证线程安全
	private static class HttpClient_1_Holder {
		private static final HttpClient_1 instance = new HttpClient_1();
	}

	public static HttpClient_1 getInstance() {
		return HttpClient_1_Holder.instance;
	}

	/**
	 * 
	 * @param url
	 * @param params
	 * @param contentType
	 * @param httpSoTimeout		请求超时时间
	 * @param connectionTimeout		传输超时时间
	 * @return
	 */
	public String doPost(String url, String params, String contentType, int httpSoTimeout, int connectionTimeout) {
		CloseableHttpClient client = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(httpSoTimeout).setConnectTimeout(connectionTimeout).build();// 设置请求和传输超时时间

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

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && response.getEntity() != null) {
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

	public String doPost(String url, String params, String contentType) {
		return doPost(url, params, contentType, 300, 300);
	}
	
	public static void main(String[] args) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("applyNo", "tst-1000000001");
		params.put("productCode", "Test");
		params.put("ruleCode", "Test543260957949952");
		params.put("jsonData", "{\"age\":23}");
		
		String result1 = HttpClient_1.getInstance().doPost("http://10.18.13.181:8080/decisionapply/apply", JSONObject.fromObject(params).toString(), "application/json;charset=UTF-8");
		System.out.println(result1);
		
	}

}
