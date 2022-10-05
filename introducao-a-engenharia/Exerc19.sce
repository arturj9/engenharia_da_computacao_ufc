clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
19 - Faça um script que gere o gráfico abaixo para 0 ≤ 𝑥 ≤ 2 pi, com um passo de 0.1. Apresente o script como resposta. Pesquise sobre o comando “legend()” para adicionar uma legenda.
*/
x = [0:0.1:2*%pi]//Entrada de dados com x sendo um vetor, recebendo valores de 0 a 2, com passo de 0.1.
ys = sin(x)// Obtendo os elementos de ys, para sin(x, para cada elemento de x.
yc = cos(x)// Obtendo os elementos de yc, para cos(x),  para cada elemento de x.
title('Funções seno e cosseno - Escalas Isométricas')// Título do gráfico.
plot(x,ys,'-b*',x,yc,'-ro')// Saída de dados em forma de gráfico.
legend('Seno','Cosseno',-1)// Legenda do gráfico.
// Deixando o eixo x em posição média entre os extremos de y.
a=get("current_axes")
a.font_size=2
a.x_location="middle"
// Personalizando os valores do eixo x.
ticks = a.x_ticks
ticks(3) =["0","0.5","1","1.5","2","2.5","3","3.5","4","4.5","5","5.5","6","6.5","7"]
ticks(2) = [0:0.5:7]
a.x_ticks = ticks
// Personalizando os valores do eixo y.
ticks = a.y_ticks
ticks(3) =["-1","-0.5","0","0.5","1"]
ticks(2) = [-1:0.5:1]
a.y_ticks = ticks
