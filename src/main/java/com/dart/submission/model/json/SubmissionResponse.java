package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionResponse {
	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private Result result = null;

	public SubmissionResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
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