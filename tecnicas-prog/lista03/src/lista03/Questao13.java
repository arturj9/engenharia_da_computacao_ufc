package lista03;

public class Questao13 {
	
	public static int[] buscaOcorrencias(int[] vetor1, int[] vetor2) {
		int[] vetorOcorrencias = new int[0];
		
		for(int numeroVetor1 : vetor1) {
			for(int numeroVetor2 : vetor2) {
				if(numeroVetor1 == numeroVetor2) {
					int[] vetorCopia = vetorOcorrencias;
 					vetorOcorrencias = new int[vetorOcorrencias.length+1];
					if(vetorOcorrencias.length==1) {
						vetorOcorrencias[0] = numeroVetor1;
					}else {
						vetorOcorrencias[vetorOcorrencias.length-1] = numeroVetor1;
						for(int i=0;i<vetorOcorrencias.length-1;i++) {
							vetorOcorrencias[i] = vetorCopia[i];
						}
					}
				}
			}
		}
		
		return vetorOcorrencias;
	}

	public static void main(String[] args) {
//		13) Busca por ocorrências: Sua função deverá receber dois vetores e deverá
//		retornar um novo vetor com todos os elementos que aparecem em ambos os
//		vetores.
		
		int[] vetor1 = {1,2,3,5,6,7,12};
		int[] vetor2 = {1,2,3,12};
		
		int[] vetorOcorrencias = buscaOcorrencias(vetor1,vetor2);
		
		for(int numero : vetorOcorrencias)
			System.out.print(numero+" ");

	}

}
