#include <stdio.h>
#include <stdlib.h>
#include "arvb.h"

// Estrutura
struct arvb{
    int info;
    ArvB *esq;
    ArvB *dir;
};

// Funções Base
ArvB* arvb_cria_vazia(){
    return NULL;
}

int arvb_vazia(ArvB* a){
    return a == NULL;
}

ArvB* arvb_insere(ArvB* a, int c){
    if(arvb_vazia(a)){
        a = (ArvB*)malloc(sizeof(ArvB));
        a->info = c;
        a->esq = NULL;
        a->dir = NULL;
    }else if(a->info > c){
        a->esq = arvb_insere(a->esq, c);
    }else if(a->info < c){
        a->dir = arvb_insere(a->dir, c);
    }else{
        printf("\nElemento Ja Pertence a Arvore");
    }
    return a;
}

ArvB* arvb_remove(ArvB *a, int c){
    if(!arvb_vazia(a)){
        if(a->info > c){
            a->esq = arvb_remove(a->esq,c);
        }else if (a->info < c){
            a->dir = arvb_remove(a->dir,c);
        }else{
            ArvB* t;
            if (a->esq == NULL){
                t = a; a = a->dir;
                free(t);
            }else if (a->dir == NULL){
                t = a; a = a->esq;
                free(t);
            }else{
                t = a->esq;
                while(t->dir!=NULL)
                t = t->dir;
                a->info = t->info; t->info = c;
                a->esq = arvb_remove(a->esq,c);
            }
        }
    }
    return a;
}

int arv_altura(ArvB* a){
    if(arvb_vazia(a)){
        return -1;
    }else{
        int hSAE = arv_altura(a->esq);
        int hSAD = arv_altura(a->dir);

        if(hSAE > hSAD){
            return 1+hSAE;
        }else{
            return 1+hSAD;
        }
    }
}

void arvb_imprime(ArvB* a){
    if(!arvb_vazia(a)){
        arvb_imprime(a->esq);
        printf("%d ", a->info);
        arvb_imprime(a->dir);
    }
}

void arvb_libera(ArvB* a){
    if(!arvb_vazia(a)){
        arvb_libera(a->esq);
        arvb_libera(a->dir);
        free(a);
    }
}

// Funções da Questão
int folhas_primos(ArvB* a){
    if(arvb_vazia(a)){
        return 0;
    }
    return eh_primo(a->info) + folhas_primos(a->esq) + folhas_primos(a->dir);
}

int dois_filhos(ArvB* a){
    if(arvb_vazia(a)){
        return 0;
    }
    if(a->esq!= NULL && a->dir!= NULL){
        return 1 + dois_filhos(a->esq) + dois_filhos(a->dir);
    }
    return dois_filhos(a->esq) + dois_filhos(a->dir);
}

int nos_igual_altura(ArvB* a){
    if(arvb_vazia(a)){
        return 0;
    }
    if(arv_altura(a->esq) == arv_altura(a->dir)){
        return 1 + nos_igual_altura(a->esq) + nos_igual_altura(a->dir);
    }
    return nos_igual_altura(a->esq) + nos_igual_altura(a->dir);
}

int iguais(ArvB* a, ArvB* b){
    if(arvb_vazia(a) && arvb_vazia(b)){
        return 1;
    }
    if(arvb_vazia(a) || arvb_vazia(b)){
        return 0;
    }
    return (a->info == b->info) && iguais(a->esq, b->esq) && iguais(a->dir, b->dir);
}

// Funções auxiliares
int eh_primo(int n) {
    if (n <= 1){
        return 0;
    }
    if (n == 2 || n == 3){ 
        return 1;
    }
    if (n % 2 == 0 || n % 3 == 0){
        return 0;
    } 
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) {
            return 0;
        }
    }
    return 1;
}