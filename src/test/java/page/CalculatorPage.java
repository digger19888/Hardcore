package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage extends AbstractPage {

    private String cloudCalculatorUrl = cloudBaseUrl + "products/calculator";
    private WebElement calculatorForm = driver.findElement(By.xpath("#cloud-site > devsite-iframe > iframe"));

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openPage() {
        driver.navigate().to(cloudCalculatorUrl);
        return this;
    }

    public CalculatorForm getCalculatorInputForm() {
        driver.switchTo().frame(calculatorForm);
        driver.switchTo().frame(0);
        return new CalculatorForm(driver);
    }
}
