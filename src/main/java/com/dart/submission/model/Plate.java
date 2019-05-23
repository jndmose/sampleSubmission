package com.dart.submission.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="tab", initialValue=0, allocationSize=50)
public class Plate {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	private Long id;
	private String clientPlateId;
	private String clientPlateBarcode;
	private String sampleSubmissionFormat;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="plate")
	private List<Sample> samples;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="submission_id")
	private Submission submission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientPlateId() {
		return clientPlateId;
	}

	public void setClientPlateId(String clientPlateId) {
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

	public List<Sample> getSamples() {
		return samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}
	
	public void addSample(Sample sample) {
		samples.add(sample);
		sample.setPlate(this);
	}
	
	public void removeSample(Sample sample) {
		samples.remove(sample);
		sample.setPlate(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientPlateBarcode == null) ? 0 : clientPlateBarcode.hashCode());
		result = prime * result + ((clientPlateId == null) ? 0 : clientPlateId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sampleSubmissionFormat == null) ? 0 : sampleSubmissionFormat.hashCode());
		result = prime * result + ((samples == null) ? 0 : samples.hashCode());
		result = prime * result + ((submission == null) ? 0 : submission.hashCode());
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
		Plate other = (Plate) obj;
		if (clientPlateBarcode == null) {
			if (other.clientPlateBarcode != null)
				return false;
		} else if (!clientPlateBarcode.equals(other.clientPlateBarcode))
			return false;
		if (clientPlateId == null) {
			if (other.clientPlateId != null)
				return false;
		} else if (!clientPlateId.equals(other.clientPlateId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sampleSubmissionFormat == null) {
			if (other.sampleSubmissionFormat != null)
				return false;
		} else if (!sampleSubmissionFormat.equals(other.sampleSubmissionFormat))
			return false;
		if (samples == null) {
			if (other.samples != null)
				return false;
		} else if (!samples.equals(other.samples))
			return false;
		if (submission == null) {
			if (other.submission != null)
				return false;
		} else if (!submission.equals(other.submission))
			return false;
		return true;
	}
	
	

}
