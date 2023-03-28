package lista01;

public class Questao05 {

	public static void main(String[] args) {
//		5) Verifique se A é maior que 10 ou se A mais B é igual a 20, se verdade
//		imprima: "número válido". Caso as afirmações não sejam verdadeiras,
//		imprima: "número não válido".
		
		int A=9;
		int B=11;
		
		if(A > 10 || A + B == 20)
			System.out.println("número válido");
		else 
			System.out.println("número não válido");

	}

}
