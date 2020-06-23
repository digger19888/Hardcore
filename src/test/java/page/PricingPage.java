package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricingPage extends AbstractPage {

    private static final String LOG_MESSAGE = "try";
    private static final String CLOUD_PRICING_URL = CLOUD_BASE_URL + "pricing";
    private WebElement calculatorsLink = driver.findElement(By.xpath("div.cloud-jump-menu__links a[href*=calculators]"));

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    public PricingPage openPage() {
        LOGGER.info(LOG_MESSAGE);
        driver.navigate().to(CLOUD_PRICING_URL);
        return this;
    }

    public CalculatorPage openCalculatorPage(){
        LOGGER.info(LOG_MESSAGE);
        wait.until(ExpectedConditions.visibilityOf(calculatorsLink));
        calculatorsLink.click();
        return new CalculatorPage(driver);
    }

}
