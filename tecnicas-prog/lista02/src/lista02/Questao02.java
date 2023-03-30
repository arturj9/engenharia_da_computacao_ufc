package lista02;
import java.util.Scanner;

public class Questao02 {
	
	public static void main(String[] args) {
//		2) Escreva um programa que leia uma sequência de números do usuário e
//		pare a leitura quando o usuário digitar um número negativo. Em seguida,
//		o programa deve imprimir a soma dos números positivos lidos.
		
		int soma=0;
		int indice=0;
		int numero;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			indice++;
			
			System.out.print("Informe o número " + indice + ":");
			numero = scanner.nextInt();
			
			if(numero<0)
				break;
			
			soma = soma + numero;
		}
		
		System.out.println("Soma dos números positivos: " + soma);
		
		scanner.close();
		

	}

}
