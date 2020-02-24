package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static WebDriver driver;
    final static String url = "https://testfortesting.online-loans.ph/";

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Method calls the main page
     */
    public void open() {

        driver.get(url);
    }


    /**
     * Input data in field
     *
     * @param locator - xpath element,
     * @param input   - field with data
     */
    public static void inputText_xpath(String locator, String input) {

        driver.findElement(By.xpath(locator)).sendKeys(input);
    }

    /**
     * Input data in field and press ENTER
     *
     * @param locator - xpath element,
     * @param input   - field with data
     */
    public static void inputTextPlusEnter_xpath(String locator, String input) {

        driver.findElement(By.xpath(locator)).sendKeys(input + Keys.ENTER);
    }
    /**
     * Waiting for an item to appear
     *
     * @param css - css element
     */
    public static void waitCss(String css) {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
    }
}
