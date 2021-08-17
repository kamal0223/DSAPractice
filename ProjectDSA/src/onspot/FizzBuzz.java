package onspot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*Input: int input
Output: String[] output
constraints: 

TestData set: Positive
			  Negative
			  Edge
Approaches Known: two pointer
*/

public class FizzBuzz {

	@Test
	public void test1() {
		int input = 5;
		Assert.assertTrue(Arrays.equals(new String[] {"1","2","Fizz","4","Buzz"}, fizzBuzz(input)));
	}
	
	@Test
	public void test2() {
		int input = 1;
		Assert.assertTrue(Arrays.equals(new String[] {"1"}, fizzBuzz(input)));
	}

	private String[] fizzBuzz(int input) {
		
		//two pointers say left to 0 and right to lastelement
		int left = 1, right = input;
		//delcare an string array for outpu
		String[] output = new String[input];
		while (left<=right) {
			//check the value at i that it is divisible by both 3 and 5
			if(left%3 == 0 && left%5 == 0) output[left-1] = "FizzBuzz";
			else if(left%3 == 0) output[left-1] = "Fizz";
			else if(left%5 == 0) output[left-1] = "Buzz";
			else output[left-1] = String.valueOf(left);
			left++;
			if(right%3 == 0 && right%5 == 0) output[right-1] = "FizzBuzz";
			else if(right%3 == 0) output[right-1] = "Fizz";
			else if(right%5 == 0) output[right-1] = "Buzz";
			else output[right-1] = String.valueOf(right);
			right--;
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
	
}
