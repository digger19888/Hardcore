package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.RowCutter;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class CalculatorForm extends AbstractPage {

    private String instancesInputFieldXpath = "//input[@id='input_58']";
    private String machineTypeFieldXpath = "//*[@id='select_83']//span[@class]";
    private String numberOfGpusXpath = "//*[@id='select_337']//span[@class='md-select-icon']";
    private String gpuTypeOptionsXpath = "//*[@id='select_339']//span[@class='md-select-icon']";
    private String localSsdOptionsXpath = "//*[@id='select_170']//span[@class='md-select-icon']";
    private String datacentrLocationXpath = "//*[@id='select_85']//span[@class='md-select-icon']";
    private String committedUsageXpath = "//*[@id='select_92']//span[@class='md-select-icon']";
    private String totalEstimationTextXpath = "#resultBlock > md-card > md-card-content > div > div > div > h2 > b";
    private String emailInputFieldXpath = "//*[@id='input_404']";//"form[name=\"emailForm\"] input[ng-model=\"emailQuote.user.email\"]";
    private String totalEstimatioinMessageXpath = "//td[@class='from'][contains(.,'Google Cloud Sales')]";
//    private String copyEmailAdressBtnXpath = "//a[@class='btn btn-big cetc'][contains(.,'Copy')]";
//    private String wXpath = "//h2[@class='md-toolbar-tools'][contains(.,'Email Your Estimate')]";


    private String totalEstimationEmailMessageTextXpath = "#mobilepadding > td > h2";
    private String machineTypeId = "//div[contains(text(),'%s')]";
    private String addGpusCheckboxXpath = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
    private String numberOfGpusId = "//md-option[@id='select_option_342']/div[contains(text(),'%s')]";
    private String gpuTypeId = "//div[contains(text(),'%s')]";
    private String localSsdId = "//div[contains(text(),'%s')]";
    private String datacentrLocationId = "//md-option[@id='select_option_181']/div[contains(text(),'%s')]";
    private String committedUsageId = "//md-option[@id='select_option_90']/div[contains(text(),'%s')]";
    private String addToEstimateBtnXpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']";//"//button[@aria-label='Add to Estimate']/div[1]";
    private String emailEstimateBtnXpath = "//div[@class='layout-align-space-between-start layout-row']/button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][contains(@id,'quote')][contains(.,'Email Estimate')]";//"//div[@class='layout-align-space-between-start layout-row']/button[contains(.,'Email Estimate')]";
    private String sendEmailBtnSelector = "//button[contains(@aria-label,'Send Email')]";//"form[name=\"emailForm\"] button[aria-label=\"Send Email\"]";

//    private String calculatorUrl;
//    private String emailName;

    public CalculatorForm(WebDriver driver) {
        super(driver);
    }

    public CalculatorForm setNumberOfInstances(int numberOfInstances) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(instancesInputFieldXpath)));
        WebElement instancesInputField = driver.findElement(By.xpath(instancesInputFieldXpath));
        wait.until(ExpectedConditions.visibilityOf(instancesInputField));
        instancesInputField.sendKeys(Integer.toString(numberOfInstances));
        return this;
    }

    public CalculatorForm selectMachineType(String machineType) {
        WebElement machineTypeOptions = driver.findElement(By.xpath(machineTypeFieldXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", machineTypeOptions);
        WebElement machineTypeItem = driver.findElement(By.xpath(String.format(machineTypeId, machineType)));
        executor.executeScript("arguments[0].click();", machineTypeItem);
        return this;
    }

    public CalculatorForm checkGPUsValue() {

        WebElement checkGpusCheckbox = driver.findElement(By.xpath(addGpusCheckboxXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkGpusCheckbox);
        return this;
    }

    public CalculatorForm addGpus(String numberOfGpus, String gpuType) {
        WebElement numberOfGPUsField = driver.findElement(By.xpath(numberOfGpusXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", numberOfGPUsField);
        WebElement numberOfGPUsItem = driver.findElement(By.xpath(String.format(numberOfGpusId, numberOfGpus)));
        executor.executeScript("arguments[0].click();", numberOfGPUsItem);

        WebElement typesOfGPUsField = driver.findElement(By.xpath(gpuTypeOptionsXpath));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", typesOfGPUsField);
        WebElement typesOfGPUsItem = driver.findElement(By.xpath(String.format(gpuTypeId, gpuType)));
        executor1.executeScript("arguments[0].click();", typesOfGPUsItem);
        return this;
    }

    public CalculatorForm selectLocalSSD(String localSSD) {
        WebElement localSsdOptions = driver.findElement(By.xpath(localSsdOptionsXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", localSsdOptions);
        WebElement localSSDItem = driver.findElement(By.xpath(String.format(localSsdId, localSSD)));
        executor.executeScript("arguments[0].click();", localSSDItem);
        return this;
    }

    public CalculatorForm selectDatacenterLocation(String datacenterLocation) {
        WebElement datacentrLocationField = driver.findElement(By.xpath(datacentrLocationXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", datacentrLocationField);
        WebElement datacentrLocationItem = driver.findElement(By.xpath(String.format(datacentrLocationId, datacenterLocation)));
        executor.executeScript("arguments[0].click();", datacentrLocationItem);
        return this;
    }

    public CalculatorForm selectCommittedUsage(String committedUsage) {
        WebElement committedUsageField = driver.findElement(By.xpath(committedUsageXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", committedUsageField);
        WebElement committedUsageItem = driver.findElement(By.xpath(String.format(committedUsageId, committedUsage)));
        executor.executeScript("arguments[0].click();", committedUsageItem);
        return this;
    }

    public CalculatorForm clickAddToEstimate() {
        WebElement addToEstimateBtn = driver.findElement(By.xpath(addToEstimateBtnXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToEstimateBtn);
//        calculatorUrl = driver.getCurrentUrl();
        return this;
    }

    public String getTotalEstimationText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(totalEstimationTextXpath)));
        WebElement totalEstimationTextSelector = driver.findElement(By.cssSelector(totalEstimationTextXpath));
        String result = totalEstimationTextSelector.getText();
        return RowCutter.removeCharsBeforeColon(result);
    }

//    public CalculatorForm openNewBrowserTab() {
//        ((JavascriptExecutor) driver).executeScript("window.open()");
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1)); //switches to new tab
//        driver.get("https://www.minuteinbox.com/");
//        return this;
//    }

//    public CalculatorForm getEmail() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(copyEmailAdressBtnXpath)));
//        WebElement copyEmailAdressBtn = driver.findElement(By.xpath(copyEmailAdressBtnXpath));
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", copyEmailAdressBtn);
//        return this;
//    }

//    public CalculatorForm backToPreviousBrowserTab() {
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(0)); //switches to previous
//        driver.navigate().refresh();
//        driver.get(calculatorUrl);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return this;
//    }

    public CalculatorForm clickEmailEstimate() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailEstimateBtnXpath)));
        WebElement emailEstimateBtn = driver.findElement(By.xpath(emailEstimateBtnXpath));
        wait.until(ExpectedConditions.visibilityOf(emailEstimateBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", emailEstimateBtn);
        return this;
    }

    public CalculatorForm sendEstimateToEmail() throws IOException, UnsupportedFlavorException {

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailInputFieldXpath)));
        WebElement emailInputField = driver.findElement(By.xpath(emailInputFieldXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('" + emailInputField.getAttribute("id") + "').focus()");

//        Actions actions = new Actions(driver);
//        driver.findElement(By.xpath(emailInputFieldXpath)).sendKeys(Keys.chord(Keys.CONTROL, "v"));
//
//        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
//        driver.findElement(By.name("to")).sendKeys(myText);

//        String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
//        emailInputField.sendKeys(data);

        WebElement sendEmailBtn = driver.findElement(By.xpath(sendEmailBtnSelector));
        JavascriptExecutor executor3 = (JavascriptExecutor) driver;
        executor3.executeScript("arguments[0].click();", sendEmailBtn);
        return this;
    }

    public CalculatorForm backToPreviousBrowserTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)); //switches to previous
//        driver.navigate().refresh();
//        driver.get(calculatorUrl);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;
    }

//    public CalculatorForm switchBackEmailBrowserTab() {
////        ((JavascriptExecutor) driver).executeScript("window.open()");
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1)); //switches to email tab
////        driver.get("https://www.minuteinbox.com/");
////        ((JavascriptExecutor)driver).executeScript("window.open('https://10minutemail.com/session/address','_blank')");
//        return this;
//    }

    public CalculatorForm getTotalEstimationMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(totalEstimatioinMessageXpath)));
        WebElement totalEstimatioinMessage = driver.findElement(By.xpath(totalEstimatioinMessageXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", totalEstimatioinMessage);

        return this;
    }

    public String getTotalEstimationMessageText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(totalEstimationEmailMessageTextXpath)));
        WebElement totalEstimationTextSelector = driver.findElement(By.cssSelector(totalEstimationEmailMessageTextXpath));
        String estimation = totalEstimationTextSelector.getText();
        return RowCutter.removeCharsBeforeColon(estimation);
    }

}
