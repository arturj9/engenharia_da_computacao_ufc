#include <stdio.h>
/*	
	2. Uma revendedora de carros usados paga 
	a seus funcion�rios vendedores um sal�rio 
	fixo por m�s, mais uma comiss�o tamb�m fixa 
	para cada carro vendido e mais 5% do valor 
	das vendas por ele efetuadas. Escrever um 
	algoritmo que leia o n�mero de carros por ele 
	vendidos, o valor total de suas vendas, o 
	sal�rio fixo e o valor que ele recebe por carro 
	vendido. Calcule e escreva o sal�rio final do vendedor.
*/
int main(void){
	int quantCarros;
	float valorVendas, salarioFixo, comissaoFixa, salarioFinal;
	
	do{
		printf("Informe, de acordo com o funcionario \n");
		printf("Quantidade de carros vendidos: ");
		scanf("%d", &quantCarros);
		printf("Valor total de vendas: ");
		scanf("%f", &valorVendas);
		printf("Salario fixo: ");
		scanf("%f", &salarioFixo);
		printf("Valor por carro vendido: ");
		scanf("%f", &comissaoFixa);
		
		if(quantCarros<0||valorVendas<0||salarioFixo<0||comissaoFixa<0){
			printf("Nenhum dos valores informados podem ser negativos.\n");
		}
	}while(quantCarros<0||valorVendas<0||salarioFixo<0||comissaoFixa<0);
	
	salarioFinal = quantCarros*comissaoFixa+valorVendas*0.05+salarioFixo;
	
	printf("Salario final: %.2f\n", salarioFinal);
	
	system("pause");
	return 0;
}
