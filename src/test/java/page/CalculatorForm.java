package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.RowCutter;

import java.util.List;

import static util.FormJSExecutor.clickElementByCss;

public class CalculatorForm extends AbstractPage {

    private String instancesInputFieldXpath = "//input[@id='input_58']";
    private String machineTypeFieldXpath = "//*[@id='select_83']//span[@class]";
    private String numberOfGpusXpath = "//*[@id='select_337']//span[@class='md-select-icon']";
    private String gpuTypeOptionsXpath = "//*[@id='select_339']//span[@class='md-select-icon']";
    private String localSsdOptionsXpath = "//*[@id='select_170']//span[@class='md-select-icon']";
    private String datacentrLocationXpath = "//*[@id='select_85']//span[@class='md-select-icon']";
    private String committedUsageXpath = "//*[@id='select_92']//span[@class='md-select-icon']";
    private String totalEstimationTextXpath = "#resultBlock > md-card > md-card-content > div > div > div > h2 > b";
    private String emailInputFieldXpath = "//*[@id='input_399']";

    private String machineTypeId = "//div[contains(text(),'%s')]";
    private String addGpusCheckboxXpath = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
    private String numberOfGpusId = "//md-option[@id='select_option_342']/div[contains(text(),'%s')]";
    private String gpuTypeId = "//div[contains(text(),'%s')]";
    private String localSsdId = "//div[contains(text(),'%s')]";
    private String datacentrLocationId = "//md-option[@id='select_option_181']/div[contains(text(),'%s')]";
    private String committedUsageId = "//md-option[@id='select_option_90']/div[contains(text(),'%s')]";
    private String addToEstimateBtnXpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']";//"//button[@aria-label='Add to Estimate']/div[1]";
    //    private String totalEstimationTextSelector = "#resultBlock > md-card > md-card-content > div > div > div > h2 > b";
    private String emailEstimateBtnId = "email_quote";
    //    private String emailInputFieldSelector = "form[name=\"emailForm\"] input[ng-model=\"emailQuote.user.email\"]";
    private String sendEmailBtnSelector = "//button[contains(@aria-label,'Send Email')]";//"form[name=\"emailForm\"] button[aria-label=\"Send Email\"]";

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
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(numberOfGpusXpath)));
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
        WebElement emailEstimateBtn = driver.findElement(By.id(emailEstimateBtnId));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", emailEstimateBtn);
        return this;
    }

    public CalculatorForm sendEstimateToEmail(String email) {
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailInputFieldXpath)));
        WebElement emailInputField = driver.findElement(By.xpath(emailInputFieldXpath));
        emailInputField.sendKeys(email);
        WebElement sendEmailBtn = driver.findElement(By.xpath(sendEmailBtnSelector));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", sendEmailBtn);
        return this;
    }


}
