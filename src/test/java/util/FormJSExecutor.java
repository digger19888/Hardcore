package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface FormJSExecutor {

    WebDriver driver = new ChromeDriver();

    JavascriptExecutor js = (JavascriptExecutor) driver;

    static void clickElementById(String id){
        String script = String.format("document.getElementById('%s').click();", id);
        js.executeScript(script);
    }

    static void clickElementByCss(String selector){
        String script = String.format("document.querySelector('%s').click();", selector);
        js.executeScript(script);
    }

    static void openNewBrowserTab(){
        js.executeScript("window.open('');");
    }

}
