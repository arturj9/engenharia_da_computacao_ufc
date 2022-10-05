clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
9 – A posição s de um corpo em movimento retilíneo uniformemente variado, em função do tempo t, é dado pela equação:
s = so + vo*t + (a*t^2)/2
Sabendo que um objeto está em movimento retilíneo uniforme variado com posição inicial de 10 m, velocidade inicial de 15 m/s e aceleração de 20 m/s^2. Obtenha um vetor de posições finais desse objeto para cada tempo t=[1, 5, 10, 15, 20].
*/
t=[1,5,10,15,20]// Entrada de dados com o vetor com valores para o tempo.
S=zeros(1,5)
for i=1:5
    S(i)=10+(15*t(i))+(0.5*20*t(i)^2)// Obtendo a possição final para determinado tempo, como há um laço, é obtido todas.
end
// Saída de dados com o vetor de posições finais desse objeto para cada tempo.
disp('O vetor com as posições finais é ')
disp(S)
