package com.qa.test;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.client.RestClient;
import com.qa.pojo.FailureResponse;
import com.qa.pojo.SuccessResponse;
import com.qa.pojo.User;

public class HttpClientPost {

	String baseUrl = "http://restapi.demoqa.com";
	String pathParameter = "/customer/register";
	String uri;
	RestClient restClient;

	@BeforeMethod
	public void setUp() {

		uri = baseUrl + pathParameter;
		restClient = new RestClient();
	}

	@Test
	public void createUserPost() throws ClientProtocolException, IOException {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Content-Type", "application/json");
		User user = new User("Wuny", "Ted", "wunyted", "wun09", "jwunyted@xmail.com");
		ObjectMapper mapper = new ObjectMapper();

		// SERIALIZATION
		String jsonPayload = mapper.writeValueAsString(user);
		CloseableHttpResponse closeableHttpResponse = restClient.post(uri, jsonPayload, hashMap);
		System.out.println("RESPONSE CODE : " + closeableHttpResponse.getStatusLine().getStatusCode());
		Header[] headerArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> responseHeaderMap = new HashMap<String, String>();
		for (Header header : headerArray) {

			responseHeaderMap.put(header.getName(), header.getValue());
		}

		System.out.println("RESPONSE HEADERS ARE : " + responseHeaderMap);

		HttpEntity httpEntity = closeableHttpResponse.getEntity();
		String responseString = EntityUtils.toString(httpEntity);

		if (closeableHttpResponse.getStatusLine().getStatusCode() == 201) {

			// DESERIALIZATION
			SuccessResponse successResponse = mapper.readValue(responseString, SuccessResponse.class);
			System.out.println("SUCCESS MESSAGE : " + successResponse.getMessage());
			System.out.println("SUCCESS CODE : " + successResponse.getSuccessCode());

		}

		else if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {

			FailureResponse failureResponse = mapper.readValue(responseString, FailureResponse.class);
			System.out.println("FAULT ID : " + failureResponse.getFaultId());
			System.out.println("FAULT : " + failureResponse.getFault());
		}

	}

}
