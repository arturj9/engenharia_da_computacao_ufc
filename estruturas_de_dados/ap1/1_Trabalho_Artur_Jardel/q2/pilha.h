// Estrutura
typedef struct pilha Pilha;

// Funções da Questão
int topo(Pilha *p);
int impares(Pilha *p);
Pilha *empilha_pares(Pilha *p1, Pilha *p2);

// Funções Fundamentais
Pilha *pilha_cria();
void pilha_push(Pilha *p, int info);
int pilha_pop(Pilha *p);
void pilha_imprime(Pilha *p);
void pilha_libera(Pilha *p);

// Funções Auxiliares
int pilha_vazia(Pilha *p);
void empilha(Pilha *p1, Pilha *p2);
void sort_decres(Pilha *p);