package com.rcintra.samsung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcintra.samsung.domain.QuotationDTO;
import com.rcintra.samsung.repository.ConsumeResponseService;

@Service
public class QuotationService {

	@Autowired
	private ConsumeResponseService service;
	
	public List<QuotationDTO> getQuotation() {
		return service.getQuotation();
	}
}
