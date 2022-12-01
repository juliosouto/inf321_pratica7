#language:pt
#encoding:utf-8

# Alteracao de senha
# Dado, Quando, Então

@AlterarSenha
Funcionalidade: Quero alterar senha.
  Como usuário do site
  Toni precisa alterar a senha

  Contexto:
    Dado que "Toni" possui uma conta com senha fraca.

  @negativoSenhaTamanho @AlterarNovaSenha
  Esquema do Cenário: Senha é menor que 6 caracteres
    Dado senha é escrita
    Quando a "<senha>" menor que 6 caracteres
    E senha de confirmação "<senha_confirmacao>" batem
    Então Devo receber mensagem de erro "<resultado>"
    Exemplos:
      | senha | senha_confirmacao | resultado                              |
      | 12345 | 12345             | Password must be at least 6 characters |

  @negativoSenhaVazia @AlterarNovaSenha
  Esquema do Cenário: Senha atual é preenchida e a nova senha vazia
    Dado a senha nova não é escrita
    Quando a "<senha>" nova for vazia
    Então Devo receber mensagem de erro "<resultado>"
    Exemplos:
      | senha | senha_confirmacao | resultado                     |
      |       | 1234567           | Please provide a new password |

  @negativoSenhaConfirmacao @AlterarNovaSenha
  Esquema do Cenário: A senha não bate
    Dado que as duas senhas não batem
    Quando a "<senha>" nova não bate com a confirmação
    E senha de confirmação "<senha_confirmacao>" não batem
    Então Devo receber mensagem de erro "<resultado>"
    Exemplos:
      | senha    | senha_confirmacao | resultado                |
      | 87654321 | 12345678          | Both password must match |
