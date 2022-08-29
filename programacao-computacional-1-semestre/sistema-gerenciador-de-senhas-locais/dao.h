// Bibliotecas.
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "model.h"
// DAO: responsável por interagir e manipular arquivo txt.
// Usuário.
// Salva novo usuário e senha no arquivo txt de mesmo nome do usuário.
int dao_usuario_salvar(Usuario novo_usuario, UsuarioCript novo_usuario_cript)
{
	int i;// Contador.
	int tamanho_senha = strlen(novo_usuario.senha);
	FILE *pont_arq;// Ponteiro para arquivo.
	char nome_arq[33];// Nome do arquivo txt do usuário.
	char carac_str[3];
	// Faz a concatenação do nome do usuário com o ".txt".
	for(i=0;i<33;i++)
	{
		nome_arq[i]=novo_usuario.usuario[i];
		if(novo_usuario.usuario[i]=='\0')
		{
			nome_arq[i]='.';
			nome_arq[i+1]='t';
			nome_arq[i+2]='x';
			nome_arq[i+3]='t';
			nome_arq[i+4]='\0';
			break;
		}
	}
	pont_arq = fopen(nome_arq, "w");// Cria o arquivo txt de nome nome_arq a abre em modo de escrita.
	if(pont_arq == NULL)
	{
		fclose(pont_arq);// Fecha o arquivo.
		return 1;// Não foi possível criar o arquivo.
	}
	else
	{
		// Salva no arquivo o novo usuário, a senha e a quantidade de senhas salvas.
		fprintf(pont_arq, "%s|", novo_usuario.usuario);
		for(i=0;i<tamanho_senha;i++)
		{
			if(novo_usuario_cript.senha[i]<10)
			{
				fprintf(pont_arq, "00%d", novo_usuario_cript.senha[i]);	
			}
			else if(novo_usuario_cript.senha[i]<100)
			{
				fprintf(pont_arq, "0%d", novo_usuario_cript.senha[i]);
			}
			else
			{
				fprintf(pont_arq, "%d", novo_usuario_cript.senha[i]);
			}
		}
		fprintf(pont_arq, "|\n%s", "0");
		fclose(pont_arq);// Fecha o arquivo.
		return 0;// Arquivo criado e usuário salvo com sucesso.
	}
}
// Ler o usuário e senha de um arquivo txt.
UsuarioCript dao_usuario_ler(Usuario usuario)
{
	int i, j=0, h=0, m=0, aux=0;// Contadores.
	FILE *pont_arq;// Ponteiro para arquivo.
	char nome_arq[33], usuario_arq[233], int_str[3];
	// Faz a concatenação do nome do usuário com o ".txt".
	for(i=0;i<33;i++)
	{
		nome_arq[i]=usuario.usuario[i];
		if(usuario.usuario[i]=='\0')
		{
			nome_arq[i]='.';
			nome_arq[i+1]='t';
			nome_arq[i+2]='x';
			nome_arq[i+3]='t';
			nome_arq[i+4]='\0';
			break;
		}
	}
	pont_arq = fopen(nome_arq, "rt");// Abre o arquivo txt de nome nome_arq em modo de leitura.
	if (pont_arq == NULL)
	{
		UsuarioCript usuario_cript_return;
		usuario_cript_return.senha[0] = 1;
		fclose(pont_arq);// Fecha o arquivo.
		return usuario_cript_return;// Não foi possível ler usuário.
	}
	else
	{// Usuário encontrado/existe.
    	fscanf(pont_arq, "%s", &usuario_arq);
    	Usuario usuario_return;
    	UsuarioCript usuario_cript_return;
    	for(i=0;i<=233;i++)
		{
    		if(aux==0)
			{
				if(usuario_arq[i]=='|')
				{
					aux=1;
					usuario_return.usuario[i]='\0';
				}
				else
				{
					usuario_return.usuario[i]=usuario_arq[i];
				}
			}
			else
			{
				if(usuario_arq[i]=='|')
				{
					break;
				}
				else
				{
					int_str[h] = usuario_arq[i];
					h++;
					if(h==3)
					{
						h=0;
						usuario_cript_return.senha[m] = atoi(int_str);
						m++;
					}
					j++;	
				}
			}
		}
		fclose(pont_arq);// Fecha o arquivo.
		return usuario_cript_return;
	}	
}
// Salva uma nova senha no arquivo txt de mesmo nome do usuário.
// Senhas
int dao_senhas_salvar(Senhas nova_senha, Senhas senhas[], SenhasCript senhas_cript[], int quant_senhas)
{
	int i, j;// Contador.
	FILE *pont_arq;// Ponteiro para arquivo.
	char carac_str[3];
	char nome_arq[33];// Nome do arquivo txt do usuário.
	char quant_senhas_str[3];
	char carac_cript[3];
	int tamanho_usuario_senha = strlen(nova_senha.usuario_senhas.senha);
	int tamanho_senhas_nome_salvo;
	int tamanho_senhas_senha_salva;
	//Faz a concatenação do nome do usuário com o ".txt".
	for(i=0;i<33;i++)
	{
		nome_arq[i]=nova_senha.usuario_senhas.usuario[i];
		if(nova_senha.usuario_senhas.usuario[i]=='\0')
		{
			nome_arq[i]='.';
			nome_arq[i+1]='t';
			nome_arq[i+2]='x';
			nome_arq[i+3]='t';
			nome_arq[i+4]='\0';
			break;
		}
	}
	pont_arq = fopen(nome_arq, "w");// Cria o arquivo txt de nome nome_arq a abre em modo de escrita.
	if (pont_arq == NULL)
	{
    	return 1;// Senha não salva com sucesso.
	}
	else// Salvar no arquivo txt o Usuário e a senha desse[a], a nova senha junto com as já existentes (se houverem) e os identificadores dessas.	
	{	
		fprintf(pont_arq, "%s|", nova_senha.usuario_senhas.usuario);
		for(i=0;i<tamanho_usuario_senha;i++)
		{
			if(senhas_cript[quant_senhas-1].usuario_senhas.senha[i]<10)
			{
				fprintf(pont_arq, "00%d", senhas_cript[quant_senhas-1].usuario_senhas.senha[i]);
			}
			else if(senhas_cript[quant_senhas-1].usuario_senhas.senha[i]<100)
			{
				fprintf(pont_arq, "0%d", senhas_cript[quant_senhas-1].usuario_senhas.senha[i]);
			}
			else
			{
				fprintf(pont_arq, "%d", senhas_cript[quant_senhas-1].usuario_senhas.senha[i]);
			}
		}
		fprintf(pont_arq, "|\n%d\n", quant_senhas);
		for(j=0;j<quant_senhas;j++)
		{
			tamanho_senhas_nome_salvo = strlen(senhas[j].nome_salvo);
			tamanho_senhas_senha_salva = strlen(senhas[j].senha_salva);
			
			for(i=0;i<tamanho_senhas_nome_salvo;i++)
			{
				if(senhas_cript[j].nome_salvo[i]<10)
				{
					fprintf(pont_arq, "00%d", senhas_cript[j].nome_salvo[i]);
				}
				else if(senhas_cript[j].nome_salvo[i]<100)
				{
					fprintf(pont_arq, "0%d", senhas_cript[j].nome_salvo[i]);
				}
				else
				{
					fprintf(pont_arq, "%d", senhas_cript[j].nome_salvo[i]);
				}
			}
			fprintf(pont_arq, "|");	
			for(i=0;i<tamanho_senhas_senha_salva;i++)
			{
				if(senhas_cript[j].senha_salva[i]<10)
				{
					fprintf(pont_arq, "00%d", senhas_cript[j].senha_salva[i]);
				}
				else if(senhas_cript[j].senha_salva[i]<100)
				{
					fprintf(pont_arq, "0%d", senhas_cript[j].senha_salva[i]);
				}
				else
				{
					fprintf(pont_arq, "%d", senhas_cript[j].senha_salva[i]);
				}	
			}
			fprintf(pont_arq, "|\n");
		}
	}	
	fclose(pont_arq);// Fecha o arquivo.
	return 0;
}
// Ler os identificadores e as senhas do arquivo txt.	
SenhasCript dao_senhas_ler(Usuario usuario, int index)
{
	int i, n, j, m=0, h=0, aux=0;// Contadores
	char nome_arq[33], quant_senhas_arq[3], usuario_arq[233];
	int quant_senhas;
	char int_str[3];
	FILE *pont_arq;
	// Faz a concatenação do nome do usuário com o ".txt".
	for(i=0;i<33;i++)
	{
		nome_arq[i]=usuario.usuario[i];
		if(usuario.usuario[i]=='\0')
		{
			nome_arq[i]='.';
			nome_arq[i+1]='t';
			nome_arq[i+2]='x';
			nome_arq[i+3]='t';
			nome_arq[i+4]='\0';
			break;
		}
	}
	pont_arq = fopen(nome_arq, "rt");
	if (pont_arq == NULL)
	{
		SenhasCript senhas_cript_return[1];
		senhas_cript_return[0].nome_salvo[0] = 1;
		fclose(pont_arq);// Fecha o arquivo.
		return senhas_cript_return[0];// Não foi possível ler senhas.
	}
	else
	{
		fscanf(pont_arq, "%s\n", &usuario_arq);
		fscanf(pont_arq, "%s\n", &quant_senhas_arq);
		quant_senhas=atoi(quant_senhas_arq);
		SenhasCript senhas_cript_return;
		char senhas_arq[233];
		for(n=0;n<=index;n++)
		{
			fscanf(pont_arq, "%s\n", &senhas_arq);
		}
			for(i=0;i<433;i++)
			{
				if(aux==0)
				{
				    if(senhas_arq[i]=='|')
					{
				    	aux=1;
				    	m=0;
				    	h=0;
					}
					else
					{
						int_str[h] = senhas_arq[i];
						h++;
						if(h==3)
						{
							h=0;
							senhas_cript_return.nome_salvo[m]=atoi(int_str);
							m++;
						}	
					}	
				}
				else
				{
					if(senhas_arq[i]=='|')
					{
				    	break;
					}
					else
					{
						int_str[h] = senhas_arq[i];
						h++;
						if(h==3)
						{
							h=0;
							senhas_cript_return.senha_salva[m]=atoi(int_str);
							m++;
						}
					}
				}
			}
		fclose(pont_arq);// Fecha o arquivo.
		return senhas_cript_return;
	}
}
// Utéis.
// Retorna a quantidade de senhas salvas no arquivo txt.
int dao_retorna_quant_senhas(Usuario usuario)
{
	int i;// Contador
	int quant_senhas;// Quantidade de senhas.
	char nome_arq[33], quant_senhas_arq[3], usuario_arq[233];
	FILE *pont_arq;
	// Faz a concatenação do nome do usuário com o ".txt".
	for(i=0;i<33;i++)
	{
		nome_arq[i]=usuario.usuario[i];
		if(usuario.usuario[i]=='\0')
		{
			nome_arq[i]='.';
			nome_arq[i+1]='t';
			nome_arq[i+2]='x';
			nome_arq[i+3]='t';
			nome_arq[i+4]='\0';
			break;
		}
	}
	pont_arq = fopen(nome_arq, "rt");// Abre o arquivo txt de nome nome_arq em modo de leitura.
	fscanf(pont_arq, "%s\n", &usuario_arq);
	fscanf(pont_arq, "%s", &quant_senhas_arq);
	quant_senhas=atoi(quant_senhas_arq);
	fclose(pont_arq);// Fecha
	return quant_senhas;
}
