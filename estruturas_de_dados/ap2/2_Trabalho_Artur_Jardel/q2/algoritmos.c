#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "algoritmos.h"

// Ordenacao
void bubbleSort(int n, int *v)
{
    int i, j, temp;
    for (i = n - 1; i > 0; i--)
        for (j = 0; j < i; j++)
            if (v[j] > v[j + 1])
            {

                temp = v[j];
                v[j] = v[j + 1];
                v[j + 1] = temp;
            }
}

void insertionSort(int n, int *v)
{
    int i, j, key;
    for (i = 1; i < n; i++)
    {
        key = v[i];
        j = i - 1;
        while (j >= 0 && v[j] > key)
        {
            v[j + 1] = v[j];
            j--;
        }
        v[j + 1] = key;
    }
}

void quickSort(int n, int *v)
{
    if (n > 1)
    {
        int x = v[0];
        int a = 1;
        int b = n - 1;
        while (1)
        {
            while (a < n && v[a] <= x)
                a++;
            while (v[b] > x)
                b--;
            if (a < b)
            {
                int temp = v[a];
                v[a] = v[b];
                v[b] = temp;
                a++;
                b--;
            }
            else
                break;
        }
        v[0] = v[b];
        v[b] = x;
        quickSort(b, v);
        quickSort(n - a, &v[a]);
    }
}

void mergeSort_intercala(int *v, int esq, int meio, int dir)
{
    int i, j, k;
    int a_tam = meio - esq + 1;
    int b_tam = dir - meio;

    int *a = (int *)malloc(sizeof(int) * a_tam);
    int *b = (int *)malloc(sizeof(int) * b_tam);

    if (a == NULL || b == NULL)
    {
        perror("Erro ao alocar memória");
        exit(EXIT_FAILURE);
    }

    for (i = 0; i < a_tam; i++)
        a[i] = v[esq + i];
    for (i = 0; i < b_tam; i++)
        b[i] = v[meio + 1 + i];

    i = 0;
    j = 0;
    for (k = esq; k <= dir; k++)
    {
        if (i == a_tam)
            v[k] = b[j++];
        else if (j == b_tam)
            v[k] = a[i++];
        else if (a[i] < b[j])
            v[k] = a[i++];
        else
            v[k] = b[j++];
    }

    free(a);
    free(b);
}

void mergeSort_ordena(int *v, int esq, int dir)
{
    if (esq < dir)
    {
        int meio = (esq + dir) / 2;
        mergeSort_ordena(v, esq, meio);
        mergeSort_ordena(v, meio + 1, dir);
        mergeSort_intercala(v, esq, meio, dir);
    }
}

void mergeSort(int n, int *v)
{
    mergeSort_ordena(v, 0, n - 1);
}

void heapify(int n, int *v, int i)
{
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && v[left] > v[largest])
        largest = left;

    if (right < n && v[right] > v[largest])
        largest = right;

    if (largest != i)
    {
        int swap = v[i];
        v[i] = v[largest];
        v[largest] = swap;

        heapify(n, v, largest);
    }
}

void heapSort(int n, int *v)
{
    int i, temp;
    for (i = n / 2 - 1; i >= 0; i--)
        heapify(n, v, i);

    for (i = n - 1; i > 0; i--)
    {
        temp = v[0];
        v[0] = v[i];
        v[i] = temp;
        heapify(i, v, 0);
    }
}

// Auxiliares
void imprimir_vetor(int n, int *v)
{
    for (int i = 0; i < n; i++)
        printf("%d ", v[i]);
    printf("\n");
}

int *copiar_vetor(int n, int *v)
{
    int *copia = (int *)malloc(n * sizeof(int));
    if (copia == NULL)
    {
        perror("Erro ao alocar memória para a cópia do vetor");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < n; i++)
    {
        copia[i] = v[i];
    }
    return copia;
}

int *gerar_vetor_aleatorio(int n)
{
    int *v = (int *)malloc(n * sizeof(int));
    if (v == NULL)
    {
        perror("Erro ao alocar memória para o vetor aleatório");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < n; i++)
    {
        v[i] = rand() % 1000;
    }
    return v;
}

void relatorio_tempo_algoritmos(int n, int *v)
{
    printf("========== Tamanho de Vetor: %d ==========\n\n", n);

    // BubbleSort
    int *vetor = copiar_vetor(n, v);
    clock_t inicio = clock();
    bubbleSort(n, vetor);
    clock_t fim = clock();
    double tempo_ms = (double)(fim - inicio) / CLOCKS_PER_SEC * 1000;
    printf("BubbleSort: %f ms\n", tempo_ms);
    free(vetor);

    // InsertionSort
    vetor = copiar_vetor(n, v);
    inicio = clock();
    insertionSort(n, vetor);
    fim = clock();
    tempo_ms = (double)(fim - inicio) / CLOCKS_PER_SEC * 1000;
    printf("InsertionSort: %f ms\n", tempo_ms);
    free(vetor);

    // QuickSort
    vetor = copiar_vetor(n, v);
    inicio = clock();
    quickSort(n, vetor);
    fim = clock();
    tempo_ms = (double)(fim - inicio) / CLOCKS_PER_SEC * 1000;
    printf("QuickSort: %f ms\n", tempo_ms);
    free(vetor);

    // MergeSort
    vetor = copiar_vetor(n, v);
    inicio = clock();
    mergeSort(n, vetor);
    fim = clock();
    tempo_ms = (double)(fim - inicio) / CLOCKS_PER_SEC * 1000;
    printf("MergeSort: %f ms\n", tempo_ms);
    free(vetor);

    // HeapSort
    vetor = copiar_vetor(n, v);
    inicio = clock();
    heapSort(n, vetor);
    fim = clock();
    tempo_ms = (double)(fim - inicio) / CLOCKS_PER_SEC * 1000;
    printf("HeapSort: %f ms\n", tempo_ms);
    free(vetor);

    free(v);
}