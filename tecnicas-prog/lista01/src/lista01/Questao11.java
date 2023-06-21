package lista01;

public class Questao11 {

	public static void main(String[] args) {
//		11)Verifique se A é maior que 10 se não for verifique se A mais B é igual a
//		20, imprima: "A + B == 20''. Caso A não seja maior que 10 e A mais B
//		for diferente de 20, imprima: "número não válido".
		
		int A=9;
		int B=11;
		
		if(!(A > 10)) {
			if(A + B == 20)
				System.out.println("A + B == 20");
			else 
				System.out.println("número não válido");
		}
	}

}
