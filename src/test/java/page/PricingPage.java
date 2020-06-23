package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricingPage extends AbstractPage {

    private String cloudPricingUrl = cloudBaseUrl + "pricing";
    private WebElement calculatorsLink = driver.findElement(By.xpath("div.cloud-jump-menu__links a[href*=calculators]"));

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    public PricingPage openPage() {
        driver.navigate().to(cloudPricingUrl);
        return this;
    }

    public CalculatorPage openCalculatorPage(){
        wait.until(ExpectedConditions.visibilityOf(calculatorsLink));
        calculatorsLink.click();
        return new CalculatorPage(driver);
    }

}
