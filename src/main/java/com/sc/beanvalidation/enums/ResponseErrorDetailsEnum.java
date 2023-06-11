package com.sc.beanvalidation.enums;

public enum ResponseErrorDetailsEnum {
		
	SUCCESS("200","Success"),
	FAILED("1014","Failed"),
    
	INVALID_CUSTOME_IDENTIFIER("1001","Please provide valid custom identifier"),
	INVALID_TRANSACTION_DETAILS("1002","Please provide transaction details"),
	INVALID_TRANSACTION_ID("1003","Please provide valid transaction id"),
	INVALID_TRANSACTION_DATE("1005","Please provide valid transaction date"),
	INVALID_DETAILS("1007","Please provide valid type details"),
	INVALID_DETAIL_TYPE("1009","Please provide valid type"),
	INVALID_TYPE_VALUE("1015","Please provide valid type value");

	private final String errorCode;
	private final String errorMsg;

	private ResponseErrorDetailsEnum(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public static ResponseErrorDetailsEnum getEnumErrorCode(String errorCode) {
		ResponseErrorDetailsEnum[] allValues = ResponseErrorDetailsEnum.values();

		for (ResponseErrorDetailsEnum value : allValues) {
			if (value.getErrorCode().equals(errorCode)) {
				return value;
			}
		}

		return null;
	}
}
