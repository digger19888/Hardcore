//package util;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BrowserTabSwitcher {
//
//    private String currentBrowserTab;
//    private String currentFrame;
//    WebDriver driver = new ChromeDriver();
//
//   public void switchToNewTab() {
//       ((JavascriptExecutor)driver).executeScript("window.open()");
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1)); //switches to new tab
//        driver.get("https://10minutemail.com/session/address");
//    }
//
//    public void closeCurrentWindowAndSwitchBackToPreviousTab() {
//        driver.close();
//        switchBackToPreviousTab();
//    }
//
//    public void switchBackToPreviousTab() {
//        if (currentBrowserTab != null) {
//            driver.switchTo().window(currentBrowserTab);
//        }
//        if (currentFrame != null) {
//            switchToIframe(currentFrame);
//        }
//        removeCurrentBrowserTabAndFrame();
//    }
//
//    public void switchToNextToCurrentTab() {
//        saveCurrentBrowserTabAndFrame();
//        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
//        int tabIndex = browserTabs.indexOf(currentBrowserTab);
//        if (tabIndex < browserTabs.size() - 1) {
//            driver.switchTo().window(String.valueOf(tabIndex + 1));
//        }
//    }
//
//    private void saveCurrentBrowserTabAndFrame() {
//        currentBrowserTab = driver.getWindowHandle();
////        LOGGER.info("current browser tab: " + driver.getCurrentUrl() + "tab name: " + currentBrowserTab);
////        if (!driver.getCurrentUrl().equals(currentFrameUrl())) {
////            currentFrame = currentFrameUrl();
////            LOGGER.info("current frame: " + currentFrame);
////        }
//    }
//
//    private String getNameOrIdOfIframe(WebElement iframe) {
//        String name = iframe.getAttribute("name");
//        String id = iframe.getAttribute("id");
//        return (name.length() > id.length()) ? name : id;
//    }
//
//    private boolean switchToIframe(String targetIframeSrc) {
//        List<WebElement> iframes = driver.findElements(By.cssSelector("iframe[src]"));
//        boolean isFound = false;
//
//        if (!iframes.isEmpty()) {
//            for (WebElement iframe : iframes) {
//                boolean
//                        isSrcAlmostEquals =
//                        targetIframeSrc.contains(iframe.getAttribute("src"));
//                String iframeNameOrId = getNameOrIdOfIframe(iframe);
//                driver.switchTo().frame(iframeNameOrId);
//
//                if (isSrcAlmostEquals) {
//                    LOGGER.info("switchToIframe = TRUE for iframe: " + iframeNameOrId);
//                    isFound = true;
//                    break;
//                } else {
//                    if (switchToIframe(targetIframeSrc)) {
//                        LOGGER.info("switchToIframe = TRUE AFTER LOOP");
//                        isFound = true;
//                        break;
//                    } else {
//                        driver.switchTo().parentFrame();
//                        LOGGER.info("switchToIframe = FALSE AFTER LOOP");
//                        isFound = false;
//                    }
//                }
//            }
//        }
//        return isFound;
//    }
//
//    private void removeCurrentBrowserTabAndFrame() {
//        currentBrowserTab = null;
//        currentFrame = null;
//    }
//
//}
