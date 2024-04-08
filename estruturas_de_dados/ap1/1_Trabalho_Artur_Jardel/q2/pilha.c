#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

#define MAX 10

struct pilha
{
    int n;
    int v[MAX];
};

Pilha *pilha_cria()
{
    Pilha *p = (Pilha *)malloc(sizeof(Pilha));
    if (p == NULL)
    {
        printf("Memoria insuficiente.\n");
        exit(1);
    }
    p->n = 0;
    return p;
}

void pilha_push(Pilha *p, int info)
{
    if (p->n == MAX)
    {
        printf("Capacidade da pilha estourou.\n");
        exit(1);
    }
    p->v[p->n] = info;
    p->n++;
}

int pilha_pop(Pilha *p)
{
    int a;
    if (pilha_vazia(p))
    {
        printf("Pilha vazia.\n");
        exit(1);
    }
    a = p->v[p->n - 1];
    p->n--;
    return a;
}

void pilha_imprime(Pilha *p)
{
    if (pilha_vazia(p))
    {
        printf("Pilha vazia.\n");
        exit(1);
    }
    for (int i = p->n - 1; i >= 0; i--)
    {
        printf("%d\n", p->v[i]);
    }
}

void pilha_libera(Pilha *p)
{
    free(p);
}

int pilha_vazia(Pilha *p)
{
    return p->n == 0;
}

int topo(Pilha *p)
{
    if (pilha_vazia(p))
    {
        printf("Pilha vazia.\n");
        exit(1);
    }
    return p->v[p->n - 1];
}

int impares(Pilha *p)
{
    if (pilha_vazia(p))
    {
        printf("Pilha vazia.\n");
        exit(1);
    }
    int quantImpares = 0;
    for (int i = p->n - 1; i >= 0; i--)
    {
        if (p->v[i] % 2 != 0)
        {
            quantImpares++;
        }
    }
    return quantImpares;
}

void empilha(Pilha *p1, Pilha *p2)
{
    while (!pilha_vazia(p1))
    {
        pilha_push(p2, pilha_pop(p1));
    }
}

void sort_decres(Pilha *p) {
    if (pilha_vazia(p)) {
        printf("Pilha vazia.\n");
        exit(1);
    }
    for (int i = 0; i < p->n - 1; i++) {
        for (int j = 0; j < p->n - i - 1; j++) {
            if (p->v[j] < p->v[j + 1]) {
                int temp = p->v[j];
                p->v[j] = p->v[j + 1];
                p->v[j + 1] = temp;
            }
        }
    }
}

Pilha *empilha_pares(Pilha *p1, Pilha *p2)
{
    if (pilha_vazia(p1))
    {
        printf("Pilha vazia.\n");
        exit(1);
    }
    Pilha *pares = pilha_cria();
    for (int i = p1->n - 1; i >= 0; i--)
    {
        if (p1->v[i] % 2 == 0)
        {
            pilha_push(pares, p1->v[i]);
        }
    }
    sort_decres(pares);
    empilha(pares, p2);
    pilha_libera(pares);
    return p2;
}