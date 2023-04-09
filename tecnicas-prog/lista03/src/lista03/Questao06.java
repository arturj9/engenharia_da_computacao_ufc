package lista03;

public class Questao06 {
	
	public static int[] ordenacaoCrescente(int[] vetor) {
		int aux = 0;
		int posicao = 0;
		for(int i=0;i<vetor.length;i++) {
			aux = vetor[i];
			for(int j=i+1;j<vetor.length;j++) {
				if(vetor[j]<aux) {
					aux = vetor[j];
					posicao = j;
				}
			}
			if(aux!=vetor[i]) {
				vetor[posicao] = vetor[i]; 
				vetor[i] = aux;
				
			}
		}
		
		return vetor;
	}

	public static void main(String[] args) {
//		6) Ordenação crescente: Sua função deverá receber um vetor e retornar o
//		vetor ordenado em ordem crescente. Exemplo: [5, 2, 9, 1, 7] -> [1, 2, 5, 7, 9]
		
		int[] vetor = {5,2,9,1,7};
		
		int[] vetorOrdemCrescente = ordenacaoCrescente(vetor);
		
		for(int numero : vetorOrdemCrescente)
			System.out.print(numero+" ");
 	}

}
