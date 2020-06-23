package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.AbstractPage;
import util.BrowserTabSwitcher;
import util.RowCutter;

import static util.RowCutter.getValueFromJsonRow;

public class MailAdresCreator extends AbstractPage {

    private static final String LOG_MESSAGE = "try";
    private static final String EMAIL_SERVICE_URL = "https://10minutemail.com/";
    private static final String EMAIL_ADDRESS_URL = "https://10minutemail.com/session/address";

    private WebElement email_counter;
    private WebElement email_top;
    private WebElement total_estimatioin_message;

    public MailAdresCreator(WebDriver driver) {
        super(driver);
    }

    public MailAdresCreator openPage() {
        LOGGER.info(LOG_MESSAGE);
        driver.navigate().to(EMAIL_SERVICE_URL);
//        wait.until(ExpectedConditions.visibilityOf(email_counter));
//        email_counter = driver.findElement(By.xpath("#inbox_count_number"));
//        email_top = driver.findElement(By.xpath("#mail_messages_content div.message_top"));
//        total_estimatioin_message = driver.findElement(By.xpath("#mobilepadding > td > h2"));
        return this;
    }

    public String getEmail() {
        LOGGER.info(LOG_MESSAGE);

//        BrowserTabSwitcher tabSwitcher = new BrowserTabSwitcher();
//        tabSwitcher.switchToNewTab();

        driver.navigate().to(EMAIL_ADDRESS_URL);
        String email = getValueFromJsonRow("body > pre");

//        tabSwitcher.closeCurrentWindowAndSwitchBackToPreviousTab();
        LOGGER.info("email received: " + email);
        return email;
    }

    public String getTotalEstimationMessage() throws InterruptedException {
        LOGGER.info(LOG_MESSAGE);
        waitUntilEmailReceived();
        email_top.click();
        wait.until(ExpectedConditions.visibilityOf(total_estimatioin_message));
        String estimation = total_estimatioin_message.getText();
        LOGGER.info("total estimation text: " + estimation);
        return RowCutter.removeCharsBeforeColon(estimation);
    }

    private void waitUntilEmailReceived() throws InterruptedException {
        String count;
        int x = 0;
        do {
            count = email_counter.getText();
            LOGGER.info(String.format("iteration: %d value [%s]", x++, count));
            Thread.sleep(1000);
        } while ("0".equals(count));
    }
}

