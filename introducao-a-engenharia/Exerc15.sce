clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/* 
15 – Crie uma função que recebe um vetor de notas e retorne a média desse vetor, independente da quantidade de notas nele. 
*/
printf("Cite um vetor de notas que darei a media desse vetor")
k=input("Diga quantas notas terá no seu vetor:")// Entrada de dados de um némero para k (quantidade de notas).
c=1// Contador.
X=[]// X = vetor com as notas.
// Obtendo cada nota.
while c <= k 
    printf("Diga a %d° nota:",c)
    i=input("")
    X=[X i]
    c=c+1// Incremento de c em 1 unidade.
end
y=sum(X)// Soma dos elementos do vetor.
media=y/k// Média dos elementos do vetor.
printf("%f é a média do vetor.",media)// Saída de dados com a média dos elementos do vetor.
