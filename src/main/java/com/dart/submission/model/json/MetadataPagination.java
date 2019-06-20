package com.dart.submission.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetadataPagination {
	@JsonProperty("currentPage")
	private Integer currentPage = null;

	@JsonProperty("pageSize")
	private Integer pageSize = null;

	@JsonProperty("totalCount")
	private Integer totalCount = null;

	@JsonProperty("totalPages")
	private Integer totalPages = null;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

}