clear // Limpa o ambiente de trabalho. 
clc // Limpa todas as entradas e saídas do Console.
/*
6 – A série de FETUCCINE é gerada da seguinte forma: os dois primeiros termos são fornecidos pelo usuário; a partir daí, os termos são gerados com a soma ou subtração dos dois termos anteriores, ou seja:
Ai=(A(i-1))+(A(i-2)) para i ímpar
Ai=(A(i-1))−(A(1-2)) para i par
Criar um algoritmo em Scilab que imprima os N primeiros termos da série de FETUCCINE, sabendo-se que para existir esta série serão necessários pelo menos três termos.
*/
anterior=input("Digite o primeiro termo: ")// Entrada de dados de um número (primeiro termo) para a variável anterior.
atual=input("Digite o segundo termo: ")// Entrada de dados de um número (segundo termo) para a variável atual.
tamanhoSeq=input("Diga o tamanho da sequência: ")// Entrada de dados de um número (tamanho da sequência) para a variável termo.
disp(anterior)// Saída de dados com 1º termo.
disp(atual)// Saída de dados com 2º termo.
for i=1:1:tamanhoSeq-2
    if modulo(i,2)==0 then // Se o termo atual for par.
        proximo = atual - anterior
        disp(proximo)// Saída de dados com o próximo termo da série. 
    else// Se o termo atual for ímpar.
        proximo = atual + anterior 
        disp(proximo)// Saída de dados com o próximo termo da série.  
    end
    anterior = atual
    atual = proximo
end
