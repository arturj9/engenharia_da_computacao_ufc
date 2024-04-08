#include <stdio.h>
#include <stdlib.h>
#include "lista.h"

struct lista
{
	int info;
	Lista *prox;
};

int comprimento(Lista *l)
{
	int quantNos = 0;
	Lista *aux = l;
	while (aux != NULL)
	{
		quantNos++;
		aux = aux->prox;
	}
	return quantNos;
};

int menores(Lista *l, int n)
{
	int quant = 0;
	Lista *aux = l;
	while (aux != NULL)
	{
		if (aux->info < n)
		{
			quant++;
		}
		aux = aux->prox;
	}
	return quant;
};

int soma(Lista *l)
{
	int result = 0;
	Lista *aux = l;
	while (aux != NULL)
	{
		result += aux->info;
		aux = aux->prox;
	}
	return result;
};

int primos(Lista *l)
{
	int quant = 0;
	Lista *aux = l;
	while (aux != NULL)
	{
		if (ehPrimo(aux->info))
		{
			quant++;
		}
		aux = aux->prox;
	}
	return quant;
};

Lista *lst_conc(Lista *l1, Lista *l2)
{
	Lista *copiaL1 = copiarLista(l1);
	Lista *copiaL2 = copiarLista(l2);
	Lista *aux = copiaL1;

	while (aux->prox != NULL)
	{
		aux = aux->prox;
	}
	aux->prox = copiaL2;
	return copiaL1;
};

Lista *lst_diferenca(Lista *l1, Lista *l2)
{
	Lista *copiaL1 = copiarLista(l1);
	Lista *copiaL2 = copiarLista(l2);
	Lista *aux = l1;

	while (aux != NULL)
	{
		Lista *aux2 = copiaL2;
		while (aux2 != NULL)
		{
			if (aux->info == aux2->info)
			{
				copiaL1 = lst_remove_rec(copiaL1, aux->info);
			}
			aux2 = aux2->prox;
		}
		aux = aux->prox;
	}
	lst_libera(copiaL2);
	lst_libera(l1);
	return copiaL1;
};

Lista *lst_cria()
{
	return NULL;
};

Lista *lst_insere(Lista *l, int info)
{
	Lista *novoNo = (Lista *)malloc(sizeof(Lista));
	if (novoNo == NULL)
	{
		printf("Memória insuficiente.");
		exit(1);
	}
	novoNo->info = info;
	novoNo->prox = NULL;
	if (l == NULL)
	{
		novoNo->prox = l;
		return novoNo;
	}
	else
	{
		Lista *aux = l;
		while (aux->prox != NULL)
		{
			aux = aux->prox;
		}
		aux->prox = novoNo;
		return l;
	}
};

int lst_vazia(Lista* l){
	return l == NULL;
}

Lista *lst_remove_rec(Lista *l, int info)
{
	if (!lst_vazia(l))
		if (l->info == info)
		{
			Lista *lAux = l;
			l = l->prox;
			free(lAux);
		}
		else
		{

			l->prox = lst_remove_rec(l->prox, info);
		}
	return l;
};

void lst_imprime(Lista *l)
{
	Lista *aux = l;
	while (aux != NULL)
	{
		printf("%d\n", aux->info);
		aux = aux->prox;
	}
}

void lst_imprime_invertida_rec(Lista *l)
{
	Lista *aux = l;
	if (aux != NULL)
	{
		lst_imprime_invertida_rec(aux->prox);
		printf("%d\n", aux->info);
	}
};

void lst_libera(Lista *l)
{
	Lista *lProx;
	while (l != NULL)
	{
		lProx = l->prox;
		free(l);
		l = lProx;
	}
}

// Funções auxiliares
int ehPrimo(int numero)
{
	if (numero <= 1)
	{
		return 0;
	}
	for (int i = 2; i * i <= numero; i++)
	{
		if (numero % i == 0)
		{
			return 0;
		}
	}
	return 1;
};

Lista *copiarLista(Lista *l)
{
	Lista *aux = l;
	Lista *copia = lst_cria();

	while (aux != NULL)
	{
		copia = lst_insere(copia, aux->info);
		aux = aux->prox;
	};

	return copia;
};
