package hacker.rank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ProductBillingErrors {
	
	@Test
	public void test1() {
		List<String> products  = new ArrayList<>(Arrays.asList(new String[] {"chocolate","cheese","tomato"}));
		List<Float> productPrices  = new ArrayList<>();
		productPrices.add((float) 15);
		productPrices.add((float) 300.9);
		productPrices.add((float) 23.44);
		List<String> productSold  = new ArrayList<>(Arrays.asList(new String[] {"cheese","tomato","chocolate"}));
		List<Float> soldPrice  = new ArrayList<>();
		soldPrice.add((float) 300.9);
		soldPrice.add((float) 23.44);
		soldPrice.add((float) 10);
		System.out.println(priceCheck(products, productPrices, productSold, soldPrice));
	}
	
	
	
	public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        //declare 2 hashMap of string and float
        //declare a int count
        //iterate the producsts list  with indexes and add the products as key and it price as value in MAP1
        //iterate the productsold with indexes
        //Get the sold price of the product and check in map1
        //if sold price and actual price not mataching increment count
        //return the count
        
        Map<String, Float> actualPriceMap = new HashMap<String, Float>();
        int errors = 0;
        for (int i = 0; i < products.size(); i++) {
            actualPriceMap.put(products.get(i), productPrices.get(i));
        }
        
        for (int i = 0; i < productSold.size(); i++) {
  
            if(!actualPriceMap.get(productSold.get(i)).toString().equals(soldPrice.get(i).toString()) ){
                errors++;
                } 
        }
        
        return errors;
    }

}
