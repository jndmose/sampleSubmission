package com.dart.submission.model.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PlateDetails {

	@JsonProperty("clientPlateId")
	private String clientPlateId;
	@JsonProperty("samples")
	private List<SampleDetails> samples = new ArrayList<SampleDetails>();

	private int numberOfSamples;

	public String getClientPlateId() {
		return clientPlateId;
	}

	public void setClientPlateId(String clientPlateId) {
		this.clientPlateId = clientPlateId;
	}

	public List<SampleDetails> getSamples() {
		return samples;
	}

	public void setSamples(List<SampleDetails> samples) {
		this.samples = samples;
	}

	public int getNumberOfSamples() {
		return numberOfSamples;
	}

	public void setNumberOfSamples(int numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
	}

}
