#include <stdio.h>

int main ()
{
    // int v[] = {2, 3, 4};
    int v[3] = {2, 3, 4};
    v[0] = 2;  *v =2;
    v[1] = 3;  *(v+1) =3;
    v[2] = 4;  *(v+2) =4;
    printf("%d\n", *(v+2));
}
