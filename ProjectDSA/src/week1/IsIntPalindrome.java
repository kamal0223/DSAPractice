package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/* Given an integer x, return true if x is palindrome integer.
 * 
 * 1. Do we understand problem yes 
 * a. Input - int input 
 * b. Output boolean isPalindrome 
 * c. Do I have all information to solve the problem - yes
 * 
 *2) Test Data Set
 *  Minimum of 3 data set !! 
 *  Positive int input = 121
 *  Edge int input = 1 return input
 *  Negative  int input = 1234
 *  Validate the data set with the interviewer 
 *
 *3) Do I know how to solver it? - yes with brute force
 *    Yes - great, Is there any alternate solution?
 *    No - Can I break down the problem to sub problems?
 *
 *4) Ask for the hint (If you don't know how to solve it)
 *
 *
 *5) Do I know alternate solution to solve this problem? 
 *
 *
 *
 *
 */
public class IsIntPalindrome {
	
	@Test
	public void test1() {
		int input = 121;
		Assert.assertTrue(isPalindromeUsingString(input));
	}
	
	@Test
	public void test2() {
		int input = 1234;
		Assert.assertFalse(isPalindromeUsingString(input));
	}
	
	@Test
	public void test3() {
		int input = 1;
		Assert.assertTrue(isPalindromeUsingString(input));
	}

	/*
	* pseudocode
	* To get the palindrome reverse the int value
	* if input number is just one digit, return the number
	* initialize a variable quotient with input value
	* initialize sum = 0;
	* Traverse over each digit of the number from the end
	* traverse till the quotient becomes 0
	* Get the last digit of the number by find modulus of it
	* reassign the quotient to remainder/10;
	* formula  sum = sum*10+modulus
	*/
	private boolean isPalindrome(int input) {
		
		if(input/10 == 0) return true;
		int quotient = input;
		int sum = 0;
		while(quotient>0) {  //o[n]
			sum = sum*10+quotient%10;
			quotient = quotient/10;
		}
		System.out.println(sum);
		return input == sum;
		
	}
	
	/*
	 * to get palindrome using string builder reverse
	 * Create an String builder object using StringBuilder(String input) by passing converted input string as params
	 * using reverse function of string builder reverse the string
	 * convert the reversed string to int type
	 * Check if int input == int reversedOutput
	 * if true then boolean isPralindrome true
	 * else false
	*/
	private boolean isPalindromeUsingString(int input) {
		
		StringBuilder sb = new StringBuilder(String.valueOf(input));
		int reversedInt = Integer.parseInt(sb.reverse().toString());  //O[n] as there is one loop for reverse
		//o[n] as there is a while loop for parseInt. So o[n+m]
		return input == reversedInt;
	}
}
