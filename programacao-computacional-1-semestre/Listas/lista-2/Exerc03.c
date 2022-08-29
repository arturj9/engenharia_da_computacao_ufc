#include <stdio.h>
#include <locale.h>
/*
3. Crie um algoritmo para armazenar as quatro notas de uma turma de N alunos,
informado pelo usuário. Como resultado, o algoritmo deve apresentar um relatório
informando:
a. A média de cada aluno;
b. A prova em que o aluno teve MENOR nota;
c. Quais alunos foram aprovados por média. Assuma que a média seja 7,0.
OBS: Utilize uma função para cada item.
*/
typedef struct{
	float nota_questao[4];
}notas;
void media_cada_aluno(notas *pont_alunos_notas, int quant_alunos){
	int i,j;
	float soma, media;
	for(i=0;i<quant_alunos;i++){
		soma=0;
		media=0;
		printf("Aluno %d | ", i+1);
		for(j=0;j<4;j++){
			soma += (*pont_alunos_notas).nota_questao[j];
		}
		media = soma/4.0;
		printf("Média: %.2f\n", media);
		pont_alunos_notas++;
	}
	printf("\n\n");
}
void prova_aluno_menor_nota(notas *pont_alunos_notas, int quant_alunos){
	int i,j;
	float menor_nota;
	int prova_menor_nota;
	for(i=0;i<quant_alunos;i++){
		menor_nota=(*pont_alunos_notas).nota_questao[0];
		prova_menor_nota=1;
		printf("Aluno %d | ", i+1);
		for(j=0;j<4;j++){
			if((*pont_alunos_notas).nota_questao[j]<menor_nota){
				menor_nota = (*pont_alunos_notas).nota_questao[j];
				prova_menor_nota = j+1;
			}
		}
		printf("Prova menor nota: %d\n", prova_menor_nota);
		pont_alunos_notas++;
	}
	printf("\n\n");
}
void alunos_aprovados_media(notas *pont_alunos_notas, int quant_alunos){
	int i,j;
	float soma, media;
	printf("Alunos aprovados por média (7.0)\n");
	for(i=0;i<quant_alunos;i++){
		soma=0;
		media=0;
		for(j=0;j<4;j++){
			soma += (*pont_alunos_notas).nota_questao[j];
		}
		media = soma/4.0;
		if(media>=7){
			printf("Aluno %d\n", i+1);
		}
		pont_alunos_notas++;
	}
	printf("\n\n");
}
void main(void){
	setlocale(LC_ALL,"Portuguese");
	int i,j;
	int quant_alunos;
	char escolha;
	printf("Informe a quantidade de alunos da turma: ");
	scanf("%d", &quant_alunos);
	notas alunos_notas[quant_alunos];
	system("cls");
	for(i=0;i<quant_alunos;i++){
		printf("Informes as notas do Aluno %d\n", i+1);
		for(j=0;j<4;j++){
			printf("Nota %d: ", j+1);
			scanf("%f", &alunos_notas[i].nota_questao[j]);
		}
		system("cls");
	}
	system("cls");
	do{
		printf("Escolha uma opção\n");
		printf("a - Mostrar a média de cada aluno;\n");
		printf("b - Mostrar a prova em que o aluno teve MENOR nota;\n");
		printf("c - Mostrar quais alunos foram aprovados por média. Média: 7,0;\n");
		printf("s - Sair.\n");
		printf("R: ");
		scanf(" %c", &escolha);
		system("cls");
		switch(escolha){
			case 'a':
				media_cada_aluno(&alunos_notas[0], quant_alunos);
				break;
			case 'b':
				prova_aluno_menor_nota(&alunos_notas[0], quant_alunos);
				break;
			case 'c':
				alunos_aprovados_media(&alunos_notas[0], quant_alunos);
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
