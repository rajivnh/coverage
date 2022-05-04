package com.lti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.CoverageService;
import com.lti.store.CoverageData;

@RestController
public class CoverageController {
	CoverageService coverageService;
	
	public CoverageController(CoverageService coverageService) {
		this.coverageService = coverageService;
	}
	
	@GetMapping("/find/{id}")
	public CoverageData find(@PathVariable String id) {
		return coverageService.find(id);
	}
}
