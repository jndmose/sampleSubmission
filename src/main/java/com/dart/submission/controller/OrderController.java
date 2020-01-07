package com.dart.submission.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dart.submission.model.json.OrderDetails;
import com.dart.submission.model.json.OrderResponse;
import com.dart.submission.model.json.ReportResponse;
import com.dart.submission.service.IOrderService;
import com.google.gson.Gson;

@Controller
public class OrderController {

	@Autowired
	private IOrderService orderService;
	OrderResponse orderResponse = new OrderResponse();
	ReportResponse reportResponse = new ReportResponse();
	List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

	@GetMapping(value = "/availableOrders")
	public String availableOrders(Model model) {
		String responseString;
		Gson g = new Gson();

		try {
			responseString = orderService.getAvailableOrders();
			orderResponse = g.fromJson(responseString, OrderResponse.class);
			orderDetails = orderResponse.getResult().getData();
			model.addAttribute("orderDetails", orderDetails);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "orderDetails";
	}

	@GetMapping(value = "/getData/{orderId}")
	public @ResponseBody String getData(@PathVariable(value = "orderId") String orderId, Model model) {

		String responseString;
		String fileUrl = null;
		Gson g = new Gson();

		try {
			responseString = orderService.getDataFromOrderId(orderId);
			reportResponse = g.fromJson(responseString, ReportResponse.class);
			fileUrl = reportResponse.getResult().getFileURL();

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileUrl;

	}

}
