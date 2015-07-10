package models;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;;

@Embeddable
public class UsuarioPerfil {	

	  @ManyToMany(fetch = FetchType.LAZY)
	  private int id_perfil;

	  @ManyToMany(fetch = FetchType.LAZY)
	  private int id_usuario;
	
}
