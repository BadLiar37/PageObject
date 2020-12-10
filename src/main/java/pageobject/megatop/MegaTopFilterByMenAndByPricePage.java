package pageobject.megatop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class MegaTopFilterByMenAndByPricePage extends Page {
    private static final String FILTER_URL = "https://megatop.by/catalog/";

    @FindBy(xpath = "/html/body/div[2]/header/div/div/div[1]/div/ul/li[2]")
    private WebElement filterByMen;

    @FindBy(xpath = "//*[contains(@for, 'arrFilter_118_1717685296')]")
    private WebElement priceFilter;

    @FindBy(xpath= "/html/body/div[2]/div/div/div/div/div[3]/div[3]/div[2]/a/span")
    private WebElement filterPopupButton;

    public MegaTopFilterByMenAndByPricePage openPage(){
        driver.get(FILTER_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;
    }

    public MegaTopFilterByMenAndByPricePage(WebDriver driver){
        super(driver);
    }

    public String filterGoods(){
        filterByMen.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        priceFilter.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(filterPopupButton));
        String filterButtonText=filterPopupButton.getText().trim();
        filterPopupButton.click();
        return  filterButtonText;
    }
}
