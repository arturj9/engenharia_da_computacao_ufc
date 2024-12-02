// Estrutura
typedef struct arvb ArvB;

// Funções Base
ArvB* arvb_cria_vazia();
int arvb_vazia(ArvB* a);
ArvB* arvb_insere(ArvB* a, int c);
ArvB* arvb_remove(ArvB *a, int c);
int arv_altura(ArvB* a);
void arvb_imprime(ArvB* a);
void arvb_libera(ArvB* a);

// Funções da Questão
int folhas_primos(ArvB* a);
int dois_filhos(ArvB* a);
int nos_igual_altura(ArvB* a);
int iguais(ArvB* a, ArvB* b);

// Funções auxiliares
int eh_primo(int n);