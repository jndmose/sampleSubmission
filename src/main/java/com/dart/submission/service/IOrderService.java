package com.dart.submission.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface IOrderService {
	/**
	 * method returns order Ids of all submitted orders
	 * 
	 * @author moses
	 */

	public String getAvailableOrders() throws ClientProtocolException, IOException;

	public String getDataFromOrderId(String orderId) throws ClientProtocolException, IOException;

}
