package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.RowCutter;

import java.util.ArrayList;

public class CalculatorForm extends AbstractPage {

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
        return this;
    }

    public String getTotalEstimationText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(totalEstimationTextXpath)));
        WebElement totalEstimationTextSelector = driver.findElement(By.cssSelector(totalEstimationTextXpath));
        String result = totalEstimationTextSelector.getText();
        return RowCutter.removeCharsBeforeColon(result);
    }

    public CalculatorForm clickEmailEstimate() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailEstimateBtnXpath)));
        WebElement emailEstimateBtn = driver.findElement(By.xpath(emailEstimateBtnXpath));
        wait.until(ExpectedConditions.visibilityOf(emailEstimateBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", emailEstimateBtn);
        return this;
    }

    public CalculatorForm sendEstimateToEmail() {

        WebElement emailInputField = driver.findElement(By.xpath(emailInputFieldXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('" + emailInputField.getAttribute("id") + "').focus()");

        driver.findElement(By.xpath(emailInputFieldXpath)).clear();
        driver.findElement(By.xpath(emailInputFieldXpath)).sendKeys(emailName);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sendEmailBtnSelector)));
        WebElement sendEmailBtn = driver.findElement(By.xpath(sendEmailBtnSelector));
        JavascriptExecutor executor3 = (JavascriptExecutor) driver;
        executor3.executeScript("arguments[0].click();", sendEmailBtn);
        return this;
    }

    public CalculatorForm backToPreviousBrowserTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)); //switches to previous
        return this;
    }

    public CalculatorForm getTotalEstimationMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(totalEstimatioinMessageXpath)));
        WebElement totalEstimatioinMessage = driver.findElement(By.xpath(totalEstimatioinMessageXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", totalEstimatioinMessage);
        return this;
    }

    public String getTotalEstimationMessageText() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iframeMail")));
        String estimation = (String) ((JavascriptExecutor) driver).executeScript("return document.getElementById('iframeMail').contentWindow.document.getElementsByTagName('h2')[0].textContent;");
        return RowCutter.removeCharsBeforeColon(estimation);
    }

    private String instancesInputFieldXpath = "//input[@id='input_58']";
    private String machineTypeFieldXpath = "//*[@id='select_83']//span[@class]";
    private String numberOfGpusXpath = "//*[@id='select_337']//span[@class='md-select-icon']";
    private String gpuTypeOptionsXpath = "//*[@id='select_339']//span[@class='md-select-icon']";
    private String localSsdOptionsXpath = "//*[@id='select_170']//span[@class='md-select-icon']";
    private String datacentrLocationXpath = "//*[@id='select_85']//span[@class='md-select-icon']";
    private String committedUsageXpath = "//*[@id='select_92']//span[@class='md-select-icon']";
    private String totalEstimationTextXpath = "#resultBlock > md-card > md-card-content > div > div > div > h2 > b";
    private String emailInputFieldXpath = "//*[@id='input_404']";
    private String totalEstimatioinMessageXpath = "//td[@class='from'][contains(.,'Google Cloud Sales')]";

    private String machineTypeId = "//div[contains(text(),'%s')]";
    private String addGpusCheckboxXpath = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
    private String numberOfGpusId = "//md-option[@id='select_option_342']/div[contains(text(),'%s')]";
    private String gpuTypeId = "//div[contains(text(),'%s')]";
    private String localSsdId = "//div[contains(text(),'%s')]";
    private String datacentrLocationId = "//md-option[@id='select_option_181']/div[contains(text(),'%s')]";
    private String committedUsageId = "//md-option[@id='select_option_90']/div[contains(text(),'%s')]";
    private String addToEstimateBtnXpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']";
    private String emailEstimateBtnXpath = "//div[@class='layout-align-space-between-start layout-row']/button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][contains(@id,'quote')][contains(.,'Email Estimate')]";//"//div[@class='layout-align-space-between-start layout-row']/button[contains(.,'Email Estimate')]";
    private String sendEmailBtnSelector = "//button[contains(@aria-label,'Send Email')]";
}
