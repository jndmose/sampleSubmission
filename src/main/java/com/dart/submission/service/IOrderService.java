package com.dart.submission.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface IOrderService {

	public String getAvailableOrders() throws ClientProtocolException, IOException;

	public String getDataFromOrderId(String orderId) throws ClientProtocolException, IOException;

}
