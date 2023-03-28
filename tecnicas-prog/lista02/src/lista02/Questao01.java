package lista02;

public class Questao01 {

	public static void main(String[] args) {
//		1) Escreva um programa que imprima todos os números pares de 1 a 100
//		usando um loop for.
		
		for(int numero = 1; numero <= 100; numero++) {
			if(numero % 2 == 0)
				System.out.println(numero);
		}

	}

}
