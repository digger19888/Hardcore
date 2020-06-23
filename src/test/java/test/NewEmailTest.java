package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.MailAdresCreator;

public class NewEmailTest extends CommonConditions {

    @Test
    public void checkOpenNewEmailPage() {
        new MailAdresCreator().openPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://10minutemail.com/");
    }

    @Test
    public void checkEmailExists() {
        String email = new MailAdresCreator().openPage()
                .getEmail();
        Assert.assertTrue(email.contains("@"));
    }

}
