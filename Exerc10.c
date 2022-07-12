#include <stdio.h>
#include <math.h>
#include <locale.h>
/*
10.Implemente uma fun��o que calcule as ra�zes de uma equa��o do segundo grau do
tipo ax^2 + bx + c = 0. Lembrando que:
x = (-b � sqrt(delta))/2a

Onde

delta = b^2 - 4ac
A vari�vel a tem que ser diferente de 0.
� Se delta < 0 n�o existe real.
� Se delta = 0 existe uma raiz real.
� Se delta > 0 existem duas ra�zes reais.
Essa fun��o deve seguir o seguinte prot�tipo:
int raizes (float A, float B, float C, float * X1, float * X2);
Essa fun��o deve ter como valor de retorno o n�mero de ra�zes reais e distintas da
equa��o. Se existirem ra�zes reais, seus valores devem ser armazenados nas
vari�veis apontadas por X1 e X2.
*/
// Prot�tipo da fun��o para obter as ra�zes
int raizes(float A, float B, float C, float *X1, float *X2);

void main(void){
	setlocale(LC_ALL,"Portuguese");
	float A, B, C, x1, x2;
	int result;
	printf("Informe os coeficientes da equa��o\n");
	printf("A: ");
	scanf("%f", &A);
	printf("B: ");
	scanf("%f", &B);
	printf("C: ");
	scanf("%f", &C);
	result = raizes(A, B, C, &x1, &x2);
	printf("\n");
	if(result==0){
		printf("N�o existe raiz real.");
	}else if(result==1){
		printf("Existe uma raiz real.\n x1 = %f", x1);
	}else if(result==2){
		printf("Existe duas ra�zes reais.\n x1 = %f\n x2 = %f", x1, x2);
	}
}

int raizes(float A, float B, float C, float *X1, float *X2){
	float delta;
	delta = pow(B,2) - 4 * A * C;
	if(delta < 0){
		return 0;
	}else if(delta > 0){
		*X1 = (-B + sqrt(delta))/2 * A;
		*X2 = (-B - sqrt(delta))/2 * A;
		return 2;
	}else if (delta == 0){
		*X1 = (-B + sqrt(delta))/2 * A;
		return 1;
	}
}
