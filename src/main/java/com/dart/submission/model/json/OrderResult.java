package com.dart.submission.model.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResult {

	@JsonProperty("data")
	private List<OrderDetails> data = new ArrayList<OrderDetails>();

	public List<OrderDetails> getData() {
		return data;
	}

	public void setData(List<OrderDetails> data) {
		this.data = data;
	}

}
