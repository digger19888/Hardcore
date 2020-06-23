package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudProductsPage extends AbstractPage {

    private String seePricingBtnXpath = "//tab/a[@href='/pricing']";

    public CloudProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public PricingPage openPricingPage() {
        WebElement seePricingBtn = driver.findElement(By.xpath(seePricingBtnXpath));
        wait.until(ExpectedConditions.visibilityOf(seePricingBtn));
        seePricingBtn.click();
        return new PricingPage(driver);
    }

}
