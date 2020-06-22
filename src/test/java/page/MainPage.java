package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    private static final String LOG_MESSAGE = "try";
    private WebElement productsDDL = driver.findElement(By.xpath("cloudx-tabs-nav a[data-label='Tab: Products']"));
    private WebElement allProductsBtn = driver.findElement(By.xpath("div.dropdown-tabbed-menu-button > a[track-name~=Products]"));

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(CLOUD_BASE_URL);
        return null;
    }

    public ProductsPage openProductsPage() {
        LOGGER.info(LOG_MESSAGE);
        wait.until(ExpectedConditions.visibilityOf(productsDDL));
        productsDDL.click();
        wait.until(ExpectedConditions.visibilityOf(allProductsBtn));
        allProductsBtn.click();
        return new ProductsPage();

    }
}
