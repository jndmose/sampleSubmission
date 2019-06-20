package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusResponse {
	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private StatusResult result = null;

	public StatusResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public StatusResult getResult() {
		return result;
	}

	public void setResult(StatusResult result) {
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