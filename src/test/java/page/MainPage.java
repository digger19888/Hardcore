package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

    private WebElement productsDDL;
    private WebElement allProductsBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

//    public MainPage openMainPage() {
//        driver.navigate().to(cloudBaseUrl);
//        return this;
//    }

    public CloudProductsPage openCloudProductsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section/devsite-header/div/div[1]/div/div/div[2]/div[1]/cloudx-tabs-nav/div/tab[3]/a[1]")));
        productsDDL = driver.findElement(By.xpath("/html/body/section/devsite-header/div/div[1]/div/div/div[2]/div[1]/cloudx-tabs-nav/div/tab[3]/a[1]"));
        productsDDL.click();
        allProductsBtn = driver.findElement(By.xpath("//tab/a[@href='/products']"));
        wait.until(ExpectedConditions.visibilityOf(allProductsBtn));
        allProductsBtn.click();
        return new CloudProductsPage(driver);
    }
}