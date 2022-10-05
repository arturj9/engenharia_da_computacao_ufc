clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
14 – Crie uma função que receba os coeficientes de uma equação do segundo grau e apresente na saída as raízes ou uma informação explicando que as raízes são complexas.
*/
function[x1,x2]=segundo_grau(a,b,c)
    delta=(b^2-(4*a*c))// Obtendo delta, utilizando-se da Fórmula de Bhaskara.
    if(delta<0)then// Se as raízes forem complexas.
        printf("Os coeficientes resultam em um delta negativo logo as raízes são complexas.\n")
        abort
    end
    // Obtendo as raízes, utilizando-se da Fórmula de Bhaskara.
    x1=(-b-sqrt(delta))/(2*a)
    x2=(-b+sqrt(delta))/(a*2)
    // Saída de dados com as raízes da equação.
    printf("As raizes são: \n")
    disp(x1)
    disp(x2)
endfunction
// Entrada de dados de números para A, B e C (coeficientes).
a=input("A: ")
b=input("B: ")
c=input("C: ")
[x1,x2] = segundo_grau(a,b,c)// Chamada da função, passando como parâmetros os coeficientes.
