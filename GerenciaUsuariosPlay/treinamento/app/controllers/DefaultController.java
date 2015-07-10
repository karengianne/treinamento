package controllers;

import Exceptions.ValidateException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import flexjson.JSONSerializer;
import models.Cargo;
import Uteis.Mensagem;
import play.Logger;
import play.db.jpa.JPA;
import play.mvc.Catch;
import play.mvc.Controller;
import play.mvc.Http;

public class DefaultController extends Controller{

	//private static Gson gson = new Gson();
	public static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
	
	public static <T> T getObjectFromJsonBody(Class<T> classe){
		String json = request.params.get("body");
	    return gson.fromJson(json, classe);	 
	}

	@Catch(value = Exception.class, priority = 2)
	protected static void handleException(Throwable throwable) {
	 	
		JPA.em().getTransaction().setRollbackOnly();
		Logger.error(throwable, throwable.getMessage());
	 	
		if (throwable instanceof ValidateException) {
			
			Mensagem msg = new Mensagem().Erro();
			msg.texto = throwable.getMessage();
			response.status = Http.StatusCode.INTERNAL_ERROR;
			renderJSON(msg);
			
		} else {
			
			Mensagem msg = new Mensagem().Erro();
			msg.texto = "Erro: contacte o administrador. ";
			response.status = Http.StatusCode.INTERNAL_ERROR;
			renderJSON(msg);
		}
	}
	
	protected static void renderJSON(Object obj, JSONSerializer serializer) {
		
		renderJSON(serializer.serialize(obj));
	}
}
