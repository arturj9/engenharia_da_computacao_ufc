package lista03;

public class Questao19 {
	
	public static boolean numeroPerfeito(int numero) {
		int somaDivisores = 1;
		for(int i=2;i<numero;i++) {
			if(numero%i==0)
				somaDivisores += i;
		}
		if(somaDivisores==numero)
			return true;
		return false;
	}

	public static void main(String[] args) {
//		19)Verificação de número perfeito: Sua função deverá receber um número
//		inteiro e verificar se ele é um número perfeito, ou seja, se a soma dos seus
//		divisores próprios é igual a ele mesmo. Exemplo: 6 -> True
		
		int numero = 6;
		
		System.out.println(numeroPerfeito(numero));

	}

}
