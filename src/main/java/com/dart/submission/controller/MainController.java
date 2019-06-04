package com.dart.submission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dart.submission.model.SubmissionPage;

@Controller
public class MainController {
	@GetMapping(value = "/submission")
	public String showSubmissionPage(Model model) {

		model.addAttribute("submission", new SubmissionPage());
		return "submission";
	}

}
