package lista03;

import java.text.DecimalFormat;

public class Questao18 {
	
	public static double jurosComposto(int valorInicial, double taxa, int periodo) {
		
		
		double base = 1 + taxa;
		double montante = 1;
		
		for(int i=0;i<periodo;i++)
			montante = montante * base;
		montante *= valorInicial;
		
		return montante;
		
	}

	public static void main(String[] args) {
//		18)Cálculo de juros compostos: Sua função deverá receber um valor inicial,
//		uma taxa de juros e um número de períodos. A função deve retornar o valor
//		final após a aplicação dos juros compostos. Exemplo: 1000, 0.05, 3 ->
//		1157.63
		
		DecimalFormat formato = new DecimalFormat("#.##");
		
		int valorInicial = 1000;
		double taxa = 0.05;
		int periodo = 3;
		
		System.out.println(formato.format(jurosComposto(valorInicial, taxa, periodo)));

	}

}
