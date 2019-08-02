package com.dart.submission.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface IPlateService {
	public String getPlateDetails(String orderId) throws ClientProtocolException, IOException;

	public String getPlateData(String submissionId) throws ClientProtocolException, IOException;

}
