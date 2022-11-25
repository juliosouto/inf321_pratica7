package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private String senha_confirmacao;
    private String actualAnswer;
    private Throwable throwable;
    private String operator;
    private Boolean formFill;

    @E("preencheu o formulário para realizar o cadastrado")
    public void preencheuOFormulárioParaRealizarOCadastrado() {
        this.formFill = true;
    }

    @Dado("que {string} acessou o site da multibags e entrou em Register")
    public void queAcessouOSiteDaMultibagsEEntrouEmRegister(final String name) {
        this.operator = name;
    }

    @Quando("é inserido {string} com {string} com {string} com {string} com {string} com {string} com {string}")
    public void é_inserido_com_com_com_com_com_com(String string, String string2, String string3, String string4,
            String string5, String string6, String string7) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("string = " + string + ", string2 = " + string2 + ", string3 = " + string3 + ", string4 = "
                + string4 + ", string5 = " + string5 + ", string6 = " + string6 + ", string7 = " + string7);
    }

    @Então("O resultado será {string}")
    public void o_resultado_será(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("string = " + string);
    }

    @Então("A resposta será {string}")
    public void a_resposta_será(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("string = " + string);
    }

    // region Alterar Senha
    @Então("Devo receber mensagem de erro {string}")
    public void deve_receber(String string) {
        System.out.println("resultado = " + string);
    }

    @E("senha de confirmação {string} batem")
    public void senha_confirmacao_bate(String string) {
        this.formFill = true;
        this.senha_confirmacao = string;
    }

    @E("senha de confirmação {string} não batem")
    public void senha_confirmacao_nao_bate(String string) {
        this.formFill = true;
        this.senha_confirmacao = string;
    }

    @Quando("a {string} menor que 8 caracteres")
    public void senha_menor_oito(String string) {
        System.out.println("resultado = " + string + " " + this.senha_confirmacao);
    }

    @Quando("a {string} nova for vazia")
    public void senha_e_vazia(String string) {
        System.out.println("resultado = " + string + " " + this.senha_confirmacao);
    }

    @Quando("a {string} nova não bate com a confirmação")
    public void senha_nao_bate_confirmacao(String string) {
        System.out.println("resultado = " + string + " " + this.senha_confirmacao);
    }
}
