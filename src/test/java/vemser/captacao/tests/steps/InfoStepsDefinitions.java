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

    @Quando("o usuário clica no botão Avançar após preencher o formulário com uma data de nascimento inválida")
    public void usuarioClicaBotaoAvancarFormularioDataNascimentoInvalida() {
        InfoPage.clickNextButton();
    }

    @Então("uma mensagem de erro sobre a data de nascimento deve ser exibida")
    public void mensagemErroDataNascimentoExibida() {
        Assert.assertEquals(InfoPage.getBirthdateErrorMessage(), "A data de nascimento deve ter no mínimo 16 anos");
    }

    @Quando("preencho o formulário com um RG contendo letras")
    public void preenchoOFormulárioComUmRGContendoLetras() {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRGWithLetters());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
    }

    @Quando("clico no botão Avançar")
    public void usuarioClicaBotaoAvancarRGUsandoLetras() {
        InfoPage.clickNextButton();
    }

    @Então("Então a mensagem de erro {String} deve ser exibida")
    public void mensagemErroDataNascimentoExibida(String mensagem) {
        Assert.assertTrue(InfoPage.getRGErrorMessage().equalsIgnoreCase(mensagem));
    }

    @Quando("eu preencher todos os campos obrigatórios com dados válidos, incluindo a opção de neurodiversidade ativada")
    public void euPreencherTodosOsCamposObrigatoriosComDadosValidosIncluindoAOpcaoDeNeurodiversidadeAtivada() {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(true);
    }

    @Quando("clicar no botão Próximo")
    public void clicarNoBotaoProximo() {
        InfoPage.clickNextButton();
    }

    @Então("devo ver o ícone de marcação de verificação na página do formulário")
    public void devoVerOIconeDeMarcacaoDeVerificacaoNaPaginaDoFormulario() {
        Assert.assertTrue(FormPage.getCheckIcon());
    }

    @Quando("eu preencher o campo de e-mail com um e-mail já cadastrado")
    public void euPreencherOCampoDeEmailComUmEmailJaCadastrado() {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail("testecadastro@dbccompany.com.br");
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
    }

    @Quando("eu preencher a segunda parte do formulário")
    public void euPreencherSegundaParteFormularioDeEmailComUmEmailJaCadastrado() {
        FormPage.selectIsEnrolledCourse("Sim");
        FormPage.selectStudyShift();
        FormPage.fillCollege(DataFactory.getCollege());
        FormPage.fillCourse(DataFactory.getCourse());
        FormPage.selectEnglishLevel();
        FormPage.selectSpanishLevel();
        FormPage.selectSexualOrientation();
        FormPage.selectGender();
        FormPage.selectProgammingLanguage(5);
        FormPage.selectStack(2);
        FormPage.selectDisability("Não");
        FormPage.fillInterestTechnology(DataFactory.getText(3));
        FormPage.fillImportantTeaching(DataFactory.getText(4));
        FormPage.selectKnowledgeProof();
        FormPage.selectTimeAvailability();
        FormPage.selectHourAvailability();
        FormPage.fillGithub(DataFactory.getLink());
        FormPage.fillLinkedin(DataFactory.getLink());
        FormPage.uploadCurrilum(DataFactory.getFilePath("pdf"));
        FormPage.uploadPcSpecs(DataFactory.getFilePath("image"));
        FormPage.checkLgpd();
    }

    @Então("devo ver uma mensagem de erro informando que o e-mail já está cadastrado")
    public void devoVerUmaMensagemDeErroInformandoQueOEmailJaEstaCadastrado() {
        Assert.assertEquals(FormPage.getEmailErrorMessage(), "Houve algum erro!\n" +
                "Candidato com este e-mail já cadastrado para essa edição.");
    }

    @Quando("eu preencher o campo de CPF com um CPF já cadastrado")
    public void euPreencherOCampoDeCPFComUmCPFJaCadastrado() {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF("474.353.708-86");
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
    }

    @Então("devo ver uma mensagem de erro informando que o CPF já está cadastrado")
    public void devoVerUmaMensagemDeErroInformandoQueOCPFJaEstaCadastrado() {
        Assert.assertEquals(FormPage.getCPFErrorMessage(), "Houve algum erro!\n" +
                "Candidato com esse cpf já existe!");
    }
}
