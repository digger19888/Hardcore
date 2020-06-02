package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    protected WebDriver driver;
    protected static final String USER_NAME = "";
    protected static final String USER_PASSWORD = "";
    private static final String RESOURCES_PATH = "";

    @BeforeMethod()
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        driver.quit();
    }
}
