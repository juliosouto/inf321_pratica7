#language:pt
#encoding:UTF-8

@Login
Funcionalidade: Realizar Login
  Como usuário cadastrado na aplicação
  "Daniel" deseja realizar o login
  Para que ele acesse sua conta

  Contexto:
    Dado que "Daniel" está cadastrado na aplicação
    E que ele acessou o caminho My Account -> Sign In

  @invalid @fast @priority:high
  Esquema do Cenário:
    Quando Daniel tenta logar com "<username>" e com "<password>"
    Então a aplicacao deve exibir uma mensagem de credenciais invalidas
    E o valor do "<resultado>" deve ser invalido

    @invalid-credentials
    Exemplos:
      | username        | password     |  resultado |
      | Joao@teste.com  | teste123     |  invalido  |
      | teste@123.com   | senhaErrada  |  invalido  |

  Esquema do Cenário: Realizar login de usuário cadastrado
    Quando Joao digitar corretamente as credenciais "<username>" e "<password>":
    Então a aplicação deve exibir corretamente o "<primeiroNome>" e carrinho conforme ultimo estado
    E o "<resultado>" deve ser logado

    @valid-credential
    Exemplos:
      | username          | password     |  primeiroNome  | resultado |
      | teste_t@123.com   | teste123     |  Teste         | logado    |
