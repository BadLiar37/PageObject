package pageobject.megatop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class MegaTopLoginPage extends Page {
    private static final String LOGIN_URL = "https://my.megatop.by/login";

    @FindBy(id = "input-39")
    private WebElement mobilePhone;

    @FindBy(id = "input-40")
    private WebElement passwordElement;

    @FindBy(xpath= "/html/body/div/div/div/div/div[3]/div[2]/div/div/div[2]/div[2]/div/div/form/div[4]/div/button/span")
    private WebElement loginButton;

    public MegaTopLoginPage openPage(){
        driver.get(LOGIN_URL);
        return this;
    }

    public MegaTopLoginPage(WebDriver driver){
        super(driver);
    }

    public String loginUser(String phoneNumber,String password){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(mobilePhone)).sendKeys(phoneNumber);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(password);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return loginButton.getText().trim();
    }
}
