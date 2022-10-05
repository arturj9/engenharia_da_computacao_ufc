clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
10 – Gere o gráfico da seguinte função: f(x) = 2*e^-0.2x, no intervalor 0 ≤ 𝑥 ≤ 10. Apresente como resposta o gráfico e seu script.
*/
x=0:0.1:10// Entrada de dados com x sendo um vetor, onde os elementos se iniciam em 0, vão até 10, com passo de 0.1.
y=2*(%e)^(-0.2*x)// Obtendo um  vetor onde cada elemento é dado por 2*e^-0.2x, para cada elemento de x.
title('f(x) 2e^-0.2x')// Título do gráfico.
plot(x,y)// Saída de dados em forma de gráfico.
 
