package com.dart.submission.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dart.submission.exception.ResourceNotFoundException;
import com.dart.submission.model.SubmissionReference;
import com.dart.submission.model.json.OrderResponse;
import com.dart.submission.model.json.SubmissionResponse;
import com.dart.submission.repository.SubmissionRefRepository;
import com.dart.submission.repository.SubmissionRepository;
import com.dart.submission.service.ISubmissionService;
import com.google.gson.Gson;

@Controller
public class SubmissionController {

	@Autowired
	private SubmissionRepository submissionRepository;
	@Autowired
	private SubmissionRefRepository subRefRepo;

	@Autowired
	private ISubmissionService submissionService;
	SubmissionResponse submissionResponse = new SubmissionResponse();
	OrderResponse orderResponse = new OrderResponse();
	Map<Integer, String> responseString = new HashMap<>();

	// Submits to DArT using the web browser and saves the submission in
	// submission reference table

	@GetMapping(value = "/submission/{submissionId}")
	public String getSubmission(@PathVariable(value = "submissionId") Long submissionId,
			RedirectAttributes redirectAttributes) {

		SubmissionReference subRef = new SubmissionReference();

		Gson g = new Gson();

		return submissionRepository.findById(submissionId).map(sub -> {
			try {
				responseString = submissionService.submitToDart(sub);
				submissionResponse = responseString.keySet().iterator().next() == 200
						? g.fromJson(responseString.get(responseString.keySet().iterator().next()),
								SubmissionResponse.class)
						: new SubmissionResponse();

				if (!(submissionResponse.getResult() == null)) {
					subRef.setSubIdDart(submissionResponse.getResult().getSubmissionId());
					subRef.setSubmission(sub);
					subRef.setSubmissionDate(Calendar.getInstance().getTime());
					subRefRepo.save(subRef);
				}
			} catch (ClientProtocolException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirectAttributes.addFlashAttribute("submissionResponse", submissionResponse);
			redirectAttributes.addFlashAttribute("responseString", responseString);
			// return responseString.get(responseString.keySet().iterator().next());
			return "redirect:/submissionResponse";

		}).orElseThrow(() -> new ResourceNotFoundException("submission with ID " + submissionId + " not found"));

	}

}
