package com.dart.submission.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class PlateService implements IPlateService {
	private static String BASE_URL = "https://ordering-testing.diversityarrays.com/brapi/v1";
	// register an account with https://ordering-testing.diversityarrays.com to get
	// a token
	private static String TOKEN = "";

	@Override
	public String getPlateDetails(String orderId) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		URIBuilder builder = null;
		try {
			builder = new URIBuilder(BASE_URL + "/vendor/orders/" + orderId + "/plates");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpGet httpGet = null;
		try {
			httpGet = new HttpGet(builder.build());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpGet.setHeader("Content-Type", "application/json");
		httpGet.setHeader("Authorization", "Bearer " + TOKEN);

		CloseableHttpResponse response = client.execute(httpGet);
		HttpEntity httpEntity = response.getEntity();
		String responseString = EntityUtils.toString(httpEntity, "UTF-8");

		return responseString;
	}

	@Override
	public String getPlateData(String submissionId) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		URIBuilder builder = null;
		try {
			builder = new URIBuilder(BASE_URL + "/vendor/plates/" + submissionId);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpGet httpGet = null;
		try {
			httpGet = new HttpGet(builder.build());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpGet.setHeader("Content-Type", "application/json");
		httpGet.setHeader("Authorization", "Bearer " + TOKEN);

		CloseableHttpResponse response = client.execute(httpGet);
		HttpEntity httpEntity = response.getEntity();
		String responseString = EntityUtils.toString(httpEntity, "UTF-8");

		return responseString;
	}

}
