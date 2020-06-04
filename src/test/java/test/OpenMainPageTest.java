package test;

import org.testng.annotations.Test;
import page.MainPage;

import javax.tools.StandardJavaFileManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class OpenMainPageTest extends CommonConditions {
    @Test
    public void checkOpenMainPage () {
                MainPage namedOpenPage = new MainPage(driver)
                        .openPage();
                driver.getCurrentUrl();
        assertThat("https://cloud.google.com/", is(equalTo(driver.getCurrentUrl())));
    }

}
