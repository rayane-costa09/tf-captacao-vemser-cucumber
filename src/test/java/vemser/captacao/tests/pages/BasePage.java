package vemser.captacao.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static vemser.captacao.tests.utils.Browser.getDriver;
import static vemser.captacao.tests.utils.Element.*;

public class BasePage {
    public static void click(By selector) {
        waitElement(selector);
        waitClickable(findElement(selector));
        findElement(selector).click();
    }

    public static void click(WebElement element) {
        waitElement(element);
        waitClickable(element);
        element.click();
    }

    public static void sendKeys(By selector, String text) {
        waitElement(selector);
        findElement(selector).sendKeys(text);
    }

    public static void pressEscape(WebElement element) {
        waitElement(element);
        element.sendKeys(Keys.ESCAPE);
    }

    public static String getText(By selector) {
        waitElement(selector);
        return findElement(selector).getText();
    }

    public static String getCurrentUrl() {
        return url();
    }

    public static boolean isDisplayed(By selector) {
        waitElement(selector);
        return findElement(selector).isDisplayed();
    }

    public static void hover(By selector) {
        mouseHover(selector);
    }

    public static void selectElement(By element, String value) {
        new Select(getDriver().findElement(element)).selectByVisibleText(value);
    }

    public static void isClickable(WebElement element) {
        waitClickable(element);
    }
}
