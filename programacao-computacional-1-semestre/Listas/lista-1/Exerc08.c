#include <stdio.h>
/*	
	8. Escreva um algoritmo que faça a leitura 
	de um número referente a um mês e informe a 
	qual trimestre ele pertence. Informe também 
	quantos dias tem esse mês.
*/
int main(void){
	int num;
	
	do{
		printf("Informe um numero referente a um mes: ");
		scanf("%d", &num);
		
		if(num<=0||num>12){
			printf("Valor invalido.\n");
		}
		
	}while(num<=0||num>12);
	
	printf("Esse mes pertence ao ");
	
	switch (num){
		case 1 ... 3:
			printf("1 trimestre.\n");
			break;
		case 4 ... 6:
			printf("2 trimestre.\n");
			break;
		case 7 ... 9:
			printf("3 trimestre.\n");
			break;
		case 10 ... 12:
			printf("4 trimestre.\n");
			break;
	}
	
	printf("E tem ");
	
	switch (num){
		case 2:
			printf("28 dias.\n");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			printf("30 dias.\n");
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			printf("31 dias.\n");
			break;
	}
	
	system("pause");
	return 0;
}
