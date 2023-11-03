from controller import AnalisadorLexico

expressao = 'True * Falsee'

analisador_lexico = AnalisadorLexico()
analisador_lexico.analise()
# O método pega a expressão do arquivo entrada.in se não for passado uma expressão como argumento.
# analisador_lexico.analise(expressao)
print(analisador_lexico.get_relatorio())
