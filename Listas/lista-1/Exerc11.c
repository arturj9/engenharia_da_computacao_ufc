#include <stdio.h>
#include <math.h>
/*	
	11. Dado um numero natural na base binaria, 
	transforma-lo para a base decimal. Exemplo: 
	Dado 10010 a saida sera 18, 
	pois 1.24+0.23+0.22+1.21+0.20=18.
*/
int main(void){
	int numBinario, primeiroBinario, cont, novoBinario, ultimoBit, numDecimal=0;
	
	printf("Informe um numero em binario: ");
	scanf("%d", &numBinario);
	
	primeiroBinario = numBinario;

	for(cont=0;novoBinario!=0;cont++){
		novoBinario = numBinario/10;
		ultimoBit = numBinario - novoBinario * 10;
		numBinario = novoBinario;
		numDecimal = numDecimal + pow(2, cont) * ultimoBit;
	}
	
	printf("%d em decimal: %d\n", primeiroBinario, numDecimal);
	
	system("pause");
	return 0;
}
