#include <stdio.h>
/*	
	6. Escreva um algoritmo para ler 2 valores 
	e se o segundo valor informado for ZERO, deve 
	ser lido um novo valor, ou seja, para o segundo 
	valor n�o pode ser aceito o valor zero e imprimir 
	o resultado da divis�o do primeiro valor lido 
	pelo segundo valor lido. Deve ser informado 
	�VALOR INV�LIDO. INFORME OUTRO N�MERO.� enquanto 
	o usu�rio fornecer o valor 0.
*/
int main(void){
	double dividendo, divisor, quociente;
	
	printf("Dividendo: ");
	scanf("%lf", &dividendo);
	
	do{
		printf("Divisor: ");
		scanf("%lf", &divisor);
		
		if(divisor==0){
			printf("VALOR INVALIDO. INFORME OUTRO NUMERO.\n");
		}
	}while(divisor==0);
	
	quociente = dividendo/divisor;
	
	printf("%.2lf / %.2lf = %.2lf\n", dividendo, divisor, quociente);
	
	system("pause");
	return 0;
}
