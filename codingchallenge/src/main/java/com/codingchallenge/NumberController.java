package com.codingchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumberController {

	@Autowired
	NextNumberService service;

	@RequestMapping(value = "/nextnumber", method = RequestMethod.GET)
	public String showPage() {

		return "number";
	}

	@RequestMapping(value = "/nextnumber", method = RequestMethod.POST)
	public String validateNumber(@RequestParam String number, ModelMap map) {

		map.put("responseMessage", service.findNextNumber(number));
		return "number";

	}
}
