package test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorForm;
import page.MainPage;
import service.MailAdresCreator;
import util.BrowserTabSwitcher;

import java.io.File;

public class MainTest extends CommonConditions {

    @Test
    public void checkEstimationsEquals() throws InterruptedException {

        CalculatorForm calculatorForm = new MainPage().openPage()
                .openProductsPage()/*doesn't work*/
                .openPage()
                .openPricingPage()
                .openCalculatorPage()
                .getCalculatorInputIframe()
                .selectProduct("COMPUTE ENGINE") /*incorrect behavior*/
                .setNumberOfInstances(4)
                .selectMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .addGpus(1, "NVIDIA Tesla V100")
                .selectLocalSSD("2x375 Gb")
                .selectDatacenterLocation("Frankfurt (europe-west3)")
                .selectCommittedUsage("1 Year")
                .clickAddToEstimate();

        String estimationFromSite = calculatorForm.getTotalEstimationText();
        this.Take("estimation_from_site");
        calculatorForm.clickEmailEstimate();

        BrowserTabSwitcher tabSwitcher = new BrowserTabSwitcher();
        tabSwitcher.switchToNewTab();

        MailAdresCreator emailPage = new MailAdresCreator().openPage();
        String email = emailPage.getEmail();
//        String email = "stubEmail@mil.com";

        tabSwitcher.switchBackToPreviousTab();
        calculatorForm.sendEstimateToEmail(email);
        tabSwitcher.switchToNextToCurrentTab();
        String estimationFromEmail = emailPage.getTotalEstimationMessage();
        driver.screenshot("estimation_from_email");

        Assert.assertTrue(estimationFromSite.contains(estimationFromEmail));
    }

}
