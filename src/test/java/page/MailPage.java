package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class MailPage extends AbstractPage {

    private String copyEmailAdressBtnXpath = "//a[@class='btn btn-big cetc'][contains(.,'Copy')]";
    private String copyEmailAdressFieldXpath = "//div[@class='col-xs-12 email-col']/span[@id='email']";

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MailPage openMailPage() {
        driver.navigate().to(mailBaseUrl);
        return this;
    }

    public MailPage getEmail() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(copyEmailAdressBtnXpath)));
        WebElement copyEmailAdressBtn = driver.findElement(By.xpath(copyEmailAdressBtnXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", copyEmailAdressBtn);
        return this;
    }

    public MailPage openNewBrowserTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        driver.get(cloudBaseUrl);
        return this;
    }

    public String getTextOfElement() {
        emailName = driver.findElement(By.xpath(copyEmailAdressFieldXpath)).getText();
        return emailName;
    }

}
