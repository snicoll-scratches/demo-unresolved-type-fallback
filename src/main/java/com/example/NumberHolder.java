package com.example;

public class NumberHolder<N extends Number> {

	private final N number;

	public NumberHolder(N number) {
		this.number = number;
	}

	public N getNumber() {
		return this.number;
	}
}