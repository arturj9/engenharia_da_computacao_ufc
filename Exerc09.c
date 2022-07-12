#include <stdio.h>
#include <locale.h>
/*
9. Escreva uma função que receba uma matriz de números inteiros A, de dimensão
m × m, fornecidas pelo usuário, e dois números inteiros i e j, troque os conteúdos
da linha i e da coluna j da matriz A e imprima a matriz resultante. Obs: 0 = <= i,j < m.
*/

void matriz_resultante(int *A, int *pont_i, int *pont_j, int i, int j, int m){
	int linha_aux[m], cont1, cont2, aux=0, coluna_i=0, linha_j=0, valor_comum;
	printf("Matriz original\n");
	for(cont1=0;cont1<m*m;cont1++){
		if(aux%m==0&&aux!=0){
			printf("\n");	
		}
		aux++;
		if(*A<10){
			printf("0%d ", *(A+cont1));
			continue;
		}
		printf("%d ", *(A+cont1));
	}
	printf("\n\n");
	for(cont1=0;cont1<m;cont1++){
		for(cont2=0;cont2<m*m;cont2+=m){
			if(i==cont2/m&&j==cont1&&*(pont_i+cont1)==*(pont_j+cont2)){
				valor_comum = *(pont_i+cont1);	
			}	
		}
	}
	cont1=0;
	for(cont2=0;cont2<m*m;cont2+=m){
		if(*(pont_i+cont1)==valor_comum&&j==cont1){
			cont1++;
			cont2-=m;
			continue;	
		}
		if(*(pont_j+cont2)==valor_comum&&i==cont2/m){
			continue;	
		}
		linha_aux[cont1]=*(pont_i+cont1);
		*(pont_i+cont1)=*(pont_j+cont2);
		*(pont_j+cont2)=linha_aux[cont1];
		cont1++;		
	}
	printf("Matriz resultante da troca da linha %d pela coluna %d\n", i+1,j+1);
	for(cont1=0;cont1<m;cont1++){
		for(cont2=0;cont2<m;cont2++){
			if(*A<10){
				printf("0%d ", *(A++));
				continue;
			}
			printf("%d ", *(A++));
		}
		printf("\n");
	}
}

void main(void){
	int m, i, j, cont1, cont2;
	printf("Informe a quantidade de linhas e colunas da matriz: ");
	scanf("%d", &m);
	int A[m][m];
	printf("\nPreencha a matriz\n");
	for(cont1=0;cont1<m;cont1++){
		for(cont2=0;cont2<m;cont2++){
			printf("Linha %d,Coluna %d: ", cont1+1,cont2+1);
			scanf("%d", &A[cont1][cont2]);
		}
	}
	system("cls");
	for(cont1=0;cont1<m;cont1++){
		for(cont2=0;cont2<m;cont2++){
			if(A[cont1][cont2]<10){
				printf("0%d ", A[cont1][cont2]);
				continue;
			}
			printf("%d ", A[cont1][cont2]);
		}
		printf("\n");
	}
	printf("\nTrocando linha por coluna\n");
	printf("Informe a linha: ");
	scanf("%d", &i);
	printf("Informe a coluna: ");
	scanf("%d", &j);
	system("cls");
	matriz_resultante(&A[0][0], &A[i-1][0], &A[0][j-1], i-1, j-1, m);
}
