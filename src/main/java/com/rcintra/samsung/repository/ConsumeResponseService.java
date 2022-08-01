package com.rcintra.samsung.repository;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rcintra.samsung.domain.CurrencyDTO;
import com.rcintra.samsung.domain.DocumentDTO;
import com.rcintra.samsung.domain.QuotationDTO;

@Service
public class ConsumeResponseService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${currency.url}")
	private String CURRENCY_URL;
	
	@Value("${quotation.url}")
	private String QUOTATION_URL;
	
	@Value("${docs.url}")
	private String DOCS_URL;
	
	public List<CurrencyDTO> getCurrency() {
		
		ResponseEntity<CurrencyDTO[]> responseEntity =
				restTemplate.getForEntity(
						CURRENCY_URL, 
						CurrencyDTO[].class);
		
		CurrencyDTO[] currencyArray = responseEntity.getBody();
		
		return Arrays.stream(currencyArray)
				.collect(Collectors.toList());
		
	}
	
	public List<QuotationDTO> getQuotation() {
		
		ResponseEntity<QuotationDTO[]> responseEntity =
				restTemplate.getForEntity(
						QUOTATION_URL, 
						QuotationDTO[].class);
		
		QuotationDTO[] quotationArray = responseEntity.getBody();
		
		return Arrays.stream(quotationArray)
				.collect(Collectors.toList());
		
	}
	
	public List<DocumentDTO> getDocument() {
		
		ResponseEntity<DocumentDTO[]> responseEntity =
				restTemplate.getForEntity(
						DOCS_URL, 
						DocumentDTO[].class);
		
		DocumentDTO[] documentArray = responseEntity.getBody();
		
		return Arrays.stream(documentArray)
				.collect(Collectors.toList());
		
	}
}
