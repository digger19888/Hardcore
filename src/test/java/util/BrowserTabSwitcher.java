package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class BrowserTabSwitcher {

    private static final String LOG_MESSAGE = "try";
    private static final Logger LOGGER = LogManager.getRootLogger();
    private String currentBrowserTab;
    private String currentFrame;
    WebDriver driver = new ChromeDriver();

    public void switchToNewTab() {
        LOGGER.info(LOG_MESSAGE);
        saveCurrentBrowserTabAndFrame();
        FormJSExecutor.openNewBrowserTab();
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(browserTabs.indexOf(currentBrowserTab) + 1));
    }

    public void closeCurrentWindowAndSwitchBackToPreviousTab() {
        LOGGER.info(LOG_MESSAGE);
        driver.close();
        switchBackToPreviousTab();
    }

    public void switchBackToPreviousTab() {
        LOGGER.info(LOG_MESSAGE);
        if (currentBrowserTab != null) {
            driver.switchTo().window(currentBrowserTab);
        }
        if (currentFrame != null) {
            switchToIframe(currentFrame);
        }
        removeCurrentBrowserTabAndFrame();
    }

    public void switchToNextToCurrentTab() {
        LOGGER.info(LOG_MESSAGE);
        saveCurrentBrowserTabAndFrame();
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        int tabIndex = browserTabs.indexOf(currentBrowserTab);
        if (tabIndex < browserTabs.size() - 1) {
            driver.switchTo().window(String.valueOf(tabIndex + 1));
        }
    }

    private void saveCurrentBrowserTabAndFrame() {
        currentBrowserTab = driver.getWindowHandle();
        LOGGER.info("current browser tab: " + url() + "tab name: " + currentBrowserTab);
        if (!url().equals(currentFrameUrl())) {
            currentFrame = currentFrameUrl();
            LOGGER.info("current frame: " + currentFrame);
        }
    }

    private String getNameOrIdOfIframe(WebElement iframe) {
        String name = iframe.getAttribute("name");
        String id = iframe.getAttribute("id");
        return (name.length() > id.length()) ? name : id;
    }

    private boolean switchToIframe(String targetIframeSrc) {
        LOGGER.info(LOG_MESSAGE);
        List<WebElement> iframes = driver.findElements(By.cssSelector("iframe[src]"));
        boolean isFound = false;

        if (!iframes.isEmpty()) {
            for (WebElement iframe : iframes) {
                boolean
                        isSrcAlmostEquals =
                        targetIframeSrc.contains(iframe.getAttribute("src"));
                String iframeNameOrId = getNameOrIdOfIframe(iframe);
                driver.switchTo().frame(iframeNameOrId);

                if (isSrcAlmostEquals) {
                    LOGGER.info("switchToIframe = TRUE for iframe: " + iframeNameOrId);
                    isFound = true;
                    break;
                } else {
                    if (switchToIframe(targetIframeSrc)) {
                        LOGGER.info("switchToIframe = TRUE AFTER LOOP");
                        isFound = true;
                        break;
                    } else {
                        driver.switchTo().parentFrame();
                        LOGGER.info("switchToIframe = FALSE AFTER LOOP");
                        isFound = false;
                    }
                }
            }
        }
        return isFound;
    }

    private void removeCurrentBrowserTabAndFrame() {
        currentBrowserTab = null;
        currentFrame = null;
    }

}
