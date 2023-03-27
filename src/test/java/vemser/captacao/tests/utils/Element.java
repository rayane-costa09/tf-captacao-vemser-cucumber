package vemser.captacao.tests.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static vemser.captacao.tests.utils.Browser.*;

public class Element {
    public static WebElement findElement(By element) {
        return getDriver().findElement(element);
    }

    public static List<WebElement> findElements(By element) {
        return getDriver().findElements(element);
    }

    public static void waitElement(By element) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void waitElement(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static String url() {
        return getDriver().getCurrentUrl();
    }

    public static void mouseHover(By element) {
        getActions().moveToElement(findElement(element)).perform();
    }

    public static void waitClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
}
