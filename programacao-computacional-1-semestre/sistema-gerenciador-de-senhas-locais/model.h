// Model: Classes/entidades do programa.
// Usuario.
typedef struct
{
	char usuario[30];
	char senha[50];
}Usuario;
// Usuário criptografado.
typedef struct
{
	int senha[50];
}UsuarioCript;
// Senhas.
typedef struct
{
	char nome_salvo[50];
	char senha_salva[50];
	Usuario usuario_senhas;
}Senhas;
// Senhas criptografadas.
typedef struct
{
	int nome_salvo[50];
	int senha_salva[50];
	UsuarioCript usuario_senhas;
}SenhasCript;

