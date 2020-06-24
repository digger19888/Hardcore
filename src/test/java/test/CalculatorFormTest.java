//package test;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import page.CalculatorPage;
//
//public class CalculatorFormTest extends CommonConditions {
//
//        @Test
//        public void checkSetNumberOfInstances() {
//            String expectedValue = "4";
//            String value = new CalculatorPage(driver)
//                    .openPage()
//                    .getCalculatorInputForm()
//                    .setNumberOfInstances(Integer.parseInt(expectedValue))
//                    .getInstancesInputField().getText();
//            Assert.assertEquals(value, expectedValue);
//        }
//
//}
