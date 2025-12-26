package br.com.produto.model;

public class Alimento extends Produto{
	private String validade;
	
	public Alimento(String nome, double preco, String validade) {
		super(nome, preco);
		this.validade = validade;
	}
	public String getValidade() {
		return this.validade;
	}
	
	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | Validade: " + this.validade;
	}
}
