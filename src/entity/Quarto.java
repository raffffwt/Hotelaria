package entity;

public class Quarto {
	public int id;
	public String tipo;
	public String descricao;
	public Double valor;
	public Boolean isReservado;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
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
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Boolean getIsReservado() {
		return isReservado;
	}
	
	public void setIsReservado(Boolean isReservado) {
		this.isReservado = isReservado;
	}
}
