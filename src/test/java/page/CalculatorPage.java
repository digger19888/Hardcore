package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.locks.Condition;

public class CalculatorPage extends AbstractPage {
    private static final String LOG_MESSAGE = "try";
    private static final String CLOUD_CALCULATOR_URL = CLOUD_BASE_URL + "products/calculator";
    private WebElement calculatorForm = driver.findElement(By.xpath("#cloud-site > devsite-iframe > iframe"));

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openPage() {
        LOGGER.info(LOG_MESSAGE);
        driver.navigate().to(CLOUD_CALCULATOR_URL);
        return this;
    }

    public CalculatorForm getCalculatorInputForm() {
        LOGGER.info(LOG_MESSAGE);

        driver.switchTo().frame(calculatorForm);
        driver.switchTo().frame(0);
        return new CalculatorForm();
    }
}
