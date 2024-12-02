#include <stdio.h>
#include <stdlib.h>
#include "fila.h"

// Estruturas
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

// Funções da Questão
Fila *inverte(Fila *f)
{
    Fila *f_invertida = fila_cria();
    Lista *aux = f->ini;
    while (aux != NULL)
    {
        fila_insere_inicio(f_invertida, aux->info);
        aux = aux->prox;
    }
    return f_invertida;
}

int qtd_maior(Fila *f, int n)
{
    int qtd = 0;
    Lista *lAux = f->ini;
    while (lAux != NULL)
    {
        if (lAux->info > n)
        {
            qtd++;
        }
        lAux = lAux->prox;
    }
    return qtd;
}

int pares(Fila *f)
{
    int qtd = 0;
    Lista *lAux = f->ini;
    while (lAux != NULL)
    {
        if (eh_par(lAux->info))
        {
            qtd++;
        }
        lAux = lAux->prox;
    }
    return qtd;
}

// Funções Fundamentais
Fila *fila_cria(void)
{
    Fila *f = (Fila *)malloc(sizeof(Fila));
    if (f == NULL)
    {
        printf("Memoria insuficiente!!!\n");
        exit(1);
    }
    f->ini = NULL;
    f->fim = NULL;
    return f;
}

void fila_insere(Fila *f, int info)
{
    Lista *l = (Lista *)malloc(sizeof(Lista));
    if (l == NULL)
    {
        printf("Memoria insuficiente!!!\n");
        exit(1);
    }
    l->info = info;
    l->prox = NULL;
    if (!fila_vazia(f))
        f->fim->prox = l;
    else
        f->ini = l;
    f->fim = l;
}

void fila_imprime(Fila *f)
{
    Lista *lAux = f->ini;
    while (lAux != NULL)
    {
        printf("%d\n", lAux->info);
        lAux = lAux->prox;
    }
}

int fila_remove(Fila *f)
{
    Lista *l;
    int a;
    if (fila_vazia(f))
    {
        printf("Fila Vazia!!!\n");
        exit(1);
    }
    a = f->ini->info;
    l = f->ini;
    f->ini = f->ini->prox;
    free(l);
    if (fila_vazia(f))
        f->fim = NULL;
    return a;
}

void fila_libera(Fila *f)
{
    Lista *l = f->ini;
    Lista *lAux;
    while (l != NULL)
    {
        lAux = l->prox;
        free(l);
        l = lAux;
    }
    free(f);
}

// Funções Auxiliares
int fila_vazia(Fila *f)
{
    return f->ini == NULL;
}

void fila_insere_inicio(Fila *f, int info)
{
    Lista *novo = (Lista *)malloc(sizeof(Lista));
    novo->info = info;
    novo->prox = NULL;
    if (fila_vazia(f))
    {
        f->ini = novo;
        f->fim = novo;
    }
    else
    {
        novo->prox = f->ini;
        f->ini = novo;
    }
}

int eh_par(int numero)
{
    return numero % 2 == 0;
}