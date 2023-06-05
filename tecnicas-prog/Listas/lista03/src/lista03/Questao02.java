package lista03;

import java.text.DecimalFormat;

public class Questao02 {
	
	public static float media(float[] vetor1, float[] vetor2) {
		
		int tamanhoTotal = vetor1.length + vetor2.length;
		float soma = 0;
		float media = 0;
		
		for(float numero : vetor1)
			soma += numero;
		
		for(float numero : vetor2)
			soma += numero;
		
		media = soma/tamanhoTotal;
		
		return media;
			
	}

	public static void main(String[] args) {
//		2) Média: Sua função deverá receber dois vetores como entrada e retornar a
//		média dos valores presentes nos vetores.
		
		DecimalFormat formato = new DecimalFormat("#.##");
		
		float[] vetor1 = {9,10};
		float[] vetor2 = {10};
		
		System.out.println(formato.format(media(vetor1, vetor2)));

	}

}
