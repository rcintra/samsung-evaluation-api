package com.rcintra.samsung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcintra.samsung.domain.CurrencyDTO;
import com.rcintra.samsung.domain.DocumentDTO;
import com.rcintra.samsung.domain.QuotationDTO;
import com.rcintra.samsung.enums.CurrencyEnum;
import com.rcintra.samsung.repository.ConsumeResponseService;

@Service
public class DocumentService {

	@Autowired
	private ConsumeResponseService service;
	
	@Autowired
	private CurrencyService currentyService;
	
	@Autowired
	private QuotationService quotationService;
	
	public List<DocumentDTO> getDocument() {
		List<DocumentDTO> docs = service.getDocument();
		descriptionCurrentyComplement(docs);
		quotationComplement(docs);
		return docs;
	}
	
	private void descriptionCurrentyComplement(List<DocumentDTO> docs) {
		List<CurrencyDTO> currencies = currentyService.getCurrency();
		for (DocumentDTO doc : docs) {
			for (CurrencyDTO cur : currencies) {
				if (doc.getCurrencyCode().equals(cur.getCurrencyCode())) {
					doc.setCurrencyDesc(cur.getCurrencyDesc());
					break;
				}
			}
		}
	}
	
	private void quotationComplement(List<DocumentDTO> docs) {
		for (DocumentDTO doc : docs) {
			CurrencyEnum e = CurrencyEnum.getCurrencyEnum(doc.getCurrencyCode());
			switch (e) {
			case BRL:
				currencyCodeBRL(doc);
				break;
			case PEN:
				currencyCodePEN(doc);
				break;	
			case USD:
				currencyCodeUSD(doc);
				break;	
			default:
				break;
			}
		}
	}
	
	private void currencyCodeBRL(DocumentDTO doc) {
		doc.setDocumentValueBRL(doc.getDocumentValue());
		
		QuotationDTO quoUSD = quotationService.getLastQuotationByCurrencyCode(doc.getDocumentDate(), doc.getCurrencyCode(), CurrencyEnum.USD.name());
		doc.setDocumentValueUSD(doc.getDocumentValue().multiply(quoUSD.getCotacao()));
		
		QuotationDTO quoPEN = quotationService.getLastQuotationByCurrencyCode(doc.getDocumentDate(), doc.getCurrencyCode(), CurrencyEnum.PEN.name());
		doc.setDocumentValuePEN(doc.getDocumentValue().multiply(quoPEN.getCotacao()));
	}
	
	private void currencyCodePEN(DocumentDTO doc) {
		doc.setDocumentValuePEN(doc.getDocumentValue());
		
		QuotationDTO quoBRL = quotationService.getLastQuotationByCurrencyCode(doc.getDocumentDate(), doc.getCurrencyCode(), CurrencyEnum.BRL.name());
		doc.setDocumentValueBRL(doc.getDocumentValue().multiply(quoBRL.getCotacao()));
		
		QuotationDTO quoUSD = quotationService.getLastQuotationByCurrencyCode(doc.getDocumentDate(), doc.getCurrencyCode(), CurrencyEnum.USD.name());
		doc.setDocumentValueUSD(doc.getDocumentValue().multiply(quoUSD.getCotacao()));
	}
	
	private void currencyCodeUSD(DocumentDTO doc) {
		doc.setDocumentValueUSD(doc.getDocumentValue());

		QuotationDTO quoBRL = quotationService.getLastQuotationByCurrencyCode(doc.getDocumentDate(), doc.getCurrencyCode(), CurrencyEnum.BRL.name());
		doc.setDocumentValueBRL(doc.getDocumentValue().multiply(quoBRL.getCotacao()));
		
		QuotationDTO quoPEN = quotationService.getLastQuotationByCurrencyCode(doc.getDocumentDate(), doc.getCurrencyCode(), CurrencyEnum.PEN.name());
		doc.setDocumentValuePEN(doc.getDocumentValue().multiply(quoPEN.getCotacao()));
	}
}
