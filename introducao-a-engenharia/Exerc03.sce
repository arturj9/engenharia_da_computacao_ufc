clear // Limpa o ambiente de trabalho. 
clc // Limpa todas as entradas e saídas do Console.
/*
3 – Escreva um algoritmo em Scilab para calcular o fatorial do número N, cujo valor é obtido através do usuário pelo teclado.
*/
N=input("Informe um número: ")// Entrada de dados de um número para a variável N.
num = N// num = cópia de N.
fat=N// fat = Fatorial de N.
while N>1
    fat=fat*(N-1)// Atribuição do produto de N (fat) pelo seu anterior, como há um laço, é obtido N!.
    N=N-1// Decremento de N em 1 unidade.
end
printf("%d! = %d",num,fat)// Saída de dados com o N! (fatorial de N). 
