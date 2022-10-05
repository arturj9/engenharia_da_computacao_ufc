clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/* 
18 – Faça um programa que receba do usuário três lados de um triângulo e apresente qual é seu tipo. 
*/
printf("Informe 3 lados de um triângulo e eu direi de que tipo ele é.\n")
// Entrada de dados da medida dos lados do triângulo (L1, L2 e L3).
L1 = input("Lado 1:")
L2 = input("Lado 2:")
L3 = input("Lado 3:")
// Comparação entre os lados do triângulo.
if(L1==L2 & L1==L3)then// Se todos os lados tiverem a mesma medida..
   disp("Esse triângulo é equilátero.")// Saída de dados para o triângulo sendo equilátero.
elseif(L1>L2+L3 | L2>L1+L3 | L3>L2+L1)then// Se a medida de um dos lados for maior que a soma das medidas dos outros dois.
   disp("Não é possível existir um triângulo com esses lados.")// Saída de dados para a impossibilidade desse triângulo existir.
elseif(L1~=L2 & L2~=L3 & L1~=L3)then// Se todos os lados tiverem medidas diferentes.
   disp("Esse triângulo é escaleno.")// Saída de dados para o triângulo sendo escaleno.
else// Se dois lados tiverem a mesma medida.
   disp("Esse triângulo é isósceles.")// Saída de dados para o triângulo sendo isósceles.
end
