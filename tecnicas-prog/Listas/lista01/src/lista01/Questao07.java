package lista01;

public class Questao07 {

	public static void main(String[] args) {
//		7) Verifique se A é maior que 10 ou se o A mais B é igual a 20, caso sejam
//		verdadeiras as afirmações imprima: "números válidos”. Caso a primeira
//		afirmação não seja verdadeira, imprima: "número não válido".
		
		int A=9;
		int B=11;
		
		if(A > 10 || A + B == 20)
			System.out.println("números válidos");
		if(!(A > 10))
			System.out.println("número não válido");

	}

}
