import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.megatop.MegaTopFilterPage;
import pageobject.megatop.MegaTopLoginPage;
import pageobject.util.TestDataReader;

public class MegaTopTest {

    private WebDriver driver;

    @BeforeEach
    public  void browserSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public  void loginPageTest(){
        String phoneNumber= TestDataReader.getTestData("teat.data.phonenumber");
        String password=TestDataReader.getTestData("test.data.password");

        String buttonText = new MegaTopLoginPage(driver)
                .openPage()
                .loginUser(phoneNumber,password);
        Assertions.assertEquals("ВОЙТИ",buttonText);
    }

    @Test
    public  void filterPageTest(){
        String popupButton = new MegaTopFilterPage(driver)
                .openPage()
                .filterGoods();

        Assertions.assertEquals("ПОКАЗАТЬ", popupButton);
    }

    @AfterEach
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }

}
