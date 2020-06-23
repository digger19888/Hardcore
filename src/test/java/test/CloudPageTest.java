package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.MainPage;
import page.PricingPage;
import page.ProductsPage;

public class CloudPageTest extends CommonConditions {
    String url = driver.getCurrentUrl();

    @Test
    public void checkOpenMainPage() {
        new MainPage(driver).openPage();
        Assert.assertEquals(url, "https://cloud.google.com/");
    }

    @Test
    public void checkOpenProductPageFromMain() {
        new MainPage(driver).openPage()
                .openProductsPage();
        Assert.assertEquals(url, "https://cloud.google.com/products");
    }

    @Test
    public void checkOpenProductPage() {
        new ProductsPage(driver).openPage();
        Assert.assertEquals(url, "https://cloud.google.com/products");
    }

    @Test
    public void checkOpenPricingPageFromMain() {
        new MainPage(driver).openPage()
                .openProductsPage().openPage()
                .openPricingPage();
        Assert.assertEquals(url, "https://cloud.google.com/pricing");
    }

    @Test
    public void checkOpenPricingPage() {
        new PricingPage(driver).openPage();
        Assert.assertEquals(url, "https://cloud.google.com/pricing");
    }

    @Test
    public void checkOpenCalculatorPageFromMain() {
        new MainPage(driver).openPage()
                .openProductsPage().openPage()
                .openPricingPage()
                .openCalculatorPage();
        Assert.assertEquals(url, "https://cloud.google.com/products/calculator");
    }

    @Test
    public void checkOpenCalculatorPage() {
        new CalculatorPage(driver).openPage();
        Assert.assertEquals(url, "https://cloud.google.com/products/calculator");
    }


}
