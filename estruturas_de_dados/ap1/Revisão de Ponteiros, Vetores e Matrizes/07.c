#include <stdio.h>

float somatorio(int m, float v[][3])
{
    int i, j;
    float md = 0.00F;
    for (i = 0; i < m; i++)
        for (j = 0; j < 3; j++)
            md += v[i][j];
    return md;
}

int main()
{
    float m[4][3] = {{5.0, 10.0, 15.0},
                     {20.0, 25.0, 30.0},
                     {35.0, 40.0, 45.0},
                     {50.0, 55.0, 60.0}};
    float s = somatorio(4, m);
    printf("%.2f\n", s);
    return 0;
}