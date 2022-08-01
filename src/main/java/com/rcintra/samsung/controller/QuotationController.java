package com.rcintra.samsung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.samsung.domain.QuotationDTO;
import com.rcintra.samsung.service.QuotationService;

@RestController
@RequestMapping("/api")
public class QuotationController {

	@Autowired
	private QuotationService service;
	
	@GetMapping("/quotation")
	public ResponseEntity<List<QuotationDTO>> listarCidades() {
		return new ResponseEntity<>(service.getQuotation(), HttpStatus.OK);
	}
	
}
