package lista02;
import java.util.Scanner;

public class Questao04 {

	public static void main(String[] args) {
//		4) Escreva um programa que imprima a tabela de multiplicação de um
//		número específico fornecido pelo usuário usando um loop while
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe um número para fazer sua tabuada de multiplicação: ");
		
		int multiplicador = scanner.nextInt();
		int multiplicando = 0;
		
		System.out.println("Tabuada de Multiplicação do "+multiplicador+":");
		
		while(multiplicando<=10) {
			System.out.println(multiplicador+" x "+multiplicando+" = "+(multiplicador*multiplicando));
			multiplicando++;
			
		}

	}

}
