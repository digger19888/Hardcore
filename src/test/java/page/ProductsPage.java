//package page;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import java.util.logging.Logger;
//
//public class ProductsPage extends AbstractPage {
//
//    private static final String LOG_MESSAGE = "try";
//    private static final String CLOUD_PRODUCTS_URL = CLOUD_BASE_URL + "products";
//
//    WebElement seePricingBtn = driver.get(By.xpath(PRICING_BUTTON_XPATH));
//
//    protected ProductsPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public ProductsPage() {
//        super();
//    }
//
//    public ProductsPage openPage() {
//        LOGGER.addLogger(Logger.getLogger(LOG_MESSAGE));
//        driver.get(CLOUD_PRODUCTS_URL);
//        return this;
//    }
//
//    public PricingPage openPricingPage(){
//        LOGGER.addLogger(Logger.getLogger(LOG_MESSAGE));
//        seePricingBtn.until(ExpectedConditions.visibilityOf(seePricingBtn)).click();
//        return new PricingPage();
//    }
//}
