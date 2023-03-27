package vemser.captacao.tests.steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import vemser.captacao.tests.pages.FormPage;
import vemser.captacao.tests.pages.InfoPage;
import vemser.captacao.tests.utils.DataFactory;

public class InfoStepsDefinitions extends BaseStep {

    @Dado("que estou na página de informações pessoais")
    public void estouPaginaInformacoesPessoais() {
        // Não é necessário fazer nada, pois o cenário começa na página de informações pessoais
    }

    @Quando("preencho os campos do formulário com um número de celular inválido")
    public void preenchoCamposFormularioNumeroCelularInvalido() {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone("0000000000000");
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();
    }

    @Então("o ícone de confirmação não deve ser exibido")
    public void iconeConfirmacaoNaoDeveSerExibido() {
        Assert.assertFalse(FormPage.getCheckIcon());
    }

    @Dado("que o usuário preenche o formulário com uma cidade que não pertence ao estado escolhido")
    public void queUsuarioPreencheFormularioComCidadeNaoPertenceEstadoEscolhido() {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity("Fortaleza");
        InfoPage.fillState("BA");
        InfoPage.fillNeurodiversity(false);
    }

    @Quando("o usuário clica no botão Avançar após preencher o formulário com uma cidade que não pertence ao estado escolhido")
    public void usuarioClicaAvançarCidadeNaoPertenceEstadoEscolhido() {
        InfoPage.clickNextButton();
    }

    @Então("o ícone de confirmação não deve ser exibido para o formulário preenchido com uma cidade que não pertence ao estado escolhido")
    public void iconeConfirmacaoNaoExibido() {
        Assert.assertFalse(FormPage.getCheckIcon());
    }

    @Dado("que o usuário preenche o formulário com um email inválido contendo acento no nome")
    public void usuarioPreencheFormularioEmailInvalidoAcentoNome() {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail("joão@email.com");
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
    }

    @Quando("o usuário clica no botão Avançar após preencher o formulário com um email inválido contendo acento no nome")
    public void usuarioClicaBotaoAvancarFormularioEmailInvalidoAcentoNome() {
        InfoPage.clickNextButton();
    }

    @Então("o ícone de confirmação não deve ser exibido para o formulário preenchido com um email inválido contendo acento no nome")
    public void iconeConfirmacaoNaoExibidoEmailPreenchidoAcentoNome() {
        Assert.assertFalse(FormPage.getCheckIcon());
    }
//--PAROU AQUI, FALTOU O RESTANTE
    @Dado("que o usuário preenche o formulário com uma data de nascimento que representa uma idade menor que {int} anos")
    public void preencherFormularioComDataDeNascimentoInvalida(int idade) {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthdayLessThan16());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
    }
}
