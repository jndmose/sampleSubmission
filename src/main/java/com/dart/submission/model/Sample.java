package com.dart.submission.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@TableGenerator(name = "tab", initialValue = 0, allocationSize = 50)
@JsonIgnoreProperties(value = { "id" })
public class Sample {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
	private Long id;
	private String row;
	private String clientSampleId;
	private String comments;
	private String organismName;
	@JsonProperty("column")
	private Long columnNumber;
	private String tissueType;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plate_id")
	private Plate plate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
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

	public String getOrganismName() {
		return organismName;
	}

	public void setOrganismName(String organismName) {
		this.organismName = organismName;
	}

	public Long getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(Long columnNumber) {
		this.columnNumber = columnNumber;
	}

	public String getTissueType() {
		return tissueType;
	}

	public void setTissueType(String tissueType) {
		this.tissueType = tissueType;
	}

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientSampleId == null) ? 0 : clientSampleId.hashCode());
		result = prime * result + ((columnNumber == null) ? 0 : columnNumber.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((organismName == null) ? 0 : organismName.hashCode());
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
		result = prime * result + ((row == null) ? 0 : row.hashCode());
		result = prime * result + ((tissueType == null) ? 0 : tissueType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sample other = (Sample) obj;
		if (clientSampleId == null) {
			if (other.clientSampleId != null)
				return false;
		} else if (!clientSampleId.equals(other.clientSampleId))
			return false;
		if (columnNumber == null) {
			if (other.columnNumber != null)
				return false;
		} else if (!columnNumber.equals(other.columnNumber))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (organismName == null) {
			if (other.organismName != null)
				return false;
		} else if (!organismName.equals(other.organismName))
			return false;
		if (plate == null) {
			if (other.plate != null)
				return false;
		} else if (!plate.equals(other.plate))
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		if (tissueType == null) {
			if (other.tissueType != null)
				return false;
		} else if (!tissueType.equals(other.tissueType))
			return false;
		return true;
	}

}
