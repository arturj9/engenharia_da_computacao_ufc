package lista01;

public class Questao04 {

	public static void main(String[] args) {
//		4) Verifique se A é maior que 10 ou se A mais B é igual a 20, se verdade
//		imprima: "número válido". Caso as afirmações não sejam verdadeiras,
//		Verificar se A é igual B, caso verdade imprima: (A é igual B; A e B são
//		diferentes de 10; A é menor que 10) caso não seja verdade imprima:
//		"número não válido".
		
		int A=9;
		int B=9;
		
		if(A > 10 || A + B == 20)
			System.out.println("número válido");
		else if(A == B)
			System.out.println("A é igual B; A e B são diferentes de 10; A é menor que 10");
		else 
			System.out.println("número não válido");
	}

}
