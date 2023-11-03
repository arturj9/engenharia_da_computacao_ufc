class Token:
    def __init__(self, nome, formato, significado=None):
        self.nome = nome
        self.formato = formato
        self.ignorar = False
        self.significado = significado
    
    def __str__(self):
        return self.nome
    
    def verifica_lexema(self, index, expressao):
        if expressao.startswith(self.formato, index):
            return True
        return False
    
    def get_lexema(self, index, expressao):
        if self.verifica_lexema(index, expressao):
            return self.formato
        return False

class Lexema:
    def __init__(self, valor, token):
        self.valor = valor
        self.token = token
    
    def __str__(self):
        return f'Lexema: {self.valor} | Token: {self.token}'
    
    def get_significado(self):
        if self.token.significado:
            return self.token.significado
        return self.valor

class Verdadeiro(Token):
    def __init__(self):
        super().__init__('VERDADEIRO', 'True', ' verdadeiro ')
    
    def verifica_lexema(self, index, expressao):
        if expressao.startswith(self.formato, index):
            if index+len(self.formato)==len(expressao):
                return True
            next_caractere:str = expressao[index+len(self.formato)]
            if not(next_caractere.isalnum() or next_caractere.isalpha()):
                return True
        return False

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
        self.tokens = [Token(nome, formato, significado) for nome, formato, significado in self.TOKENS]
        self.tokens.append(Comentario())
        self.tokens.append(Espaco())
        self.tokens.append(Verdadeiro())
        self.tokens.append(Falso())
        self.tokens.append(Identificador())
        self.tokens.append(QuebraLinha())

    def __new__(cls):
        if not hasattr(cls, 'instance'):
            cls.instance = super(Tokens, cls).__new__(cls)
        return cls.instance

    def __repr__(self):
        return self.tokens

    def __str__(self):
        return '\n'.join(str(token) for token in self.tokens)

class AnalisadorLexico:
    def __init__(self):
        self.tokens = Tokens()
        self.lexemas = []

    def __set_expressao(self, expressao):
        self.index = 0
        if expressao:
            self.expressao = expressao
        else:
            self.expressao = open('entrada.in', 'r').read()
    
    def analise(self, expressao:str=None):
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
        text = ''
        for lexema in self.lexemas:
            text += lexema.__str__()+'\n'
        return text
    
    def get_expressao_significado(self):
        text = ''
        for lexema in self.lexemas:
            if isinstance(lexema.token, Desconhecido):
                return 'Há elementos desconhecidos fornecidos, corrija para obter o significado da expressão lógica.'
            text += lexema.get_significado()+' '
        return text
    
    def get_relatorio(self):
        text='========== Relatório de Analisador Léxico ==========\n\n'
        text+=f'========== Expressão Lógica ==========\n\n{self.expressao}'
        text+=f'\n\n========== Significado da Expressão Lógica ==========\n\n{self.get_expressao_significado()}'
        text+=f'\n\n========== Relação de Lexemas e Tokens ==========\n\n{self.list_lexemas_str()}'
        return text