package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatesDataResponse {

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private PlatesDataResult result = null;

	public PlatesDataResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public PlatesDataResult getResult() {
		return result;
	}

	public void setResult(PlatesDataResult result) {
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
