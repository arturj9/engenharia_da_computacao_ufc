#include <stdio.h>
#include <locale.h>
/*
2. Elabore um algoritmo C para efetuar a corre��o das provas dos alunos da disciplina
de Programa��o Computacional do curso de Engenharia da Computa��o da UFC.
A prova � composta por 10 quest�es, onde cada uma vale 1,0 ponto. Primeiramente,
o gabarito da prova deve ser lido. Em seguida, devem ser lidas as respostas de cada
aluno. Assuma que a turma possua N alunos, tal que 1 <= N <= 100, calcule e imprima
o n�mero e a nota de cada aluno. (Considere que o gabarito � formado por apenas
caracteres a, b, c ou d).
*/
typedef struct{
	char questoes[10];
}gabarito;
void main(void){
	setlocale(LC_ALL,"Portuguese");
	int i,j,quant_alunos,quant_acertos;
	gabarito gabarito_prova;
	printf("Informe o gabarito da prova (a,b,c ou d)\n");
	for(i=0;i<10;i++){
		printf("Quest�o %d: ", i+1);
		scanf(" %c", &gabarito_prova.questoes[i]);
		if(gabarito_prova.questoes[i]!='a'&&gabarito_prova.questoes[i]!='b'&&gabarito_prova.questoes[i]!='c'&&gabarito_prova.questoes[i]!='d'){
			printf("S� � aceito como resposta a, b, c ou d\n");
			i--;
		}
	}
	system("cls");
	do{
		printf("Informe a quantidade de alunos da turma: ");
		scanf("%d", &quant_alunos);
		if(quant_alunos<1||quant_alunos>100){
			system("cls");
			printf("Informe uma valor >=1 e <=100.\n");
		}
	}while(quant_alunos<1||quant_alunos>100);
	system("cls");
	gabarito gabaritos_alunos[quant_alunos];
	printf("Informe o gabarito dos alunos (a,b,c ou d)\n");
	for(j=0;j<quant_alunos;j++){
		printf("Aluno %d\n", j+1);
		for(i=0;i<10;i++){
			printf("Quest�o %d: ", i+1);
			scanf(" %c", &gabaritos_alunos[j].questoes[i]);
			if(gabaritos_alunos[j].questoes[i]!='a'&&gabaritos_alunos[j].questoes[i]!='b'&&gabaritos_alunos[j].questoes[i]!='c'&&gabaritos_alunos[j].questoes[i]!='d'){
				printf("S� � aceito como resposta a, b, c ou d\n");
				i--;
			}
		}
		system("cls");
	}
	for(j=0;j<quant_alunos;j++){
		quant_acertos=0;
		printf("Aluno %d -", j+1);
		for(i=0;i<10;i++){
			if(gabaritos_alunos[j].questoes[i]==gabarito_prova.questoes[i]){
				quant_acertos++;
			}
		}
		printf(" Nota = %d\n", quant_acertos);
	}
	system("pause");
}
