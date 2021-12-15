package test;

import data.Product;
//import junit.framework.TestCase;

public class TestClaseProductoPrecios extends TestCase {

	private Product p1;
	private Product p2;
	protected void setUp() throws Exception {
		this.p1= new Product(1,"Btc",4,3);
		this.p2= new Product(1,"Ada",30,4);
		
	}

	protected void tearDown() throws Exception {
		this.p1=null;
		this.p2=null;
	}
	public void testsumPrice(){
		double sum=Product.sumPrice(p1, p2);
		assertEquals(34,sum,0.0);
	}

	/**
	 * @author Benat
	 * testing junit
	 */
	public void testRestPrice(){
		double rest = Product.restPrice(p2, p1);
		assertEquals(26, rest, 0.0);
	}

}
