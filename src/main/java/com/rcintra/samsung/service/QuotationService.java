package com.rcintra.samsung.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcintra.samsung.comparator.QuotationComparator;
import com.rcintra.samsung.domain.QuotationDTO;
import com.rcintra.samsung.repository.ConsumeResponseService;

@Service
public class QuotationService {

	@Autowired
	private ConsumeResponseService service;
	
	public List<QuotationDTO> getQuotation() {
		return service.getQuotation();
	}
	
	public QuotationDTO getLastQuotationByCurrencyCode(LocalDate documentDate, String fromCurrencyCode, String toCurrencyCode) {
		List<QuotationDTO> quotations = new ArrayList<>();
		for (QuotationDTO dto : getQuotation()) {
			if (dto.getFromCurrencyCode().equalsIgnoreCase(fromCurrencyCode)
					&& dto.getToCurrencyCode().equalsIgnoreCase(toCurrencyCode)) {
				quotations.add(dto);
			}
		}
		for (QuotationDTO quotation : quotations) {
			if (quotation.getDataHoraCotacao().compareTo(documentDate) == 0)
				return quotation;
		}
		Collections.sort(quotations, new QuotationComparator());
		return quotations.get(0);
	}
}
