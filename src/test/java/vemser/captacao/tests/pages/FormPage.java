package vemser.captacao.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import vemser.captacao.tests.utils.Browser;
import vemser.captacao.tests.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static vemser.captacao.tests.pages.BasePage.*;
import static vemser.captacao.tests.utils.Element.findElement;
import static vemser.captacao.tests.utils.Element.findElements;

public class FormPage {
    /* Campos */
    private static final By IS_ENROLLED_COURSE = By.cssSelector("div.MuiGrid-grid-lg-6:nth-child(1) > div > label");
    private static final By STUDY_SHIFT = By.cssSelector("div.MuiGrid-grid-lg-6:nth-child(2) > div > label");
    private static final By COLLEGE_FIELD = By.cssSelector("input[id=instituicao-de-ensino-candidato]");
    private static final By COURSE_FIELD = By.cssSelector("input[id=curso-candidato]");
    private static final By ENGLISH_LEVEL_DROPDOWN = By.cssSelector("div[id=s2-nivel-ingles-candidato]");
    private static final By ENGLISH_LEVEL_OPTIONS = By.cssSelector("div[id=menu-ingles] > div > ul > li");
    private static final By SPANISH_LEVEL_DROPDOWN = By.cssSelector("div[id=s2-nivel-espanhol-candidato]");
    private static final By SPANISH_LEVEL_OPTIONS = By.cssSelector("div[id=menu-espanhol] > div > ul > li");
    private static final By SEXUAL_ORIENTATION_DROPDOWN = By.cssSelector("div[id=orientacao-sexual-candidato]");
    private static final By SEXUAL_ORIENTATION_OPTIONS = By.cssSelector("div[id=menu-orientacao] > div > ul > li");
    private static final By GENDER_DROPDOWN = By.cssSelector("div[id=s2-select-genero-candidato]");
    private static final By GENDER_OPTIONS = By.cssSelector("div[id=menu-genero] > div > ul > li");
    private static final By PROGRAMMING_LANG_DROPDOWN = By.cssSelector("div[id=s2-select-linguagens-checkbox]");
    private static final By PROGRAMMING_LANG_OPTIONS = By.cssSelector("ul[aria-labelledby=s2-select-linguagens] > li");
    private static final By STACK_LIST = By.cssSelector("form > div:nth-child(10) > div > label");
    private static final By DISABILITY_DROPDOWN = By.cssSelector("div[id=s2-select-deficiencia-candidato]");
    private static final By DISABILITY_OPTIONS = By.cssSelector("div[id=menu-deficienciaBoolean] > div > ul > li");
    private static final By DISABILITY_FIELD = By.cssSelector("input[id=s2-candidato-deficiencia-descricao]");
    private static final By INTEREST_TECHNOLOGY_FIELD = By.cssSelector("textarea[id=s2-candidato-motivo]");
    private static final By IMPORTANT_TEACHING_FIELD = By.cssSelector("textarea[id=textarea-importante-candidato]");
    private static final By KNOWLEDGE_PROOF = By.cssSelector("form > div:nth-child(14) > div > label > div > label");
    private static final By TIME_AVAILABILITY = By.cssSelector("form > div:nth-child(16) > div > label > div > label");
    private static final By HOUR_AVAILABILITY = By.cssSelector("form > div:nth-child(17) > div > label > div > label");
    private static final By GITHUB_FIELD = By.cssSelector("input[id=s2-candidato-github]");
    private static final By LINKEDIN_FIELD = By.cssSelector("input[id=s2-candidato-linkedin]");
    private static final By CURRICULUM_UPLOAD = By.cssSelector("label[id=botao-curriculo] > input[id=s2-input-curriculo]");
    private static final By PC_SPECS_UPLOAD = By.cssSelector("input[id=s2-input-configuracoes]");
    private static final By LGPD_CHECKBOX = By.cssSelector("label[id=s2-candidato-lgpd]");
    private static final By CHECK_ICON = By.cssSelector("span.Mui-completed.css-a5nipc > svg > path");
    private static final By SUBMIT_BUTTON = By.cssSelector("button[id=s2-botao-submit]");

    /* Mensagens de erro */
    private static final By COLLEGE_ERROR_MESSAGE = By.cssSelector("p[id=instituicao-de-ensino-candidato-helper-text]");
    private static final By COURSE_ERROR_MESSAGE = By.cssSelector("p[id=curso-candidato-helper-text]");
    private static final By PROG_LANG_ERROR_MESSAGE = By.cssSelector("form > div:nth-child(9) > div > p");
    private static final By STACK_ERROR_MESSAGE = By.cssSelector("form > div:nth-child(10) > p");
    private static final By INTEREST_TECHNOLOGY_ERROR_MESSAGE = By.cssSelector("p[id=s2-candidato-motivo-helper-text]");
    private static final By IMPORTANT_TEACHING_ERROR_MESSAGE = By.cssSelector("p[id=textarea-importante-candidato-helper-text]");
    private static final By CURRICULUM_ERROR_MESSAGE = By.cssSelector("form > div:nth-child(20) > p");
    private static final By PC_SPECS_ERROR_MESSAGE = By.cssSelector("form > div:nth-child(21) > p");
    private static final By LGPD_ERROR_MESSAGE = By.cssSelector("h6[id=mensagem-erro-lgpd]");

    private static final By ERROR_MESSAGE = By.cssSelector(".MuiAlert-message");

    public static void scrollDown(int position) {
        Browser.scrollDown(position);
    }

    public static void forceWait(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void selectIsEnrolledCourse(String choice) {

        findElements(IS_ENROLLED_COURSE).forEach(element -> {
            if (element.getText().equalsIgnoreCase(choice)) {
                click(element);
            }
        });
    }

    public static void selectStudyShift() {

        List<WebElement> elements = findElements(STUDY_SHIFT);
        int elementsSize = elements.size();
        int randomIndex = Utils.getRandomNumber(elementsSize );

        click(elements.get(randomIndex));
    }

    public static void fillCollege(String college) {
        sendKeys(COLLEGE_FIELD, college);
    }

    public static void fillCourse(String course) {
        sendKeys(COURSE_FIELD, course);
    }

    public static void selectEnglishLevel() {
        click(ENGLISH_LEVEL_DROPDOWN);

        List<WebElement> elements = findElements(ENGLISH_LEVEL_OPTIONS);
        int elementsSize = elements.size();
        int randomIndex = Utils.getRandomNumber(elementsSize );

        click(elements.get(randomIndex));
    }

    public static void selectSpanishLevel() {
        click(SPANISH_LEVEL_DROPDOWN);

        List<WebElement> elements = findElements(SPANISH_LEVEL_OPTIONS);
        int elementsSize = elements.size();
        int randomIndex = Utils.getRandomNumber(elementsSize );

        click(elements.get(randomIndex));
    }

    public static void selectSexualOrientation() {
        click(SEXUAL_ORIENTATION_DROPDOWN);

        List<WebElement> elements = findElements(SEXUAL_ORIENTATION_OPTIONS);
        int elementsSize = elements.size();
        int randomIndex = Utils.getRandomNumber(elementsSize );

        click(elements.get(randomIndex));
    }

    public static void selectGender() {
        click(GENDER_DROPDOWN);

        List<WebElement> elements = findElements(GENDER_OPTIONS);
        int elementsSize = elements.size();
        int randomIndex = Utils.getRandomNumber(elementsSize );

        click(elements.get(randomIndex));
    }

    public static void selectProgammingLanguage(int amount) {
        click(PROGRAMMING_LANG_DROPDOWN);

        List<WebElement> elements = findElements(PROGRAMMING_LANG_OPTIONS);
        List<Integer> randomIndex = new ArrayList<>();

        while (randomIndex.size() < amount) {

            int index = Utils.getRandomNumber(elements.size());

            if (!randomIndex.contains(index)) {
                randomIndex.add(index);
            }

        }

        randomIndex.forEach(index -> {
            click(elements.get(index));
        });

        /* Aperta ESC após escolher a útilma linguagem */
        pressEscape(elements.get(randomIndex.get(randomIndex.size() - 1)));
    }

    public static void selectStack(int amount) {
        List<WebElement> elements = findElements(STACK_LIST);
        List<Integer> randomIndex = new ArrayList<>();

        while (randomIndex.size() < amount) {

            int index = Utils.getRandomNumber(elements.size());

            if (!randomIndex.contains(index)) {
                randomIndex.add(index);
            }

        }

        randomIndex.forEach(index -> {
            click(elements.get(index));
        });
    }

    public static void selectDisability(String choice) {
        click(DISABILITY_DROPDOWN);

        findElements(DISABILITY_OPTIONS).forEach(element -> {
            if (element.getText().equalsIgnoreCase(choice)) {
                click(element);
            }
        });
    }
    public static void fillDisability(String text){
        sendKeys(DISABILITY_FIELD, text);
    }

    private static boolean getDisabilityChoice() {
        return getText(DISABILITY_DROPDOWN).equalsIgnoreCase("Sim");
    }

    public static void fillInterestTechnology(String text) {
        sendKeys(INTEREST_TECHNOLOGY_FIELD, text);
    }

    public static void fillImportantTeaching(String text) {
        sendKeys(IMPORTANT_TEACHING_FIELD, text);
    }

    public static void selectKnowledgeProof() {

        final By KNOWLEDGE_PROOF_2 = By.cssSelector("form > div:nth-child(15) > div > label > div > label");

        if (getDisabilityChoice()){

            List<WebElement> elements = findElements(KNOWLEDGE_PROOF_2);
            int elementsSize = elements.size();
            int randomIndex = Utils.getRandomNumber(elementsSize);

            click(elements.get(randomIndex));

            return;
        }

        List<WebElement> elements = findElements(KNOWLEDGE_PROOF);
        int elementsSize = elements.size();
        int randomIndex = Utils.getRandomNumber(elementsSize);

        click(elements.get(randomIndex));
    }

    public static void selectTimeAvailability() {

        final By TIME_AVAILABILITY_2 = By.cssSelector("form > div:nth-child(17) > div > label > div > label");

        if (getDisabilityChoice()){
            List<WebElement> elements = findElements(TIME_AVAILABILITY_2);
            int elementsSize = elements.size();
            int randomIndex = Utils.getRandomNumber(elementsSize);

            click(elements.get(randomIndex));

            return;
        }

        List<WebElement> elements = findElements(TIME_AVAILABILITY);
        int elementsSize = elements.size();
        int randomIndex = Utils.getRandomNumber(elementsSize);

        click(elements.get(randomIndex));
    }

    public static void selectHourAvailability() {

        final By HOUR_AVAILABILITY_2 = By.cssSelector("form > div:nth-child(18) > div > label > div > label");

        if (getDisabilityChoice()){
            List<WebElement> elements = findElements(HOUR_AVAILABILITY_2);
            int elementsSize = elements.size();
            int randomIndex = Utils.getRandomNumber(elementsSize);

            click(elements.get(randomIndex));

            return;
        }

        List<WebElement> elements = findElements(HOUR_AVAILABILITY);
        int elementsSize = elements.size();
        int randomIndex = Utils.getRandomNumber(elementsSize);

        click(elements.get(randomIndex));
    }

    public static void fillGithub(String text) {
        sendKeys(GITHUB_FIELD, text);
    }

    public static void fillLinkedin(String text) {
        sendKeys(LINKEDIN_FIELD, text);
    }

    public static void uploadCurrilum(String path) {
        sendKeys(CURRICULUM_UPLOAD, path);
    }

    public static void uploadPcSpecs(String path) {
        sendKeys(PC_SPECS_UPLOAD, path);
    }

    public static void checkLgpd() {
        click(LGPD_CHECKBOX);
    }

    public static void clickSubmit() {
        click(SUBMIT_BUTTON);
    }

    public static String getCollegeErrorMessage() {
        return getText(COLLEGE_ERROR_MESSAGE);
    }

    public static String getCourseErrorMessage() {
        return getText(COURSE_ERROR_MESSAGE);
    }

    public static String getProgLangErrorMessage() {
        return getText(PROG_LANG_ERROR_MESSAGE);
    }

    public static String getStackErrorMessage() {
        return getText(STACK_ERROR_MESSAGE);
    }

    public static String getInterestTechnologyErrorMessage() {
        return getText(INTEREST_TECHNOLOGY_ERROR_MESSAGE);
    }

    public static String getImportantTeachingErrorMessage() {
        return getText(IMPORTANT_TEACHING_ERROR_MESSAGE);
    }

    public static String getCurrilumErrorMessage() {
        return getText(CURRICULUM_ERROR_MESSAGE);
    }

    public static String getPcSpecsErrorMessage() {
        return getText(PC_SPECS_ERROR_MESSAGE);
    }

    public static String getLgpdErrorMessage() {
        return getText(LGPD_ERROR_MESSAGE);
    }

    public static boolean getCheckIcon() {
        return isDisplayed(CHECK_ICON);
    }

    public static boolean isCollegeErrorDisplayed() {
        return isDisplayed(COLLEGE_ERROR_MESSAGE);
    }

    public static boolean isCourseErrorDisplayed() {
        return isDisplayed(COURSE_ERROR_MESSAGE);
    }

    public static boolean isProgLangErrorDisplayed() {
        return isDisplayed(PROG_LANG_ERROR_MESSAGE);
    }

    public static boolean isStackErrorDisplayed() {
        return isDisplayed(STACK_ERROR_MESSAGE);
    }

    public static boolean isInterestTechnologyErrorDisplayed() {
        return isDisplayed(INTEREST_TECHNOLOGY_ERROR_MESSAGE);
    }

    public static boolean isImportantTeachingErrorDisplayed() {
        return isDisplayed(IMPORTANT_TEACHING_ERROR_MESSAGE);
    }

    public static boolean isCurrilumErrorDisplayed() {
        return isDisplayed(CURRICULUM_ERROR_MESSAGE);
    }

    public static boolean isPcSpecsErrorDisplayed() {
        return isDisplayed(PC_SPECS_ERROR_MESSAGE);
    }

    public static boolean isLgpdErrorDisplayed() {
        return isDisplayed(LGPD_ERROR_MESSAGE);
    }
    public static String getEmailErrorMessage() {
        return getText(ERROR_MESSAGE);
    }

    public static String getCPFErrorMessage() {
        return getText(ERROR_MESSAGE);
    }
}
