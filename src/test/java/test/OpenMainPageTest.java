package test;

import org.testng.annotations.Test;
import page.CloudProductsPage;
import page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class OpenMainPageTest extends CommonConditions {
    @Test
    public void checkOpenMainPage() {
        new MainPage(driver).openCloudProductsPage();
        assertThat("https://cloud.google.com/", is(equalTo(driver.getCurrentUrl())));
    }

}
