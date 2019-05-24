package com.dart.submission.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlateJson {
	@JsonProperty("clientPlateId")
	private Long clientPlateId;
	@JsonProperty("clientPlateBarcode")
	private String clientPlateBarcode;
	@JsonProperty("sampleSubmissionFormat")
	private String sampleSubmissionFormat;
	@JsonProperty("samples")
	private List<SampleJson> samples;

	public Long getClientPlateId() {
		return clientPlateId;
	}

	public void setClientPlateId(Long clientPlateId) {
		this.clientPlateId = clientPlateId;
	}

	public String getClientPlateBarcode() {
		return clientPlateBarcode;
	}

	public void setClientPlateBarcode(String clientPlateBarcode) {
		this.clientPlateBarcode = clientPlateBarcode;
	}

	public String getSampleSubmissionFormat() {
		return sampleSubmissionFormat;
	}

	public void setSampleSubmissionFormat(String sampleSubmissionFormat) {
		this.sampleSubmissionFormat = sampleSubmissionFormat;
	}

	public List<SampleJson> getSamples() {
		return samples;
	}

	public void setSamples(List<SampleJson> samples) {
		this.samples = samples;
	}

	@Override
	public String toString() {
		return "PlateJson [clientPlateId=" + clientPlateId + ", clientPlateBarcode=" + clientPlateBarcode
				+ ", sampleSubmissionFormat=" + sampleSubmissionFormat + ", samples=" + samples + "]";
	}

}
