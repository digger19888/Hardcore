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

    //    private String  productInputFieldXpath = "#input-0";
//    private List<WebElement> productsOptions = driver.findElements(By.xpath("#ul-0 > li"));
    private String instancesInputFieldXpath = "//input[@id='input_58']";
    private String machineTypeFieldXpath = "//*[@id='select_83']//span[@class]";
    private String numberOfGpusXpath = "//*[@id='select_337']//span[@class='md-select-icon']";
    private String gpuTypeOptionsXpath = "//*[@id='select_339']//span[@class='md-select-icon']";
    private String localSsdOptionsXpath = "//*[@id='select_170']//span[@class='md-select-icon']";
    private String datacentrLocationXpath = "//*[@id='select_85']//span[@class='md-select-icon']";
    private String committedUsageOptionsXpath = "//*[@id='select_92']";
    private String totalEstimationTextSelectorXpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']/div[1]";
    private String emailInputFieldSelectorXpath = "//*[@id='input_386']";

    private String defaultMachineTypeOptionId = "//div[contains(text(),'%s')]";
    private String addGpusCheckboxXpath = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
//    private String addGpusCheckboxSelector = "md-checkbox[aria-label=\"Add GPUs\"]";
    private String defaultNumberOfGpusOptionId = "//md-option[@id='select_option_342']/div[contains(text(),'%s')]";
    private String defaultGpuTypeOptionId = "//div[contains(text(),'%s')]";
    private String defaultLocalSsdOptionId = "//div[contains(text(),'%s')]";
    private String defaultDatacentrLocationOptionId = "//md-option[@id='select_option_181']/div[contains(text(),'%s')]";
    private String defaultCommittedUsageOptionId = "select_option_89";
    private String addToEstimateBtnSelector = "div:nth-child(1) > form button[aria-label=\"Add to Estimate\"]";
    //    private String totalEstimationTextSelector = "#resultBlock > md-card > md-card-content > div > div > div > h2 > b";
    private String emailEstimateBtnId = "email_quote";
    //    private String emailInputFieldSelector = "form[name=\"emailForm\"] input[ng-model=\"emailQuote.user.email\"]";
    private String sendEmailBtnSelector = "form[name=\"emailForm\"] button[aria-label=\"Send Email\"]";

    public CalculatorForm(WebDriver driver) {
        super(driver);
    }

//    public CalculatorForm selectProduct(String product) {
//        WebElement productInputField = driver.findElement(By.xpath(productInputFieldXpath));
//        wait.until(ExpectedConditions.visibilityOf(productInputField));
//        productInputField.click();
//
//        for (WebElement element : productsOptions) {
//            if (element.getText().equals("product")) {
//                element.click();
//            }
//        }
//        return this;
//    }

    public CalculatorForm setNumberOfInstances(int numberOfInstances) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(instancesInputFieldXpath)));
        WebElement instancesInputField = driver.findElement(By.xpath(instancesInputFieldXpath));
        wait.until(ExpectedConditions.visibilityOf(instancesInputField));
        instancesInputField.sendKeys(Integer.toString(numberOfInstances));
        return this;
    }

    public CalculatorForm selectMachineType(String machineType) {
        WebElement machineTypeOptions = driver.findElement(By.xpath(machineTypeFieldXpath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", machineTypeOptions);
        WebElement machineTypeItem = driver.findElement(By.xpath(String.format(defaultMachineTypeOptionId, machineType)));
        executor.executeScript("arguments[0].click();", machineTypeItem);
        return this;
    }

    public CalculatorForm checkGPUsValue() {

        WebElement checkGpusCheckbox = driver.findElement(By.xpath(addGpusCheckboxXpath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", checkGpusCheckbox);
        return this;
    }

    public CalculatorForm addGpus(String numberOfGpus, String gpuType) {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(numberOfGpusXpath)));
        WebElement numberOfGPUsField = driver.findElement(By.xpath(numberOfGpusXpath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", numberOfGPUsField);
        WebElement numberOfGPUsItem = driver.findElement(By.xpath(String.format(defaultNumberOfGpusOptionId, numberOfGpus)));
        executor.executeScript("arguments[0].click();", numberOfGPUsItem);

        WebElement typesOfGPUsField = driver.findElement(By.xpath(gpuTypeOptionsXpath));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", typesOfGPUsField);
        WebElement typesOfGPUsItem = driver.findElement(By.xpath(String.format(defaultGpuTypeOptionId, gpuType)));
        executor1.executeScript("arguments[0].click();", typesOfGPUsItem);
        return this;
    }

    public CalculatorForm selectLocalSSD(String localSSD) {
        WebElement localSsdOptions = driver.findElement(By.xpath(localSsdOptionsXpath));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", localSsdOptions);
        WebElement localSSDItem = driver.findElement(By.xpath(String.format(defaultLocalSsdOptionId, localSSD)));
        executor1.executeScript("arguments[0].click();", localSSDItem);

        return this;
    }

    public CalculatorForm selectDatacenterLocation(String datacenterLocation) {
        WebElement datacentrLocationField = driver.findElement(By.xpath(datacentrLocationXpath));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", datacentrLocationField);
        WebElement datacentrLocationItem = driver.findElement(By.xpath(String.format(defaultDatacentrLocationOptionId, datacenterLocation)));
        executor1.executeScript("arguments[0].click();", datacentrLocationItem);

//        List<WebElement> datacentrLocationOptions = driver.findElements(By.xpath(datacentrLocationOptionsXpath));
//        openOptionsListAndSelectOption(defaultDatacentrLocationOptionId, datacentrLocationOptions, datacenterLocation);
        return this;
    }

    public CalculatorForm selectCommittedUsage(String committedUsage) {
        List<WebElement> committedUsageOptions = driver.findElements(By.xpath(committedUsageOptionsXpath));
        openOptionsListAndSelectOption(defaultCommittedUsageOptionId, committedUsageOptions, committedUsage);
        return this;
    }

    public CalculatorForm clickAddToEstimate() {
        clickElementByCss(addToEstimateBtnSelector);
        return this;
    }

    public String getTotalEstimationText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(totalEstimationTextSelectorXpath)));
        WebElement totalEstimationTextSelector = driver.findElement(By.xpath(totalEstimationTextSelectorXpath));
        String result = totalEstimationTextSelector.getText();
        return RowCutter.removeCharsBeforeColon(result);
    }

    public CalculatorForm clickEmailEstimate() {
        driver.findElement(By.id(emailEstimateBtnId)).click();
        return this;
    }

    public CalculatorForm sendEstimateToEmail(String email) {
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailInputFieldSelectorXpath)));
        WebElement emailInputFieldSelector = driver.findElement(By.xpath(emailInputFieldSelectorXpath));
        emailInputFieldSelector.sendKeys(email);
        clickElementByCss(sendEmailBtnSelector);
        return this;
    }

    private void openOptionsListAndSelectOption(String defaultOptionId, List<WebElement> options, String filterValue) {
        driver.findElement(By.id(defaultOptionId)).click();
        selectOptionFromList(options, filterValue);
    }

    private void selectOptionFromList(List<WebElement> options, String searchedOptionText) {
        options.stream()
                .filter(element -> searchedOptionText.equalsIgnoreCase(element.getText())
                        || searchedOptionText.equalsIgnoreCase(element.getText().trim())).findFirst()
                .ifPresent(element -> driver.findElement(By.id("id")).click());
    }

//    public WebElement getInstancesInputField() {
//        return this;
//    }

}
