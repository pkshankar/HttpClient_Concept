package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.client.RestClient;

public class HttpClientDelete {

	String baseUrl = "https://reqres.in";
	String pathParameter = "/api/users/2";
	String uri;
	RestClient restClient;

	@BeforeMethod
	public void setUp() {

		uri = baseUrl + pathParameter;
		restClient = new RestClient();
	}

	@Test
	public void deleteUser() throws ClientProtocolException, IOException {

		CloseableHttpResponse closeableHttpResponse = restClient.delete(uri);
		System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
	}

}
