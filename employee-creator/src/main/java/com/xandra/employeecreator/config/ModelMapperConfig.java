package com.xandra.employeecreator.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.typeMap(String.class, String.class).setConverter(new StringTrimConverter());
		mapper.getConfiguration().setSkipNullEnabled(false);
		return mapper;
	}
	
	private class StringTrimConverter implements Converter<String, String> {

		@Override
		public String convert(MappingContext<String, String> context) {
			if (context.getSource() == null) {
				return null;
			}
			return context.getSource().trim();
		}
		
	}
}
