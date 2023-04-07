package lista02;

public class Questao09 {
	
	public static void main(String[] args) {
//		9) Faça um programa para gerar todas as permutações de um conjunto de
//		caracteres (por exemplo, "ABC" pode gerar "ABC", "ACB", "BAC",
//		"BCA", "CAB" e "CBA").
		
		String conjunto = "ABCDE";
		String conjuntoIni = conjunto;
		int conjuntoTam = conjunto.length();
		
		int quantPermutacoes=1;
		
		for(int i=conjuntoTam;i>0;i--) {
			quantPermutacoes *= i;
		}
		
		char[] caracs = new char[conjuntoTam];
		
		for(int i=0;i<conjuntoTam;i++)
			caracs[i] = conjunto.charAt(i);
		
		String[] permutacoes = new String[quantPermutacoes];
		
		int position = 0;
		
		for(int h=0;h<conjuntoTam;h++) {
		
			for(int i=0;i<conjuntoTam;i++) {
				char aux;
				for(int j=i+1;j<conjuntoTam;j++) {
					aux = caracs[i];
					caracs[i]=caracs[j];
					caracs[j]=aux;
					permutacoes[position++] = new String(caracs);
					caracs[j] = caracs[i];
					caracs[i] = aux;
				}
			}
			
			if(h==conjuntoTam-1 || position == quantPermutacoes)
				break;
			
			if(h==conjuntoTam-2) {
				int cont = 0;
				
				for(int i=conjuntoTam-1;i>=0;i--)
					caracs[cont++] = conjuntoIni.charAt(i);
			}else {
				conjunto = conjunto.charAt(h+1) + conjunto.substring(0,h+1) + conjunto.substring(h+2); 
				for(int i=0;i<conjuntoTam;i++)
					caracs[i] = conjunto.charAt(i);
			}
		
		}
		
		
		for(String permutacao : permutacoes)
			System.out.println(permutacao);
		

	}

}
