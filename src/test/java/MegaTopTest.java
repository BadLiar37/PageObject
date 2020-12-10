import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.megatop.MegaTopFilterByMenAndByPricePage;
import pageobject.megatop.MegaTopAddToPageOfFavouriteGoods;
import pageobject.util.TestDataReader;

public class MegaTopTest {

    private WebDriver driver;

    @BeforeEach
    public  void browserSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public  void addToFavouriteGoodsTest(){
        String phoneNumber= TestDataReader.getTestData("teat.data.phonenumber");
        String password=TestDataReader.getTestData("test.data.password");
        String goodid=TestDataReader.getTestData("test.data.goodid");

        String countOfFavouriteGoods = new MegaTopAddToPageOfFavouriteGoods(driver)
                .openPage()
                .loginUser(phoneNumber,password)
                .addToFavouriteGoods(goodid);
        Assertions.assertEquals("1",countOfFavouriteGoods);
    }

    @Test
    public  void filterPageTest(){
        String popupButton = new MegaTopFilterByMenAndByPricePage(driver)
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
