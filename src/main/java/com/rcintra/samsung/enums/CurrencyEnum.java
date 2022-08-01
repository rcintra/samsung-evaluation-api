package com.rcintra.samsung.enums;

public enum CurrencyEnum {

	USD,
	PEN,
	BRL;
	
	public static CurrencyEnum getCurrencyEnum(String code) {
		for (CurrencyEnum e : CurrencyEnum.values()) {
			if (e.name().equalsIgnoreCase(code))
				return e;
		}
		throw new IllegalArgumentException(code);
	}
}
