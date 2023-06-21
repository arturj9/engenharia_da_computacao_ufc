package lista01;

public class Questao02 {

	public static void main(String[] args) {
//		2) Verifique se A é menor que 10, se verdade imprima: "A < 10", e verifique
//		se o A mais B é igual a 20, se verdade imprima: "A + B == 20". Caso
//		nenhumas das afirmação não seja verdadeira, imprima: "número não
//		válido", (obs: apenas uma impressão é permitida na saída do programa).
		
		int A=9;
		int B=11;
		
		if(A < 10){
			System.out.print("A < 10;");
			if(A + B == 20)
				System.out.println(" A + B == 20");
		} else
			System.out.println("número não válido");
		

	}

}
