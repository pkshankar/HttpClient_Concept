package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.client.RestClient;
import com.qa.pojo.UserUpdate;
import com.qa.pojo.UserUpdateResponse;

public class HttpClientPut {

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
	public void updateUser() throws ClientProtocolException, IOException {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Content-Type", "application/json");
		UserUpdate userUpdate = new UserUpdate("Roland", "Doctor");
		ObjectMapper mapper = new ObjectMapper();
		String requestString = mapper.writeValueAsString(userUpdate);
		CloseableHttpResponse closeableHttpResponse = restClient.put(uri, requestString, hashMap);
		System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
		HttpEntity httpEntity = closeableHttpResponse.getEntity();
		String responseString = EntityUtils.toString(httpEntity);
		UserUpdateResponse userUpdateResponse = mapper.readValue(responseString, UserUpdateResponse.class);
		System.out.println(userUpdate.getName());
		System.out.println(userUpdateResponse.getName());

	}

}
