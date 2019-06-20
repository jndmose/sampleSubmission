package com.dart.submission.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dart.submission.exception.ResourceNotFoundException;
import com.dart.submission.model.Submission;
import com.dart.submission.model.SubmissionReference;
import com.dart.submission.model.json.OrderResponse;
import com.dart.submission.model.json.SubmissionResponse;
import com.dart.submission.repository.SubmissionRefRepository;
import com.dart.submission.repository.SubmissionRepository;
import com.dart.submission.service.ISubmissionService;
import com.google.gson.Gson;

@RestController
public class SubmissionController {

	@Autowired
	private SubmissionRepository submissionRepository;
	@Autowired
	private SubmissionRefRepository subRefRepo;

	@Autowired
	private ISubmissionService submissionService;
	SubmissionResponse submissionResponse = new SubmissionResponse();
	OrderResponse orderResponse = new OrderResponse();

	// Submits to DArT using the web browser and saves the submission in submission
	// reference table

	@GetMapping(value = "/submission/{submissionId}", produces = { "application/json" })
	public SubmissionResponse getSubmission(@PathVariable(value = "submissionId") Long submissionId) {

		SubmissionReference subRef = new SubmissionReference();

		Gson g = new Gson();

		return submissionRepository.findById(submissionId).map(sub -> {
			try {
				String responseString = submissionService.submitToDart(sub);
				submissionResponse = g.fromJson(responseString, SubmissionResponse.class);
				subRef.setSubIdDart(submissionResponse.getResult().getSubmissionId());
				subRef.setSubmission(sub);
				subRef.setSubmissionDate(Calendar.getInstance().getTime());
				subRefRepo.save(subRef);
			} catch (ClientProtocolException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			return submissionResponse;

		}).orElseThrow(() -> new ResourceNotFoundException("submission with ID " + submissionId + " not found"));

	}

	// Locally submits plates from postman into the database.

	@PostMapping("/vendor/orders")
	public Long submitPlates(@RequestBody @Valid Submission submission) {

		Submission sub = submissionRepository.save(submission);
		sub.getPlates().forEach(plate -> {
			plate.setSubmission(sub);
			plate.getSamples().forEach(sample ->

			sample.setPlate(plate));

		});
		return submissionRepository.save(sub).getId();

	}

}
