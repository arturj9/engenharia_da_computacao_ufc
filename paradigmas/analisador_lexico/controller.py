# Classe base para representar tokens.
class Token:
    def __init__(self, nome, formato, significado=None):
        """
        Inicializa um token com nome, formato e significado (opcional).

        :param nome: Nome do token (por exemplo, "VERDADEIRO").
        :param formato: Formato do token (por exemplo, "True").
        :param significado: Significado associado ao token (opcional).
        """
        self.nome = nome
        self.formato = formato
        self.ignorar = False # Define se o token deve ser ignorado na análise.
        self.significado = significado # Significado do token (opcional).
    
    def __str__(self):
        """
        Retorna uma representação de string do token (seu nome).
        """
        return self.nome
    
    def verifica_lexema(self, index, expressao):
        """
        Verifica se o token corresponde ao lexema na posição 'index' da expressão.

        :param index: A posição inicial na expressão a ser verificada.
        :param expressao: A expressão a ser analisada.
        :return: True se o token corresponder ao lexema, caso contrário False.
        """
        if expressao.startswith(self.formato, index):
            return True
        return False
    
    def get_lexema(self, index, expressao):
        """
        Obtém o lexema correspondente ao token na posição 'index' da expressão.

        :param index: A posição inicial na expressão a ser verificada.
        :param expressao: A expressão a ser analisada.
        :return: O lexema correspondente se encontrado, caso contrário False.
        """
        if self.verifica_lexema(index, expressao):
            return self.formato
        return False

# Classe para representar lexemas com seus tokens associados.
class Lexema:
    def __init__(self, valor, token):
        """
        Inicializa um lexema com um valor e um token associado.

        :param valor: O valor do lexema.
        :param token: O token associado ao lexema.
        """
        self.valor = valor
        self.token = token
    
    def __str__(self):
        """
        Retorna uma representação de string do lexema e seu token associado.
        """
        return f'Lexema: {self.valor} | Token: {self.token}'
    
    def get_significado(self):
        """
        Obtém o significado associado ao token do lexema, se existir.

        :return: O significado do token ou o valor do lexema se não houver significado.
        """
        if self.token.significado:
            return self.token.significado
        return self.valor

# As classes abaixo herdam de Token e definem tokens específicos.
class Verdadeiro(Token):
    def __init__(self):
        """
        Inicializa um lexema com um valor e um token associado.

        :param valor: O valor do lexema.
        :param token: O token associado ao lexema.
        """
        super().__init__('VERDADEIRO', 'True', ' verdadeiro ')
    
    def verifica_lexema(self, index, expressao):
        """
        Verifica lexemas específicos para o token VERDADEIRO.

        :param index: A posição inicial na expressão a ser verificada.
        :param expressao: A expressão a ser analisada.
        :return: True se o lexema corresponder ao token VERDADEIRO, caso contrário False.
        """
        if expressao.startswith(self.formato, index):
            if index+len(self.formato)==len(expressao):
                return True
            next_caractere:str = expressao[index+len(self.formato)]
            if not(next_caractere.isalnum() or next_caractere.isalpha()):
                return True
        return False

# As outras classes para tokens: Falso, Comentario, Espaco, Identificador, QuebraLinha e Desconhecido seguem uma estrutura semelhante.
class Falso(Token):
    def __init__(self):
        super().__init__('FALSO', 'False', 'falso')
    
    def verifica_lexema(self, index, expressao):
        if expressao.startswith(self.formato, index):
            if index+len(self.formato)==len(expressao):
                return True
            next_caractere:str = expressao[index+len(self.formato)]
            if not(next_caractere.isalnum() or next_caractere.isalpha()):
                return True
        return False
        
class Comentario(Token):
    def __init__(self):
        super().__init__('COMENTARIO', '\\')
        self.ignorar = True
    
    def get_lexema(self, index, expressao):
        if self.verifica_lexema(index, expressao):
            if expressao.find('\n', index) == -1:
                return expressao[index:]
            return expressao[index:expressao.find('\n', index)]
        return False
    
class Espaco(Token):
    def __init__(self):
        super().__init__('ESPACO', ' ')
        self.ignorar = True

class Identificador(Token):
    def __init__(self):
        super().__init__('IDENTIFICADOR', r'[a-zA-Z][a-zA-Z0-9]{0,99}')

    def verifica_lexema(self, expressao):
        if len(expressao) < 1 or len(expressao) > 100:
            return False  # O comprimento da expressão está fora do intervalo permitido

        for caractere in expressao[1:]:
            if not (caractere.isalnum() or caractere.isalpha()):
                return False  # Um caractere não é uma letra ou um dígito

        return True
    
    def get_expressao(self, expressao):
        lexema = ''
        for caractere in expressao:
            if not (caractere.isalnum() or caractere.isalpha()):
                break
            lexema+=caractere
        return lexema
    
    def get_lexema(self, index, expressao):
        expressao = self.get_expressao(expressao[index:])
        if self.verifica_lexema(expressao):
            return expressao
        return False

class QuebraLinha(Token):
    def __init__(self):
        super().__init__('QUEBRALINHA', '\n')
        self.ignorar = True

class Desconhecido(Token):
    def __init__(self, valor):
        super().__init__('DESCONHECIDO', valor)
    
    def verifica_lexema(self):
        ...
    
    def get_lexema(self):
        ...

# A classe Tokens cria instâncias de todos os tokens e fornece métodos para analisar a expressão.
class Tokens:
    TOKENS = [
        ('PARENTESE_ABRE', '(', '('),
        ('PARENTESE_FECHA', ')', ')'),
        ('OPERADOR_OU', '+', 'ou'),
        ('OPERADOR_E', '*', 'e'),
        ('IMPLICACAO', '->', 'implica'),
        ('EQUIVALENCIA', '<->', 'se e só se'),
        ('OPERADOR_NEGACAO', '¬', 'não')]

    def __init__(self):
        """
        Inicializa a classe Tokens criando instâncias de todos os tokens definidos.

        Os tokens são armazenados em uma lista.
        """
        self.tokens = [Token(nome, formato, significado) for nome, formato, significado in self.TOKENS]
        self.tokens.append(Comentario())
        self.tokens.append(Espaco())
        self.tokens.append(Verdadeiro())
        self.tokens.append(Falso())
        self.tokens.append(Identificador())
        self.tokens.append(QuebraLinha())

    def __new__(cls):
        """
        Singleton: Garante que exista apenas uma instância da classe Tokens.

        :return: A instância única da classe Tokens.
        """
        if not hasattr(cls, 'instance'):
            cls.instance = super(Tokens, cls).__new__(cls)
        return cls.instance

    def __repr__(self):
        """
        Retorna a lista de tokens.
        """
        return self.tokens

    def __str__(self):
        """
        Retorna uma representação de string de todos os tokens.
        """
        return '\n'.join(str(token) for token in self.tokens)

# A classe AnalisadorLexico analisa expressões usando os tokens definidos.
class AnalisadorLexico:
    def __init__(self):
        self.tokens = Tokens() # Instância de Tokens.
        self.lexemas = []  # Armazena os lexemas reconhecidos.
        self.expressao = None  # A expressão a ser analisada.
        self.index = 0  # Índice da posição atual na expressão.

    def __set_expressao(self, expressao):
        """
        Define a expressão a ser analisada e redefine o índice e os lexemas identificados.

        :param expressao: A expressão a ser analisada.
        """
        self.index = 0
        self.lexemas = []
        if expressao:
            self.expressao = expressao
        else:
            self.expressao = open('entrada.in', 'r').read()
    
    def analise(self, expressao:str=None):
        """
        Analisa a expressão dada em busca de lexemas usando os tokens definidos.

        :param expressao: A expressão a ser analisada (opcional).
        """
        self.__set_expressao(expressao)
        while self.index < len(self.expressao):
            for token in self.tokens.__repr__():
                resposta = token.get_lexema(self.index, self.expressao)
                if resposta:
                    lexema = Lexema(resposta, token)
                    if not token.ignorar:
                        self.lexemas.append(lexema)
                    self.index += len(lexema.valor)
                    break
            if not resposta:
                self.lexemas.append(Lexema(self.expressao[self.index], Desconhecido(self.expressao[self.index])))
                self.index += 1

    def list_lexemas_str(self):
        """
        Retorna uma representação de string dos lexemas reconhecidos.
        """
        text = ''
        for lexema in self.lexemas:
            text += lexema.__str__()+'\n'
        return text
    
    def get_expressao_significado(self):
        """
        Obtém o significado da expressão lógica com base nos lexemas reconhecidos.

        :return: O significado da expressão lógica.
        """
        text = ''
        for lexema in self.lexemas:
            if isinstance(lexema.token, Desconhecido):
                return 'Há elementos desconhecidos fornecidos, corrija para obter o significado da expressão lógica.'
            text += lexema.get_significado()+' '
        return text
    
    def get_relatorio(self):
        """
        Gera um relatório com informações sobre a análise léxica da expressão.

        :return: O relatório completo.
        """
        text='\n========== Relatório de Analisador Léxico ==========\n\n'
        text+=f'========== Expressão Lógica ==========\n\n{self.expressao}'
        text+=f'\n\n========== Significado da Expressão Lógica ==========\n\n{self.get_expressao_significado()}'
        text+=f'\n\n========== Relação de Lexemas e Tokens ==========\n\n{self.list_lexemas_str()}'
        return text