package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends AbstractPage {

    private String cloudProductsUrl = cloudBaseUrl + "products";
    private WebElement seePricingBtn = driver.findElement(By.xpath("#google-cloud-products  a.cloud-button.cloud-button--secondary"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage openPage() {
        driver.navigate().to(cloudProductsUrl);
        return this;
    }

    public PricingPage openPricingPage(){
        wait.until(ExpectedConditions.visibilityOf(seePricingBtn));
        seePricingBtn.click();
        return new PricingPage(driver);
    }

}
