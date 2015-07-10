package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import org.hibernate.validator.constraints.NotBlank;

import com.jamonapi.utils.Logger;
import com.mysql.fabric.xmlrpc.base.Params;

import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;
import play.mvc.results.RenderJson;
import controllers.Cargos;
import Exceptions.ValidateException;
import Uteis.JPAUtil;
import Uteis.Mensagem;
import Uteis.ValidatorUtil;

@Entity
public class Cargo extends GenericModel {
		
	@Id
	@GeneratedValue
	public int id;
	
	@NotBlank(message = Mensagem.notBlank)
	@Unique(message = Mensagem.unique)
	@Column
	public String nome;
	
	/**
	 * 
	 * Em caso de relacionamento bidirecional, o trecho 
	 * abaixo funcionaria pois agora estou utilizando a 
	 * classe UsuariosSerializer para serializar os objetos 
	 * ao renderizar o Json
	 * 
	 * @OneToMany(mappedBy="cargo")
	 * public List<Usuario> usuarios;
	 * 
	**/
		
	public static Cargo findByNome(String nome) {
		
		return Cargo.find("byNome", nome).first();	
	}
		
	@Override
	public Cargo save() {
		
		ValidatorUtil.valida(this);
		return super.save();
	}
	
	public Mensagem remove() {
		
		validaRemove();
		this.delete();
		return new Mensagem().sucesso();
	}	

	public void update(Cargo cargoAtualizado) {		
		
		this.nome = cargoAtualizado.nome;
		
		ValidatorUtil.valida(this);
		super.save();		
	}	
	
	private void validaRemove() {
		
		Usuario usuario = Usuario.find("byId_Cargo", this.id).first();
		
		if(usuario != null)
			throw new ValidateException("Existe usuário cadastrado com este cargo.");	
	}
	
}
