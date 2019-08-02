package com.dart.submission.service;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.dart.submission.model.Submission;

public interface ISubmissionService {

	public Map<Integer, String> submitToDart(Submission sub) throws ClientProtocolException, IOException;

	public String getOrderIdFromSubmissionId(String id) throws ClientProtocolException, IOException;

	public String getOrderstatus(String orderId) throws ClientProtocolException, IOException;

}
