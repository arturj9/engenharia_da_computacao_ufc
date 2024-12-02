// Estrutura
typedef struct lista Lista;
typedef struct fila Fila;

// Funções da Questão
Fila *inverte(Fila *f);
int qtd_maior(Fila *f, int n);
int pares(Fila *f);

// Funções Fundamentais
Fila *fila_cria();
void fila_insere(Fila *f, int info);
void fila_imprime(Fila *f);
int fila_remove(Fila *f);
void fila_libera(Fila *f);

// Funções Auxiliares
int fila_vazia(Fila *f);
void fila_insere_inicio(Fila *f, int info);
int eh_par(int numero);