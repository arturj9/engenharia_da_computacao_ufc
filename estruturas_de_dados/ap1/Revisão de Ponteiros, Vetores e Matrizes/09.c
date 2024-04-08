#include <stdio.h>
#include <stdlib.h>

float somatorio(int m, int n, float **v)
{
    int i, j;
    float md = 0.0F;
    for (i = 0; i < m; i++)
        for (j = 0; j < n; j++)
            md += v[i][j];
    return md;
}

void liberar(int m, float **mat)
{
    for (int i = 0; i < m; i++)
        free(mat[i]);
    free(mat);
}

int main()
{
    int m = 2;
    int n = 3;
    float **mat = (float **)malloc(m * sizeof(float *));
    if (mat == NULL)
    {
        printf("Memoria insuficiente\n");
        exit(1);
    }
    for (int i = 0; i < m; i++)
    {
        mat[i] = (float *)malloc(n * sizeof(float));
        if (mat[i] == NULL)
        {
            printf("Memoria insuficiente\n");
            exit(1);
        }
    }
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%f", &mat[i][j]);
        }
    }
    float s = somatorio(m, n, mat);
    printf("%f\n", s);
    liberar(m, mat);
    return 0;
}
