package lista01;

public class Questao13 {

	public static void main(String[] args) {
//		13) Verifique se A é maior que 10, se verdade imprima: "A > 10". Ainda,
//		verifique se o A mais B é igual a 20, se verdade imprima: "A + B == 20”.
//		Caso as afirmações não sejam verdadeiras, imprima: "números não
//		válidos".
		
		int A=9;
		int B=10;
		
		if(A > 10)
			System.out.println("A > 10");
		
		if(A + B == 20)
			System.out.println("A + B == 20");
		
		if(!(A > 10) && !(A + B == 20))
			System.out.println("números não válidos");
		
	}

}
