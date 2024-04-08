#include <stdio.h>
#include <stdlib.h>

int main()
{
    int *v = (int *)malloc(3 * sizeof(int));
    float *pf = (float *)malloc(2 * sizeof(float));
    *pf = 5;
    *(pf + 1) = 8;
    *(v + 2) = 3;
    printf("%f\n", *(pf + 1));
    return 0;
}