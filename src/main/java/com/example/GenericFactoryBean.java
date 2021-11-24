package com.example;

import org.springframework.beans.factory.FactoryBean;

public class GenericFactoryBean<T> implements FactoryBean<T> {

	private final T value;

	public GenericFactoryBean(T value) {
		this.value = value;
	}

	@Override
	public T getObject() {
		return this.value;
	}

	@Override
	public Class<?> getObjectType() {
		return this.value.getClass();
	}

}