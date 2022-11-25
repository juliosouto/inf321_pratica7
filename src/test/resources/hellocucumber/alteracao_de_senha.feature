#language:pt
#encoding:utf-8

# Alteração de senha
# Dado, Quando, Então, E, Mas (Passos)


@AlterarSenha
Funcionalidade: Quero alterar senha.
  Como usuário do site
  Toni precisa alterar a senha

  Contexto:
    Dado que "Toni" possui uma conta com senha fraca.

  @negativo @AlterarNovaSenha
  Cenário: Senha é menor que 8 caracteres
    Dado senha é escrita
    Quando a senha menor que 8 caracteres
    Então Devo receber mensagem de erro "Invalid password"

  @negativo @AlterarNovaSenha
  Cenário: Senha atual é preenchida e a nova senha vazia
    Dado a senha nova não é escrita
    Quando a senha nova for vazia
    Então Devo receber mensagem de erro "Please provide a new password"

  Cenário: A senha não bate
    Dado que as duas senhas não batem
    Quando a senha nova não bate com a confirmação
    Então Devo receber mensagem de erro ""

  Cenário: A senha atual é vazia
    Dado quando a senha atual é vazia
    Quando a senha atual não for escrita
    Então Devo recebe mensagem de erro "Please provide your current password"
