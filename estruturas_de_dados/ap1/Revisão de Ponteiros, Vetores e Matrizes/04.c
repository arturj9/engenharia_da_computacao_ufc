#include <stdio.h>

float somatorio(int tamanho, float *v)
{
    float soma = 0.0F;;
    for (int i = 0; i < tamanho; i++)
    {
        soma += v[i];
    }
    return soma;
}

int main()
{
    float v[] = {2.0, 3.0, 5.0};
    float s = somatorio(3, v);
    printf("somatorio=%.1f,media=%.1f\n", s, s / 3);
    return 0;
}