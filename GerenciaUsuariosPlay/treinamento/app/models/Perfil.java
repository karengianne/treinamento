package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Query;

import org.hibernate.validator.constraints.NotBlank;

import play.data.validation.Unique;
import play.db.jpa.GenericModel;
import Exceptions.ValidateException;
import Uteis.JPAUtil;
import Uteis.Mensagem;
import Uteis.ValidatorUtil;

@Entity
public class Perfil extends GenericModel {
	@Id
	@GeneratedValue
	public int id;	

	@NotBlank(message = Mensagem.notBlank)
	@Unique(message = Mensagem.unique)
	@Column
	public String nome;
	
	public static List<Perfil> lista() {
		
		return Perfil.findAll();
	}
	
	public static Perfil findByNome(String nome) {
		
		return Perfil.find("byNome", nome).first();			
	}
		
	@Override
	public Perfil save() {
		
		ValidatorUtil.valida(this);
		return super.save();
	}
	
	public Mensagem remove() {
		
		validaRemove();
		super.delete();
		return new Mensagem().sucesso();
	}	
	
	public void update(Perfil perfilAtualizado) {	
		
		this.nome = perfilAtualizado.nome;
		
		ValidatorUtil.valida(this);
		super.save();	
	}

	private void validaRemove() {		
		
		List<Usuario> usuarios = Usuario.listaPorPerfil(this.id);
		
		if (!usuarios.isEmpty())
			throw new ValidateException("Existe usuário cadastrado com este perfil.");				
	}
	
}
