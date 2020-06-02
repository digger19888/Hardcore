package page;

import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class MainPage extends AbstractPage
{
    private static final String LOG_MESSAGE = "try";
    private String productsDDL = "cloudx-tabs-nav a[data-label='Tab: Products']";
    private String allProductsBtn = "div.dropdown-tabbed-menu-button > a[track-name~=Products]";

    public MainPage openPage() {
        LOGGER.addLogger(Logger.getLogger(LOG_MESSAGE));
        .openPage(CLOUD_BASE_URL);
    }
}
