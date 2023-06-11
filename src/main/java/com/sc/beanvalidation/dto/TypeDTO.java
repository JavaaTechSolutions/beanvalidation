package com.sc.beanvalidation.dto;

import com.sc.beanvalidation.custom.EnumValidator;
import com.sc.beanvalidation.custom.FieldMatch;
import com.sc.beanvalidation.enums.TypeEnum;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@FieldMatch.List({ @FieldMatch(first = "type", second = "value", message = "1015") })
public class TypeDTO {

	@NotNull(message = "1009")
	@EnumValidator(message = "1009", enumClass = TypeEnum.class)
	private Integer type;

	@NotEmpty(message = "1015")
	private String value;

}
