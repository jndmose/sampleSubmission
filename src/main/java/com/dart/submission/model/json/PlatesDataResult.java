package com.dart.submission.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatesDataResult {

	@JsonProperty("numberOfSamples")
	private String numberOfSamples = null;

	@JsonProperty("sampleType")
	private String sampleType = null;

	@JsonProperty("clientId")
	private String clientId = null;

	@JsonProperty("plates")
	private List<PlatesData> plates = null;

	public String getNumberOfSamples() {
		return numberOfSamples;
	}

	public void setNumberOfSamples(String numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public List<PlatesData> getPlates() {
		return plates;
	}

	public void setPlates(List<PlatesData> plates) {
		this.plates = plates;
	}

}
