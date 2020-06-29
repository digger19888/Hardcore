package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MailPage;

public class NewEmailTest extends CommonConditions {

    @Test
    public void checkOpenNewEmailPage() {
        new MailPage(driver).openMailPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.minuteinbox.com/");
    }

    @Test
    public void checkEmailExists() {
        String email = new MailPage(driver).openMailPage()
                .getTextOfElement();
        Assert.assertTrue(email.contains("@"));
    }

}
