#include <stdio.h>
#include <locale.h>
/*
8. Um matem�tico italiano da idade m�dia conseguiu modelar o ritmo de crescimento
da popula��o de coelhos atrav�s de uma sequ�ncia de n�meros naturais que passou
a ser conhecida como sequ�ncia de Fibonacci. O en�simo n�mero da sequ�ncia de
Fibonacci dado pela seguinte f�rmula de recorr�ncia:
	 _
	|F1 = 1
	|F2 = 1
	|Fi = Fi-1 + Fi-2 para i = 3
	--
Fa�a um programa que para um dado n apresente a sequ�ncia at� Fn.
*/

void fibonacci_fn(int n){
	int f_anterior=1,f_atual=1,fn, cont;
	printf("F%d = %d\nF%d = %d\n", f_anterior, f_anterior, f_atual+1, f_atual);
	for(cont=3;cont<=n;cont++){
			fn = f_anterior + f_atual;
			printf("F%d = %d\n", cont, fn);
			f_anterior = f_atual;
			f_atual = fn;
	}
}

void main(void){
	setlocale(LC_ALL,"Portuguese");
	int n;
	printf("Informe at� qual ordem da sequ�ncia de Fibonacci voc� deseja obter: ");
	scanf("%d", &n);
	fibonacci_fn(n);
	system("pause");
}
