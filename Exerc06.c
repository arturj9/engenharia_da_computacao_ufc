#include <stdio.h>
#include <locale.h>
#include <math.h>
/*
6. (a) Escreva uma função encaixa que, recebendo dois números inteiros a e b como
parâmetros, verifica se b corresponde aos últimos dígitos de a.
Exemplo:

a 		b
567890 890 -> encaixa
1243 1243 -> encaixa
2457 245 -> não encaixa
457 2457 -> não encaixa

(b) Usando o mesmo código do item anterior, faça uma função que lê dois números
a e b e verifica se o menor deles é segmento do outro.
Exemplo:

a 		b
567890 678 -> b é segmento de a
1243 2212435 -> a é segmento de b
2457 236 -> um não é segmento do outro
*/
void encaixa(int a,int b){
	int cpy_b = b, cpy_a = a, tam_b=0, tam_a=0, i;
	int maior_alg;
	while(cpy_a!=0){
		cpy_a = cpy_a/10;
		tam_a++;
	}
	while(cpy_b!=0){
		cpy_b = cpy_b/10;
		tam_b++;
	}
	if(a<b){
		printf("%d não corresponde aos últimos dígitos de %d.\n", b,a);
	}else if(tam_a==tam_b){
		if(a==b){
			printf("%d corresponde aos últimos dígitos de %d.\n", b,a);
		}else{
			printf("%d não corresponde aos últimos dígitos de %d.\n", b,a);
		}
	}else{
		cpy_b = b;
		cpy_a = a;
		while(tam_a!=tam_b){
			maior_alg = cpy_a/(pow(10,--tam_a));
			cpy_a = cpy_a - (maior_alg*pow(10,tam_a));
		}
		if(cpy_a==b){
			printf("%d corresponde aos últimos dígitos de %d.\n", b,a);	
		}else{
			printf("%d não corresponde aos últimos dígitos de %d.\n", b,a);
		}
	}
	printf("\n\n");
}
void menor_segmento_outro(int a,int b){
	int cpy_b = b, cpy_a = a, tam_b=0, tam_a=0, i, j, aux=0, inicial=-1;
	int maior_alg;
	while(cpy_a!=0){
		cpy_a = cpy_a/10;
		tam_a++;
	}
	while(cpy_b!=0){
		cpy_b = cpy_b/10;
		tam_b++;
	}
	int vet_a[tam_a], vet_b[tam_b];
	cpy_b = b;
	cpy_a = a;
	for(i=0;i<tam_a;i++){
		vet_a[aux++]=cpy_a/(pow(10,i));
	}
	aux=0;
	for(i=0;i<tam_b;i++){
		vet_b[aux++]=cpy_b/(pow(10,i));
	}
	aux=0;
	if(a<b){
		
	}else if(b<a){
	
	}else{
		if(a==b){
			printf("%d é segmento de %d.\n", a,b);
		}else{
			printf("Um não é segmento do outro.\n");
		}
	}
	printf("\n\n");
}
void main(void){
	setlocale(LC_ALL,"Portuguese");
	int a, b;
	char escolha;
	printf("Informe os números para a e b\n");
	printf("a: ");
	scanf("%d", &a);
	printf("b: ");
	scanf("%d", &b);
	system("cls");
	do{
		printf("Digite uma opção\n");
		printf("a - Verificar se b corresponde aos últimos dígitos de a;\n");
		printf("b - Verificar se o menor dentre os números é segmento do outro.\n");
		printf("s - Sair\n");
		printf("R: ");
		scanf(" %c", &escolha);
		system("cls");
		switch(escolha){
			case 'a':
				encaixa(a,b);
				break;
			case 'b':
				menor_segmento_outro(a,b);
				break;
			case 's':
				printf("Saindo...\n");
				break;
			default:
				printf("Informe uma opção válida.\n");
				break;
		}
	}while(escolha!='s');
	system("pause");
}
