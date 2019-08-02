package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportResponse {
	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private ReportResult result = null;

	public ReportResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public ReportResult getResult() {
		return result;
	}

	public void setResult(ReportResult result) {
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