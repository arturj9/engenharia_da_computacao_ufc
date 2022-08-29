#include <stdio.h>
#include <locale.h>
/*
4. Dadas N datas dd/mm/aaaa, com 1 <= N <= 100, e uma data de referência d, verifique
qual das N datas é mais próxima à data d.
*/
typedef struct{
	int dd;
	int mm;
	int aaaa;
}data;
void main(void){
	setlocale(LC_ALL,"Portuguese");
	int quant_datas;
	int i;
	int mod_dif_dia, mod_dif_mes, mod_dif_ano;
	data data_ref;
	do{
		printf("Informe a quantidade de datas: ");
		scanf("%d", &quant_datas);
		if(quant_datas<1||quant_datas>100){
			system("cls");
			printf("Informe uma valor >=1 e <=100.\n");
		}
	}while(quant_datas<1||quant_datas>100);
	system("cls");
	data datas[quant_datas];
	for(i=0;i<quant_datas;i++){
		printf("Informe a data %d\n", i+1);
		printf("Dia: ");
		scanf("%d", &datas[i].dd);
		printf("Mês: ");
		scanf("%d", &datas[i].mm);
		printf("Ano: ");
		scanf("%d", &datas[i].aaaa);
		system("cls");
	}
	printf("Informe a data de referência\n");
	printf("Dia: ");
	scanf("%d", &data_ref.dd);
	printf("Mês: ");
	scanf("%d", &data_ref.mm);
	printf("Ano: ");
	scanf("%d", &data_ref.aaaa);
	system("cls");
	mod_dif_ano = abs(data_ref.aaaa-datas[0].aaaa);
	mod_dif_mes = abs(data_ref.mm-datas[0].mm);
	mod_dif_dia = abs(data_ref.dd-datas[0].dd);
	data data_mais_prox;
	data_mais_prox.aaaa = datas[0].aaaa;
	data_mais_prox.mm = datas[0].mm;
	data_mais_prox.dd = datas[0].dd;
	for(i=0;i<quant_datas;i++){
		if(abs(data_ref.aaaa-datas[i].aaaa)<mod_dif_ano){
			data_mais_prox.aaaa = datas[i].aaaa;
			data_mais_prox.mm = datas[i].mm;
			data_mais_prox.dd = datas[i].dd;
			mod_dif_ano = abs(data_ref.aaaa-datas[i].aaaa);
			continue;
		}else if(abs(data_ref.aaaa-datas[i].aaaa)==mod_dif_ano){
			if(abs(data_ref.mm-datas[i].mm)<mod_dif_mes){
				data_mais_prox.mm = datas[i].mm;
				data_mais_prox.dd = datas[i].dd;
				mod_dif_mes = abs(data_ref.mm-datas[i].mm);
				continue;
			}else if(abs(data_ref.mm-datas[i].mm)==mod_dif_mes){
				if(abs(data_ref.dd-datas[i].dd)<mod_dif_dia){
					data_mais_prox.dd = datas[i].dd;
					mod_dif_dia = abs(data_ref.dd-datas[i].dd);	
					continue;
				}
			}
		}
	}
	printf("Data mais próxima de %d/%d/%d: %d/%d/%d\n", data_ref.dd,data_ref.mm,data_ref.aaaa,data_mais_prox.dd,data_mais_prox.mm,data_mais_prox.aaaa);
	system("pause");
}
