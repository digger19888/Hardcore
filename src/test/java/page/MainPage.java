package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

    private static final String LOG_MESSAGE = "try";
    private WebElement productsDDL;
    private WebElement allProductsBtn;

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
        productsDDL = driver.findElement(By.xpath("/html/body/section/devsite-header/div/div[1]/div/div/div[2]/div[1]/cloudx-tabs-nav/div/tab[3]/a[1]"));
        productsDDL.click();
        wait.until(ExpectedConditions.visibilityOf(allProductsBtn));
        allProductsBtn = driver.findElement(By.xpath("div.dropdown-tabbed-menu-button > a[track-name~=Products]"));
        allProductsBtn.click();
        return new ProductsPage(driver);

    }
}
