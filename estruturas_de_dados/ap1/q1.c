#include <stdio.h>
#include <stdlib.h>

typedef struct lista Lista;
struct lista{
    int info;
    Lista* prox;
};

Lista* add_node_final(Lista* l, int x){
    Lista* newNode = (Lista*) malloc(sizeof(Lista*));
    newNode->info = x;
    newNode->prox = NULL;
    if(l==NULL){
        return newNode;
    }
    Lista* currentNode = l;
    while(currentNode!=NULL){
        if(currentNode->prox==NULL){
            currentNode->prox=newNode;
            break;
        }
        currentNode = currentNode->prox;
    }
    return l;
}

Lista* create_lista(){
    return NULL;
}

void show(Lista* l){
    Lista* currentNode = l;
    while(currentNode!=NULL){
        printf("%d\n", currentNode->info);
        currentNode = currentNode->prox;
    }
}

int qtd_menores_lista(Lista* l, int x)
{
    int qtd = 0;
    Lista* currentNode = l;
    while(currentNode!=NULL){
        if(currentNode->info<x){
            qtd++;
        }
        currentNode = currentNode->prox;
    }
    return qtd;
}

int main(void)
{
    Lista* head = create_lista();
    head = add_node_final(head,1);
    head = add_node_final(head,2);
    head = add_node_final(head,3);
    head = add_node_final(head,4);
    head = add_node_final(head,5);
    int qtd =  qtd_menores_lista(head, 4);
    show(head);
    printf("qtd: %d", qtd);
}
