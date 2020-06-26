//package service;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.internal.FindsByCssSelector;
//import org.openqa.selenium.support.FindBy;
//import page.AbstractPage;
//
//import static util.RowCutter.getValueFromJsonRow;
//
//public class MailAdresCreator extends AbstractPage {
//
//    private static final String EMAIL_SERVICE_URL = "https://10minutemail.com/";
//    private static final String EMAIL_ADDRESS_URL = "https://10minutemail.com/session/address";
//
//    public MailAdresCreator(WebDriver driver) {
//        super(driver);
//    }
//
//    public MailAdresCreator openMailPage() {
//        driver.navigate().to(EMAIL_SERVICE_URL);
//        return this;
//    }
//
//    public String getEmail() {
//        String email = getValueFromJsonRow(("body > pre").getText());
//        LOGGER.info("email received: " + email);
//        return email;
//    }

//    public static String getTotalEstimationMessage() throws InterruptedException {
//        wait.until(ExpectedConditions.visibilityOf(emailCounter));
//        WebElement emailCounter  = driver.findElement(By.xpath(emailCounterXpath));
//        email_top = driver.findElement(By.xpath("#mail_messages_content div.message_top"));
//        total_estimatioin_message = driver.findElement(By.xpath("#mobilepadding > td > h2"));
//        waitUntilEmailReceived();
//        email_top.click();
//        wait.until(ExpectedConditions.visibilityOf(total_estimatioin_message));
//        String estimation = total_estimatioin_message.getText();
//        LOGGER.info("total estimation text: " + estimation);
//        return RowCutter.removeCharsBeforeColon(estimation);
//    }

//    private void waitUntilEmailReceived() throws InterruptedException {
//        String count;
//        int x = 0;
//        do {
//            count = email_counter.getText();
//            LOGGER.info(String.format("iteration: %d value [%s]", x++, count));
//            Thread.sleep(1000);
//        } while ("0".equals(count));
//    }
//}

