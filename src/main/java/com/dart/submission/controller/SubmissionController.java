package com.dart.submission.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dart.submission.exception.ResourceNotFoundException;
import com.dart.submission.model.Submission;
import com.dart.submission.model.json.SubmissionResponse;
import com.dart.submission.repository.SubmissionRepository;
import com.dart.submission.service.ISubmissionService;
import com.google.gson.Gson;

@RestController
public class SubmissionController {

	@Autowired
	private SubmissionRepository submissionRepository;

	@Autowired
	private ISubmissionService submissionService;
	SubmissionResponse submissionResponse = new SubmissionResponse();

	@GetMapping(value = "/submission/{submissionId}", produces = { "application/json" })
	public SubmissionResponse getSubmission(@PathVariable(value = "submissionId") Long submissionId) {

		Gson g = new Gson();

		return submissionRepository.findById(submissionId).map(sub -> {
			try {
				String responseString = submissionService.submitToDart(sub);
				submissionResponse = g.fromJson(responseString, SubmissionResponse.class);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return submissionResponse;

		}).orElseThrow(() -> new ResourceNotFoundException("submission with ID " + submissionId + " not found"));

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

	@GetMapping(value = "/result")
	public ModelAndView showResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result");
		return modelAndView;
	}

}
