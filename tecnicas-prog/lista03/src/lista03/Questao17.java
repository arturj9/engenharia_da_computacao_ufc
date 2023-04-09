package lista03;

public class Questao17 {
	
	public static String inverterString(String frase) {
		String fraseInvertida = "";
		for(int i=frase.length()-1;i>=0;i--)
			fraseInvertida += frase.charAt(i);
		return fraseInvertida;
	}

	public static void main(String[] args) {
//		17)Inversão de string: Sua função deverá receber uma string e retornar a
//		mesma string invertida. Exemplo: "hello" -> "olleh".
		
		String frase = "hello";
		
		System.out.println(inverterString(frase));

	}

}
