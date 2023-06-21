package lista02;

import java.util.Scanner;

public class Questao06 {

	public static void main(String[] args) {
//		6) Escreva um programa que utilize uma estrutura "if-else" para verificar se
//		uma matriz é simétrica (ou seja, a matriz é igual à sua transposta).
		
		Scanner scanner = new Scanner(System.in);
		
		// Povoar a matriz
		
		System.out.print("Informe a quantidade de linhas: ");
		int linhasTamanho = scanner.nextInt();
		
		System.out.print("Informe a quantidade de colunas: ");
		int colunasTamanho = scanner.nextInt();
		
		int[][] matriz = new int[linhasTamanho][colunasTamanho];
		
		System.out.println("Povoe a matriz");
		
		for(int linha=0;linha<linhasTamanho;linha++) {
			for(int coluna=0;coluna<colunasTamanho;coluna++) {
				System.out.print("Linha "+(linha+1)+", Coluna "+(coluna+1)+": ");
				matriz[linha][coluna] = scanner.nextInt();
			}
		}
		
		// Verificar se a matriz é simétrica
		
		boolean isSimetrica = true;
		
		if(linhasTamanho==colunasTamanho) {
			
			for(int linha=0;linha<linhasTamanho;linha++) {
				
				for(int coluna=0;coluna<colunasTamanho;coluna++) {
					
					if(matriz[linha][coluna] != matriz[coluna][linha]) {
						
						isSimetrica = false;
						break;
						
					}
				}
				
				if(!isSimetrica)
					break;
			}
		} else
			isSimetrica = false;
		
		if(isSimetrica) 
			System.out.println("A matriz é simétrica.");
		else
			System.out.println("A matriz não é simétrica.");
	
				
		scanner.close();		

	}

}
