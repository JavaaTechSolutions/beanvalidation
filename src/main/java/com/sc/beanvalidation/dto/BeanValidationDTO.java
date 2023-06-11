package com.sc.beanvalidation.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BeanValidationDTO {

	@NotEmpty(message = "1001")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "1001")
	private String customIdentifier;

	@Valid
	@NotNull(message = "1002")
	private NestedDTO nestedDTO;

	@Valid
	@Size(min = 1, message = "1007")
	@NotNull(message = "1007")
	private List<TypeDTO> types;

}
