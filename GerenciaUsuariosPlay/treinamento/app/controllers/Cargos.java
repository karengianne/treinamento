package controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import play.mvc.Controller;
import Exceptions.ValidateException;
import Uteis.Mensagem;
import models.Cargo;

public class Cargos extends DefaultController{	
	
	public static void lista(){		
		
 		renderJSON(Cargo.findAll());
	}
		
	public static void adiciona(Cargo cargo){		
		
		cargo.save();			
		renderJSON(new Mensagem(cargo).sucesso());		
	}
	
	public static void remove(int id){		
			
		Cargo cargo = Cargo.findById(id);			
		renderJSON(cargo.remove());			
	}
		
	public static void edita(int id, Cargo cargoAtualizado){	
		
	    Cargo cargo = Cargo.findById(id); 
	    cargo.update(cargoAtualizado);
	    
	    renderJSON(new Mensagem(cargo).sucesso());
	}
	
	public static void buscaPorNome(String nome){
		
		Cargo cargo = Cargo.findByNome(nome);
		renderJSON(cargo);		
	}
}
