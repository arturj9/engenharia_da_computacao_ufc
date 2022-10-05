clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*
20 – Faça um programa que calcule 𝑆 = cos(𝑥) = 1 − ((x^2)/2!) +  ((x^4)/4!) - 
 ((x^6)/6!) -  ((x^8)/8!) - ...para os 100 primeiros termos. 
 E ainda, plote os gráficos de S com 10, 20, 50, 75 e 100 primeiros
elementos da referida série.
*/
function yf = S(xf,n)
    yf = 0
    // Somátorio equivalente a 1 − ((x^2)/2!) +  ((x^4)/4!) - ((x^6)/6!) -  ((x^8)/8!) - ...
    for i = 0:1:n-1
        yf = yf + (-1)^i*xf^(2*i)/factorial(2*i)
    end
endfunction
xf = input('Informe um número: ')// Entrada de daddos de um número para xf (x da função).
x = [10,20,50,75,100]// Vetor com os números dos gráficos requqeridos.
y = []
j = 1// Contador.
for i = x
    y(j) = S(xf,i)// O vetor y recebe S, para cada valor de x, por conta de haver o laço. 
    j=j+1// Incremento de j em 1 unidade.
end
printf("S = cos(%d) = %g, para os 100 primeiros termos.", xf, y(5))// Saída de dados com xf para os 100 primeiros termos.
plot(x',y)// Saída de dados em forma de gráfico.
// Personalizando os valores do eixo x.
a=get("current_axes")
ticks = a.x_ticks
ticks(3) =["10","20","50","75","100"]
ticks(2) = [10,20,50,75,100]
a.x_ticks = ticks


