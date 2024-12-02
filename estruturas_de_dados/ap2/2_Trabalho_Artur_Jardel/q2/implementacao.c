#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "algoritmos.h"

#define SIZE_1 100
#define SIZE_2 1000
#define SIZE_3 10000
#define SIZE_4 100000
#define SIZE_5 1000000

int main()
{
    srand(time(NULL));

    int sizes[] = {SIZE_1, SIZE_2, SIZE_3, SIZE_4, SIZE_5};
    int num_sizes = 5;

    printf("Relatorio de tempo de execucao de algoritmos de ordenacao (ms)\n\n");

    for (int i = 0; i < num_sizes; i++)
    {
        int *v = gerar_vetor_aleatorio(sizes[i]);
        relatorio_tempo_algoritmos(sizes[i], v);
        printf("\n");
    }

    return 0;
}