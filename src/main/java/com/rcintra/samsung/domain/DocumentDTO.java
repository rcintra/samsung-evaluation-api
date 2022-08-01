package com.rcintra.samsung.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DocumentDTO {
	
	private Integer documentId;
	private Long documentNumber;
	private String notaFiscal;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date documentDate;
	
	private BigDecimal documentValue;
	private String currencyCode;
	
}
