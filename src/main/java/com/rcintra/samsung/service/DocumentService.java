package com.rcintra.samsung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcintra.samsung.domain.DocumentDTO;
import com.rcintra.samsung.repository.ConsumeResponseService;

@Service
public class DocumentService {

	@Autowired
	private ConsumeResponseService service;
	
	public List<DocumentDTO> getDocument() {
		return service.getDocument();
	}
	
}
