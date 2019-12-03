package com.qa.test;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.client.RestClient;

public class HttpClientGetCapitalInfo {

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
	public void getCapitalInfo() throws ParseException, IOException {

		CloseableHttpResponse closeableHttpResponse = restClient.get(uri);
		HttpEntity httpEntity = closeableHttpResponse.getEntity();
		String responseString = EntityUtils.toString(httpEntity);
		responseString = responseString.substring(1, responseString.length());
		responseString = responseString.substring(0, responseString.length() - 1);
		JSONObject jObj = new JSONObject(responseString);
		System.out.println(jObj.getString("name"));
		System.out.println(jObj.getJSONArray("topLevelDomain"));
		System.out.println(jObj.getJSONArray("topLevelDomain").get(0));
		System.out.println(jObj.getJSONArray("callingCodes").get(0));
		System.out.println(jObj.getJSONArray("altSpellings"));
		System.out.println(jObj.getJSONArray("altSpellings").get(2));
		System.out.println(jObj.getJSONArray("timezones").get(0));
		System.out.println(jObj.getJSONArray("currencies").getJSONObject(0).getString("code"));
		System.out.println(jObj.getJSONArray("languages").getJSONObject(0).getString("nativeName"));
		System.out.println(jObj.getJSONObject("translations").getString("pt"));
		System.out.println(jObj.getJSONArray("regionalBlocs").getJSONObject(0).getJSONArray("otherNames").get(0));
	}
}
