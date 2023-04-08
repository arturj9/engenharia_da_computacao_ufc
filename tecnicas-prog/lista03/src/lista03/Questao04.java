package lista03;

public class Questao04 {
	
	public static int contagemElementos(int[] vetor1, int[] vetor2, int numero) {
		int quantVezes = 0;
		
		for(int numeroVetor : vetor1) {
			if(numeroVetor==numero)
				quantVezes++;
		}
		
		for(int numeroVetor : vetor2) {
			if(numeroVetor==numero)
				quantVezes++;
		}
		
		return quantVezes;
	}

	public static void main(String[] args) {
//		4) Contagem de elementos: Sua função deverá receber dois vetores e um
//		elemento a ser contado. A função deve retornar a quantidade de vezes que
//		esse elemento aparece nos vetores. Exemplo: [1,3, 3, 2, 5],[1, 2, 3, 2, 4],
//		2 -> 3
		
		int numero = 2;
		int[] vetor1 = {1,3,3,2,5};
		int[] vetor2 = {1,2,3,2,4};
		
		System.out.println(contagemElementos(vetor1,vetor2,numero));

	}

}
