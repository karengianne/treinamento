package Uteis;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import Exceptions.ValidateException;
import play.data.validation.Validation;
import play.db.jpa.GenericModel;


public class ValidatorUtil{
	
	private static ValidatorFactory hibernateValidatorFactory = 
			javax.validation.Validation.buildDefaultValidatorFactory();
	
	public static void valida(GenericModel obj) {
		
		executarValidacoesPlay(obj);
		
		executarValidacoesHibernate(obj);
	}
	
	private static void executarValidacoesPlay(GenericModel model) {
		
		Validation validation = Validation.current();
		
		if (!validation.valid(model).ok) 
			throw new ValidateException(validation.errors().get(0).message());
	}
	
	private static <T> void executarValidacoesHibernate(T obj){
		
		Validator validator = hibernateValidatorFactory.getValidator();
		Set<ConstraintViolation<T>> erros = validator.validate(obj);
		Mensagem msg = new Mensagem();
		
		for(ConstraintViolation<T> erro : erros){
			throw new ValidateException(erro.getMessage());
		}	
	}
}
