package com.dart.submission.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@TableGenerator(name = "tab", initialValue = 0, allocationSize = 50)
public class SubmissionReference {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
	private Long id;

	private String subIdDart;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "submissionId", referencedColumnName = "id")
	private Submission submission;

	@Temporal(TemporalType.DATE)
	private Date submissionDate;

	private String status;

	private String orderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubIdDart() {
		return subIdDart;
	}

	public void setSubIdDart(String subIdDart) {
		this.subIdDart = subIdDart;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
