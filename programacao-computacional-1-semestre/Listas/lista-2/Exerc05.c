#include <stdio.h>
#include <locale.h>
/*
5. Dados um inteiro positivo n, uma sequência de n nomes, telefones e datas de
aniversário, e uma data no formato dd/mm, imprima os nomes e telefones das
pessoas que aniversariam nesta data.
*/
typedef struct{
	int dd;
	int mm;
	int aaaa;
}Data;
typedef struct{
	char nome[100];
	int telefone;
	Data aniversario;
}Pessoa;
void main(void){
	setlocale(LC_ALL,"Portuguese");
	int quant_pessoas;
	int i;
	do{
		printf("Informe a quantidade de pessoas: ");
		scanf("%d", &quant_pessoas);
		if(quant_pessoas<1){
			printf("Informe um valor positivo.\n");
			system("cls");
		}
	}while(quant_pessoas<1);
	system("cls");
	Pessoa pessoas[quant_pessoas];
	for(i=0;i<quant_pessoas;i++){
		printf("Pessoa %d\n", i+1);
		printf("Nome: ");
		scanf(" %[^\n]s", &pessoas[i].nome);
		printf("Telefone (apenas números): ");
		scanf("%d", &pessoas[i].telefone);
		printf("Data de aniversário\n");
		printf("Dia: ");
		scanf("%d", &pessoas[i].aniversario.dd);
		printf("Mês: ");
		scanf("%d", &pessoas[i].aniversario.mm);
		printf("Ano: ");
		scanf("%d", &pessoas[i].aniversario.aaaa);
		system("cls");
	}
	Data data_ref;
	printf("Informe outra data, formato dd/mm\n");
	printf("Dia: ");
	scanf("%d", &data_ref.dd);
	printf("Mês: ");
	scanf("%d", &data_ref.mm);
	system("cls");
	printf("Pessoas que fazem aniversário em %d/%d\n",data_ref.dd,data_ref.mm);
	for(i=0;i<quant_pessoas;i++){
		if(pessoas[i].aniversario.dd==data_ref.dd&&pessoas[i].aniversario.mm==data_ref.mm){
			printf("Nome: %s | Telefone: %d\n",pessoas[i].nome,pessoas[i].telefone);
		}
	}
	system("pause");
}
