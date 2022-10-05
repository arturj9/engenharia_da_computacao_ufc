clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
1 – Escreva um algoritmo em Scilab que determine todos os divisores de um dado número N.
*/ 
N=input("Informe um número: ")// Entrada de dados de um número para a variável N.
printf("Divisores de %d:", N)
for i=1:1:N// Laço com i assumindo valores de 1 a N, com passo de 1.
    if(modulo(N,i)==0)then// Se o módulo de N por i for igual a 0, significa que i é um dividor de N.
        printf("\n%d", i)// Saída de dados com um divisor de N, como há um laço, todos os divisores são obtidos. 
    end
end
