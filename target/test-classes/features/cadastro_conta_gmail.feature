#language: pt

Funcionalidade: Cadastrar Conta Gmail
	
	Cenário:
			Dado uma página que gera dados fictícios de pessoas, como o "https://www.fakenamegenerator.com/" e armazene essas informações
			E Com os dados armazenados, tentar se cadastrar no gmail
			E Preencher o número de telefone com dado inválido
			Então Validar mensagem de erro de retorno