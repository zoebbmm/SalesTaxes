package TaxCalculation;

import java.text.DecimalFormat;

public class RoundTax {
	private static final double RoundNearest = 0.05;
    
    /** Round a double value to the nearest 0.05 */
    public static double roundoff(double value) {
            return (int)(value / RoundNearest + 0.5) * 0.05;
    }

    /** Truncate a double value to two decimal places. */
    public static double truncate(double value) {
            String result = new DecimalFormat("0.00").format(value);
            return Double.parseDouble(result);
    }
}
