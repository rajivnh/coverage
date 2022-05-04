package com.lti.service;

import org.springframework.stereotype.Service;

import com.lti.store.CoverageData;

@Service
public class CoverageImpl implements CoverageService {

	@Override
	public CoverageData find(String id) {
		if(id != null) {
			CoverageData jacoData = CoverageData.builder()
				.vendorName("ICW")
				.build();
			
			return jacoData;
		} else {
			return CoverageData.builder().build();
		}
	}
}
