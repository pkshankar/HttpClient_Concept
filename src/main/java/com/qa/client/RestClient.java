package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	public CloseableHttpResponse get(String uri) {

		CloseableHttpResponse closeableHttpResponse = null;

		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		try {
			closeableHttpResponse = closeableHttpClient.execute(httpGet);
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return closeableHttpResponse;

	}

	public CloseableHttpResponse post(String uri, String entityString, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uri);
		for (Map.Entry<String, String> map : headerMap.entrySet()) {

			httpPost.addHeader(map.getKey(), map.getValue());
		}

		httpPost.setEntity(new StringEntity(entityString));
		return closeableHttpClient.execute(httpPost);
	}

	public CloseableHttpResponse put(String uri, String entityString, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut(uri);
		for (Map.Entry<String, String> map : headerMap.entrySet()) {

			httpPut.addHeader(map.getKey(), map.getValue());

		}

		httpPut.setEntity(new StringEntity(entityString));
		return closeableHttpClient.execute(httpPut);
	}

	public CloseableHttpResponse delete(String uri) throws ClientProtocolException, IOException {

		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete(uri);
		return closeableHttpClient.execute(httpDelete);

	}

}
