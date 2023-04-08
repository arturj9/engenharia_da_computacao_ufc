package lista03;

import java.text.DecimalFormat;

public class Questao03 {
	
	public static float mediaPonderada(float[] notas, float[] pesos) {
		
		float somaNotas = 0;
		float somaPesos = 0;
		float mediaPonderada = 0;
		
		for(int i=0;i<notas.length;i++)
			somaNotas += notas[i]*pesos[i];
		
		for(float peso : pesos)
			somaPesos += peso;
		
		mediaPonderada = somaNotas/somaPesos;
		
		return mediaPonderada;
	}

	public static void main(String[] args) {
//		3) Média ponderada: Sua função deverá receber um vetor de notas e um vetor
//		de pesos correspondentes. A função deve retornar a média ponderada das
//		notas. Exemplo: [7, 8, 6], [2, 3, 1] -> 7.33
		
		DecimalFormat formato = new DecimalFormat("#.##");
		
		float[] notas = {7,8,6};
		float[] pesos = {2,3,1};
		
		System.out.println(formato.format(mediaPonderada(notas, pesos)));

	}

}
