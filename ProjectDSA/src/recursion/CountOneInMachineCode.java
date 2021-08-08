package recursion;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class CountOneInMachineCode {
	
	/*
	 * 010101011
	 *  Quotient becomes one digit
	 *  remainder+countOnes(quotient)
	 *  implement
	 */
	
	
	@Test
	public void test1() {
		int input = 1010;
		Assert.assertEquals(2, countOnes(input));
	}
	
	@Test
	public void test2() {
		int input = 1;
		Assert.assertEquals(1, countOnes(input));
	}
	
	@Test
	public void test3() {
		int input = 0;
		Assert.assertEquals(0, countOnes(input));
	}
	
	@Test
	public void test4() {
		int input = 1111;
		Assert.assertEquals(4, countOnes(input));
	}

	@Test
	public void test5() {
		int input = 111111101;
		Assert.assertEquals(8, countOnes(input));
	}
	
	
	
	private int countOnes(int input) {
		//1010
		if(input == 0) return 0;
		int remainder = input%10; 
		input = input/10;
		return remainder+countOnes(input);  //1+1
		
		
	}
	
	//delcare counter 0
	//quotient is single digit and 1 then return 1
	//find the remainder and add the remainder with before last element
	//
	
	private int countOnesOptimized(int input) {
		if(input == 0) return 0;
		int remainder = input%10;
		if(remainder == 1) return 1+countOnesOptimized(input/10);
		else return countOnesOptimized(input/10);
	}

}
