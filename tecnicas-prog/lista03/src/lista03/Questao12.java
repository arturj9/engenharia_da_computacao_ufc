package lista03;

public class Questao12 {
	
	public static boolean primo(int numero) {
		
		if(numero<=0)
			return false;
		
		for(int i=2;i<numero;i++) {
			if(numero%i==0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		12)Primo: Sua função deverá receber um número inteiro e verificar se ele é
//		primo, ou seja, se é divisível apenas por 1 e por ele mesmo.
		
		int numero = 9;
		
		System.out.println(primo(numero));

	}

}
