
typedef struct lista Lista;

Lista *lst_cria();
Lista *lst_insere(Lista *l, int info);
Lista *lst_remove_rec(Lista* l, int info);
void lst_imprime(Lista *l);
void lst_imprime_invertida_rec(Lista *l);
void lst_libera(Lista *l);

int menores(Lista *l, int n);
int soma(Lista *l);
int primos(Lista *l);
int comprimento(Lista *l);
Lista *lst_conc(Lista *l1, Lista *l2);
Lista* lst_diferenca(Lista* l1, Lista* l2);

int ehPrimo(int numero);
Lista *copiarLista(Lista *lista);
