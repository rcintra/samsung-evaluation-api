package com.rcintra.samsung.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QuotationDTO {

	private String fromCurrencyCode;
	private String toCurrencyCode;
	private BigDecimal cotacao;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataHoraCotacao;
	
}
