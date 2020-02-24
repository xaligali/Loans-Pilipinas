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
     * Метод вызывает главную страницу
     */
    public void open() {

        driver.get(url);
    }


    /**
     * Ввод данных в поле
     *
     * @param locator - xpath элемента,
     * @param input   - строка с данными
     */
    public static void inputText_xpath(String locator, String input) {

        driver.findElement(By.xpath(locator)).sendKeys(input);
    }

    public static void inputTextPlusEnter_xpath(String locator, String input) {

        driver.findElement(By.xpath(locator)).sendKeys(input + Keys.ENTER);
    }
    /**
     * Ожидание появления элемента
     *
     * @param css - css элемента
     */
    public static void waitCss(String css) {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
    }

    /**
     * Ожидание появления элемента
     *
     * @param xpath - css элемента
     */
    public static void waitXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

}
