package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleJson {

	@JsonProperty("row")
	private Long row;
	@JsonProperty("clientSampleId")
	private String clientSampleId;
	@JsonProperty("comments")
	private String comments;

	@JsonProperty("organismName")
	private Long organismName;
	@JsonProperty("column")
	private String column;
	@JsonProperty("tissueType")
	private String tissueType;

	public Long getRow() {
		return row;
	}

	public void setRow(Long row) {
		this.row = row;
	}

	public String getClientSampleId() {
		return clientSampleId;
	}

	public void setClientSampleId(String clientSampleId) {
		this.clientSampleId = clientSampleId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getOrganismName() {
		return organismName;
	}

	public void setOrganismName(Long organismName) {
		this.organismName = organismName;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getTissueType() {
		return tissueType;
	}

	public void setTissueType(String tissueType) {
		this.tissueType = tissueType;
	}

	@Override
	public String toString() {
		return "SampleJson [row=" + row + ", clientSampleId=" + clientSampleId + ", comments=" + comments
				+ ", organismName=" + organismName + ", column=" + column + ", tissueType=" + tissueType + "]";
	}

}
