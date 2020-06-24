package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage extends AbstractPage {

    private String cloudCalculatorUrl = cloudBaseUrl + "products/calculator";
    private String calculatorFormXpath = "//iframe[@src='/products/calculator/index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']";

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openPage() {
        driver.navigate().to(cloudCalculatorUrl);
        return this;
    }

    public CalculatorForm getCalculatorInputForm() {
        WebElement calculatorForm = driver.findElement(By.xpath(calculatorFormXpath));
        driver.switchTo().frame(calculatorForm);
        driver.switchTo().frame(0);
        return new CalculatorForm(driver);
    }
}
