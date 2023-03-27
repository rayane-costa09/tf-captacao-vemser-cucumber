package vemser.captacao.tests.steps;

import org.junit.Assert;
import org.junit.Test;
import vemser.captacao.tests.pages.FinishPage;
import vemser.captacao.tests.pages.FormPage;
import vemser.captacao.tests.pages.InfoPage;
import vemser.captacao.tests.utils.DataFactory;

public class FormSteps extends BaseStep {
    @Test
    public void testUploadCurriculumComErro() {
        InfoPage.fillAllFieldsWithValidInformations();
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
        FormPage.uploadCurrilum(DataFactory.getFilePath("other"));
        FormPage.uploadPcSpecs(DataFactory.getFilePath("image"));
        FormPage.checkLgpd();
        FormPage.clickSubmit();
        Assert.assertTrue(FormPage.isCurrilumErrorDisplayed());
        Assert.assertTrue(FormPage.getCurrilumErrorMessage().equalsIgnoreCase("O tipo de arquivo não é suportado. Só é possível enviar PDF."));
    }
    @Test
    public void tentarPreencherCampoDeficienciaInvalido(){

        InfoPage.fillAllFieldsWithValidInformations();
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
        FormPage.selectDisability("Sim");
        FormPage.fillDisability("12345342567446354313277");
        FormPage.fillInterestTechnology(DataFactory.getText(3));
        FormPage.fillImportantTeaching(DataFactory.getText(4));
        FormPage.selectKnowledgeProof();
        FormPage.selectTimeAvailability();
        FormPage.selectHourAvailability();
        FormPage.fillGithub(DataFactory.getLink());
        FormPage.fillLinkedin(DataFactory.getLink());
        FormPage.uploadCurrilum(DataFactory.getFilePath("PDF"));
        FormPage.uploadPcSpecs(DataFactory.getFilePath("image"));
        FormPage.checkLgpd();
        FormPage.clickSubmit();
    }

    @Test
    public void testSignUpSuccessfully() {
        /* Preenchendo a primeira parte */
        InfoPage.fillAllFieldsWithValidInformations();

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
        FormPage.selectStack(3);
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
        Assert.assertTrue(FinishPage.isSuccessIconDisplayed());
        Assert.assertTrue(FinishPage.isSuccessHeaderIconDisplayed());
        Assert.assertTrue(FinishPage.getSuccessMessage().equalsIgnoreCase("Inscrito com sucesso!\nSua inscrição foi enviada! Retornaremos seu resultado em breve."));
    }

    @Test
    public void testSignUpWithInvalidPrintUpload() {
        /* Preenchendo a primeira parte */
        InfoPage.fillAllFieldsWithValidInformations();

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
        FormPage.uploadPcSpecs(DataFactory.getFilePath("other"));
        FormPage.checkLgpd();
        FormPage.clickSubmit();

        /* Validações */
        Assert.assertTrue(FormPage.isPcSpecsErrorDisplayed());
        Assert.assertTrue(FormPage.getPcSpecsErrorMessage().equalsIgnoreCase("O tipo de arquivo não é suportado"));

    }
}