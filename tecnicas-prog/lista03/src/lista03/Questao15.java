package lista03;

public class Questao15 {
	
	public static boolean verificacaoPalindromo(String frase) {
		
		frase = frase.replaceAll(" ", "");
		
	    int j = frase.length() - 1;
	    
	    for (int i = 0; i < j; i++, j--) {
	        if (frase.charAt(i) != frase.charAt(j))
	            return false;
	    }
	    
	    return true;
	}

	public static void main(String[] args) {
//		15)Verificação de palíndromo: Sua função deverá receber uma string e
//		verificar se ela é um palíndromo, ou seja, se pode ser lida da mesma forma
//		de trás para frente. Exemplo: "ana" -> True.
		
		String frase = "ana";
		
		System.out.println(verificacaoPalindromo(frase));

	}
	
}
