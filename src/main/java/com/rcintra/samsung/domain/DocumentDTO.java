package com.rcintra.samsung.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DocumentDTO {
	
	private Integer documentId;
	private Long documentNumber;
	private String notaFiscal;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate documentDate;
	
	private BigDecimal documentValue;
	private String currencyCode;
	
	private String currencyDesc;
	private BigDecimal documentValueUSD;
	private BigDecimal documentValuePEN;
	private BigDecimal documentValueBRL;
	
}
