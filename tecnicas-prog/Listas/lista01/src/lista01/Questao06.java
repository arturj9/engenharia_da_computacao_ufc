package lista01;

public class Questao06 {

	public static void main(String[] args) {
//		6) Verifique se A é maior que 10, se verdade imprima: "A > 10" caso não
//		seja, imprima: "A <= 10". Verifique se A mais B é igual a 20, se
//		verdadeiro, imprima: "A + B == 20”, caso não seja imprima: “A + B !=
//		20”.

		int A=11;
		int B=9;
		
		if(A > 10)
			System.out.println("A > 10");
		else 
			System.out.println("A <= 10");
		
		if(A + B == 20)
			System.out.println("A + B == 20");
		else 
			System.out.println("A + B != 20");
	}

}
