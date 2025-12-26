package br.com.produto.service;

import java.util.Scanner;
import br.com.produto.model.*;
import java.util.ArrayList;

public class ProdutoService {
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public void addProduto(Scanner scan) {
		String nome = lerTextoObrigatorio("Digite o nome: ", scan);
		double preco = lerDouble("Digite o preço: R$", scan);
		boolean tipoValido = false;
		
		for(Produto p : this.getProdutos()) {
			if(p.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Produto já cadastrado...");
				return;
			}
		}
		while(!tipoValido) {
			try {
				System.out.println("\n--- Escolhar o Tipo de Produto ---");
				System.out.println("1. Alimento");
				System.out.println("2. Eletrônico");
				System.out.print("Escolhar a opção: ");
				int opcao = scan.nextInt();
				scan.nextLine();
				if(opcao == 1) {
					String validade = lerTextoObrigatorio("Digite a validade ex (12/10/2025): ", scan);
					this.produtos.add(new Alimento(nome, preco, validade));
					tipoValido = true;
					break;
				} else if(opcao == 2) {
					String tensao = lerTextoObrigatorio("Digite a tensão ex (110v/220v): ", scan);
					this.produtos.add(new Eletronico(nome, preco, tensao));
					tipoValido = true;
					break;			
				} else {
					System.out.println("Opção invalida...");
				}
			} catch (Exception e) {
				System.out.println("Opção inválida. Escolhar um número positivo");
				scan.nextLine();
			}
		}
		System.out.println("Produto cadastrado com sucesso...");
	}
	
	public void buscarProduto(Scanner scan) {
		String buscarProduto = lerTextoObrigatorio("Digite o nome para buscar: ", scan);
		for(Produto p : this.getProdutos()) {
			if(p.getNome().equalsIgnoreCase(buscarProduto)) {
				System.out.println("Produto encontrado!");
				System.out.println(p);
				return;
			}
		}
		System.out.println("Produto não encontrado...");
	}
	
	public void atualizarPreco(Scanner scan) {
		String atualizarProduto = lerTextoObrigatorio("Digite o nome do produto: ", scan);
		for(Produto p : this.getProdutos()) {
			if(p.getNome().equalsIgnoreCase(atualizarProduto)) {
				double novoPreco = lerDouble("Digite o novo preço: R$ ", scan);
				p.setPreco(novoPreco);
				System.out.println("Preço atualizador com sucesso...");
				return;
			}
		}
		System.out.println("Produto não encontrado...");
	}
	
	public void excluirProduto(Scanner scan) {
		String excluirProduto = lerTextoObrigatorio("Digite o nome do produto para excluir: ", scan);
		boolean removeu = this.getProdutos().removeIf(p -> p.getNome().equalsIgnoreCase(excluirProduto));
		if(removeu) {
			System.out.println("Produto removido com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}
	
	public void imprimirValidades() {
		System.out.println("--- RELATÓRIO DE VALIDADE ---");
		boolean temAlimento = false;
		for(Produto p : this.getProdutos()) {
			if(p instanceof Alimento) {
				Alimento a = (Alimento) p;
				System.out.println("Produto: " + a.getNome() + " | Validade: " + a.getValidade());
				temAlimento = true;
			}
		}
		if(!temAlimento) {
			System.out.println("Nenhum alimento no estoque.");
		}
	}
	public void valorTotal() {
		double total = 0;
		for(Produto p : this.getProdutos()) {
			total += p.getPreco();
		}
		System.out.printf("Valor total em estoque R$%.2f", total);
	}

	public ArrayList<Produto> getProdutos() {
		return this.produtos;
	}
	
	// Métodos auxiliares
	public String lerTextoObrigatorio(String msg, Scanner scan) {
		while(true) {
			System.out.print(msg);
			String texto = scan.nextLine().trim();
			if(!texto.isEmpty()) {
				return texto;
			}
			System.out.println("Erro: Esse campo não pode ser vazio.");
		}
	}
	
	public double lerDouble(String msg, Scanner scan) {
		while(true) {
			try {
				System.out.print(msg);
				double valor = scan.nextDouble();
				scan.nextLine();
				if(valor <= 0) {
					System.out.println("Erro: Preço não pode ser negativo ou igual a zero!");
					continue;
				}
				return valor;
			} catch (Exception e) {
				System.out.println("Dados inválido tente novamente...");
				scan.nextLine();
			}
			
		}
	}
}
