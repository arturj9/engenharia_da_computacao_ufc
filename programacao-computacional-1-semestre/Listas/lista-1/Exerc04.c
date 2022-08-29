#include <stdio.h>
/*	
	4. Ler o salário fixo e o valor das vendas 
	efetuadas pelo vendedor de uma empresa. 
	Sabendo-se que ele recebe uma comissão de 
	3% sobre o total das vendas até R$ 1.500,00 
	mais 5% sobre o que ultrapassar este valor, 
	calcular e escrever o seu salário total.
*/
int main(void){
	double salarioFixo, vendas, comissao3, comissao5, salarioTotal;
	
	do{
		printf("Informe, de acordo com o vendedor.\n");
	
		printf("Salario fixo: ");
		scanf("%lf", &salarioFixo);
	
		printf("Valor das vendas: ");
		scanf("%lf", &vendas);
		
		if(salarioFixo<0||vendas<0){
			printf("Nenhum dos valores informados podem ser negativos.\n");
		}
		
	}while(salarioFixo<0||vendas<0);
	
	if(vendas<=1500){
		comissao3 = vendas*0.03;
		comissao5 = 0;
	}else{
		comissao3 = 45; /* 1500 * 0.03 */
		comissao5 = (vendas-1500)*0.05;
	}
	
	salarioTotal = salarioFixo+comissao3+comissao5;
	
	printf("Salario total: %.2lf \n", salarioTotal);
	
	system("pause");
	return 0;
}
