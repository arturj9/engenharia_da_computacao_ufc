package lista03;

public class Questao05 {
	
	public static int[] copiaVetor(int[] vetor) {
		int[] copiaVetor = new int[vetor.length];
		
		for(int i=0;i<vetor.length;i++)
			copiaVetor[i] = vetor[i];
		
		return copiaVetor;
	}

	public static void main(String[] args) {
//		5) Cópia de vetor: Sua função deverá receber um vetor e retornar uma cópia
//		exata desse vetor.
		
		int[] vetor = {1,2,3,4};
		
		System.out.println(vetor);
		for(int numero : vetor)
			System.out.print(" "+numero);
		
		System.out.println("\n");
		
		int[] copiaVetor = copiaVetor(vetor);
		System.out.println(copiaVetor);
		for(int numero : copiaVetor)
			System.out.print(" "+numero);

	}

}
