#language:pt
#encoding:UTF-8

@Login
Funcionalidade: Realizar Login
  Como usuário cadastrado na aplicação
  "João" deseja realizar o login
  Para que ele acesse sua conta

  Contexto:
    Dado que "João" está cadastrado na aplicação
    E que ele acessou o caminho My Account -> Sign In

  @invalid @fast @priority:high
  Esquema do Cenário:
    Quando João tenta logar com "<username>" e com "<password>"
    Então a aplicacao deve receber uma mensagem de credenciais invalidas

    @invalid-credentials
    Exemplos:
      | username       | password    |
      | Joao@teste.com | teste123    |
      | teste@123.com  | senhaErrada |

  Esquema do Cenário: Realizar login de usuário cadastrado
    Quando Joao digitar corretamente as credenciais "<username>" e "<password>":
    Então a aplicação deve exibir corretamente o "<primeiroNome>" e carrinho conforme ultimo estado

    @valid-credential
    Exemplos:
      | username      | password | primeiroNome |
      | teste@123.com | teste123 | Teste        |
