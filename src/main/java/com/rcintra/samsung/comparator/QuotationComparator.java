package com.rcintra.samsung.comparator;

import java.util.Comparator;

import com.rcintra.samsung.domain.QuotationDTO;

public class QuotationComparator implements Comparator<QuotationDTO> {

	@Override
	public int compare(QuotationDTO o1, QuotationDTO o2) {
		return o1.getDataHoraCotacao().compareTo(o2.getDataHoraCotacao());
	}
}
