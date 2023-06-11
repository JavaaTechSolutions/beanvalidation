package com.sc.beanvalidation.enums;

public enum TypeEnum {

	TYPE_1(1, "Type 1"), 
	TYPE_2(2, "Type 2"), 
	TYPE_3(3, "Type 3");

	private Integer type;

	private String desc;

	private TypeEnum(Integer type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public Integer getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	public static TypeEnum getInstallmentEnumByType(Integer type) {
		TypeEnum[] allValues = TypeEnum.values();

		for (TypeEnum value : allValues) {
			if (value.getType().equals(type)) {
				return value;
			}
		}
		
		return null;
	}
	
	public static boolean isType1(Integer cashbackType) {		
		return cashbackType.equals(TypeEnum.TYPE_1.getType());
	}
}
