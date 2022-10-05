clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
11 – Gere o gráfico da seguinte função: 𝑓(𝑥) = |sin x|, no intervalo -2*pi<=x<=2*pi Utilize o passo de pi/2. Apresente como resposta o gráfico e seu script.
*/
x=-2*%pi:(%pi/2):2*%pi// Entrada de dados com x sendo um vetor, onde os elementos se iniciam em -2*pi, vão até 2*pi, com passo de pi/2.
y=abs(sin(x))// Obtendo um  vetor onde cada elemento é dado por |sin x|, para cada elemento de x.
title("f(x) = |sin x|")// Título do gráfico
plot(x,y)// Saída de dados em forma de gráfico.

