package pageobject.megatop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class MegaTopAddToFavouritePage extends Page {
    private static final String LOGIN_URL = "https://my.megatop.by/login";

    @FindBy(id = "input-39")
    private WebElement mobilePhone;

    @FindBy(id = "input-40")
    private WebElement passwordElement;

    @FindBy(xpath= "/html/body/div/div/div/div/div[3]/div[2]/div/div/div[2]/div[2]/div/div/form/div[4]/div/button/span")
    private WebElement loginButton;

    @FindBy(xpath= "/html/body/div/div/div/div/div[3]/div[2]/div/div/div[3]/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[2]")
    private WebElement userName;

    @FindBy(xpath= "/html/body/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/section/div/div[2]/div/div[2]/div/a[2]")
    private WebElement goodToFavourite;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/header/div/div[1]/a[2]/span/span")
    private WebElement onlyMenGoods;

    @FindBy(xpath = "/html/body/div[2]/header/div/div/div[4]/div/div[2]/div[2]/a")
    private WebElement countOfFavouriteGood;

    public MegaTopAddToFavouritePage openPage(){
        driver.get(LOGIN_URL);
        return this;
    }

    public MegaTopAddToFavouritePage(WebDriver driver){
        super(driver);
    }

    public MegaTopAddToFavouritePage loginUser(String phoneNumber, String password) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(mobilePhone)).sendKeys(phoneNumber);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(password);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(userName));
        return this;
    }

    public  String addToFavouriteGoods(String goodId){
        WebElement onlyMenElement = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(onlyMenGoods));
        onlyMenElement.click();
        goodToFavourite.click();
        driver.navigate().refresh();
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(countOfFavouriteGood)).getText().trim();
    }
}
