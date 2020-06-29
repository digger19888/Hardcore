package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.MainPage;
import page.PricingPage;
import page.ProductsPage;

public class CloudPageTest extends CommonConditions {


    @Test
    public void checkOpenMainPage() {
        new MainPage(driver).openPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://cloud.google.com/");
    }

    @Test
    public void checkOpenProductPageFromMain() {
        new MainPage(driver).openPage().openCloudProductsPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://cloud.google.com/products");
    }

    @Test
    public void checkOpenProductPage() {
        new ProductsPage(driver).openPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://cloud.google.com/products");
    }


    @Test
    public void checkOpenPricingPage() {
        new PricingPage(driver).openPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://cloud.google.com/pricing");
    }

    @Test
    public void checkOpenCalculatorPageFromMain() {
        new MainPage(driver).openPage().openCloudProductsPage()
                .openPricingPage()
                .openCalculatorPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://cloud.google.com/products/calculator");
    }

    @Test
    public void checkOpenCalculatorPage() {
        new CalculatorPage(driver).openPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://cloud.google.com/products/calculator");
    }


}
