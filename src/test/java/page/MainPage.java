package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    private final String CLOUD_BASE_URL = "https://cloud.google.com/";

    private final By nameMainPageLocator = By.xpath("//meta[@property='og:site_name']");
    private WebElement productsDDL = driver.findElement(By.xpath("cloudx-tabs-nav a[data-label='Tab: Products']"));
    private WebElement allProductsBtn = driver.findElement(By.xpath("div.dropdown-tabbed-menu-button > a[track-name~=Products]"));
    public MainPage(WebDriver driver)
    {
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
        productsDDL.shouldBe(Condition.visible).click();
        allProductsBtn.shouldBe(Condition.visible).click();
        return new ProductsPage();


//    public String getOpenedMainPage()
//    {
//        WebElement nameMainPage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//                .until(ExpectedConditions.presenceOfElementLocated(nameMainPageLocator));
//        return nameMainPage.getAttribute("Google Cloud");
//    }
}
