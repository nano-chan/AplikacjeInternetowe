package com.kwapisz.nai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgeController {
	@RequestMapping("/age")
	public String age(@RequestParam(value = "age", required = false, defaultValue = "18") Integer age,
			Model model) {
		model.addAttribute("age", age);
		return "age";
	}
}
