package Uteis;

public class Mensagem<T> {
	
	public static final String notBlank = "Campo Obrigatório.";
	public static final String unique = "Campo duplicado no banco.";	
	
	public String texto;
	public String tipo;
	public T dados;
	
	public Mensagem() {}
	
	public Mensagem(String mensagem){
		
		this.texto = mensagem;
	}
	
	public Mensagem(T dados) {
		
		this.dados = dados;
	}
	
	public Mensagem sucesso(){
		this.tipo = "Sucesso";
		this.texto = "Operação Realizada com Sucesso";
		return this;
	}
	
	public Mensagem Erro(){
		this.tipo = "Erro";
		return this;
	}
}
