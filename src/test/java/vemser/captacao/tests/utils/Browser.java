package vemser.captacao.tests.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String userOs = Utils.getUserOs();

    public static void openBrowser(String url) {

        if (userOs.equals("Linux")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/linux/chromedriver");
        } else if (userOs.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/win/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/mac/chromedriver");
        }

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);

        driver.manage().window().maximize();

        driver.get(url);

        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static Actions getActions() {
        return new Actions(driver);
    }

    public static void scrollDown(int position) {

        try {
            Thread.sleep(2000);
            ((JavascriptExecutor) getDriver())
                    .executeScript("window.scroll(0, %s)".formatted(position));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
