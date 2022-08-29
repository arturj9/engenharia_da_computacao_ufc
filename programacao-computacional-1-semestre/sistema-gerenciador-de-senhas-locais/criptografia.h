// Criptografia
//Criptografa um caractere.
int criptografar(char caractere)
{
	int caractere_int; //Armazena o valor criptografado do caractere.
	if(caractere!='\0')
	{ // Condição para parar no fim da string.
		caractere_int=(((int)caractere)*7)%256; // Função para mudar o valor inteiro.
	}
	return caractere_int; // Retorna valor inteiro correspondente ao caractere.
}
//Volta um caractere criptografado a sua forma "real".
char descriptografar(int caractere_cript_int)
{
	char caractere; // Caractere a ser retornado.
	int k; // k -> Inteiro para auxiliar na função.
	if(caractere_cript_int!='\0')
	{
		int swit=caractere_cript_int%7; // swit -> Auxiliar na função.
		switch(swit)
		{ 
			case 0:
				k=0;
				break;
			case 3:
				k=1;
				break;
			case 6:
				k=2;
				break;
			case 2:
				k=3;
				break;
			case 5:
				k=4;
				break;
			case 1:
				k=5;
				break;
			case 4:
				k=6;
				break;
			}
		char senha;
		if(k<=2)
		{
			caractere=(char)((caractere_cript_int/7)+k+36*k);
		}
		else if(k<=4)
		{
			caractere=(char)(caractere_cript_int/7+k-1+36*k);
		}
		else if(k<=6)
		{
			caractere=(char)(caractere_cript_int/7+k-2+36*k);
		}
		if(caractere!=(char)201||caractere!='Æ')
		{ // Condição para evitar erros de caracteres a mais.
			return caractere; // Retorna o caractere descriptografado.
		}
	}
}
