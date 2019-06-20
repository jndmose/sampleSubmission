package com.dart.submission.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.dart.submission.model.Submission;

public interface ISubmissionService {

	public String submitToDart(Submission sub) throws ClientProtocolException, IOException;

	public String getOrderIdFromSubmissionId(String id) throws ClientProtocolException, IOException;

	public String getOrderstatus(String orderId) throws ClientProtocolException, IOException;

}
