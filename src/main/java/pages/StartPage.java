package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class StartPage extends MainPage{
    //private static WebDriver driver;

    private final static String first_name_id = "//*[@id='application_first_name']";
    private final static String middle_initial_id = "//*[@id='application_middle_initial']";
    private final static String last_name_id = "//*[@id='application_last_name']";
    private final static String mobile_phone_id = "//*[@id='application_mobile_phone']";
    private final static String button_get_first_loan_xpath = "//*[@name='commit']";
    private final static String input_first_name = "Gal";
    private final static String input_middle_initial = "Rin";
    private final static String input_last_name_id = "Khal";
    private final static String input_mobile_phone = "9177625962";

    public StartPage(WebDriver driver) {

        //this.driver = driver;
        super(driver);
    }

    /**
     *
     * */
    public static void populateStartForm(){

        inputText_xpath(first_name_id, input_first_name);
        inputText_xpath(middle_initial_id, input_middle_initial);
        inputText_xpath(last_name_id, input_last_name_id);
        inputTextPlusEnter_xpath(mobile_phone_id, input_mobile_phone);


        //driver.findElement(By.xpath(mobile_phone_id)).sendKeys(Keys.ENTER);
        /*driver.manage().timeouts().implicitlyWait(60, SECONDS);
        driver.findElement(By.xpath("//input[@value='Get First Loan']")).click();
        driver.manage().timeouts().implicitlyWait(60, SECONDS);*/
        //Assert.assertEquals(error_mesg_name, driver.findElement(By.xpath(name_xpath)).getText());
    }
}
