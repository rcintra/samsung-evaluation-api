package com.rcintra.samsung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.samsung.domain.DocumentDTO;
import com.rcintra.samsung.service.DocumentService;

@RestController
@RequestMapping("/api")
public class DocumentController {

	@Autowired
	private DocumentService service;
	
	@GetMapping("/document")
	public ResponseEntity<List<DocumentDTO>> listarCidades() {
		return new ResponseEntity<>(service.getDocument(), HttpStatus.OK);
	}
	
	
}
