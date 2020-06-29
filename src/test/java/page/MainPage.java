package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {
    private String productBtnXpath = "/html/body/section/devsite-header/div/div[1]/div/div/div[2]/div[1]/cloudx-tabs-nav/div/tab[3]/a[1]";
    private String productsDdlXpath = "/html/body/section/devsite-header/div/div[1]/div/div/div[2]/div[1]/cloudx-tabs-nav/div/tab[3]/a[1]";
    private String allProductsBtnXpath = "//div[@class='devsite-nav-item-title'][contains(.,'See all products (100+)')]";

    public MainPage openPage() {
        driver.navigate().to(cloudBaseUrl);
        return this;
    }

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CloudProductsPage openCloudProductsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productBtnXpath)));
        WebElement productsDDL = driver.findElement(By.xpath(productsDdlXpath));
        productsDDL.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(allProductsBtnXpath)));
        WebElement allProductsBtn = driver.findElement(By.xpath(allProductsBtnXpath));
        allProductsBtn.click();
        return new CloudProductsPage(driver);
    }
}