package br.com.produto.app;
import java.util.*;
import br.com.produto.service.*;
import br.com.produto.model.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ProdutoService servi = new ProdutoService();
		boolean rodando = true;

		while(rodando) {
			try {
				System.out.println("\n--- MENU ---");
				System.out.println("1. Adiciona produto");
				System.out.println("2. Buscar produto");
				System.out.println("3. Atualizar preço do produto");
				System.out.println("4. Lista produtos");
				System.out.println("5. Excluir produto");
				System.out.println("6. Ver valor total em estoque");
				System.out.println("7. Relatório de Validade (Alimentos)");
				System.out.println("8. Sair");
				System.out.print("Escolhar uma opção: ");
				int opcao = scan.nextInt();
				scan.nextLine();
				
				switch(opcao) {
					case 1:
						servi.addProduto(scan);
						break;
					case 2:
						servi.buscarProduto(scan);
						break;
					case 3:
						servi.atualizarPreco(scan);
						break;
					case 4:
						System.out.println("\n--- LISTA DE PRODUTOS ---");
						if(servi.getProdutos().isEmpty()) {
							System.out.println("Lista está vazia...");
							break;
						}
						for(Produto p : servi.getProdutos()) {
							System.out.println(p);
						}
						break;
					case 5:
						servi.excluirProduto(scan);
						break;
					case 6:
						servi.valorTotal();
						break;
					case 7:
						servi.imprimirValidades();
						break;
					case 8:
						System.out.println("Encerrando...");
						rodando = false;
						break;
					default:
						System.out.println("Opção inválida..");
				}
			} catch (Exception e) {
				System.out.println("Opção inválida. escolha um número positivo!");
				scan.nextLine();
			}
		}
		scan.close();
	}

}
