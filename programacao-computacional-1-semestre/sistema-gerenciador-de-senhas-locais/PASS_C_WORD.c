// Bibliotecas.
#include <stdio.h>
#include <locale.h>
#include "controller.h"
// Arquitetura utilizada: MVC.
// View: "front-end" do projeto.
void main(void)
{
	// Configurações básicas.
	setlocale(LC_ALL,"Portuguese");// Incrementando os caracteres da Língua Portuguesa.
	system("color 6F");// Personalizando as cores da tela de fundo e da fonte.
	// Variáveis.
	char decisao, voltar; //decisao <- escolha do menu, voltar <- sair da tela de visualização de senhas. 
	int result, quant_senhas, i;// result <- retorno de funções, quant_senhas <- quantidade de senhas salvas, i <- contador.
	Usuario usuario; // Estrutura fornecida pelo usuário.
	Senhas senha;// Estrutura fornecida pelo usuário.
	// Laços de repeticação em conjunto com o "cls" são utilizados para promover o efeito de "redenrização" e dinamismo entre telas.
	while(1)
	{
		// Nome do programa: "PASS_C_WORD".
		printf("\t	 ____       _      ____    ____             ____          __        __   ___    ____    ____  \n");
		printf("\t	|  _ \\     / \\    / ___|  / ___|           / ___|         \\ \\      / /  / _ \\  |  _ \\  |  _ \\ \n");
		printf("\t	| |_) |   / _ \\   \\___ \\  \\___ \\          | |              \\ \\ /\\ / /  | | | | | |_) | | | | |\n");
		printf("\t	|  __/   / ___ \\   ___) |  ___) |         | |___            \\ V  V /   | |_| | |  _ <  | |_| |\n");
		printf("\t	|_|     /_/   \\_\\ |____/  |____/   _____   \\____|  _____     \\_/\\_/     \\___/  |_| \\_\\ |____/ \n");
	    printf("\t                    			  |_____|         |_____|                                     \n");
		// Menu tela inicial.
		printf("\n\t\tEscolha uma opção:\n");
		printf("\n\t\t[1] - Cadastrar-se\n");
		printf("\t\t[2] - Logar\n");
		printf("\t\t[3] - Sair\n\n");
		printf("\t\tR: ");
		scanf(" %c", &decisao); // De acordo com o valor, ocorre o redirecionamento para tela específica.
		// Cadastrar-se.
		if(decisao=='1')
		{ 
			system("cls");// Limpar tela.
			// Tela de cadastro de usuário.
			// Palavra: "CADASTRAR-SE".
			puts("\t   ____      _      ____       _      ____    _____   ____       _      ____            ____    _____ ");
			puts("\t  / ___|    / \\    |  _ \\     / \\    / ___|  |_   _| |  _ \\     / \\    |  _ \\          / ___|  | ____|");
			puts("\t | |       / _ \\   | | | |   / _ \\   \\___ \\    | |   | |_) |   / _ \\   | |_) |  _____  \\___ \\  |  _|  ");
			puts("\t | |___   / ___ \\  | |_| |  / ___ \\   ___) |   | |   |  _ <   / ___ \\  |  _ <  |_____|  ___) | | |___ ");
			puts("\t  \\____| /_/   \\_\\ |____/  /_/   \\_\\ |____/    |_|   |_| \\_\\ /_/   \\_\\ |_| \\_\\         |____/  |_____|");                                                                                
			puts("\n\t\t\t\t\tPara sair do programa: Aperte ctrl+c");
			printf("\n\n\t\t\t\t\tUsuário: ");
			scanf(" %s",usuario.usuario);// Novo usuário.
			printf("\t\t\t\t\tSenha: ");
			scanf(" %s",usuario.senha);// Nova senha para usuário.
			// Verificando cadastro de usuário.
			if(controller_usuario_autenticar(usuario)!=1)
			{
				system("cls");// Limpar tela.
				puts("\n\t\t\t\t\t<----------Usuário já existe---------->");
			}
			else
			{
				result = controller_usuario_cadastrar(usuario);
				system("cls");// Limpar tela.
				if(result==0)
				{
					puts("\n\t\t\t\t\t<----------Usuário cadastrado com sucesso!---------->");
				}
				else
				{
					puts("\n\t\t\t\t\t<----------Não foi possível cadastrar usuário---------->");
				}
			}
		// Logar.
		}
		else if(decisao=='2')
		{
			system("cls");// Limpar tela.
			// Tela de login.
			// Palavra: "LOGIN".
			puts("\t\t\t\t\t  _        ___     ____   ___   _   _ ");
			puts("\t\t\t\t\t | |      / _ \\   / ___| |_ _| | \\ | |");
			puts("\t\t\t\t\t | |     | | | | | |  _   | |  |  \\| |");
			puts("\t\t\t\t\t | |___  | |_| | | |_| |  | |  | |\\  |");
			puts("\t\t\t\t\t |_____|  \\___/   \\____| |___| |_| \\_|");                    
			puts("\n\t\t\t\t\tPara sair do programa: Aperte ctrl+c");
			printf("\n\n\t\t\t\t\tUsuário: ");
			scanf(" %s",usuario.usuario);// Usuário.
			printf("\t\t\t\t\tSenha: ");
			scanf(" %s",usuario.senha);// Senha de usuário.
			// Autenticação de usuário.
			result = controller_usuario_autenticar(usuario);
			if(result==0)
			{
				system("cls");// Limpar tela.
				// Tela "logado".
				// Palavra: "LOGADO".
				while(1)
				{
					puts("\n\t\t\t\t _        ___     ____      _      ____     ___  		");
					puts("\t\t\t\t| |      / _ \\   / ___|    / \\    |  _ \\   / _ \\ 	");
					puts("\t\t\t\t| |     | | | | | |  _    / _ \\   | | | | | | | |		");
					puts("\t\t\t\t| |___  | |_| | | |_| |  / ___ \\  | |_| | | |_| |		");
					puts("\t\t\t\t|_____|  \\___/   \\____| /_/   \\_\\ |____/   \\___/ ");                          
					//Menu tela "logado".
					puts("\n\t\t\t\tEscolha uma opção:");
					puts("\n\t\t\t\t[1] - Cadastrar senha");
					puts("\t\t\t\t[2] - Visualizar senhas");
					puts("\t\t\t\t[3] - Sair\n\n");
					printf("\t\t\t\tR: ");
					scanf(" %c", &decisao);
					// Cadastrar nova senha.
					if(decisao=='1')
					{
						printf("\t\t\t\tIndentificação da senha (ex.: Netflix): ");
						scanf(" %s",senha.nome_salvo);// Indentificação da senha.
						printf("\t\t\t\tInforme a senha: ");
						scanf(" %s",senha.senha_salva);// Nova senha.
						senha.usuario_senhas=usuario;
						result = controller_senha_cadastrar(senha);// Cadastrando nova senha.
						if(result==0)
						{
							system("cls");// Limpar tela.	
							puts("\n\t\t\t\t<----------Senha cadastrada com sucesso!---------->");
						}
						else
						{
							system("cls");// Limpar tela.
							puts("\n\t\t\t\t\t<----------Não foi possível cadastrar senha---------->");
						}
					// Visualizar senhas.
					}
					else if(decisao=='2')
					{
						system("cls");// Limpar tela.
						quant_senhas = dao_retorna_quant_senhas(usuario);
						Senhas senhas;
						for(i=0;i<quant_senhas;i++){
							senhas = controller_senhas_ler(usuario,1);// Lendo senhas de arquivo txt.
						}
						if(senhas.nome_salvo[0]=='|')
						{
							system("cls");// Limpar tela.
							puts("\n\t\t\t\t\t<----------Erro ao ler senhas---------->");
						}
						else
						{
							system("cls");// Limpar tela.
							printf("\n");
							// Palavra: "SENHAS".
							puts("\n\t\t\t\t  ____    _____   _   _   _   _      _      ____  ");
							puts("\t\t\t\t / ___|  | ____| | \\ | | | | | |    / \\    / ___| ");
							puts("\t\t\t\t \\___ \\  |  _|   |  \\| | | |_| |   / _ \\   \\___ \\ ");
							puts("\t\t\t\t  ___) | | |___  | |\\  | |  _  |  / ___ \\   ___) |");
							puts("\t\t\t\t |____/  |_____| |_| \\_| |_| |_| /_/   \\_\\ |____/ \n\n");              
							// Formatação de senhas para "printar".
							puts("\t\t\t\t----Identificador \t\t\t Senha----\n");
							for(i=0;i<quant_senhas;i++){
								senhas = controller_senhas_ler(usuario,i);// Lendo senhas de arquivo txt.
								printf("\t\t\t\t\t\t%s \t %s\n", senhas.nome_salvo, senhas.senha_salva);
							}						
							printf("\n\n\n\t\t\tAperte s para sair: ");
							scanf(" %c", &voltar); // Sair de tela de senhas
							system("cls");// Limpar tela.
						}
					// Sair de tela de login.
					}
					else if(decisao=='3')
					{
						system("cls");// Limpar tela.
						break;
					// Valor inválido.
					}
					else
					{
						system("cls");// Limpar tela.
						puts("\n\t\t\t\t\t<----------Digite uma opção válida---------->\n");
					}
				}
			}
			else
			{
				system("cls");// Limpar tela.
				puts("\n\t\t\t\t\t<----------Usuário e/ou senha inválidos---------->\n");
			}
		// Saindo
		}
		else if(decisao=='3')
		{ 
			system("cls");// Limpar tela.
			// Palavra: "Saindo".
			puts("\t\t\t\t  ____            _               _                     ");
			puts("\t\t\t\t / ___|    __ _  (_)  _ __     __| |   ___              ");
			puts("\t\t\t\t \\___ \\   / _` | | | | '_ \\   / _` |  / _ \\             ");
			puts("\t\t\t\t  ___) | | (_| | | | | | | | | (_| | | (_) |  _   _   _ ");
			puts("\t\t\t\t |____/   \\__,_| |_| |_| |_|  \\__,_|  \\___/  (_) (_) (_)");                                        
			break;
		// Opção inválida.
		}
		else
		{
			system("cls");// Limpar tela.
			puts("\n\t\t\t\t\t<----------Digite uma opção válida---------->");
		}
	}
	system("pause");
}


