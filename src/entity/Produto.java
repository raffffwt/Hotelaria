package entity;

public class Produto {
	
	public String nome;
	public String descricao;
	public Double valor;
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
}

