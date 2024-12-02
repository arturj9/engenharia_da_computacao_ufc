// Estrutura
typedef struct lista Lista;

// Funções da Questão
int comprimento(Lista *l);
int menores(Lista *l, int n);
int soma(Lista *l);
int primos(Lista *l);
Lista *lst_conc(Lista *l1, Lista *l2);
Lista *lst_diferenca(Lista *l1, Lista *l2);

// Funções Fundamentais
Lista *lst_cria();
Lista *lst_insere(Lista *l, int info);
Lista *lst_remove_rec(Lista *l, int info);
void lst_imprime(Lista *l);
void lst_imprime_invertida_rec(Lista *l);
void lst_libera(Lista *l);

// Funções Auxiliares
int eh_primo(int numero);
Lista *lst_copia(Lista *l);