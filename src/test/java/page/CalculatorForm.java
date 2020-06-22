package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.RowCutter;

import java.util.List;
import java.util.concurrent.locks.Condition;

import static util.FormJSExecutor.clickElementByCss;

public class CalculatorForm extends AbstractPage {

    private static final String LOG_MESSAGE = "try: ";
    private WebElement productInputField = driver.findElement(By.xpath("#input-0"));
    private List<WebElement> productsOptions = driver.findElements(By.xpath("#ul-0 > li"));
    private WebElement instancesInputField = driver.findElement(By.xpath("#input_58"));
    private List<WebElement> machineTypeOptions = driver.findElements(By.xpath("#select_container_84 md-option"));
    private List<WebElement> numberOfGpusOptions = driver.findElements(By.xpath("#select_container_335 md-option"));
    private List<WebElement> gpuTypeOptions = driver.findElements(By.xpath("#select_container_337 md-option"));
    private List<WebElement> localSsdOptions = driver.findElements(By.xpath("#select_container_171 md-option"));
    private List<WebElement> datacentrLocationOptions = driver.findElements(By.xpath("#select_container_86 md-option"));
    private List<WebElement> committedUsageOptions = driver.findElements(By.xpath("#select_container_93 md-option"));

    private String defaultMachineTypeOptionId = "select_value_label_55";
    private String addGpusCheckboxSelector = "md-checkbox[aria-label=\"Add GPUs\"]";
    private String defaultNumberOfGpusOptionId = "select_option_338";
    private String defaultGpuTypeOptionId = "select_option_343";
    private String defaultLocalSsdOptionId = "select_option_231";
    private String defaultDatacentrLocationOptionId = "select_option_172";
    private String defaultCommittedUsageOptionId = "select_option_89";
    private String addToEstimateBtnSelector = "div:nth-child(1) > form button[aria-label=\"Add to Estimate\"]";
    private String totalEstimationTextSelector = "#resultBlock > md-card > md-card-content > div > div > div > h2 > b";
    private String emailEstimateBtnId = "email_quote";
    private String emailInputFieldSelector = "form[name=\"emailForm\"] input[ng-model=\"emailQuote.user.email\"]";
    private String sendEmailBtnSelector = "form[name=\"emailForm\"] button[aria-label=\"Send Email\"]";

    public CalculatorForm selectProduct(String product) {
        wait.until(ExpectedConditions.visibilityOf(productInputField));
        productInputField.click();
        LOGGER.error( LOG_MESSAGE + product);

        for (WebElement element : productsOptions) {
            if (element.getText("product")) {
                element.click();
            }
        }
        return this;
    }

    public CalculatorForm setNumberOfInstances(int numberOfInstances) {
        LOGGER.info( LOG_MESSAGE + numberOfInstances);
        wait.until(ExpectedConditions.visibilityOf(instancesInputField));
        instancesInputField.sendKeys(Integer.toString(numberOfInstances));
        return this;
    }

    public CalculatorForm selectMachineType(String machineType) {
        LOGGER.info( LOG_MESSAGE + machineType);
        openOptionsListAndSelectOption(defaultMachineTypeOptionId, machineTypeOptions, machineType);
        return this;
    }

    public CalculatorForm addGpus(int numberOfGpus, String gpuType) {
        LOGGER.info( LOG_MESSAGE + "number = " + numberOfGpus + ", type = " + gpuType);
        clickElementByCss(addGpusCheckboxSelector);
        openOptionsListAndSelectOption(defaultNumberOfGpusOptionId, numberOfGpusOptions, Integer.toString(numberOfGpus));
        openOptionsListAndSelectOption(defaultGpuTypeOptionId, gpuTypeOptions, gpuType);
        return this;
    }

    public CalculatorForm selectLocalSSD(String localSSD) {
        LOGGER.info(LOG_MESSAGE + localSSD);
        openOptionsListAndSelectOption(defaultLocalSsdOptionId, localSsdOptions, localSSD);
        return this;
    }

    public CalculatorForm selectDatacenterLocation(String datacenterLocation) {
        LOGGER.info( LOG_MESSAGE + datacenterLocation);
        openOptionsListAndSelectOption(defaultDatacentrLocationOptionId, datacentrLocationOptions, datacenterLocation);
        return this;
    }

    public CalculatorForm selectCommittedUsage(String committedUsage) {
        LOGGER.info( LOG_MESSAGE + committedUsage);
        openOptionsListAndSelectOption(defaultCommittedUsageOptionId, committedUsageOptions, committedUsage);
        return this;
    }

    public CalculatorForm clickAddToEstimate() {
        LOGGER.info(LOG_MESSAGE);
        clickElementByCss(addToEstimateBtnSelector);
        return this;
    }

    public String getTotalEstimationText(){
        LOGGER.info(LOG_MESSAGE);
        wait.until(ExpectedConditions.visibilityOf(totalEstimationTextSelector));
        String result = new FindBy(totalEstimationTextSelector).getText();
        LOGGER.info("total estimation text: " + result);
        return RowCutter.removeCharsBeforeColon(result);
    }

    public CalculatorForm clickEmailEstimate() {
        LOGGER.info(LOG_MESSAGE);
        driver.findElement(By.id(emailEstimateBtnId)).click();
        return this;
    }

    public CalculatorForm sendEstimateToEmail(String email){
        LOGGER.info( LOG_MESSAGE + email);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(emailInputFieldSelector));
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
                        || searchedOptionText.equalsIgnoreCase(element.innerText().trim())).findFirst()
                .ifPresentOrElse(element -> driver.findElement(By.id("id")).click(),
                        () -> LOGGER.error("option is not found: " + searchedOptionText));
    }

    public WebElement getInstancesInputField() {
        return instancesInputField;
    }

}
