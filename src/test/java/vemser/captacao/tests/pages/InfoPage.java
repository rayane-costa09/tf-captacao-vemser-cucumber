package vemser.captacao.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import vemser.captacao.tests.utils.DataFactory;
import vemser.captacao.tests.utils.Utils;

import java.util.List;

import static vemser.captacao.tests.pages.BasePage.*;
import static vemser.captacao.tests.utils.Element.findElements;

public class InfoPage {
    /* Campos */
    private static final By NAME_FIELD = By.cssSelector("input[id=step-1-nome]");
    private static final By EMAIL_FIELD = By.cssSelector("input[id=step-1-email]");
    private static final By RG_FIELD = By.cssSelector("input[id=step-1-rg]");
    private static final By CPF_FIELD = By.cssSelector("input[id=step-1-cpf]");
    private static final By CELLPHONE_FIELD = By.cssSelector("input[id=step-1-telefone]");
    private static final By BIRTHDATE_FIELD = By.cssSelector("input[id=step-1-dataNascimento]");
    private static final By CITY_FIELD = By.cssSelector("input[id=step-1-cidade]");
    private static final By STATE_DROPDOWN = By.cssSelector("div[id=step-1-estado]");
    private static final By LIST_STATE = By.cssSelector("div[id=menu-estado] > div > ul > li");
    private static final By NEURODIVERSITY_DROPDOWN = By.cssSelector("div[id=step-1-neurodiversidade-combo]");
    private static final By NEURODIVERSITY_OPTIONS = By.cssSelector("div[id=menu-neurodiversidadeBoolean] > div > ul > li");
    private static final By NEURODIVERSITY_DESCRIPTION = By.cssSelector("input[id=step-1-neurodiversidade]");
    private static final By NEXT_BUTTON = By.cssSelector("button[id=step-1-enviar]");

    /* Mensagens de erro */
    private static final By NAME_ERROR_MESSAGE = By.cssSelector("p[id=step-1-nome-helper-text]");
    private static final By EMAIL_ERROR_MESSAGE = By.cssSelector("p[id=step-1-email-helper-text]");
    private static final By RG_ERROR_MESSAGE = By.cssSelector("p[id=step-1-rg-helper-text]");
    private static final By CPF_ERROR_MESSAGE = By.cssSelector("p[id=step-1-cpf-helper-text]");
    private static final By CELLPHONE_ERROR_MESSAGE = By.cssSelector("p[id=step-1-telefone-helper-text]");
    private static final By BIRTHDATE_ERROR_MESSAGE = By.cssSelector("p[id=step-1-dataNascimento-helper-text]");
    private static final By CITY_ERROR_MESSAGE = By.cssSelector("p[id=step-1-cidade-helper-text]");

    public static void fillName(String name) {
        sendKeys(NAME_FIELD, name);
    }

    public static void fillEmail(String email) {
        sendKeys(EMAIL_FIELD, email);
    }

    public static void fillRG(String rg) {
        click(RG_FIELD);
        sendKeys(RG_FIELD, rg);
    }

    public static void fillCPF(String cpf) {
        click(CPF_FIELD);
        sendKeys(CPF_FIELD, cpf);
    }

    public static void fillCellphone(String cellphone) {
        sendKeys(CELLPHONE_FIELD, cellphone);
    }

    public static void fillBirthDate(String birthDate) {
        sendKeys(BIRTHDATE_FIELD, birthDate);
    }

    public static void fillCity(String city) {
        sendKeys(CITY_FIELD, city);
    }

    public static void fillState(String state) {

        click(STATE_DROPDOWN);
        findElements(LIST_STATE).forEach(element -> {
            if (element.getAttribute("data-value").equals(state)) {
                element.click();
            }
        });
    }

    public static void fillNeurodiversity(boolean withDescription) {
        click(NEURODIVERSITY_DROPDOWN);

        if(withDescription){
            click(findElements(NEURODIVERSITY_OPTIONS).get(1));
            fillNeurodiversityDescription(DataFactory.getText(1));
            return;
        }

        click(findElements(NEURODIVERSITY_OPTIONS).get(0));
    }

    public static void fillNeurodiversityDescription(String text) {
        click(NEURODIVERSITY_DESCRIPTION);
        sendKeys(NEURODIVERSITY_DESCRIPTION, text);
    }

    public static void fillAllFieldsWithValidInformations() {
        fillName(DataFactory.getFullName());
        fillEmail(DataFactory.getEmail());
        fillRG(DataFactory.getRG());
        fillCPF(DataFactory.getCPF());
        fillCellphone(DataFactory.getPhone());
        fillBirthDate(DataFactory.getBirthday());
        fillCity(DataFactory.getCity());
        fillState(DataFactory.getState());
        fillNeurodiversity(true);
        click(NEXT_BUTTON);
    }

    public static void clickNextButton() {
        click(NEXT_BUTTON);
    }

    public static String getNameErrorMessage() {
        return getText(NAME_ERROR_MESSAGE);
    }

    public static String getEmailErrorMessage() {
        return getText(EMAIL_ERROR_MESSAGE);
    }

    public static String getRGErrorMessage() {
        return getText(RG_ERROR_MESSAGE);
    }

    public static String getCPFErrorMessage() {
        return getText(CPF_ERROR_MESSAGE);
    }

    public static String getPhoneErrorMessage() {
        return getText(CELLPHONE_ERROR_MESSAGE);
    }

    public static String getBirthdateErrorMessage() {
        return getText(BIRTHDATE_ERROR_MESSAGE);
    }

    public static String getCityErrorMessage() {
        return getText(CITY_ERROR_MESSAGE);
    }

    public static boolean isNameErrorMessageDisplayed() {
        return isDisplayed(NAME_ERROR_MESSAGE);
    }

    public static boolean isEmailErrorMessageDisplayed() {
        return isDisplayed(EMAIL_ERROR_MESSAGE);
    }

    public static boolean isRGErrorMessageDisplayed() {
        return isDisplayed(RG_ERROR_MESSAGE);
    }

    public static boolean isCPFErrorMessageDisplayed() {
        return isDisplayed(CPF_ERROR_MESSAGE);
    }

    public static boolean isPhoneErrorMessageDisplayed() {
        return isDisplayed(CELLPHONE_ERROR_MESSAGE);
    }

    public static boolean isBirthdateErrorMessageDisplayed() {
        return isDisplayed(BIRTHDATE_ERROR_MESSAGE);
    }

    public static boolean isCityErrorMessageDisplayed() {
        return isDisplayed(CITY_ERROR_MESSAGE);
    }
}
