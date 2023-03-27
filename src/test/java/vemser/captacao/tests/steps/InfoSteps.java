package vemser.captacao.tests.steps;

import org.junit.Assert;
import org.junit.Test;
import vemser.captacao.tests.pages.InfoPage;
import vemser.captacao.tests.utils.DataFactory;

import vemser.captacao.tests.pages.FormPage;

public class InfoSteps extends BaseStep {

    @Test
    public void preencherTela1ComSucessoSemNeurodiversidade() {
//        TC01 - Preencher tela "1 - Informações" de usuário sem neurodiversidade com sucesso

        InfoPage.fillAllFieldsWithValidInformations();

        Assert.assertTrue(FormPage.getCheckIcon());

    }

    @Test
    public void verificarQtdDigitosAMaisNoCelular() {
//        TC10 - Verificar quantidade de digitos a mais permitidos no campo de celular

        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone("0000000000000");
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        Assert.assertFalse(FormPage.getCheckIcon());
    }

    @Test
    public void tentarInformarCidadeQueNaoContemNoEstado() {
//        TC06 - Tentar informar cidade que não contém no estado escolhido

        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity("Fortaleza");
        InfoPage.fillState("BA");
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        Assert.assertFalse(FormPage.getCheckIcon());
    }

    @Test
    public void tentarInformarEmailInvalidoComAcentoNoNome() {
//        TC20 - Tentar fazer inscrição com email inválido usando acento no texto

        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail("joão@email.com");
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        Assert.assertFalse(FormPage.getCheckIcon());
    }

    @Test
    public void tentarInformarDataNascimentoForaDoPadrao() {
//        TC21 - Tentar fazer cadastro com idade não permitida

        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthdayLessThan16());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        Assert.assertEquals(InfoPage.getBirthdateErrorMessage(), "A data de nascimento deve ter no mínimo 16 anos");
    }
    @Test
    public void testTryingSignupWithInvalidRG() {
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRGWithLetters());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        /* Validações */
        Assert.assertTrue(InfoPage.isRGErrorMessageDisplayed());
        Assert.assertTrue(InfoPage.getRGErrorMessage().equalsIgnoreCase("O RG deve conter apenas números"));
    }

    @Test
    public void testSignUpWithInvalidEmail() {

        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmailOnlyNumbers());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        /* Validações */
        Assert.assertTrue(InfoPage.isEmailErrorMessageDisplayed());
        Assert.assertTrue(InfoPage.getEmailErrorMessage().equalsIgnoreCase("O email deve ser um endereço de email válido"));
    }

    @Test
    public void testSignUpWithInvalidCPF() {

        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPFWithLettersAndNumbers());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        /* Validações */
        Assert.assertTrue(InfoPage.isCPFErrorMessageDisplayed());
        Assert.assertTrue(InfoPage.getCPFErrorMessage().equalsIgnoreCase("O CPF deve ser um número válido"));
    }

    @Test
    public void testFillInfoFormWithNeurodiversity(){

        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(true);
        InfoPage.clickNextButton();

        Assert.assertTrue(FormPage.getCheckIcon());
    }
    @Test
    public void testEmailCadastrado(){
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail("testecadastro@dbccompany.com.br");
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF(DataFactory.getCPF());
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        /* Preenchendo a segunda parte */
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
        FormPage.clickSubmit();

        /* Validações */
        Assert.assertEquals(FormPage.getEmailErrorMessage(), "Houve algum erro!\n" +
                "Candidato com este e-mail já cadastrado para essa edição.");


        /*TODO: preencher a segunda parte e fazer asserts*/
    }
    @Test
    public void testCPFCadastrado(){
        InfoPage.fillName(DataFactory.getFullName());
        InfoPage.fillEmail(DataFactory.getEmail());
        InfoPage.fillRG(DataFactory.getRG());
        InfoPage.fillCPF("474.353.708-86");
        InfoPage.fillCellphone(DataFactory.getPhone());
        InfoPage.fillBirthDate(DataFactory.getBirthday());
        InfoPage.fillCity(DataFactory.getCity());
        InfoPage.fillState(DataFactory.getState());
        InfoPage.fillNeurodiversity(false);
        InfoPage.clickNextButton();

        /* Preenchendo a segunda parte */
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
        FormPage.clickSubmit();

        /* Validações */
        Assert.assertEquals(FormPage.getCPFErrorMessage(), "Houve algum erro!\n" +
                "Candidato com esse cpf já existe!");

        /*TODO: preencher a segunda parte e fazer asserts*/
    }
}