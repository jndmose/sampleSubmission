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
public class OrderService implements IOrderService {

	private static String BASE_URL = "https://ordering-testing.diversityarrays.com/brapi/v1";
	// register an account with https://ordering-testing.diversityarrays.com to get
	// a token
	private static String TOKEN = "";

	@Override
	public String getAvailableOrders() throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		URIBuilder builder = null;
		try {
			builder = new URIBuilder(BASE_URL + "/vendor/orders");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		builder.setParameter("pageSize", "1000");

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
	public String getDataFromOrderId(String orderId) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		CloseableHttpClient client = HttpClients.createDefault();
		URIBuilder builder = null;
		try {
			builder = new URIBuilder(BASE_URL + "/vendor/orders/" + orderId + "/results");
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
