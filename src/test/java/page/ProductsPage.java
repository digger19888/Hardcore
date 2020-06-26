package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends AbstractPage {
    private String cloudProductsUrl = cloudBaseUrl + "products";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage openPage() {
        driver.navigate().to(cloudProductsUrl);
        return this;
    }
}
