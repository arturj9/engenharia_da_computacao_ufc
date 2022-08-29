// Bibliotecas.
#include <stdio.h>
#include <locale.h>
#include "controller.h"
// Arquitetura utilizada: MVC.
// View: "front-end" do projeto.
void main(void)
{
	// Configura��es b�sicas.
	setlocale(LC_ALL,"Portuguese");// Incrementando os caracteres da L�ngua Portuguesa.
	system("color 6F");// Personalizando as cores da tela de fundo e da fonte.
	// Vari�veis.
	char decisao, voltar; //decisao <- escolha do menu, voltar <- sair da tela de visualiza��o de senhas. 
	int result, quant_senhas, i;// result <- retorno de fun��es, quant_senhas <- quantidade de senhas salvas, i <- contador.
	Usuario usuario; // Estrutura fornecida pelo usu�rio.
	Senhas senha;// Estrutura fornecida pelo usu�rio.
	// La�os de repetica��o em conjunto com o "cls" s�o utilizados para promover o efeito de "redenriza��o" e dinamismo entre telas.
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
		printf("\n\t\tEscolha uma op��o:\n");
		printf("\n\t\t[1] - Cadastrar-se\n");
		printf("\t\t[2] - Logar\n");
		printf("\t\t[3] - Sair\n\n");
		printf("\t\tR: ");
		scanf(" %c", &decisao); // De acordo com o valor, ocorre o redirecionamento para tela espec�fica.
		// Cadastrar-se.
		if(decisao=='1')
		{ 
			system("cls");// Limpar tela.
			// Tela de cadastro de usu�rio.
			// Palavra: "CADASTRAR-SE".
			puts("\t   ____      _      ____       _      ____    _____   ____       _      ____            ____    _____ ");
			puts("\t  / ___|    / \\    |  _ \\     / \\    / ___|  |_   _| |  _ \\     / \\    |  _ \\          / ___|  | ____|");
			puts("\t | |       / _ \\   | | | |   / _ \\   \\___ \\    | |   | |_) |   / _ \\   | |_) |  _____  \\___ \\  |  _|  ");
			puts("\t | |___   / ___ \\  | |_| |  / ___ \\   ___) |   | |   |  _ <   / ___ \\  |  _ <  |_____|  ___) | | |___ ");
			puts("\t  \\____| /_/   \\_\\ |____/  /_/   \\_\\ |____/    |_|   |_| \\_\\ /_/   \\_\\ |_| \\_\\         |____/  |_____|");                                                                                
			puts("\n\t\t\t\t\tPara sair do programa: Aperte ctrl+c");
			printf("\n\n\t\t\t\t\tUsu�rio: ");
			scanf(" %s",usuario.usuario);// Novo usu�rio.
			printf("\t\t\t\t\tSenha: ");
			scanf(" %s",usuario.senha);// Nova senha para usu�rio.
			// Verificando cadastro de usu�rio.
			if(controller_usuario_autenticar(usuario)!=1)
			{
				system("cls");// Limpar tela.
				puts("\n\t\t\t\t\t<----------Usu�rio j� existe---------->");
			}
			else
			{
				result = controller_usuario_cadastrar(usuario);
				system("cls");// Limpar tela.
				if(result==0)
				{
					puts("\n\t\t\t\t\t<----------Usu�rio cadastrado com sucesso!---------->");
				}
				else
				{
					puts("\n\t\t\t\t\t<----------N�o foi poss�vel cadastrar usu�rio---------->");
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
			printf("\n\n\t\t\t\t\tUsu�rio: ");
			scanf(" %s",usuario.usuario);// Usu�rio.
			printf("\t\t\t\t\tSenha: ");
			scanf(" %s",usuario.senha);// Senha de usu�rio.
			// Autentica��o de usu�rio.
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
					puts("\n\t\t\t\tEscolha uma op��o:");
					puts("\n\t\t\t\t[1] - Cadastrar senha");
					puts("\t\t\t\t[2] - Visualizar senhas");
					puts("\t\t\t\t[3] - Sair\n\n");
					printf("\t\t\t\tR: ");
					scanf(" %c", &decisao);
					// Cadastrar nova senha.
					if(decisao=='1')
					{
						printf("\t\t\t\tIndentifica��o da senha (ex.: Netflix): ");
						scanf(" %s",senha.nome_salvo);// Indentifica��o da senha.
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
							puts("\n\t\t\t\t\t<----------N�o foi poss�vel cadastrar senha---------->");
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
							// Formata��o de senhas para "printar".
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
					// Valor inv�lido.
					}
					else
					{
						system("cls");// Limpar tela.
						puts("\n\t\t\t\t\t<----------Digite uma op��o v�lida---------->\n");
					}
				}
			}
			else
			{
				system("cls");// Limpar tela.
				puts("\n\t\t\t\t\t<----------Usu�rio e/ou senha inv�lidos---------->\n");
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
		// Op��o inv�lida.
		}
		else
		{
			system("cls");// Limpar tela.
			puts("\n\t\t\t\t\t<----------Digite uma op��o v�lida---------->");
		}
	}
	system("pause");
}


