package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusResult {
	@JsonProperty("status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
