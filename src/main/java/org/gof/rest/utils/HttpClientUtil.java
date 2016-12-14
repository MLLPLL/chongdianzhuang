package org.gof.rest.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpClientUtil {

	protected static Logger logger = (Logger.getLogger(HttpClientUtil.class));

	private static PoolingHttpClientConnectionManager cm;
	/**
	 * OK: Success!
	 */
	public static final int OK = 200;

	static {
		if (cm == null) {
			cm = new PoolingHttpClientConnectionManager();
			cm.setMaxTotal(50);// 整个连接池最大连接数
			cm.setDefaultMaxPerRoute(5);// 每路由最大连接数，默认值是2
		}
	}

	public static CloseableHttpClient getHttpClient() {
		CloseableHttpClient httpClient = null;
		httpClient = HttpClients.custom().setConnectionManager(cm).build();
		if (httpClient == null) {
			httpClient = HttpClients.createDefault();
		}
		return httpClient;
	}

	/**
	 * 根据URL发送get请求获取数据
	 *
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		String result = null;
		HttpGet get = new HttpGet(url);
		try {
			CloseableHttpResponse response = getHttpClient().execute(get);
			HttpEntity resEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != OK) {
				get.abort();
				return null;
			}
			if (resEntity != null) {
				String respBody = EntityUtils.toString(resEntity);
				try {
					result = respBody;
				} catch (Exception e) {
					logger.error("+++++==> respBody:" + respBody + " <==+++++",e);
				}
			}
		} catch (IOException e) {
			logger.error("++++ doGet:" + url + " ++++++", e);
		} finally {
			get.releaseConnection();
		}
		return result;
	}


	/**
	 * 根据URL发送post请求获取数据
	 *
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String doPost(String url, Map<String, String> paramsMap) {
		String result = null;
		HttpPost post = new HttpPost(url);
		try {
			if (paramsMap != null && paramsMap.size() > 0) {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> m : paramsMap.entrySet()) {
					params.add(new BasicNameValuePair(m.getKey(), m.getValue()));
				}
				UrlEncodedFormEntity reqEntity = new UrlEncodedFormEntity(params, "UTF-8");
				post.setEntity(reqEntity);
			}
			HttpResponse response = getHttpClient().execute(post);
			HttpEntity resEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != OK) {
				post.abort();
				return null;
			}
			if (resEntity != null) {
				String respBody = EntityUtils.toString(resEntity);
				try {
					result = respBody;
				} catch (Exception e) {
					logger.error("+++++==> respBody:" + respBody + " <==+++++",e);
				}
			}
		} catch (IOException e) {
			logger.error("+++++==> doPost:" + url + " <==+++++", e);
		} finally {
			post.releaseConnection();
		}
		return result;
	}

	/**
	 * 不指定参数名的方式来POST Xml数据
	 * 
	 * @param url
	 * @param params
	 * @return
	 */ 
	public static String doPostXml(String url, String params) {
		String result = null;
		HttpPost post = new HttpPost(url);
		try {
			StringEntity myEntity = new StringEntity(params, "UTF-8"); 
			post.addHeader("Content-Type", "application/xml"); 
			post.setEntity(myEntity);
			HttpResponse response = getHttpClient().execute(post);
			HttpEntity resEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != OK) {
				post.abort();
				return null;
			}
			if (resEntity != null) {
				String respBody = EntityUtils.toString(resEntity);
				try {
					result = respBody;
				} catch (Exception e) {
					logger.error("+++++==> respBody:" + respBody + " <==+++++",e);
				}
			}
		} catch (IOException e) {
			logger.error("+++++==> doPost:" + url + " <==+++++", e);
		} finally {
			post.releaseConnection();
		}
		return result;
	}
	
	/**
	 * 不指定参数名的方式来POST JSON数据
	 * 
	 * @param url
	 * @param params
	 * @return
	 */ 
	public static String doPostJson(String url, String params) {
		String result = null;
		HttpPost post = new HttpPost(url);
		try {
			StringEntity myEntity = new StringEntity(params, "UTF-8"); 
			post.addHeader("Content-Type", "application/json"); 
			post.setEntity(myEntity);
			HttpResponse response = getHttpClient().execute(post);
			HttpEntity resEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != OK) {
				post.abort();
				return null;
			}
			if (resEntity != null) {
				String respBody = EntityUtils.toString(resEntity);
				try {
					result = respBody;
				} catch (Exception e) {
					logger.error("+++++==> respBody:" + respBody + " <==+++++",e);
				}
			}
		} catch (IOException e) {
			logger.error("+++++==> doPostJson:" + url + " <==+++++", e);
		} finally {
			post.releaseConnection();
		}
		return result;
	}
	
}
