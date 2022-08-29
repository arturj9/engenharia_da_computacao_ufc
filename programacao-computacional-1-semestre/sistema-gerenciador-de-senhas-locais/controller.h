// Bibliotecas.
#include "dao.h"
#include "criptografia.h"
#include <locale.h>
#include <string.h>
// Controller: responsável pela lógica "pesada".
//Usuario.
// Criptografa senha do novo usuário e cadastrar esse.
int controller_usuario_cadastrar(Usuario novo_usuario)
{
	UsuarioCript novo_usuario_cript;
	int i;// Contador
	for(i=0;i<50;i++)
	{
		if(novo_usuario.senha[i]=='\0')
		{
			break;
		}
		novo_usuario_cript.senha[i] = criptografar(novo_usuario.senha[i]);
	}
	return dao_usuario_salvar(novo_usuario, novo_usuario_cript);
}
// Autentica usuário.
int controller_usuario_autenticar(Usuario usuario)
{
	UsuarioCript usuario_cript;
	usuario_cript = dao_usuario_ler(usuario);
	int i=0;// Contador.
	if(usuario_cript.senha[0]==1)
	{
		return 1;// Usuários diferentes.
	}
	else
	{
		while(1)
		{
			if(usuario.senha[i]=='\0')
			{
				if(usuario.senha[i]!=descriptografar(usuario_cript.senha[i]))
				{
					return 2;// Senhas diferentes.
				}
				break;
			}
			if(usuario.senha[i]!=descriptografar(usuario_cript.senha[i]))
			{
				return 2;// Senhas diferentes.
				break;
			}
			i++;
		}
		return 0;
	}
}	
//Senhas.
// Descripitografa identificadores e senhas salvas no arquivo txt.
Senhas controller_senhas_ler(Usuario usuario, int index)
{
	int i=0, j;// Contador.
	int quant_senhas = dao_retorna_quant_senhas(usuario);
	Senhas senhas;
	SenhasCript senhas_cript;
	int quant_carac_senhas[quant_senhas];
	if(senhas_cript.nome_salvo[0]==1)
	{
		Senhas senha;
		senha.nome_salvo[0]='|';
		return senha;// Erro ao ler senhas.
	}
	else
	{
		senhas_cript = dao_senhas_ler(usuario, index);
		while(1)
		{
			if(senhas_cript.nome_salvo[i]>0&&senhas_cript.nome_salvo[i]<1000)
			{
				senhas.nome_salvo[i] = descriptografar(senhas_cript.nome_salvo[i]);
				i++;
				continue;	
			}
			senhas.nome_salvo[i] = '\0';
			break;
		}
		i=0;
		while(1)
		{
			if(senhas_cript.senha_salva[i]>0&&senhas_cript.senha_salva[i]<1000)
			{
				if(descriptografar(senhas_cript.senha_salva[i]=='-')){
						
				}
				else
				{
					senhas.senha_salva[i] = descriptografar(senhas_cript.senha_salva[i]);
					i++;
					continue;
				}
			}
			senhas.senha_salva[i] = '\0';
			break;
		}
	}
	return senhas;
}
// Criptografa inditicador e nova senha; e cadastra esses.
int controller_senha_cadastrar(Senhas nova_senha)
{
	int i, j;// Contadores.
	int quant_senhas;
	quant_senhas = dao_retorna_quant_senhas(nova_senha.usuario_senhas);
	quant_senhas++;
	SenhasCript senhas_cript[quant_senhas];
	Senhas senhas[quant_senhas];
	for(i=0;i<quant_senhas-1;i++)
	{
		senhas_cript[i] = dao_senhas_ler(nova_senha.usuario_senhas, i);
		senhas[i] = controller_senhas_ler(nova_senha.usuario_senhas, i);
	}
	for(i=0;i<50;i++)
	{
		if(nova_senha.nome_salvo[i]=='\0')
		{
			senhas[quant_senhas-1].nome_salvo[i] = '\0';
			break;
		}
		senhas_cript[quant_senhas-1].nome_salvo[i] = criptografar(nova_senha.nome_salvo[i]);
		senhas[quant_senhas-1].nome_salvo[i] = nova_senha.nome_salvo[i];
	}
	for(i=0;i<50;i++)
	{
		if(nova_senha.senha_salva[i]=='\0')
		{
			senhas[quant_senhas-1].senha_salva[i]='\0';
			break;
		}
		senhas_cript[quant_senhas-1].senha_salva[i] = criptografar(nova_senha.senha_salva[i]);
		senhas[quant_senhas-1].senha_salva[i] = nova_senha.senha_salva[i];
	}
	for(i=0;i<50;i++)
	{
		if(nova_senha.usuario_senhas.senha[i]=='\0')
		{
			senhas[quant_senhas-1].usuario_senhas.senha[i]='\0';
			break;
		}
		senhas_cript[quant_senhas-1].usuario_senhas.senha[i] = criptografar(nova_senha.usuario_senhas.senha[i]);
		senhas[quant_senhas-1].usuario_senhas.senha[i] = nova_senha.usuario_senhas.senha[i];
	}
	dao_senhas_salvar(nova_senha, senhas, senhas_cript, quant_senhas);
	return 0;
}
