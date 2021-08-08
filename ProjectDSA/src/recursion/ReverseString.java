package recursion;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseString {

	
	//base case
	//if(str.length == 0) return "";
	//condition pattern
	//recursively get the last element and add it to front
	//int n = 1;
	//Strin reversed = reversed+reverse(str.length-n);
	//n++
	
	
	@Test
	public void test1() {
		String str1 = "kamal";
		String output = "lamak";
		Assert.assertEquals(output, reverse(str1));
	}
	
	@Test
	public void test2() {
		String str1 = "rahul is a master";
		String output = "retsam a si luhar";
		Assert.assertEquals(output, reverse(str1));
	}
	
	@Test
	public void test3() {
		String str1 = "";
		String output = "";
		Assert.assertEquals(output, reverse(str1));
	}

	private String reverse(String str1) {
		if(str1.length() == 0) return "";
		//return reversed string concatenation with last character of string and update the reverseString
		return str1.charAt(str1.length()-1)+reverse(str1.substring(0, str1.length()-1));
		
	}
	
	
	
}
