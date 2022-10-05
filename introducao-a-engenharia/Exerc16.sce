clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/* 
16 – Faça um programa que receba do usuário uma medida de temperatura em Fahrenheit e faça a chamada de uma função sua que converta para Celsius. Essa função deve retornar o valor em Celsius.
*/
printf("Diga uma temperatura em Fahrenheit que converterei para Celsius")
F = input("diga o valor da temperatura em fahrenheit: ")// Entrada de dados de um némero para a variável F (temperatura em Fahrenheit).
C =(F-32) * 5/9// Convertendo a temperatura de Fahrenheit em Celsius.
printf("%f é a temperatura em Celsius.",C)// Saída de dados da temperatura convertida em Celsius.
