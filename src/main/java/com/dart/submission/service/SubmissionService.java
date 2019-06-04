package com.dart.submission.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.dart.submission.model.Submission;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("submissionService")
public class SubmissionService implements ISubmissionService {

	private static String BASE_URL = "https://ordering-testing.diversityarrays.com/brapi/v1";
	// register an account with https://ordering-testing.diversityarrays.com to get
	// a token
	private static String TOKEN = "";

	@Override
	public String submitToDart(Submission submission) throws ClientProtocolException, IOException {

		ObjectMapper obj = new ObjectMapper();

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(BASE_URL + "/vendor/plates");
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setHeader("Authorization", "Bearer " + TOKEN);
		String jsonString = obj.writeValueAsString(submission);
		StringEntity entity = new StringEntity(jsonString);
		httpPost.setEntity(entity);

		CloseableHttpResponse response = client.execute(httpPost);
		HttpEntity entity1 = response.getEntity();
		String responseString = EntityUtils.toString(entity1, "UTF-8");
		System.out.println(responseString);

		client.close();
		/*
		 * return "{\n" + "   \"metadata\" : {\n" + "      \"status\" : [\n" +
		 * "         {}\n" + "      ],\n" + "      \"datafiles\" : []\n" + "   },\n" +
		 * "   \"result\" : {\n" + "      \"submissionId\" : \"52\"\n" + "   }\n" + "}";
		 */

		return responseString;

	}

}
