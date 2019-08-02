package com.dart.submission.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@TableGenerator(name = "tab", initialValue = 0, allocationSize = 50)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@JsonIgnoreProperties(value = { "id", "submissionRefs" })
public class Submission {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
	private Long id;

	private Long numberOfSamples;
	private String sampleType;
	private String clientId;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "submission")
	private List<Plate> plates = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "submission")
	private List<SubmissionReference> submissionRefs = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addPlate(Plate plate) {
		plates.add(plate);
		plate.setSubmission(this);
	}

	public void removePlate(Plate plate) {
		plates.remove(plate);
		plate.setSubmission(null);
	}

	public Long getNumberOfSamples() {
		return numberOfSamples;
	}

	public void setNumberOfSamples(Long numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public List<Plate> getPlates() {
		return plates;
	}

	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}

	public List<SubmissionReference> getSubmissionRefs() {
		return submissionRefs;
	}

	public void setSubmissionRefs(List<SubmissionReference> submissionRefs) {
		this.submissionRefs = submissionRefs;
	}

}
