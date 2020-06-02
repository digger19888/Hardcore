package page;

import org.openqa.selenium.WebDriver;

import java.util.logging.LogManager;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected static final LogManager LOGGER = LogManager.getLogManager();
    protected static final String CLOUD_BASE_URL = "https://cloud.google.com/";
    protected abstract AbstractPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver)
    {
this.driver=driver;
        }
}
