//package test;
//
//import org.testng.annotations.Test;
//import page.FormPage;
//import page.MainPage;
//
//public class MainTest extends CommonConditions{
//
//    @Test
//    public void checkEstimationsEquals() throws InterruptedException {
//
//        FormPage formPage = new MainPage().openPMainage()
//                .openProductsPage()/*doesn't work*/
//                .openPage()
//                .openPricingPage()
//                .openCalculatorPage()
//                .getCalculatorInputIframe()
//                .selectProduct("COMPUTE ENGINE") /*incorrect behavior*/
//                .setNumberOfInstances(4)
//                .selectMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
//                .addGpus(1, "NVIDIA Tesla V100")
//                .selectLocalSSD("2x375 Gb")
//                .selectDatacenterLocation("Frankfurt (europe-west3)")
//                .selectCommittedUsage("1 Year")
//                .clickAddToEstimate();
//
//        String estimationFromSite = calculatorIframe.getTotalEstimationText();
//        Selenide.screenshot("estimation_from_site");
//        calculatorIframe.clickEmailEstimate();
//
//        BrowserTabSwitcher tabSwitcher = new BrowserTabSwitcher();
//        tabSwitcher.switchToNewTab();
//
//        NewEmailPage emailPage = new NewEmailPage().openPage();
//        String email = emailPage.getEmail();
////        String email = "stubEmail@mil.com";
//
//        tabSwitcher.switchBackToPreviousTab();
//        calculatorIframe.sendEstimateToEmail(email);
//        tabSwitcher.switchToNextToCurrentTab();
//        String estimationFromEmail = emailPage.getTotalEstimationMessage();
//        Selenide.screenshot("estimation_from_email");
//
//        Assert.assertTrue(estimationFromSite.contains(estimationFromEmail));
//    }
//
//}
//
