package controllers;

import java.util.List;

import serializers.UsuariosSerializer;
import flexjson.JSONSerializer;
import models.Cargo;
import models.Perfil;
import models.Usuario;

public class Usuarios extends DefaultController{
	
	public static void lista(){
		List<Usuario> usuarios = Usuario.lista();
		renderJSON(usuarios, UsuariosSerializer.lista);
	}
	
	public static void adiciona(){
		Usuario usuario = getObjectFromJsonBody(Usuario.class);					
		renderJSON(usuario.insere());
	}
	
	public static void remove(int id){
		Usuario usuario = Usuario.buscaPorId(id);
		renderJSON(usuario.remove());
	}
	
	public static void edita(int id){
		Usuario usuarioASerEditado = Usuario.buscaPorId(id);		
		renderJSON(usuarioASerEditado.edita(
				getObjectFromJsonBody(Usuario.class)));
	}
}
