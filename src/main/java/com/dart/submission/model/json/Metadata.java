package com.dart.submission.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {
	@JsonProperty("datafiles")
	private List<String> datafiles = null;

	@JsonProperty("pagination")
	private MetadataPagination pagination = null;

	@JsonProperty("status")
	private List<Status> status = null;

	public List<String> getDatafiles() {
		return datafiles;
	}

	public void setDatafiles(List<String> datafiles) {
		this.datafiles = datafiles;
	}

	public MetadataPagination getPagination() {
		return pagination;
	}

	public void setPagination(MetadataPagination pagination) {
		this.pagination = pagination;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

}
