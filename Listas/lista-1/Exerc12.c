#include <stdio.h>
/*	
	12. Escreva um algoritmo que imprima 
	a tabuada (multiplicação) (de 1 a 10) para os números de 1 a 10.
*/
int main(void){
	
	int multiplicador, multiplicando;
	
	for(multiplicador=1; multiplicador<=10; multiplicador++){
		
		printf("\n--TABUADA DO %d--\n", multiplicador);
		
		for(multiplicando=1; multiplicando<=10; multiplicando++){
			
			printf("%d x %d = %d\n", multiplicador, multiplicando, multiplicador*multiplicando);
		}
	}
	
	system("pause");
	return 0;
}
