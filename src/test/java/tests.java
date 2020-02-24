import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.MainPage;
import pages.PersonalInformationPage;
import pages.StartPage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class tests {

    private static WebDriver driver;

    @BeforeClass
    public static void setupAll() {
        driver = Driver.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
    }

    @Before
    public void setup() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void check_form_negative_3_fields_are_not_populated() {
        StartPage createStartPage = new StartPage(driver);
        createStartPage.populateStartForm();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        createStartPage.waitCss(PersonalInformationPage.personal_inf_css);
        Assert.assertEquals(personalInformationPage.text, driver.findElement(By.cssSelector(personalInformationPage.personal_inf_css)).getText());

        Assert.assertEquals(3,personalInformationPage.checkRequiredThreeFields());
        System.out.println("Test 1 is passed");
    }

    @Test
    public void check_form_negative_2_fields_are_not_populated() {
        StartPage createStartPage = new StartPage(driver);
        createStartPage.populateStartForm();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        createStartPage.waitCss(PersonalInformationPage.personal_inf_css);
        Assert.assertEquals(personalInformationPage.text, driver.findElement(By.cssSelector(personalInformationPage.personal_inf_css)).getText());

        Assert.assertEquals(2,personalInformationPage.checkRequiredTwoFields());
        System.out.println("Test 2 is passed");
    }

    @Test
    public void check_form_negative_1_field_is_not_populated() {
        StartPage createStartPage = new StartPage(driver);
        createStartPage.populateStartForm();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        createStartPage.waitCss(PersonalInformationPage.personal_inf_css);
        Assert.assertEquals(personalInformationPage.text, driver.findElement(By.cssSelector(personalInformationPage.personal_inf_css)).getText());

        Assert.assertEquals(2,personalInformationPage.checkRequiredTwoFields());
        System.out.println("Test 3 is passed");
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }

}