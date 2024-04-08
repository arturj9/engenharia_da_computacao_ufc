#include <stdio.h>
#include <stdlib.h>

float somatorio(int tamanho, float *v)
{
    float soma = 0.00F;
    ;
    for (int i = 0; i < tamanho; i++)
    {
        soma += v[i];
    }
    return soma;
}

int main()
{
    int n;
    int i;
    float *v;
    float s;
    scanf("%d", &n);
    v = (float *)malloc(n * sizeof(float));
    if (v == NULL)
    {
        printf("Memoria Insuficiente");
        exit(1);
    }
    for (i = 0; i < n; i++)
        scanf("%f", &v[i]);
    s = somatorio(n, v);
    printf("somatorio = % .2f, media = % .2f\n", s, s / n);
    free(v);
    return 0;
}