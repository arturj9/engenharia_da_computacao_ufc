#include <stdio.h>
#include <locale.h>
#include <math.h>
/*
7. Podemos calcular o seno de um número segundo a série de Taylor-Maclaurin:

sen(x) = x - (x^3)/3! + (x^5)/5! - (x^7)/7! + (x^9)/9! - ...


Faça um programa em C que lê um valor para x e calcule o valor de Sen(x). O valor
deve ser calculado utilizando funções e enquanto o termo (x^n)/n!
calculado for maior que 10^-12
*/
double fatorial(double x){
	double fat=1;
	while(x!=0){
		fat = fat * x--;
	}
	return fat;
}
void seno_taylor_maclaurin(double x){
	double sen_x=0.0;
	double i=0.0;
	while((pow(x,2.0*i+1)/fatorial(2.0*i+1))>(double)pow(10,-12)){
		sen_x = sen_x + pow(-1.0,i)*((pow(x,2.0*i+1)/fatorial(2.0*i+1)));
		i=i+1.0;
	}
	printf("Sen(%d) = %lf\n", (int)x, sen_x);
}
void main(void){
	setlocale(LC_ALL,"Portuguese");
	double x;
	printf("Informe um valor para calcular seu seno: ");
	scanf("%lf", &x);
	seno_taylor_maclaurin(x);
	system("pause");
}
