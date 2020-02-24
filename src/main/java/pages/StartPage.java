package pages;

import org.openqa.selenium.WebDriver;

import static pages.MainPage.inputTextPlusEnter_xpath;
import static pages.MainPage.inputText_xpath;

public class StartPage{
    private static WebDriver driver;

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
        this.driver = driver;
    }

    /**
     * Populated fields on the start page
     * */
    public static void populateStartForm(){

        inputText_xpath(first_name_id, input_first_name);
        inputText_xpath(middle_initial_id, input_middle_initial);
        inputText_xpath(last_name_id, input_last_name_id);
        inputTextPlusEnter_xpath(mobile_phone_id, input_mobile_phone);
    }
}
