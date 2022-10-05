clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
13 - A série de Fibonacci se define como tendo os dois primeiros elementos iguais a um e cada elemento seguinte é igual a soma dois elementos imediatamente anteriores. Exemplo, 1, 1, 2, 3, 5, 8 . . . Pede-se que escreva todos os elementos da série de Fibonacci menor ou igual a um determinado N.
*/
N=input("Informe um número: ")// Entrada de dados de número para N.
fibonacci=zeros(1,N)
for i=1:N
    fibonacci(1)=1// 1º termo.
    if(i==2)then
        fibonacci(2)=1// 2º termo.
        end
    if(i>=3)then// Obtendo termos da série de Fibonacci de posição >= 3
        fibonacci(i)=fibonacci(i-1)+fibonacci(i-2)
    end
    if(fibonacci(i)>N) then
        break
    end
    disp(fibonacci(i))// Saída de dados com o termo da série de Fibonacci, como há um laço, é obtido todos os termos menor ou igual a  N.
end

