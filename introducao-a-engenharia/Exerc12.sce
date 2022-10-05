clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
12 - Elabore um programa que calcule e escreve o valor de S. S = 1/1 + 3/2 + 5/3 + 7/4 + ... + 99/50
*/
a=1// a = númerador
b=1// b = denominador
S=0
while b<50
    div=a/b// Divisão de a por b.
    S=S+div// Soma de S por um termo, como há um laço, é obtido S = 1/1 + 3/2 + 5/3 + 7/4 + ... + 99/50.
    a=a+2// Incremento de a em 2 unidades.
    b=b+1// Incremento de b em 1 unidade.
end
disp(S)// Saída de dados com S = 1/1 + 3/2 + 5/3 + 7/4 + ... + 99/50
