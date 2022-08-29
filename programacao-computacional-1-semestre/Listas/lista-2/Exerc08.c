#include <stdio.h>
#include <locale.h>
/*
8. Um matemático italiano da idade média conseguiu modelar o ritmo de crescimento
da população de coelhos através de uma sequência de números naturais que passou
a ser conhecida como sequência de Fibonacci. O enésimo número da sequência de
Fibonacci dado pela seguinte fórmula de recorrência:
	 _
	|F1 = 1
	|F2 = 1
	|Fi = Fi-1 + Fi-2 para i = 3
	--
Faça um programa que para um dado n apresente a sequência até Fn.
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
	printf("Informe até qual ordem da sequência de Fibonacci você deseja obter: ");
	scanf("%d", &n);
	fibonacci_fn(n);
	system("pause");
}
