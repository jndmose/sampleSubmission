package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleDetails {
	@JsonProperty("clientSampleId")
	private String clientSampleId;
	@JsonProperty("organismName")
	private String organismName;
	/*
	 * @JsonProperty("speciesName") private String speciesName;
	 */
	@JsonProperty("tissueType")
	private String tissueType;
	@JsonProperty("column")
	private String column;
	@JsonProperty("row")
	private String row;
	@JsonProperty("comments")
	private String comments;

	public String getClientSampleId() {
		return clientSampleId;
	}

	public void setClientSampleId(String clientSampleId) {
		this.clientSampleId = clientSampleId;
	}

	public String getOrganismName() {
		return organismName;
	}

	public void setOrganismName(String organismName) {
		this.organismName = organismName;
	}

	/*
	 * public String getSpeciesName() { return speciesName; }
	 * 
	 * public void setSpeciesName(String speciesName) { this.speciesName =
	 * speciesName; }
	 */

	public String getTissueType() {
		return tissueType;
	}

	public void setTissueType(String tissueType) {
		this.tissueType = tissueType;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
