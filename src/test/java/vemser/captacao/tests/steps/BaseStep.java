package vemser.captacao.tests.steps;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import vemser.captacao.tests.utils.Utils;

import static vemser.captacao.tests.pages.BasePage.click;
import static vemser.captacao.tests.utils.Browser.closeBrowser;
import static vemser.captacao.tests.utils.Browser.openBrowser;

public class BaseStep {

    private final By GO_TO_SIGNUP_BUTTON = By.cssSelector("div > button[type=button]");

    @Before
    public void setUp() {

        String url = Utils.getProperties().getProperty("base_url");
        openBrowser(url);
        clickSignupButton();
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }

    public void clickSignupButton() {
        click(GO_TO_SIGNUP_BUTTON);
    }
}
