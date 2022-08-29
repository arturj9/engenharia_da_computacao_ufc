#include <stdio.h>
/*	
	7. Escreva um algoritmo que faça a leitura 
	de uma letra e informe se a letra é uma vogal 
	ou uma consoante.
*/
int main(void){
	char letra;
	
	printf("Informe uma letra: ");
	scanf("%c", &letra);
	
	switch (letra){
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			printf("%c e uma vogal.\n", letra);
			break;
		default:
			printf("%c e uma consoante.\n", letra);
			break;
	}
	 
	system("pause");
	return 0;
}
