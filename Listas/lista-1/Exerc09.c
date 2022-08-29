#include <stdio.h>
/*	
	9. Dado um inteiro positivo n e uma 
	sequ�ncia de n inteiros, determinar 
	quantos n�meros da sequ�ncia s�o positivos 
	e quantos s�o n�o-positivos. Um n�mero � 
	n�o-positivo se � negativo ou se � igual a 0 (zero).
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
