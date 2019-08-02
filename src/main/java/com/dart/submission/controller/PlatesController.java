package com.dart.submission.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dart.submission.model.json.PlateDetails;
import com.dart.submission.model.json.PlateResponse;
import com.dart.submission.model.json.PlateResult;
import com.dart.submission.model.json.PlatesData;
import com.dart.submission.model.json.PlatesDataResponse;
import com.dart.submission.service.PlateService;
import com.google.gson.Gson;

@RestController
public class PlatesController {
	@Autowired
	private PlateService plateService;

	PlateResponse plateResponse = new PlateResponse();
	PlatesDataResponse platesDataResponse = new PlatesDataResponse();
	List<PlateDetails> plateDetails = new ArrayList<PlateDetails>();
	PlateResult plateResult = new PlateResult();
	List<PlatesData> platesData = new ArrayList<PlatesData>();

	@GetMapping(value = "/plateInformation/{orderId}", produces = "application/json")
	public PlateResult plateDetailsInfo(@PathVariable(value = "orderId") String orderId, Model model) {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plateResult;

	}

	@GetMapping(value = "/platesData/{submissionId}", produces = "application/json")
	public List<PlatesData> platesDetails(@PathVariable(value = "submissionId") String submissionId, Model model) {

		String responseString;
		Gson g = new Gson();
		try {
			responseString = plateService.getPlateData(submissionId);
			platesDataResponse = g.fromJson(responseString, PlatesDataResponse.class);
			platesData = platesDataResponse.getResult().getPlates();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return platesData;

	}

}
