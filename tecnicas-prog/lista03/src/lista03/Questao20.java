package lista03;

public class Questao20 {
	
	public static void diminuirVetor(int numero) {
		int[] vetor = new int[numero];
		for(int i=numero-1;i>0;i--)
			vetor = new int[i];
	}

	public static void main(String[] args) {
//		20)Diminuição do vetor: sua função deverá receber um número qualquer que
//		represente e criar um vetor com o tamanho informado. Este vetor deverá ter
//		sucessivas diminuições do seu tamanho em um unidade até que seu
//		tamanho seja igual a 1.
		
		int numero = 6;
		
		diminuirVetor(numero);

	}

}
