package com.dart.submission.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatesData {
	@JsonProperty("clientPlateBarcode")
	private String clientPlateBarcode;
	@JsonProperty("clientPlateId")
	private String clientPlateId;
	@JsonProperty("sampleSubmissionFormat")
	private String sampleSubmissionFormat;

	@JsonProperty("samples")
	private List<SampleData> samples;

	public String getClientPlateBarcode() {
		return clientPlateBarcode;
	}

	public void setClientPlateBarcode(String clientPlateBarcode) {
		this.clientPlateBarcode = clientPlateBarcode;
	}

	public String getClientPlateId() {
		return clientPlateId;
	}

	public void setClientPlateId(String clientPlateId) {
		this.clientPlateId = clientPlateId;
	}

	public String getSampleSubmissionFormat() {
		return sampleSubmissionFormat;
	}

	public void setSampleSubmissionFormat(String sampleSubmissionFormat) {
		this.sampleSubmissionFormat = sampleSubmissionFormat;
	}

	public List<SampleData> getSamples() {
		return samples;
	}

	public void setSamples(List<SampleData> samples) {
		this.samples = samples;
	}

}
