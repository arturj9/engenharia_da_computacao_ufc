package lista02;

import java.util.Scanner;

public class Questao07 {

	public static void main(String[] args) {
//		7) Crie um programa que use um loop "while" para encontrar o maior
//		número primo que é menor do que um número fornecido pelo usuário.
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe um número inteiro positivo: ");
		int numero = scanner.nextInt();
		int copiaNumero = numero-1;
		int numeroPrimo = 0;
		
		boolean isPrimo = false;
		
		if(numero<3) {
			System.out.println("Informe um número maior/igual a 3");
		}else {
			while(!isPrimo) {
				for(int aux = copiaNumero-1;aux>=1;aux--) {
					if(copiaNumero%aux==0&&aux>=2) {
						copiaNumero--;
						break;
					}
					if(aux==1) {
						isPrimo = true;
						numeroPrimo=copiaNumero;
					}
				}
			}
			
			System.out.println("O maior número primo e menor que "+numero+" é "+numeroPrimo);
			
			
		}
		
		scanner.close();
		
	}

}
