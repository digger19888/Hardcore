//package page;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import java.util.concurrent.locks.Condition;
//import java.util.logging.Logger;
//
//public class MainPage extends AbstractPage {
//
//    private static final String LOG_MESSAGE = "try";
//
//    WebElement productsDDLBtn = driver.findElement(By.xpath("cloudx-tabs-nav a[data-label='Tab: Products']"));
//    WebElement allProductsBtn = driver.findElement(By.xpath("div.dropdown-tabbed-menu-button > a[track-name~=Products]"));
//
//    public MainPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public MainPage openMainPage() {
//        LOGGER.addLogger(Logger.getLogger(LOG_MESSAGE));
//        driver.get(CLOUD_BASE_URL);
//        return this;
//    }
//
//    public ProductsPage openProductsPage() {
//        LOGGER.addLogger(Logger.getLogger(LOG_MESSAGE));
//        productsDDLBtn.click();
//        allProductsBtn.click();
//        return new ProductsPage();
//    }
//}
