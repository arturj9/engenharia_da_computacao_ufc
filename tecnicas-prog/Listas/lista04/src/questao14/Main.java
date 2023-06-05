package questao14;

public class Main {

	public static void main(String[] args) {
		Pessoa einstein = new Pessoa("Albert Einstein",14,3,1879);
		Pessoa newton = new Pessoa("Isaac Newton",4,1,1643);
		
		einstein.calculaIdade(4, 4, 2023);
		newton.calculaIdade(4, 4, 2023);
		
		System.out.println(einstein.informaNome()+" | "+einstein.informaIdade());
		System.out.println(newton.informaNome()+" | "+newton.informaIdade());
	}

}
