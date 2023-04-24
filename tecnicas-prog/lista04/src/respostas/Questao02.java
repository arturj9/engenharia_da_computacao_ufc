package respostas;

import classes.Empregado;

public class Questao02 {

	public static void main(String[] args) {
//		Crie duas instâncias da classe e exiba o salário anual de cada
//		instância. Então dê a cada empregado um aumento de 10% e exiba novamente o
//		salário anual de cada empregado.
		
		Empregado empregado1 = new Empregado("Artur", "Gomes", 10000);
		Empregado empregado2 = new Empregado("Mateus", "Sousa", 12550.5);
		
		System.out.println(empregado1.getSalarioAnual());
		System.out.println(empregado2.getSalarioAnual());
		
		empregado1.setSalarioMensalEmPorcentagem(10);
		empregado2.setSalarioMensalEmPorcentagem(10);
		
		System.out.println(empregado1.getSalarioAnual());
		System.out.println(empregado2.getSalarioAnual());

	}

}
