package page;

import org.openqa.selenium.WebDriver;

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
