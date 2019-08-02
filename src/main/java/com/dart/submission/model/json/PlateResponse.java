package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlateResponse {
	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private PlateResult result = null;

	public PlateResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public PlateResult getResult() {
		return result;
	}

	public void setResult(PlateResult result) {
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