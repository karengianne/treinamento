package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Query;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.validator.constraints.NotBlank;

import play.data.validation.Unique;
import play.db.jpa.GenericModel;
import play.db.jpa.JPA;
import controllers.Cargos;
import flexjson.JSONSerializer;
import Exceptions.ValidateException;
import Uteis.JPAUtil;
import Uteis.Mensagem;
import Uteis.ValidatorUtil;

@Entity
public class Usuario extends GenericModel{
	@Id
	@GeneratedValue
	public int id;
	
	@NotBlank (message = Mensagem.notBlank) 
	@Unique(message = Mensagem.unique)
	@Column
	public String cpf;
	
	@NotBlank (message = Mensagem.notBlank) 
	public String nome;	
		
	@ManyToOne
	@JoinColumn(name="id_cargo",nullable=false)
	public Cargo cargo;
	
	public Date data_cadastro;
	public Date data_nascimento;
	public char sexo;
	public boolean ativo;

	@ManyToMany(fetch=FetchType.LAZY)
	public List<Perfil> perfis = new ArrayList<Perfil>();

	public static List<Usuario> lista(){
		
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("ativo", String.valueOf(true));
		return lista(parametros);		
	}
	
	public static List<Usuario> listaPorPerfil(int idPerfil) {
		
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("p.id", String.valueOf(idPerfil));
		return lista(parametros);
	}
	
	private static <T> List<Usuario> lista(Map<T,T> parametros){
				
		StringBuilder builder = new StringBuilder()
			.append("select u from Usuario u ")
			.append("left outer join fetch u.perfis p ")
			.append("left outer join fetch u.cargo c");
		
		if (parametros.isEmpty()){
			return JPA.em().createQuery(builder.toString()).getResultList();
		}
		
		Iterator<String> iterator = (Iterator<String>) parametros.keySet().iterator();		
		String parametro = iterator.next();
		
		builder.append(" WHERE " + parametro);
		builder.append(" = " + parametros.get(parametro));
		
		while (iterator.hasNext()) {
			parametro = iterator.next();
			builder.append(" AND " + (Object) parametro);
			builder.append(" = " + parametros.get(parametro));
		}
				
		return JPA.em().createQuery(builder.toString()).getResultList();		
	}
		
	
	public static Usuario buscaPorId(int id){
		
		StringBuilder builder = new StringBuilder()
			.append("select u from Usuario u ")
			.append("left outer join fetch u.perfis p ")
			.append("left outer join fetch u.cargo c ")
			.append("where u.id =:idUsuario");
		
		Query query = JPA.em().createQuery(builder.toString());
		query.setParameter("idUsuario", id);
		return (Usuario) query.getResultList().get(0);
	}
	
	public Usuario insere(){
		
		ValidatorUtil.valida(this);
		return super.save();
	}
	
	public Mensagem remove(){
		
		this.ativo = false;
		super.save();
		return new Mensagem().sucesso();
	}
	
	public Mensagem edita(Usuario usuarioAtualizado){
		
		this.cargo = usuarioAtualizado.cargo;
		this.data_cadastro = usuarioAtualizado.data_nascimento;
		this.nome = usuarioAtualizado.nome;
		this.perfis = usuarioAtualizado.perfis;
		this.sexo = usuarioAtualizado.sexo;
		
		ValidatorUtil.valida(this);
		super.save();
		return new Mensagem().sucesso();
	}
}
