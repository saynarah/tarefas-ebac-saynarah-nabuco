package br.com.saynab.vendas.online.ProdutoService.config;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.Validator;

public class ValidatorConfig {
	
	public Validator validatorFactory() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		return bean;
	}

}
