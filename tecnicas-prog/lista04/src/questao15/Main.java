package questao15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nome;
		float precoVenda;
		float precoCusto;
		float despesas;
		
		System.out.print("Nome: ");
		nome = scanner.next();
		System.out.print("Preço de Custo: ");
		precoCusto = scanner.nextFloat();
		System.out.print("Preço de Venda: ");
		precoVenda = scanner.nextFloat();
		System.out.print("Preço de Despesas: ");
		despesas = scanner.nextFloat();
		
		Produto p = new Produto(nome,precoCusto,precoVenda,despesas);
		p.calculoMargemLucro();
		System.out.println("Margem de lucro: "+p.getMargemLucro()+"%");
		
		scanner.close();
	}

}
