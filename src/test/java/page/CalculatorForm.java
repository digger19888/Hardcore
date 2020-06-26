package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.RowCutter;
import util.TestListener;

import java.util.ArrayList;

import static util.RowCutter.getValueFromJsonRow;

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
    private String totalEstimatioinMessageXpath = "\"#mobilepadding > td > h2\"";
    private String copyEmailAdressBtnXpath = "//a[@class='btn btn-big cetc'][contains(.,'Copy')]";

    private String emailCounterXpath = "#inbox_count_number";
    private String emailTopXpath = "#mail_messages_content div.message_top";
    private String machineTypeId = "//div[contains(text(),'%s')]";
    private String addGpusCheckboxXpath = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
    private String numberOfGpusId = "//md-option[@id='select_option_342']/div[contains(text(),'%s')]";
    private String gpuTypeId = "//div[contains(text(),'%s')]";
    private String localSsdId = "//div[contains(text(),'%s')]";
    private String datacentrLocationId = "//md-option[@id='select_option_181']/div[contains(text(),'%s')]";
    private String committedUsageId = "//md-option[@id='select_option_90']/div[contains(text(),'%s')]";
    private String addToEstimateBtnXpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']";//"//button[@aria-label='Add to Estimate']/div[1]";
    private String emailEstimateBtnId = "email_quote";
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


    public CalculatorForm openNewBrowserTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        driver.get("https://www.minuteinbox.com/");
//        ((JavascriptExecutor)driver).executeScript("window.open('https://10minutemail.com/session/address','_blank')");
        return this;
    }

    public CalculatorForm getEmail() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(copyEmailAdressBtnXpath)));
        WebElement copyEmailAdressBtn = driver.findElement(By.xpath(copyEmailAdressBtnXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", copyEmailAdressBtn);
        return this;
    }

    public CalculatorForm backToPreviousBrowserTab() {
//        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)); //switches to previous
//        driver.get("https://10minutemail.com/session/address");
//        ((JavascriptExecutor)driver).executeScript("window.open('https://10minutemail.com/session/address','_blank')");
        return this;
    }

    public CalculatorForm clickEmailEstimate() {
        WebElement emailEstimateBtn = driver.findElement(By.id(emailEstimateBtnId));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", emailEstimateBtn);
        return this;
    }

    public CalculatorForm sendEstimateToEmail() {
//        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailInputFieldXpath)));
        WebElement emailInputField = driver.findElement(By.xpath(emailInputFieldXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", emailInputField);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();

        WebElement sendEmailBtn = driver.findElement(By.xpath(sendEmailBtnSelector));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", sendEmailBtn);
        return this;
    }

    public CalculatorForm openAnotherNewBrowserTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2)); //switches to new tab
        driver.get("https://10minutemail.com/");
//        ((JavascriptExecutor)driver).executeScript("window.open('https://10minutemail.com/session/address','_blank')");
        return this;
    }

    public String getTotalEstimationMessage() throws InterruptedException {
        WebElement emailCounter = driver.findElement(By.cssSelector(emailCounterXpath));
        wait.until(ExpectedConditions.visibilityOf(emailCounter));
        WebElement emailTop = driver.findElement(By.cssSelector(emailTopXpath));
        wait.until(ExpectedConditions.visibilityOf(emailTop)).click();
//        waitUntilEmailReceived();
        WebElement totalEstimatioinMessage = driver.findElement(By.cssSelector(totalEstimatioinMessageXpath));
        wait.until(ExpectedConditions.visibilityOf(totalEstimatioinMessage));
        String estimation = totalEstimatioinMessage.getText();
        LOGGER.info("total estimation text: " + estimation);
        return RowCutter.removeCharsBeforeColon(estimation);
    }

//    private void waitUntilEmailReceived() throws InterruptedException {
//        String count;
//        int x = 0;
//        do {
//            count = emailCounterXpath.;
//            LOGGER.info(String.format("iteration: %d value [%s]", x++, count));
//            Thread.sleep(1000);
//        } while ("0".equals(count));
//    }

}
