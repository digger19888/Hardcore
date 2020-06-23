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
        new MainPage().openPage();
        Assert.assertEquals(url, "https://cloud.google.com/");
    }

    @Test
    public void checkOpenProductPageFromMain() {
        new MainPage().openPage()
                .openProductsPage();
        Assert.assertEquals(url, "https://cloud.google.com/products");
    }

    @Test
    public void checkOpenProductPage() {
        new ProductsPage().openPage();
        Assert.assertEquals(url, "https://cloud.google.com/products");
    }

    @Test
    public void checkOpenPricingPageFromMain() {
        new MainPage().openPage()
                .openProductsPage().openPage()
                .openPricingPage();
        Assert.assertEquals(url, "https://cloud.google.com/pricing");
    }

    @Test
    public void checkOpenPricingPage() {
        new PricingPage().openPage();
        Assert.assertEquals(url, "https://cloud.google.com/pricing");
    }

    @Test
    public void checkOpenCalculatorPageFromMain() {
        new MainPage().openPage()
                .openProductsPage().openPage()
                .openPricingPage()
                .openCalculatorPage();
        Assert.assertEquals(url, "https://cloud.google.com/products/calculator");
    }

    @Test
    public void checkOpenCalculatorPage() {
        new CalculatorPage().openPage();
        Assert.assertEquals(url, "https://cloud.google.com/products/calculator");
    }


}
