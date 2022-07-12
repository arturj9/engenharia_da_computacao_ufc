#include <stdio.h>
#include <locale.h>
/*
1. Elabore um único código em C para ler uma matriz de números inteiros e que possua
uma função para cada item abaixo:
a. Mostrar cada elemento da matriz;
b. Calcular e mostrar a soma dos elementos da matriz;
c. Calcular e mostrar o maior elemento da matriz;
d. Calcular e mostrar o menor elemento da matriz;
e. Calcular e mostrar o maior e o menor elemento da matriz;
f. Exibir cada elemento cujo valor seja maior que 50;
g. Exibir cada elemento cujo valor seja par;
h. Calcular e exibir a quantidade de elementos pares da matriz.
*/
void mostrar_elementos(int *pont_a, int m, int n){
	int i, j;
	printf("Matriz\n");
	for(i=0;i<m;i++){
		for(j=0;j<n;j++){
			printf("%d ", *(pont_a++));
		}
		printf("\n");
	}
	printf("\n\n");
}
void soma_elementos(int *pont_a, int quant_elementos){
	int soma=0;
	int i;
	for(i=0;i<quant_elementos;i++){
		soma += *(pont_a++);
	}
	printf("Soma dos elementos da matriz: %d\n", soma);
	printf("\n\n");
}
void maior_elemento(int *pont_a, int quant_elementos){
	int i;
	int maior=*pont_a;
	for(i=0;i<quant_elementos;i++){
		if(*pont_a>maior){
			maior = *pont_a;
		}
		pont_a++;
	}
	printf("Maior elemento da matriz: %d\n", maior);
	printf("\n\n");
}
void menor_elemento(int *pont_a, int quant_elementos){
	int i;
	int menor=*pont_a;
	for(i=0;i<quant_elementos;i++){
		if(*pont_a<menor){
			menor = *pont_a;
		}
		pont_a++;
	}
	printf("Menor elemento da matriz: %d\n", menor);
	printf("\n\n");
}
void maior_e_menor_elemento(int *pont_a, int quant_elementos){
	int i;
	int maior=*pont_a;
	int menor=*pont_a;
	for(i=0;i<quant_elementos;i++){
		if(*pont_a>maior){
			maior = *pont_a;
		}
		if(*pont_a<menor){
			menor = *pont_a;
		}
		pont_a++;
	}
	printf("Maior elemento %d | Menor elemento: %d\n", maior,menor);
	printf("\n\n");
}
void elementos_maior_50(int *pont_a, int quant_elementos){
	int i;
	printf("Elementos cujo valores são maiores que 50\n");
	for(i=0;i<quant_elementos;i++){
		if(*pont_a>50){
			printf("%d\n", *pont_a);
		}
		pont_a++;
	}
	printf("\n\n");
}
void elementos_pares(int *pont_a, int quant_elementos){
	int i;
	printf("Elementos cujo valores são pares\n");
	for(i=0;i<quant_elementos;i++){
		if(*pont_a%2==0){
			printf("%d\n", *pont_a);
		}
		pont_a++;
	}
	printf("\n\n");
}
void quant_elementos_pares(int *pont_a, int quant_elementos){
	int i;
	int quant_elementos_pares=0;
	printf("Quantidade de elementos pares da matriz: ");
	for(i=0;i<quant_elementos;i++){
		if(*pont_a%2==0){
			quant_elementos_pares++;
		}
		pont_a++;
	}
	printf("%d\n", quant_elementos_pares);
	printf("\n\n");
}
void main(void){
	setlocale(LC_ALL,"Portuguese");
	int m,n;
	int i;
	char escolha;
	printf("Informe a quantidade de linhas da matriz: ");
	scanf("%d", &m);
	printf("Informe a quantidade de colunas da matriz: ");
	scanf("%d", &n);
	printf("\n\n");
	int A[m][n];
	printf("Informe os elementos da matriz\n");
	for(i=0;i<m*n;i++){
		scanf("%d", (&A[0][0])+i);
	}
	printf("\n\n");
	do{
		printf("Escolha uma opção\n");
		printf("a - Mostrar cada elemento da matriz;\n");
		printf("b - Calcular e mostrar a soma dos elementos da matriz;\n");
		printf("c - Calcular e mostrar o maior elemento da matriz;\n");
		printf("d - Calcular e mostrar o menor elemento da matriz;\n");
		printf("e - Calcular e mostrar o maior e o menor elemento da matriz;\n");
		printf("f - Exibir cada elemento cujo valor seja maior que 50;\n");
		printf("g - Exibir cada elemento cujo valor seja par;\n");
		printf("h - Calcular e exibir a quantidade de elementos pares da matriz;\n");
		printf("s - Sair.\n");
		printf("R: ");
		scanf(" %c", &escolha);
		system("cls");
		switch(escolha){
			case 'a':
				mostrar_elementos(&A[0][0],m,n);
				break;
			case 'b':
				soma_elementos(&A[0][0], m*n);
				break;
			case 'c':
				maior_elemento(&A[0][0], m*n);
				break;
			case 'd':
				menor_elemento(&A[0][0], m*n);
				break;
			case 'e':
				maior_e_menor_elemento(&A[0][0], m*n);
				break;
			case 'f':
				elementos_maior_50(&A[0][0], m*n);
				break;
			case 'g':
				elementos_pares(&A[0][0], m*n);
				break;
			case 'h':
				quant_elementos_pares(&A[0][0], m*n);
				break;
			case 's':
				printf("Saindo...\n");
				break;
			default:
				printf("Digite uma opção válida.\n");
				break;
		}
	}while(escolha!='s');
	system("pause");
}
