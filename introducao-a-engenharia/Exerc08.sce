clear// Limpa o ambiente de trabalho. 
clc// Limpa todas as entradas e saídas do Console.
/*  
8 – Digite as seguintes matrizes no ambiente Scilab:
A=[4 -3; 2 1; 0 6]
B=[1 2 4; 2 4 1; 0 1 5]
C=[5; 8; 7]
(a) Mostre somente a segunda coluna de A;
(b) Mostre o elemento (3, 2) de A;
(c) Mostre somente a terceira coluna de B;
(d) Mostre as duas primeiras colunas de B;
(e) Mostre as duas últimas linhas de A;
*/

// Atribuição das matrizes.
A=[4 -3; 2 1; 0 6]
B=[1 2 4; 2 4 1; 0 1 5]
C=[5; 8; 7]

// Saída de dados com as matrizes.
disp("A:")
disp(A)
disp("B:")
disp(B)
disp("C:")
disp(C)


// Saída de dados com os comandos dos itens.
disp("a)Mostre somente a segunda coluna de A:")
disp(A(:,2))

disp("b)Mostre o elemento (3,2) de A:")
disp(A(3,2))

disp("c)Mostre somente a terceira coluna de B:")
disp(B(:,3))

disp("d)Mostre as duas primeiras colunas de B:")
disp([B(:,1)B(:,2)])

disp("e)Mostre as duas últmas linhas de A:")
disp([A($-1,:);A($,:)])
