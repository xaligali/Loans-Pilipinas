package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.junit.*;

import static pages.MainPage.inputText_xpath;
import static pages.MainPage.waitCss;

public class PersonalInformationPage{
    private static WebDriver driver;

    private final static String text_pi = "Personal Information";
    private final static String personal_inf_css = "[class='h2 step_page__title']";
    private final static String doc_id = "//*[@id='application_document_number']";
    private final static String dateofbirth_id = "//*[@id='application_date_of_birth']";
    private final static String email_id = "//*[@id='application_email']";
    private final static String button_continue_xpath = "//*[text() ='Continue']";
    private final static String error_mesg = "//*[contains(text(),'This field is required')]";
    private final static String input_doc_id = "1111111111";
    private final static String input_doc_id_incorr = "111111111";
    private final static String gender_female_id = "(//*[@class='radio'])[2]";
    private final static String input_dateofbirth = "02151991";
    private final static String input_dateofbirth_incorr = "02152020";
    private final static String input_email = "xalgalrin@mailinator.com";
    public final static String error_doc_id_mesg = "Please enter valid ID number";
    private final static String error_doc_id_css = "[class='form__error form__error-static']";
    public final static String error_dob_mesg = "Invalid Date";
    private final static String error_dob_css = "[class='form__error']";

    public PersonalInformationPage(WebDriver driver) {

        this.driver = driver;
    }

    public void checkText(){
        waitCss(personal_inf_css);
        String text = driver.findElement(By.cssSelector(personal_inf_css)).getText();
        Assert.assertEquals(text_pi,text);
    }

    private static void selectDocTypeAndInputDocId(int id){
        Select select = new Select(driver.findElement(By.xpath("//*[@id='application_type_of_document']")));
        select.selectByIndex(1);
        if(id == 1)
        {
            inputText_xpath(doc_id, input_doc_id);
        }
        else
            inputText_xpath(doc_id, input_doc_id_incorr);
    }

    public static int checkRequiredThreeFields(){

        selectDocTypeAndInputDocId(1);
        driver.findElement(By.xpath(button_continue_xpath)).click();
        List<WebElement> number_errors = driver.findElements(By.xpath(error_mesg));
        int size_list = number_errors.size();
        return size_list;
    }

    public static int checkRequiredTwoFields(){

        selectDocTypeAndInputDocId(1);
        inputText_xpath(dateofbirth_id, input_dateofbirth);
        driver.findElement(By.xpath(button_continue_xpath)).click();
        List<WebElement> number_errors = driver.findElements(By.xpath(error_mesg));
        int size_list = number_errors.size();
        return size_list;
    }

    public static int checkRequiredOneFields(){

        selectDocTypeAndInputDocId(1);
        inputText_xpath(dateofbirth_id, input_dateofbirth);
        inputText_xpath(email_id, input_email);
        driver.findElement(By.xpath(button_continue_xpath)).click();
        List<WebElement> number_errors = driver.findElements(By.xpath(error_mesg));
        int size_list = number_errors.size();
        return size_list;
    }

    public static String checkDocIdField(){

        selectDocTypeAndInputDocId(0);
        driver.findElement(By.xpath(gender_female_id)).click();
        inputText_xpath(dateofbirth_id, input_dateofbirth);
        inputText_xpath(email_id, input_email);
        driver.findElement(By.xpath(button_continue_xpath)).click();
        String text = driver.findElement(By.cssSelector(error_doc_id_css)).getText();
        return text;
    }

    public static String checkDateOfBirthField(){

        selectDocTypeAndInputDocId(1);
        driver.findElement(By.xpath(gender_female_id)).click();
        inputText_xpath(dateofbirth_id, input_dateofbirth_incorr);
        inputText_xpath(email_id, input_email);
        driver.findElement(By.xpath(button_continue_xpath)).click();
        String text = driver.findElement(By.cssSelector(error_dob_css)).getText();
        return text;
    }
}
