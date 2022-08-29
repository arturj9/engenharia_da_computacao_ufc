#include <stdio.h>
/*	
	9. Dado um inteiro positivo n e uma 
	sequência de n inteiros, determinar 
	quantos números da sequência são positivos 
	e quantos são não-positivos. Um número é 
	não-positivo se é negativo ou se é igual a 0 (zero).
*/
int main(void){
	int cont, n, numPositivos=0, numNaoPositivos=0;
	double num;
	
	do{
		
		printf("Informe o tamanho da sequencia: ");
		scanf("%d", &n);
		
		if(n<=0){
			printf("O tamanho deve ser um inteiro positivo.\n");	
		}
		
	}while(n<=0);
	
	puts("Informe os numeros da sequencia:");
	
	for(cont=0; cont<n; cont++){
		scanf("%lf", &num);
		if(num>0){
			numPositivos++;
		}else{
			numNaoPositivos++;
		}
	}
	
	printf("Quantidade de numeros \nPositivos: %d \nNao-Positivos: %d\n", numPositivos, numNaoPositivos);
	
	system("pause");
	return 0;
}
