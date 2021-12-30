package palo.alto;

import org.junit.Test;

import junit.framework.Assert;

/*
 * Given an integer N, return the maximum possible value obtained by deleting one '5' digit from the
 * decimal representation of N. It is guanranteed that N will contain atleast one '5' digit.
 */
public class Remove5ToMaxOut {

	@Test
	public void test1() {
		int N = 15958;
		Assert.assertEquals(1958, removes5(N));
	}

	@Test
	public void test2() {
		int N = -5859;
		Assert.assertEquals(-589, removes5(N));
	}

	@Test
	public void test3() {
		int N = -5000;
		Assert.assertEquals(0, removes5(N));
	}

	/*
	 * check if the given number is negative and set a boolean
	 * convert the number to string
	 * Traverse the string from left to right
	 *   check if the number is 5
	 *   yes->check the is negative boolean
	 *   	  yes-> remove the 5 by taking substring of before 5 + substring of after 5
	 *   			get the 
	 */
	private int remove5(int n) {
		String str = String.valueOf(n);
		int maxDigit = Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '5') {
				maxDigit = Math.max(Integer.parseInt(str.substring(0, i)+str.substring(i+1)), maxDigit);
			}
		}
		return maxDigit;
	}

	private int removes5(int n) {
		int maxDigit = Integer.MIN_VALUE;
		String str = String.valueOf(n);
		for (int i = 0; i < str.length(); i++) {
			StringBuilder sb = new StringBuilder(str);
			if(sb.charAt(i) == '5') {
				int parsedInt = Integer.parseInt(sb.deleteCharAt(i).toString());
				maxDigit = Math.max(parsedInt, maxDigit);
				//maxDigit = parsedInt>maxDigit?parsedInt:maxDigit;				
			}
		}
		return maxDigit;
	}
}
