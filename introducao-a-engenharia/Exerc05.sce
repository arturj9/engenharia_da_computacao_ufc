clear // Limpa o ambiente de trabalho. 
clc // Limpa todas as entradas e saídas do Console.
/*
5 - A série de Fibonacci se define como tendo os dois primeiros elementos iguais a um e cada elemento seguinte é igual à soma dois elementos imediatamente anteriores. Exemplo, 1, 1, 2, 3, 5, 8 . . . Pede-se que apresente a soma de todos os elementos da série de Fibonacci menor ou igual a um determinado N
*/
a=input("Informe a quantidade de termos da sequência:")// Entrada de dados de um número (quantidade de termos) para a variável a.
if(a>0)then// a = quantidade de termos
    s=1// s = soma
else
    s=0
end
n1=0
n2=1
i=0// Contador.
while i<a-1
    b=n1+n2// Soma dos anteriores.
    n1=n2// Atribuição do anterior do termo atual para n1.
    n2=b// Atribuição do termo atual para n2
    s=s+b// Soma de s com o termo atual, como há um laço, é obtido a soma total requerida.
    i=i+1// Incremento de i em 1 unidades.
end
printf("A soma de %d termos é de %d",a,s)// Saída de dados com a soma de todos os elementos da série de Fibonacci menor ou igual a N.
