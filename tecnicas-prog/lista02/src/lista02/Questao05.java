package lista02;

import java.util.Scanner;

public class Questao05 {

	public static void main(String[] args) {
//		5) Faça um programa que possa exibir uma sequência como a abaixo,
//		sendo o limite superior dos pares da esquerda e direita informados pelo
//		usuário. Exemplo: com pares da esquerda e direta com o limite superior
//		de 2 unidades.
//		0 - 0
//		0 - 1
//		0 - 2
//		1 - 0
//		1 - 1
//		1 - 2
//		2 - 0
//		2 - 1
//		2 - 2
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o limite: ");
		int limite = scanner.nextInt();
		
		for(int esquerda=0; esquerda<=limite; esquerda++) {
			for(int direita=0; direita<=limite; direita++) {
				System.out.println(esquerda + " - " + direita);
			}
		}
		
		
		scanner.close();

	}

}
