package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

//    static protected String emailName;
    protected WebDriver driver;
    protected WebDriverWait wait;
    //    protected abstract AbstractPage openPage();
    protected static final Logger LOGGER = LogManager.getRootLogger();
    protected String cloudBaseUrl = "https://cloud.google.com/";
    protected String mailBaseUrl = "https://www.minuteinbox.com/";
    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 50);
        wait.ignoring(StaleElementReferenceException.class);
    }
}

