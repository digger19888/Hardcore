package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;

public class CalculatorFormTest extends CommonConditions {

        @Test
        public void checkSetNumberOfInstances() {
            String expectedValue = "4";
            String value = new CalculatorPage()
                    .openPage()
                    .getCalculatorInputIframe()
                    .setNumberOfInstances(Integer.parseInt(expectedValue))
                    .getInstancesInputField().getValue();
            Assert.assertEquals(value, expectedValue);
        }

}
