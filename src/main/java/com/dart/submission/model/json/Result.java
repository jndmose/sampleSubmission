package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("submissionId")
	private String submissionId;

	public String getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

}
