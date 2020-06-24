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
    private String numberOfGpusOptionsXpath = "//*[@id='select_337']";
    private String gpuTypeOptionsXpath = "//*[@id='select_339']";
    private String localSsdOptionsXpath = "//*[@id='select_170']";
    private String datacentrLocationOptionsXpath = "//*[@id='select_85']";
    private String committedUsageOptionsXpath = "//*[@id='select_92']";
    private String totalEstimationTextSelectorXpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']/div[1]";
    private String emailInputFieldSelectorXpath = "//*[@id='input_386']";

    private String defaultMachineTypeOptionId = "//div[contains(text(),'%s')]";
    private String addGpusCheckboxXpath = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
    private String addGpusCheckboxSelector = "md-checkbox[aria-label=\"Add GPUs\"]";
    private String defaultNumberOfGpusOptionId = "select_option_428";
    private String defaultGpuTypeOptionId = "select_option_343";
    private String defaultLocalSsdOptionId = "select_option_231";
    private String defaultDatacentrLocationOptionId = "select_option_172";
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

    public CalculatorForm addGpus(int numberOfGpus, String gpuType) {
//        driver.switchTo().defaultContent();
        clickElementByCss(addGpusCheckboxSelector);
//        WebElement chekbox = driver.findElement(By.xpath(machineTypeFieldXpath));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
        List<WebElement> numberOfGpusOptions = driver.findElements(By.xpath(numberOfGpusOptionsXpath));
        openOptionsListAndSelectOption(defaultNumberOfGpusOptionId, numberOfGpusOptions, Integer.toString(numberOfGpus));
        List<WebElement> gpuTypeOptions = driver.findElements(By.xpath(gpuTypeOptionsXpath));
        openOptionsListAndSelectOption(defaultGpuTypeOptionId, gpuTypeOptions, gpuType);
        return this;
    }

    public CalculatorForm selectLocalSSD(String localSSD) {
        List<WebElement> localSsdOptions = driver.findElements(By.xpath(localSsdOptionsXpath));
        openOptionsListAndSelectOption(defaultLocalSsdOptionId, localSsdOptions, localSSD);
        return this;
    }

    public CalculatorForm selectDatacenterLocation(String datacenterLocation) {
        List<WebElement> datacentrLocationOptions = driver.findElements(By.xpath(datacentrLocationOptionsXpath));
        openOptionsListAndSelectOption(defaultDatacentrLocationOptionId, datacentrLocationOptions, datacenterLocation);
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

    public CalculatorForm checkGPUsValue() {

        WebElement checkGpusCheckbox = driver.findElement(By.xpath(addGpusCheckboxXpath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", checkGpusCheckbox);

//        WebElement chekChekbox = driver.findElement(By.xpath(addGpusCheckboxXpath));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addGpusCheckboxXpath)));
//        WebElement instancesInputField = driver.findElement(By.xpath(addGpusCheckboxXpath));
//        wait.until(ExpectedConditions.visibilityOf(instancesInputField));
//        instancesInputField.click();
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
