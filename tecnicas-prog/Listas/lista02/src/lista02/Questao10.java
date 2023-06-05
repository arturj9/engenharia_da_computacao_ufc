package lista02;

import java.util.Scanner;

public class Questao10 {

	public static void main(String[] args) {
//		10)Para cada item abaixo imprima as formas apresentadas. Permita que o
//		usuário escolha o número de linhas e colunas desejadas. No exemplo
//		abaixo, para cada matriz foram utilizadas 5 linhas e 5 colunas. Porém,
//		independentemente do número de linhas e colunas, as formas devem
//		ser mantidas. As matrizes sempre serão quadradas.

		Scanner scanner = new Scanner(System.in);
		
		// Povoar a matriz
		
		System.out.print("Informe a quantidade de linhas e colunas: ");
		int tamanho = scanner.nextInt();
		
		
		// a)
		System.out.print("\na)\n\n");
		for(int tamanhoLinha=1;tamanhoLinha<=tamanho;tamanhoLinha++) {
			for(int numero=0;numero<tamanhoLinha;numero++)
				System.out.print(numero+"     ");
			System.out.print("\n\n");
		}
		
		
		// b)
		System.out.print("\nb)\n\n");
		for(int i=0;i<tamanho;i++) {
			for(int j=0;j<tamanho;j++)
				if((i+j)%2==0)
					System.out.print("@     ");
				else 
					System.out.print("*     ");
			
			System.out.print("\n\n");
		}
		
		
		// b)2
		System.out.print("\nb)2\n\n");
		for(int i=0;i<tamanho;i++) {
			int inicio = 0;
			int limite = tamanho-1;
			for(int j=0;j<tamanho;j++) {
				if(i==(tamanho-1)/2 || i==tamanho/2 || j==(tamanho-1)/2 || j==tamanho/2)
					System.out.print("@     ");
				else if(i%2==0)
					System.out.print((limite)+"     ");
				else
					System.out.print((inicio)+"     ");
					
				if(i%2==0)
					limite--;
				else
					inicio++;
			}
			
			System.out.print("\n\n");
		}
		
		
		// c)
		System.out.print("\nc)\n\n");
		int meioIni = 1;
		int meioFim = tamanho-2;
		for(int i=0;i<tamanho;i++) {
			int limite = tamanho-1;
			for(int j=0;j<tamanho;j++)
				if(i==0)
					System.out.print(j+"     ");
				else if(i==tamanho-1)
					System.out.print((limite--)+"     ");
				else if(j==0)
					System.out.print((meioIni++)+"     ");
				else if(j==tamanho-1)
					System.out.print((meioFim--)+"     ");
				else
					System.out.print("*     ");
			
			System.out.print("\n\n");
		}
		
		
		// d)
		System.out.print("\nd)\n\n");
		for(int i=0;i<tamanho;i++) {
			for(int j=0;j<tamanho;j++)
				if(j==(tamanho-1)/2||j==tamanho/2)
					System.out.print("||     ");
				else if(i==(tamanho-1)/2||i==tamanho/2)
					System.out.print("=     ");
				else if(i<tamanho/2 && j<tamanho/2)
					System.out.print("#     ");
				else if(i>tamanho/2 && j<tamanho/2)
					System.out.print("*     ");
				else if(i<tamanho/2 && j>tamanho/2)
					System.out.print("!     ");
				else
					System.out.print("%     ");
			
			System.out.print("\n\n");
		}		

		// e)
		System.out.print("\ne)\n\n");
		int leftPosition = 0;
		int rightPosition = tamanho-1;
		for(int i=0;i<tamanho;i++) {
			for(int j=0;j<tamanho;j++)
				if(tamanho%2!=0&&i==tamanho/2&&j==tamanho/2) {
					System.out.print(tamanho/2+"     ");
					leftPosition++;
					rightPosition--;
				}else if(i==leftPosition&&j==leftPosition)
					System.out.print((leftPosition++)+"     ");
				else if(j==rightPosition&&(tamanho-1)-i==rightPosition)
					System.out.print((rightPosition--)+"     ");
				else
					System.out.print("*     ");
					
			System.out.print("\n\n");
		}
		
		
		scanner.close();

	}

}
