package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.client.RestClient;

public class HttpClientGet {

	String baseUrl = "https://restcountries.eu";
	String pathParameter = "/rest/v2/capital/Washington";
	String uri;
	RestClient restClient;

	@BeforeMethod
	public void setUp() {

		uri = baseUrl + pathParameter;
		restClient = new RestClient();
	}

	@Test
	public void getCapitalInfo() {

		String jsonResponse = null;

		CloseableHttpResponse closeableHttpResponse = restClient.get(uri);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity httpEntity = closeableHttpResponse.getEntity();
		try {
			jsonResponse = EntityUtils.toString(httpEntity);
		} catch (ParseException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println(jsonResponse);
		Header[] headerArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		for (Header header : headerArray) {

			headerMap.put(header.getName(), header.getValue());
		}

		System.out.println(headerMap);

	}
}
