package com.rcintra.samsung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcintra.samsung.domain.CurrencyDTO;
import com.rcintra.samsung.repository.ConsumeResponseService;

@Service
public class CurrencyService {

	@Autowired
	private ConsumeResponseService service;
	
	public List<CurrencyDTO> getCurrency() {
		return service.getCurrency();
	}
}
