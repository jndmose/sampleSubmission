package com.dart.submission.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dart.submission.exception.ResourceNotFoundException;
import com.dart.submission.model.Plate;
import com.dart.submission.model.Sample;
import com.dart.submission.model.Submission;
import com.dart.submission.model.SubmissionReference;
import com.dart.submission.model.json.OrderResponse;
import com.dart.submission.model.json.StatusResponse;
import com.dart.submission.repository.SubmissionRefRepository;
import com.dart.submission.repository.SubmissionRepository;
import com.dart.submission.service.ISubmissionService;
import com.google.gson.Gson;

@Controller
public class MainController {
	@Autowired
	private SubmissionRepository submissionRepository;
	@Autowired
	SubmissionRefRepository subRefRepo;

	@Autowired
	private ISubmissionService submissionService;

	OrderResponse orderResponse = new OrderResponse();
	StatusResponse statusResponse = new StatusResponse();

	// Loads data from the submission reference table and also fetches orderId and
	// Status from DArT API

	@GetMapping(value = "/submissionReference")
	public String showSubmissionPage(Model model) {
		Gson g = new Gson();
		List<SubmissionReference> subRef = subRefRepo.findAll();
		subRef.stream().forEach(sub -> {

			List<String> orderId = getOrderNumberFromSubmission(sub.getSubIdDart());
			if (!orderId.isEmpty()) {
				sub.setOrderId(orderId.get(0));

				String responseString = null;
				try {
					responseString = submissionService.getOrderstatus(orderId.get(0));
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				statusResponse = g.fromJson(responseString, StatusResponse.class);
				sub.setStatus(statusResponse.getResult().getStatus());

			}

			else {

				sub.setOrderId("NONE");
				sub.setStatus("NONE,");

			}

		});

		model.addAttribute("submissionRef", subRef);
		return "submission";
	}

	// LOads data from the submission table
	@GetMapping(value = "/")
	public String showResult(Model model) {
		List<Submission> subs = submissionRepository.findAll();
		model.addAttribute("submissions", subs);
		return "result";
	}

	// Loads the data from the unique submission Id upon clicking

	@GetMapping(value = "/submissionLocal/{submissionId}")
	public String getLocalSubmission(@PathVariable(value = "submissionId") Long submissionId, Model model) {
		List<Sample> samples = new ArrayList<Sample>();
		return submissionRepository.findById(submissionId).map(sub -> {
			List<Plate> plates = sub.getPlates();
			plates.forEach(plate -> {
				samples.addAll(plate.getSamples());
			});
			model.addAttribute("submission", sub);
			model.addAttribute("samples", samples);
			return "tableData";

		}).orElseThrow(() -> new ResourceNotFoundException("submission with ID " + submissionId + " not found"));

	}

	// Method returns the order number from the submission using submission ID

	public List<String> getOrderNumberFromSubmission(String submissionId) {
		Gson g = new Gson();
		List<String> orderId = null;
		try {
			String responseString = submissionService.getOrderIdFromSubmissionId(submissionId);
			orderResponse = g.fromJson(responseString, OrderResponse.class);

			orderId = orderResponse.getResult().getData().stream().map(data -> data.getOrderId())
					.collect(Collectors.toList());

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderId;

	}

}
