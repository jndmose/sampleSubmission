package com.dart.submission.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dart.submission.exception.ResourceNotFoundException;
import com.dart.submission.model.Submission;
import com.dart.submission.repository.SubmissionRepository;

@RestController
public class SubmissionController {

	@Autowired
	private SubmissionRepository submissionRepository;

	@GetMapping(value = "/submission/{submissionId}", produces = { "application/json" })
	public Submission getSubmission(@PathVariable(value = "submissionId") Long submissionId) {

		return submissionRepository.findById(submissionId).orElseThrow(ResourceNotFoundException::new);

	}

	@PostMapping("/vendor/orders")
	public Submission submitPlates(@RequestBody @Valid Submission submission) {

		Submission sub = submissionRepository.save(submission);
		sub.getPlates().forEach(plate -> {
			plate.setSubmission(sub);
			plate.getSamples().forEach(sample ->

			sample.setPlate(plate));

		});
		return submissionRepository.save(sub);

	}

}
