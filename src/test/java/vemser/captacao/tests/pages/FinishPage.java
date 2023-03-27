package vemser.captacao.tests.pages;

import org.openqa.selenium.By;
import static vemser.captacao.tests.pages.BasePage.getText;
import static vemser.captacao.tests.pages.BasePage.isDisplayed;

public class FinishPage {

    private static final By SUCCESS_MESSAGE = By.cssSelector("div[role=alert] > div:nth-child(2)");
    private static final By SUCCESS_ICON = By.cssSelector("div[role=alert] > div > svg[data-testid=SuccessOutlinedIcon]");
    private static final By SUCCESS_HEADER_ICON = By.cssSelector("div > svg[data-testid=CheckIcon]");

    public static String getSuccessMessage() {
        return getText(SUCCESS_MESSAGE);
    }

    public static boolean isSuccessIconDisplayed() {
        return isDisplayed(SUCCESS_ICON);
    }

    public static boolean isSuccessHeaderIconDisplayed() {
        return isDisplayed(SUCCESS_HEADER_ICON);
    }
}
