package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends AbstractPage {

    private static final String LOG_MESSAGE = "try";
    private static final String CLOUD_PRODUCTS_URL = CLOUD_BASE_URL + "products";
    private WebElement seePricingBtn = driver.findElement(By.xpath("#google-cloud-products  a.cloud-button.cloud-button--secondary"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage openPage() {
        LOGGER.info(LOG_MESSAGE);
        driver.navigate().to(CLOUD_PRODUCTS_URL);
        return this;
    }

    public PricingPage openPricingPage(){
        LOGGER.info(LOG_MESSAGE);
        wait.until(ExpectedConditions.visibilityOf(seePricingBtn));
        seePricingBtn.click();
        return new PricingPage(driver);
    }

}
