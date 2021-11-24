package com.example;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.ResolvableType;

import static org.assertj.core.api.Assertions.assertThat;

class DemoApplicationTests {

	@Test
	void autowiredResolvesUndefinedDependency() {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(
				GenericFactoryBeanConfiguration.class, DummyInjector.class);
		NumberHolder<Integer> numberHolder = context.getBean(DummyInjector.class).numberHolder;
		assertThat(numberHolder).isNotNull();
		assertThat(numberHolder.getNumber()).isInstanceOf(Integer.class).isEqualTo(42);
	}

	@Test
	void getObjectProviderResolvesUndefinedDependency() {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(
				GenericFactoryBeanConfiguration.class, DummyInjector.class);
		Object numberHolder = context.getBeanProvider(ResolvableType.forClassWithGenerics(
				NumberHolder.class, Integer.class)).getIfAvailable();
		assertThat(numberHolder).isNotNull().isInstanceOf(NumberHolder.class);
	}




	static class DummyInjector {

		@Autowired
		private NumberHolder<Integer> numberHolder;

	}

}
