package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorForm;
import page.MailPage;
import page.MainPage;
import util.TestListener;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MainTestTimely extends CommonConditions {

    private final TestListener testListener = new TestListener();

    @Test
    public void checkEstimationsEquals() throws InterruptedException, IOException, UnsupportedFlavorException {
        MailPage mailPage = new MailPage(driver).openMailPage()
                .getEmail()
                .openNewBrowserTab();
       CalculatorForm calculatorForm = new MainPage(driver)
//                .openMainPage()
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
        calculatorForm.clickEmailEstimate();
        calculatorForm.sendEstimateToEmail();
        calculatorForm.backToPreviousBrowserTab();
        calculatorForm.getTotalEstimationMessage();
        String estimationFromEmail = calculatorForm.getTotalEstimationMessageText();
        testListener.saveScreenshot("estimation_from_email");

        Assert.assertTrue(estimationFromSite.contains(estimationFromEmail));
    }

}
