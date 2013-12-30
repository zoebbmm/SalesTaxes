/**
 * The TaxCalculator generate the tax calculator for a region.
 *  
 * @author WeiZhou
 */

package TaxCalculation;

import java.util.HashMap;

public class TaxCalculatorHelper {

        /** Map the taxcalculators with their key region values */
        private HashMap<String, TaxCalculator> taxCalculators;
        
        public TaxCalculatorHelper() {
                taxCalculators = new HashMap<String, TaxCalculator>();
                taxCalculators.put("Local", new LocalTaxCalculator());
        }
        
        /**
         * Get the tax calculator object.
         */
        public TaxCalculator getTaxCalculator(String region) {
                TaxCalculator taxCalc = (TaxCalculator)taxCalculators.get(region);
                return taxCalc;
        }
        
        public int getTaxCalculatorSize(){
                return taxCalculators.size();
        }
}