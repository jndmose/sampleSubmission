package com.dart.submission.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dart.submission.model.Submission;
import com.dart.submission.model.json.PlateDetails;
import com.dart.submission.model.json.PlateResponse;
import com.dart.submission.model.json.PlateResult;
import com.dart.submission.model.json.PlatesData;
import com.dart.submission.model.json.PlatesDataResponse;
import com.dart.submission.repository.SubmissionRepository;
import com.dart.submission.service.PlateService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@RestController
public class PlatesController {
	@Autowired
	private PlateService plateService;
	@Autowired
	private SubmissionRepository submissionRepository;

	PlateResponse plateResponse = new PlateResponse();
	PlatesDataResponse platesDataResponse = new PlatesDataResponse();
	List<PlateDetails> plateDetails = new ArrayList<PlateDetails>();
	PlateResult plateResult = new PlateResult();
	List<PlatesData> platesData = new ArrayList<PlatesData>();

	@GetMapping(value = "/plateInformation/{orderId}", produces = "application/json")
	public ResponseEntity<PlateResult> plateDetailsInfo(@PathVariable(value = "orderId") String orderId, Model model) {

		String responseString;
		Gson g = new Gson();
		try {
			responseString = plateService.getPlateDetails(orderId);
			plateResponse = g.fromJson(responseString, PlateResponse.class);
			plateDetails = plateResponse.getResult().getData();
			plateDetails.forEach(plate -> {

				plate.setNumberOfSamples(plate.getSamples().size());
			});
			plateResult.setData(plateDetails);
		} catch (ClientProtocolException e) {

			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		catch (JsonSyntaxException ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		// return plateResult;
		return new ResponseEntity<>(plateResult, HttpStatus.OK);

	}

	@GetMapping(value = "/platesData/{submissionId}", produces = "application/json")
	public ResponseEntity<List<PlatesData>> platesDetails(@PathVariable(value = "submissionId") String submissionId,
			Model model) {

		String responseString;
		Gson g = new Gson();
		try {
			responseString = plateService.getPlateData(submissionId);
			platesDataResponse = g.fromJson(responseString, PlatesDataResponse.class);
			platesData = platesDataResponse.getResult().getPlates();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		catch (JsonSyntaxException ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(platesData, HttpStatus.OK);

	}

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
