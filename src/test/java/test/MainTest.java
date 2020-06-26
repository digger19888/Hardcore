package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorForm;
import page.MainPage;
import util.TestListener;

public class MainTest extends CommonConditions {

    private final TestListener testListener = new TestListener();

    @Test
    public void checkEstimationsEquals() throws InterruptedException {

        CalculatorForm calculatorForm = new MainPage(driver).openMainPage()
                .openCloudProductsPage()
                .openPricingPage()
                .openCalculatorPage()
                .getCalculatorInputForm()
                .setNumberOfInstances(4)
                .selectMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .checkGPUsValue()
                .addGpus("1", "NVIDIA Tesla V100")
                .selectLocalSSD("2x375 GB")
                .selectDatacenterLocation("Frankfurt (europe-west3)")
                .selectCommittedUsage("1 Year")
                .clickAddToEstimate();


        String estimationFromSite = calculatorForm.getTotalEstimationText();
        testListener.saveScreenshot("estimation_from_site");
        calculatorForm.openNewBrowserTab();
        calculatorForm.getEmail();
        calculatorForm.backToPreviousBrowserTab();
        calculatorForm.clickEmailEstimate();
        calculatorForm.sendEstimateToEmail();
        calculatorForm.openAnotherNewBrowserTab();
        String estimationFromEmail = calculatorForm.getTotalEstimationMessage();
        testListener.saveScreenshot("estimation_from_email");

        Assert.assertTrue(estimationFromSite.contains(estimationFromEmail));
    }

}
