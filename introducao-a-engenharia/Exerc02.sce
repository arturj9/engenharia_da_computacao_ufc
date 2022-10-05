clear // Limpa o ambiente de trabalho. 
clc // Limpa todas as entradas e saídas do Console.
/*
2 – Escreva um algoritmo em Scilab que determine se um dado número N (digitado pelo usuário) é primo ou não.
*/
i=2// Divisor.
res=0// Valor para N sendo primo.
N=input("Digite um número: ")// Entrada de dados de um número para a variável N.
while i<=N/2
    if(modulo(N,i)==0)then
        res=res+1// Incremento de res em 1 unidade.
        break
    end
    i=i+1// Incremento de i em 1 unidade.
end
if(res==0)then // Se res for igual a 0, então N é primo.
    printf("%d é primo.", N)// Saída de dados para N sendo primo. 
else
    printf("%d não é primo.", N)// Saída de dados para N não sendo primo. 
end
