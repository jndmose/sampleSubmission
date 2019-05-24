package com.dart.submission.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionJson {
	@JsonProperty("numberOfSamples")
	private Long numberOfSamples;
	@JsonProperty("sampleType")
	private String sampleType;
	@JsonProperty("clientId")
	private String clientId;
	@JsonProperty("plates")
	private List<PlateJson> plates;

	public Long getNumberOfSamples() {
		return numberOfSamples;
	}

	public void setNumberOfSamples(Long numberOfSamples) {
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

	public List<PlateJson> getPlates() {
		return plates;
	}

	public void setPlates(List<PlateJson> plates) {
		this.plates = plates;
	}

	@Override
	public String toString() {
		return "SubmissionJson [numberOfSamples=" + numberOfSamples + ", sampleType=" + sampleType + ", clientId="
				+ clientId + ", plates=" + plates + "]";
	}

}
