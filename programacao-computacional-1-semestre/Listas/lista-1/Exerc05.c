#include <stdio.h>
/*	
	5. Ler 3 valores (A, B e C) representando as 
	medidas dos lados de um triângulo e escrever se 
	formam ou não um triângulo. OBS: para formar um 
	triângulo, o valor de cada lado deve ser menor 
	que a soma dos outros 2 lados.
*/
int main(void){
	int A,B,C;
	
	do{
		printf("Informe a medida de 3 lados de um triangulo (A, B e C): \n");
		scanf("%d\n %d\n %d", &A,&B,&C);
		
		if(A<=0||B<=0||C<=0){
			printf("As medidas devem ser positivas.\n");
		}
		
	}while(A<=0||B<=0||C<=0);
	
	printf("A,B e C ");
	if(A<B+C && B<A+C && C<A+B){
		printf("formam um triangulo.\n");
	}else{
		printf("nao formam um triangulo.\n");
	}
	system("pause");
	return 0;
}
