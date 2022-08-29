#include <stdio.h>
/*	
	3. Ler a hora de início e a hora de fim 
	de um jogo de Xadrez (considere apenas horas 
	inteiras, sem os minutos) e calcule a duração 
	do jogo em horas, sabendo-se que o tempo máximo 
	de duração do jogo é de 24 horas e que o jogo 
	pode iniciar em um dia e terminar no dia seguinte.
*/
int main(void){
	
	int horaInicio, horaFim, duracao;
	
	do{
		printf("Informe a hora de inicio e a hora de fim no formato 24h\n");
		printf("obs.: A duracao maxima e de 24 horas e deve ser apenas hora, sem minutos. \n");
		printf("Hora de inicio: ");
		scanf("%d", &horaInicio);
		printf("Hora de fim: ");
		scanf("%d", &horaFim);
		
		if(horaInicio<0||horaInicio>24||horaFim<0||horaFim>24){
			printf("Hora inserida invalida.\n");
		}
	}while(horaInicio<0||horaInicio>24||horaFim<0||horaFim>24);
	
	if(horaInicio==horaFim){
		duracao = 24;
	}else if(horaInicio<horaFim){
		duracao = horaFim-horaInicio;
	}else if(horaInicio>horaFim){
		duracao = 24-horaInicio+horaFim;
	}
	
	printf("Duracao: %d hora(s).\n", duracao);
	
	system("pause");
	return 0;
}
