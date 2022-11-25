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
  Cenário: Senha é menor que 8 caracteres
    Dado senha é escrita
    Quando a "<senha>" menor que 8 caracteres
    E senha de confirmação "<senha_confirmacao>" batem
    Então Devo receber mensagem de erro "<resultado>"
    Exemplos:
      | senha   | senha_confirmacao | resultado                    |
      | 1234567 | 1234567           | Senha menor que 8 caracteres |

  @negativoSenhaVazia @AlterarNovaSenha
  Cenário: Senha atual é preenchida e a nova senha vazia
    Dado a senha nova não é escrita
    Quando a "<senha>" nova for vazia
    Então Devo receber mensagem de erro "<resultado>"
    Exemplos:
      | senha | senha_confirmacao | resultado   |
      |       | 1234567           | Senha vazia |

  @negativoSenhaConfirmacao @AlterarNovaSenha
  Cenário: A senha não bate
    Dado que as duas senhas não batem
    Quando a "<senha>" nova não bate com a confirmação
    E senha de confirmação "<senha_confirmacao>" não batem
    Então Devo receber mensagem de erro "<resultado>"
    Exemplos:
      | senha    | senha_confirmacao | resultado                     |
      | 87654321 | 12345678          | Senha de confirmação não bate |
