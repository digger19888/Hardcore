package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorForm;
import page.MainPage;
import service.MailAdresCreator;
import util.BrowserTabSwitcher;
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
        calculatorForm.clickEmailEstimate();

        BrowserTabSwitcher tabSwitcher = new BrowserTabSwitcher();
        tabSwitcher.switchToNewTab();

        MailAdresCreator emailPage = new MailAdresCreator(driver).openMailPage();
        String email = emailPage.getEmail();
//        String email = "stubEmail@mil.com";

        tabSwitcher.switchBackToPreviousTab();
        calculatorForm.sendEstimateToEmail(email);
        tabSwitcher.switchToNextToCurrentTab();
        String estimationFromEmail = emailPage.getTotalEstimationMessage();
        testListener.saveScreenshot("estimation_from_email");

        Assert.assertTrue(estimationFromSite.contains(estimationFromEmail));
    }

}
