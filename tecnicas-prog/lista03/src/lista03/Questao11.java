package lista03;

public class Questao11 {
	
	public static int potenciacao(int base, int expoente) {
		int resultado = 1;
		
		for(int i=0;i<expoente;i++)
			resultado *= base;
		
		return resultado;
	}

	public static void main(String[] args) {
//		11)Potenciação: Sua função deverá receber dois números, a base e o
//		expoente, e retornar a potência da base elevada ao expoente.
		
		int base = 5;
		int expoente = 3;
		
		System.out.println(potenciacao(base,expoente));

	}

}
