clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
21 – Faça um programa que apresente o gráfico da função abaixo. Apresente como resposta o gráfico e o script. Utilize uma faixa numérica suficiente para visualização dastransações entre as partes da função.
      -----
      |Sen(x+2),se x <= 0
g(x) =|ln x, se 0 < x <= 1
      |x^5+3, se x > 1
      -----
*/
function y = g(x)
    // Obtendo y, de acordo com as condições da função apresentada.
    if (x<=0) then
        y = sin(x+2)
    elseif (x>1) then
        y = (x^5)+3
    else
        y = log(x)
    end
endfunction

x = -50:0.1:2//Entrada de dados com x sendo um vetor, recebendo valores de -50 a 2, com passo de 0.1.
y = []

for xp = [1:length(x)]
    y(xp) = g(x(xp))// Obtendo valores de y, para cada valor de x, utilizando-se da função.
end

plot(x',y)// Saída de dados em forma de gráfico.

