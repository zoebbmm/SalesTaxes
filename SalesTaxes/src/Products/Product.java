/**
 * The Product is the item which is purchased in the shopping store and for which a receipt is generated.
 *
 * @author WeiZhou
 * 
 */
package Products;
import ProductHelper.*;

public abstract class Product{
	// the name of the product
	protected String name;

	// the original price of the product
	protected double price;

	// indicate if the product is imported or not
	protected Boolean imported;

	// the number of the product items
	protected int quantity;

	// the price of the product including the tax
	protected double taxedCost;

	public Product(){
		this.name = "";
		this.price = 0.0;
		this.imported = false;
		this.quantity = 0;
		this.taxedCost = 0.0;
	}

	/**
	 * Parameterized constructor to initialize the values of the product attributes.
	 *
	 * @param name - the name of the product
	 * @param price - the price of the product
	 * @param imported - boolean value of whether product imported or not
	 * @param quantity - quantity of product item
	 */        
	public Product(String name, double price, boolean imported, int quantity){
		this.name = name;
		this.price = price * quantity;
		this.imported = imported;
		this.quantity = quantity;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price = price * quantity;
	}

	public boolean isImported(){
		return imported;
	}

	public void setImported(boolean imported){
		this.imported = imported;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public double getTaxedCost() {
		return taxedCost;
	}

	public void setTaxedCost(double taxedCost) {
		this.taxedCost = taxedCost;
	}

	public String toString(){
		return (quantity + " " + toString(imported) + " " + name + " : " + taxedCost);
	}

	/**
	 * Gets a String representation for the <code>imported</code> attribute.
	 *
	 * @param imported - boolean value for imported
	 * @return String
	 */
	public String toString(boolean imported) {
		if(imported == false) {
			return "";
		}else{
			return "imported";
		}
	}

	public abstract ProductHelper getHelper();

	public abstract double getTaxValue(String region);
}