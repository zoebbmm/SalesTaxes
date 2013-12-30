package TaxCalculation;


public enum LocalTaxRate {
	/** The tax values of various products. */
	BOOK_TAX(0.0),
	FOOD_TAX(0.0),
	MEDICAL_TAX(0.0),
	OTHER_TAX(0.10);

	/** The item tax value. */
	private double itemTaxValue;

	private LocalTaxRate(double taxValue) {
		itemTaxValue = taxValue;
	}

	public double getTax(){
		return itemTaxValue;
	}
}
