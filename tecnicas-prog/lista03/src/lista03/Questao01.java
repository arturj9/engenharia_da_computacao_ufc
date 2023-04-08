package lista03;

public class Questao01 {
	
	public static float somatorio(float[] numeros) {
		
		int numerosTam = numeros.length;
		float soma = 0;
		
		for(int i=2;i<numerosTam-2;i++)
			soma += numeros[i];
			
		return soma;
	}

	public static void main(String[] args) {
//		1) Somatório: Sua função deverá receber um vetor como parâmetro e retornar
//		a soma de todos elementos do vetor, sendo que as primeiras duas e as
//		últimas posições do vetor de entrada não devem ser consideradas;
		
		float[] numeros = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(somatorio(numeros));

	}

}
