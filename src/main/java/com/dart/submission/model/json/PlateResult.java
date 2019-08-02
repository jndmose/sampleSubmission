package com.dart.submission.model.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlateResult {

	@JsonProperty("data")
	private List<PlateDetails> data = new ArrayList<PlateDetails>();

	public List<PlateDetails> getData() {
		return data;
	}

	public void setData(List<PlateDetails> data) {
		this.data = data;
	}

}
