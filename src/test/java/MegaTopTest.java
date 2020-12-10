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
    public  void addToFavouriteTest(){
        String phoneNumber= TestDataReader.getTestData("teat.data.phonenumber");
        String password=TestDataReader.getTestData("test.data.password");
        String goodid=TestDataReader.getTestData("test.data.goodid");

        String countOfFavouriteGoods = new MegaTopLoginPage(driver)
                .openPage()
                .loginUser(phoneNumber,password)
                .addToFavouriteGood(goodid);
        Assertions.assertEquals("1",countOfFavouriteGoods);
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
