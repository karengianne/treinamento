package serializers;

import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;

public class UsuariosSerializer {

	public static JSONSerializer lista;
	
	static {
		lista =  new JSONSerializer()
			.include(
				"id", 
				"cpf", 
				"nome", 
				"cargo.id", 
				"cargo.nome",
				"perfis.id",
				"perfis.nome",
				"data_nascimento",
				"data_cadastro")				
			.exclude("*")	
			.transform(new DateTransformer("dd/MM/yyyy"),"data_nascimento")
			.transform(new DateTransformer("dd/MM/yyyy"),"data_cadastro");
	}
}
