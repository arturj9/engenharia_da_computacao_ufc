package questao02;

public class Main {

	public static void main(String[] args) {
		
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
