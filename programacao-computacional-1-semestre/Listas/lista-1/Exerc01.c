#include <stdio.h>
/*	
	1. O custo de um carro novo ao consumidor é a soma 
	do custo de fábrica com a porcentagem do distribuidor 
	e dos impostos (aplicados ao custo de fábrica). 
	Supondo que o percentual do distribuidor seja de 28% 
	e os impostos de 45%, escrever um algoritmo para ler o 
	custo de fábrica de um carro, calcular e escrever o 
	custo final ao consumidor.
*/
int main(void){
	double carroNovo, custoFabrica;
	
	do{
		printf("Informe o custo de fabrica: ");
		scanf("%lf", &custoFabrica);
		
		if(custoFabrica<=0){
			printf("O custo de fabrica deve ser positivo.\n");
		}	
		
	}while(custoFabrica<=0);
	
	carroNovo = custoFabrica*1.73;
	
	/* 	  
		(custoFabrica * 0.28) + (custoFabrica * 0.45) + custoFabrica
	   = custoFabrica * (0.28 + 0.45) + custoFabrica
	   = custoFabrica * (0.73 + 1) =>
	   = custoFabrica * 1,73
	*/
	
	printf("Custo final (carro novo): %.2lf\n", carroNovo);
	
	system("pause");
	return 0;
}
