package lista03;

public class Questao16 {
	
	public static boolean verificacaoPrimo(int numero) {
		
		if(numero<=0)
			return false;
		
		for(int i=2;i<numero;i++) {
			if(numero%i==0)
				return false;
		}
		return true;
	}
	
	

	public static void main(String[] args) {
//		16)Verificação de número primo: Sua função deverá receber um número
//		inteiro e verificar se ele é um número primo. Exemplo: 7 -> True.
		
		int numero = 9;
		
		System.out.println(verificacaoPrimo(numero));

	}

}
