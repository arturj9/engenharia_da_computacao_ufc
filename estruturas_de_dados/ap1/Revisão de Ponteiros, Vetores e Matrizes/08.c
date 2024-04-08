#include <stdio.h>
#include <stdlib.h>

float somatorio(int m, int n, float *v)
{
    int i, j;
    float md = 0.0F;
    for (i = 0; i < m; i++)
        for (j = 0; j < n; j++)
            md += v[i * n + j];
    return md;
}

int main()
{
    int m = 2, n = 3;
    float *mat = (float *)malloc(m * n * sizeof(float));
    if (mat == NULL)
    {
        printf("Memoria Insuficiente");
        exit(1);
    }
    for (int i = 0; i < n * m; i++)
        scanf("%f", mat + i);
    // mat[i][j];
    // mat[i * n + j];
    // mat[2][1];
    // mat[2 * 3 + 1] = 40;
    float s = somatorio(m,n,mat);
    printf("%f\n", s);
    return 0;
}