package BillInfo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import Products.*;
import TaxCalculation.*;

public class BillTest {
	Bill bill;
	ArrayList<Product> prodList;
	BookProduct book;
	FoodProduct food;

	@Before
	public void setUp() {
		bill = new Bill(new LocalTaxCalculator());
		book = new BookProduct("book", 40.00, true, 1);
		food = new FoodProduct("box of chocolates", 30.00, false, 1);
		book.setTaxedCost(45.00);
		food.setTaxedCost(37.00);
		prodList = new ArrayList<Product>();
		prodList.add(book);
		prodList.add(food);
	}

	@Test
	public void testCalculateTax() {
		assertEquals(6.00, bill.calculateTax(40.00, 0.10, true), 0.0009);
	}

	@Test
	public void testCalcTotalProductCost() {
		assertEquals(46.00, bill.calculateTotalTaxedCost(40.00, 6.00), 0);
	}
	
	@Test
	public void testCalcTotalTax() {
		assertEquals(12, bill.calcTotalTax(prodList), 0);
	}

	@Test
	public void testCalcTotalAmount() {
		assertEquals(82, bill.calcTotalAmount(prodList), 0);
	}

	@Test
	public void testCreateNewReceipt(){
		Receipt r = bill.createNewReceipt(prodList, 9.00, 45.00);
		assertEquals(2, r.getTotalNumberOfItems());
		assertEquals(9.00, r.getTotalSalesTax(), 0.0009);
		assertEquals(45.00, r.getTotalAmount(), 0.0009);
	}

	@Test
	public void testGenerateReceipt(){
		Receipt r = bill.createNewReceipt(prodList, 9.00, 45.00);
		bill.generateReceipt(r);
	}
}
