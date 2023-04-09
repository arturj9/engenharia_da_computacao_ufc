package lista03;

public class Questao07 {
	
	public static boolean verificacaoOrdenacao(int[] vetor) {
		
		if (vetor.length <= 1) {
	        return true;
	    }
		
		
		for(int i=0;i<vetor.length-1;i++) {
			if(vetor[i]>vetor[i+1]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
//		7) Verificação de ordenação: Sua função deverá receber um vetor e verificar
//		se ele está ordenado em ordem crescente. Se sim retornar true.
		
		int[] vetor = {1,2,7,9,5};
		
		System.out.print(verificacaoOrdenacao(vetor));

	}

}
