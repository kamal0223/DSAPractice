package onspot;

import java.util.Iterator;

import org.junit.Test;

import junit.framework.Assert;

public class MultiplyString_43 {

	@Test
	public void test1() {
		String num1 = "456";
		String num2 = "23";
		Assert.assertEquals("10488", multipleString(num1, num2));
	}
	//
	
	@Test
	public void test2() {
		String num1 = "3";
		String num2 = "4";
		Assert.assertEquals("12", multipleString(num1, num2));
	}

	/*
	 * 
	 */
	private String multipleString(String num1, String num2) {
		int[] output = new int[num1.length()+num2.length()];
		for (int i = num1.length()-1; i >= 0; i--) {
			int remainder = 0;
			int product = 1;
			for (int j = num2.length()-1; j >=0 ; j--) {
				product = num1.charAt(i)-'0' * num2.charAt(j)-'0'+remainder;
				output[i+j+1] = product%10;
				remainder = product/10;
			}
		}
		return null;
	}
}
