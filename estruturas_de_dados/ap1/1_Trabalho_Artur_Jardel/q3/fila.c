#include "fila.h"

struct lista
{
    int info;
    Lista *prox;
};

struct fila
{
    Lista *ini;
    Lista *fim;
};