package com.sc.beanvalidation.dto;

import com.sc.beanvalidation.custom.CheckDateFormat;
import com.sc.beanvalidation.custom.DateUtils;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NestedDTO {

	@NotEmpty(message = "1003")
	private String txnId;

	@NotEmpty(message = "1005")
	@CheckDateFormat(message = "1005", pattern = DateUtils.YYYYMMDDDASH)
	private String txnDate;

}
