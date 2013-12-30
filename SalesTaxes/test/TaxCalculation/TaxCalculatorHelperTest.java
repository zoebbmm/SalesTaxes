package TaxCalculation;

import static org.junit.Assert.*;
import org.junit.Test;

public class TaxCalculatorHelperTest {
	TaxCalculatorHelper helper = new TaxCalculatorHelper();

    @Test
    public void testTaxCalculatorHelper() {
            assertEquals(1, helper.getTaxCalculatorSize());
    }
}
