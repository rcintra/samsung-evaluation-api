package com.rcintra.samsung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.samsung.domain.CurrencyDTO;
import com.rcintra.samsung.service.CurrencyService;

@RestController
@RequestMapping("/api")
public class CurrencyController {
	
	@Autowired
	private CurrencyService service;
	
	@GetMapping("/currency")
	public ResponseEntity<List<CurrencyDTO>> listarCidades() {
		return new ResponseEntity<>(service.getCurrency(), HttpStatus.OK);
	}
	
}
