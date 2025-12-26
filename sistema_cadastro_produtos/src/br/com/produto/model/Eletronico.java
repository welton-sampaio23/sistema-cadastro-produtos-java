package br.com.produto.model;

public class Eletronico extends Produto {
	private String tensao;
	
	public Eletronico(String nome, double preco, String tensao) {
		super(nome, preco);
		this.tensao = tensao;
	}
	public String getTensao() {
		return this.tensao;
	}
	
	public void setTensao(String tensao) {
		this.tensao = tensao;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | Tensão: " + this.tensao;
	}
}
