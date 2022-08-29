#include <stdio.h>
#include <math.h>
/*	
	10. Dado n, imprimir as n primeiras 
	potências de 2. Exemplo: para n = 5 a 
	saída deve ser 1, 2, 4, 8, 16.
*/
int main(void){
	int n, cont, potencia;
	
	do{
		printf("n: ");
		scanf("%d", &n);
		
		if(n<0){
			printf("n nao deve ser negativo.");
		}
		
	}while(n<0);
	
	printf("--Primeiras %d potencias de 2--\n", n);
	for(cont=0; cont<n; cont++){
		potencia = pow(2, cont);
		printf("%d\n", potencia);
	}
	
	system("pause");
	return 0;
}
