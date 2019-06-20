package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse {
	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private OrderResult result = null;

	public OrderResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public OrderResult getResult() {
		return result;
	}

	public void setResult(OrderResult result) {
		this.result = result;
	}

	/**
	 * Get metadata
	 * 
	 * @return metadata
	 **/

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

}