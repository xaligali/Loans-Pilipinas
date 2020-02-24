package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import static pages.MainPage.inputText_xpath;
import static pages.MainPage.waitCss;

public class PersonalInformationPage{
    private static WebDriver driver;

    public final static String text = "Personal Information";
    public final static String personal_inf_css = "[class='h2 step_page__title']";
    public final static String doc_id = "//*[@id='application_document_number']";
    public final static String dateofbirth_id = "//*[@id='application_date_of_birth']";
    public final static String email_id = "//*[@id='application_email']";
    public final static String button_continue_xpath = "//*[text() ='Continue']";
    public final static String error_mesg = "//*[contains(text(),'This field is required')]";
    private final static String input_doc_id = "1111111111";
    private final static String input_dateofbirth = "02151991";
    private final static String input_email = "xalgalrin@mailinator.com";


    public PersonalInformationPage(WebDriver driver) {

        this.driver = driver;
    }

    public String checkText(){
        waitCss(personal_inf_css);
        String text = driver.findElement(By.cssSelector(personal_inf_css)).getText();
        return text;
    }

    private static void selectDocTypeAndInputDocId(){
        Select select = new Select(driver.findElement(By.xpath("//*[@id='application_type_of_document']")));
        select.selectByIndex(1);
        inputText_xpath(doc_id, input_doc_id);
    }

    public static int checkRequiredThreeFields(){

        selectDocTypeAndInputDocId();
        driver.findElement(By.xpath(button_continue_xpath)).click();
        List<WebElement> number_errors = driver.findElements(By.xpath(error_mesg));
        int size_list = number_errors.size();
        return size_list;
    }

    public static int checkRequiredTwoFields(){

        selectDocTypeAndInputDocId();
        inputText_xpath(dateofbirth_id, input_dateofbirth);
        driver.findElement(By.xpath(button_continue_xpath)).click();
        List<WebElement> number_errors = driver.findElements(By.xpath(error_mesg));
        int size_list = number_errors.size();
        return size_list;
    }

    public static int checkRequiredOneFields(){

        selectDocTypeAndInputDocId();
        inputText_xpath(dateofbirth_id, input_dateofbirth);
        inputText_xpath(email_id, input_email);
        driver.findElement(By.xpath(button_continue_xpath)).click();
        List<WebElement> number_errors = driver.findElements(By.xpath(error_mesg));
        int size_list = number_errors.size();
        return size_list;
    }
}
