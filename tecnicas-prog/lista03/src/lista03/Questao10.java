package lista03;

public class Questao10 {
	
	public static boolean verificacaoIgualdade(int[] vetor1, int[] vetor2) {
		
		if(vetor1.length!=vetor2.length)
			return false;
		
		for(int i=0;i<vetor1.length;i++) {
			if(vetor1[i]!=vetor2[i])
				return false;	
		}
		
		return true;
		
	}

	public static void main(String[] args) {
//		10) Verificação de igualdade: Sua função deverá receber dois vetores e verificar
//		se eles são iguais, ou seja, se possuem os mesmos elementos na mesma
//		ordem.
		
		int[] vetor1 = {1,3,3,2};
		int[] vetor2 = {1,3,3,2};
		
		System.out.println(verificacaoIgualdade(vetor1,vetor2));

	}

}
