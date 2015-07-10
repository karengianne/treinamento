package controllers;

import Uteis.Mensagem;
import models.Cargo;
import models.Perfil;

public class Perfis extends DefaultController {

	public static void lista() {
		
		renderJSON(Perfil.lista());
	}
	
	public static void adiciona(Perfil perfil) {
						
		renderJSON(perfil.save());		
	}
	
	public static void remove(int id) {
		
		Perfil perfil = Perfil.findById(id);
		renderJSON(perfil.remove());
	}
	
	public static void edita(int id, Perfil perfilAtualizado) {
		
		Perfil perfil = Perfil.findById(id);		
		perfil.update(perfilAtualizado);
		
	    renderJSON(new Mensagem(perfil).sucesso());
	}
	
}
