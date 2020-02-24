import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.PersonalInformationPage;
import pages.StartPage;

import static java.util.concurrent.TimeUnit.SECONDS;


public class tests {
    ChromeDriver driver;

    @Before
    public void setup() {

        System.setProperty("WebDriver.chrome.driver", "/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        StartPage.populateStartForm();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.checkText();
    }

    @Test
    public void three_fields_are_not_populated() {
        Assert.assertEquals(3,PersonalInformationPage.checkRequiredThreeFields());
        System.out.println("Test 1 is passed");
    }

    @Test
    public void two_fields_are_not_populated() {
        Assert.assertEquals(2,PersonalInformationPage.checkRequiredTwoFields());
        System.out.println("Test 2 is passed");
    }

    @Test
    public void one_field_is_not_populated() {
        Assert.assertEquals(1,PersonalInformationPage.checkRequiredOneFields());
        System.out.println("Test 3 is passed");
    }

    @Test
    public void validate_field_doc_id() {
        Assert.assertEquals(PersonalInformationPage.error_doc_id_mesg,PersonalInformationPage.checkDocIdField());
        System.out.println("Test 4 is passed");
    }

    @Test
    public void validate_field_date_of_birth() {
        Assert.assertEquals(PersonalInformationPage.error_dob_mesg,PersonalInformationPage.checkDateOfBirthField());
        System.out.println("Test 5 is passed");
    }

    @After
    public void quit() {
        driver.quit();
    }

}