// Ordenacao
void bubbleSort(int n, int *v);

void insertionSort(int n, int *v);

void quickSort(int n, int *v);

void mergeSort_intercala(int *v, int esq, int meio, int dir);

void mergeSort_ordena(int *v, int esq, int dir);

void mergeSort(int n, int* v);

void heapify(int n, int* v, int i);

void heapSort(int n, int* v);

// Auxiliares
int* copiar_vetor(int n, int *v);

int* gerar_vetor_aleatorio(int n);

void relatorio_tempo_algoritmos(int n, int *v);