package com.dart.submission.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dart.submission.model.Submission;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("submissionService")
public class SubmissionService implements ISubmissionService {

	private static String BASE_URL = "https://ordering-testing.diversityarrays.com/brapi/v1";
	// register an account with https://ordering-testing.diversityarrays.com to get
	// a token
	@Value("${api.authtoken}")
	private String TOKEN;

	// Submit data to DArT

	@Override
	public Map<Integer, String> submitToDart(Submission submission) throws ClientProtocolException, IOException {

		ObjectMapper obj = new ObjectMapper();
		Map<Integer, String> responseMap = new HashMap<>();
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(BASE_URL + "/vendor/plates");
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setHeader("Authorization", "Bearer " + TOKEN);

		String jsonString = obj.writeValueAsString(submission);
		StringEntity entity = new StringEntity(jsonString);
		httpPost.setEntity(entity);

		CloseableHttpResponse response = client.execute(httpPost);
		HttpEntity httpEntity = response.getEntity();
		Integer statusCode = response.getStatusLine().getStatusCode();
		String responseString = EntityUtils.toString(httpEntity, "UTF-8");
		System.out.println(responseString);

		client.close();
		responseMap.put(statusCode, responseString);

		/*
		 * responseMap.put(201, "{\n" + "   \"metadata\" : {\n" +
		 * "      \"status\" : [\n" + "         {}\n" + "      ],\n" +
		 * "      \"datafiles\" : []\n" + "   },\n" + "   \"result\" : {\n" +
		 * "      \"submissionId\" : \"103\"\n" + "   }\n" + "}");
		 */

		return responseMap;

	}

	// Using submissionId get orderId from DArT API

	@Override
	public String getOrderIdFromSubmissionId(String id) throws ClientProtocolException, IOException {

		CloseableHttpClient client = HttpClients.createDefault();
		URIBuilder builder = null;
		try {
			builder = new URIBuilder(BASE_URL + "/vendor/orders");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		builder.setParameter("submissionId", id);
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

	// Using orderId, get the order status from DArT API

	@Override
	public String getOrderstatus(String orderId) throws ClientProtocolException, IOException {

		CloseableHttpClient client = HttpClients.createDefault();
		URIBuilder builder = null;
		try {
			builder = new URIBuilder(BASE_URL + "/vendor/orders/" + orderId + "/status");
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
