clear // Limpa o ambiente de trabalho. 
clc // Limpa todas as entradas e saídas do Console.
/*
4 - Escreva um algoritmo em Scilab que determine se dois valores inteiros e positivos A e B são primos entre si. (dois números inteiros são ditos primos entre si, caso não exista divisor comum aos dois números). 
*/
A=input("Digite um número: ")// Entrada de dados de um número para a variável A.
B=input("Digite outro número: ")// Entrada de dados de um número para a variável B.
if B>A then
// Troca dos valores de A e B para B>A
    c=B
    B=A
    A=c
end
if modulo(A,B)==0 then// Se o módulo de A por B for igual a 0, então A e B são primos entre si
    printf("%d e %d não são primos entre si.",A,B)// Saída de dados para A e B sendo primos entre si. 
else
    printf("%d e %d são primos entre si.",A,B)// Saída de dados para A e B não sendo primos entre si. 
end
