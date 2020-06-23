package test;

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
        new MainPage(driver).openCloudProductsPage();
        Assert.assertEquals(url, "https://cloud.google.com/");
    }

    @Test
    public void checkOpenProductPageFromMain() {
        new MainPage(driver).openCloudProductsPage();
        Assert.assertEquals(url, "https://cloud.google.com/products");
    }

    @Test
    public void checkOpenProductPage() {
        new ProductsPage(driver).openPage();
        Assert.assertEquals(url, "https://cloud.google.com/products");
    }

    @Test
    public void checkOpenPricingPageFromMain() {
        new MainPage(driver).openCloudProductsPage()
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
        new MainPage(driver).openCloudProductsPage()
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
