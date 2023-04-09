package lista03;

public class Questao14 {
	
	public static int[] removerElementoVetor(int[] vetor, int elemento) {
		int numOcorrencias = 0;
	    for (int num : vetor) {
	        if (num == elemento) {
	            numOcorrencias++;
	        }
	    }
	    int[] novoVetor = new int[vetor.length - numOcorrencias];
	    int i = 0;
	    for (int num : vetor) {
	        if (num != elemento) {
	            novoVetor[i++] = num;
	        }
	    }
	    return novoVetor;
 	}

	public static void main(String[] args) {
//		14)Remoção de elemento do vetor: Sua função deverá receber um vetor e um
//		elemento a ser removido. A função deve remover todas as ocorrências desse
//		elemento no vetor. Um novo vetor, apenas com elementos mantindos, deve
//		ser retornado: Exemplo: [1, 2, 3, 2, 4], 2 -> [1, 3, 4]
		
		int[] vetor = {1,2,3,2,4};
		int elemento = 2;
		
		int[] newVetor = removerElementoVetor(vetor,elemento);
		
		for(int numero : newVetor)
			System.out.print(numero+" ");
 
	}

}
