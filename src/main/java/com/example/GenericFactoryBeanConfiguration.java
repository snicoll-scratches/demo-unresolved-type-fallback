package com.example;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class GenericFactoryBeanConfiguration {

	@Bean
	public FactoryBean<NumberHolder<?>> integerHolder() {
		return new GenericFactoryBean<>(new NumberHolder<>(42));
	}

}