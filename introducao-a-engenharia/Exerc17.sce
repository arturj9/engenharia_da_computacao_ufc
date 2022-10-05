clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/* 
17 - Faça um programa que receba do usuário o diâmetro e a profundidade (em metros) de uma piscina redonda. O programa deve calcular e apresentar o volume da piscina em metros cúbicos e em litros. 
*/
// Entrada de dados com os valores do diâmetro e da profundida, os dois em metros, para as variáveis D e P, respectivamente.
printf("Escreva o diâmetro e a profundidade da piscina que direi seu volume em metros cúbicos e em litros.\n")
D = input("Escreva o diâmetro em metros:")
P = input("Escreva a profundidade em metros:")
Vm = D^2 * P * 0.785//Obtendo o volume da piscina em metros cúbicos.
Vl = Vm * 10^3// Obtendo o equivalente do volume (metros cúbicos) em litros.
printf("%f é o volume da piscina em metros cúbicos, o que é equivalente a %f em litros.",Vm,Vl)// Saída de dados do volume da piscina, em metros cúbicos e em litros.
