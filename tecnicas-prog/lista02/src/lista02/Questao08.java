package lista02;

import java.util.Scanner;

public class Questao08 {

	public static void main(String[] args) {
//		8) Escreva um programa que utilize uma estrutura para determinar se uma
//		expressão matemática contendo parênteses, colchetes e chaves está
//		bem formada (ou seja, se cada símbolo de abertura tem um símbolo de
//		fechamento correspondente).
		
		int parenteseIni=0;
		int parenteseFim=0;
		int colcheteIni=0;
		int colcheteFim=0;
		int chaveIni=0;
		int chaveFim=0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe uma expressão matemática: ");
		String expressaoMat = scanner.nextLine();
		
		for(int cont=0;cont<expressaoMat.length();cont++) {
			if(expressaoMat.charAt(cont)=='(')
				parenteseIni++;
			if(expressaoMat.charAt(cont)==')')
				parenteseFim++;
			
			if(expressaoMat.charAt(cont)=='[')
				colcheteIni++;
			if(expressaoMat.charAt(cont)==']')
				colcheteFim++;
			
			if(expressaoMat.charAt(cont)=='{')
				chaveIni++;
			if(expressaoMat.charAt(cont)=='}')
				chaveFim++;
		}
		
		System.out.print("A expressão matemática "+expressaoMat+" está ");
		
		if(parenteseIni==parenteseFim && colcheteIni==colcheteFim && chaveIni==chaveFim)
			System.out.print("bem formatada");
		else
			System.out.print("mal formatada");
		
		scanner.close();
		
	}
}
