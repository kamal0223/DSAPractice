package onspot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/*
You have an old grocery shop that instead of scanning their sold proudcts once sold, 
they type in the prices, which leaves room for mistyping sold prices. 
Given 4 lists: soldItems = ['eggs', 'milk', 'apple'], soldPrices = [1.00, 2.50, 2.1], 
productsAvailable = ['eggs', 'lemons', 'milk', 'apple'], productPrices = [1.01, 0.5, 2.50, 2.1], 
Find the number of items with mistyped prices
 */
public class ErrorMissTypesPriceCount {
	
	@Test
	public void test1() {
		String[] products = {"eggs", "lemons", "milk", "apple"};
		double[]  originalPrice = {1.01, 0.5, 2.5, 2.1};
		String[] sold = {"eggs","milk","apple"};
		double[] soldPrice = {1.0, 2.5, 2.1};
		Assert.assertEquals(1, misTypedPrices(products,originalPrice,sold,soldPrice));
	}

	
	/*
	 * delclare count
	 *add the product and its price in hashmap
	 *iterate the sold products array
	 *get the value of product from hashmap and check with the current index sold price
	 *if not equal then increment the count
	 *return the count 
	 *
	 */
	private int misTypedPrices(String[] products, double[] originalPrice, String[] sold, double[] soldPrice) {
		
		Map<String, Double> hm = new HashMap<String,Double>();
		int count = 0;
		for (int i = 0; i < originalPrice.length; i++) {
			hm.put(products[i], originalPrice[i]);
		}
		for (int i = 0; i < soldPrice.length; i++) {
			if(hm.get(sold[i]) != soldPrice[i]) count++;
		}
		return count
				;
	}

}
