package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/whatever")
public class WhateverController {
	
	@GetMapping
	public String whatever() {
		return "whatever";
	}

}
