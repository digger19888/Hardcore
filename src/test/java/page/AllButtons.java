//package page;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import javax.lang.model.element.Element;
//import org.openqa.selenium.By;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//public interface AllButtons {
//
//    String PRICING_BUTTON_XPATH = "#google-cloud-products  a.cloud-button.cloud-button--secondary";
//    WebDriverWait wait = new WebDriverWait(driver, 10);
//
//    default void clickPricingBtn (By by, WebDriver driver, WebDriverWait wait){
//        WebElement pricingBtn = new WebElement (By.xpath(PRICING_BUTTON_XPATH));
//        wait().until(ExpectedConditions.visibilityOf((WebElement) pricingBtn));
//        ((WebElement) pricingBtn).click();
//    }
//}
