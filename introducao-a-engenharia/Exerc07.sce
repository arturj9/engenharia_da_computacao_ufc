clear // Limpa o ambiente de trabalho. 
clc // Limpa todas as entradas e saídas do Console.
/*
7 – Sendo H = 1 + 1/2 + 1/3 + 1/4 + ... 1/N, faça um algoritmo em Scilab para gerar o número H. O número N é lido do usuário pelo teclado.
*/
N=input("Digite um número: ")// Entrada de dados de um número para a variável N.
H=0
for i=1:1:N// Laço com i assumindo valores de 1 a N, com passo de 1.
    H=H+(1/i) // Obtendo H, como há um laço, é obtido H = 1 + 1/2 + 1/3 + 1/4 + ... 1/N.
end
printf("%g", H)// Saída de dados com H como real. 
