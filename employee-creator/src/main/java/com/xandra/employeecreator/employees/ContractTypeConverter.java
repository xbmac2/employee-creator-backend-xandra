package com.xandra.employeecreator.employees;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ContractTypeConverter implements AttributeConverter<ContractType, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(ContractType contractType) {
		//include null check?
		
		return contractType.getCode();
	}
	
	@Override
	public ContractType convertToEntityAttribute(Integer code) {
		//include null check?
		
		return Stream.of(ContractType.values())
				.filter(c -> c.getCode() == code)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
