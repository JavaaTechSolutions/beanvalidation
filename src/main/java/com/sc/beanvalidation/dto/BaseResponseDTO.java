package com.sc.beanvalidation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseResponseDTO {
	private String responseCode;

	private String responseMessage;

}
