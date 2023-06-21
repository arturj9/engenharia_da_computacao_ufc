package lista01;

public class Questao12 {

	public static void main(String[] args) {
//		12) Verifique se A é maior que 10 imprima: "A > 10" ou verifique se A mais
//		B é igual a 20, imprima: "A + B == 20'', caso as afirmações não sejam
//		verdadeiras, imprima: "números não válidos". Sejam as afirmações
//		anteriores falsas ou verdadeiras imprima: “Sejam bem-vindos à
//		disciplina de Técnicas de Programação”.
		
		int A=10;
		int B=11;
		
		if(A > 10)
			System.out.println("A > 10");
		else if(A + B == 20)
			System.out.println("A + B == 20");
		else 
			System.out.println("números não válidos");
		
		System.out.println("Sejam bem-vindos à disciplina de Técnicas de Programação");

	}

}
