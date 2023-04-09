package lista03;

public class Questao08 {
	
	public static int[] copiaVetor(int[] vetor) {
		int[] copiaVetor = new int[vetor.length];
		
		for(int i=0;i<vetor.length;i++)
			copiaVetor[i] = vetor[i];
		
		return copiaVetor;
	}
	
	public static int kEsicoMaiorValor(int[] vetor, int K) {
		
		
		int[] copiaVetor = new int[vetor.length];
		
		for(int i=0;i<vetor.length;i++)
			copiaVetor[i] = vetor[i];
		
		int aux = 0;
		int posicao = 0;
		for(int i=0;i<copiaVetor.length;i++) {
			aux = copiaVetor[i];
			for(int j=i+1;j<copiaVetor.length;j++) {
				if(copiaVetor[j]>aux) {
					aux = copiaVetor[j];
					posicao = j;
				}
			}
			if(aux!=copiaVetor[i]) {
				copiaVetor[posicao] = copiaVetor[i]; 
				copiaVetor[i] = aux;
				
			}
		}
		
		return copiaVetor[K-1];
	}

	public static void main(String[] args) {
//		8) K-ésimo maior valor: Sua função deverá receber um vetor e um K e retornar
//		o K-ésimo maior valor presente no vetor.
		
		int[] vetor = {5,2,9,1,7};
		int K = 1;
		
		System.out.println(kEsicoMaiorValor(vetor,K));
		

	}

}
