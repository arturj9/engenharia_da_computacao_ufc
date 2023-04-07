package lista02;

import java.util.Scanner;

public class Questao03 {

	public static void main(String[] args) {
//		3) Escreva um programa que peça ao usuário para adivinhar um número
//		entre 1 e 100. Se o usuário adivinhar incorretamente, o programa deve
//		dizer se o número a ser adivinhado é maior ou menor do que o número
//		digitado pelo usuário. O programa deve continuar a pedir ao usuário que
//		adivinhe até que ele adivinhe corretamente.
		
		Scanner scanner = new Scanner(System.in);
		
		int numeroAleatorio = 67;
		int numeroInput;
		
		while(true) {
			
			System.out.print("Adivinhe o número entre 0 e 100: ");
			numeroInput = scanner.nextInt();
			
			
			if(numeroInput < 0 || numeroInput > 100)
				System.out.println("O número informado está entre 0 e 100");
			else if(numeroInput==numeroAleatorio)
				break;
			else if(numeroInput<numeroAleatorio)
				System.out.println(numeroInput + " é menor que o número desconhecido");
			else if(numeroInput>numeroAleatorio)
				System.out.println(numeroInput + " é maior que o número desconhecido");
		}
		
		System.out.println("Parabéns, " + numeroInput + " é o número correto");
		
		scanner.close();

	}

}
