package refresher;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class MakePalindromeIfNot {
	
	@Test
	public void test1() {
		int num = 121;
		Assert.assertEquals(121, makePalindrome(num));
	}
	
	@Test
	public void test2() {
		int num = 1234;
		Assert.assertEquals(1234321, makePalindrome(num));
	}
	
	@Test
	public void test3() {
		int num = 223;
		Assert.assertEquals(22322, makePalindrome(num));
	}

	private int makePalindrome(int num) {
		String input = Integer.toString(num);
		String reversedInput = reverseString(input);
		if(!reversedInput.equals(input)) {
			String substring = input.substring(0, input.length()-1);
			return Integer.parseInt(input+reverseString(substring));
		}
		return num;
	}
	
	private String reverseString(String input) {
		int left = 0, right = input.length()-1;
		char[] charArray = input.toCharArray();
		while(left<right) {
			//swap the left and right
			char temp = charArray[left];
			charArray[left++] = charArray[right];
			charArray[right--] = temp;
		}
		
		return Arrays.toString(charArray).replaceAll("[^0-9]", "");
	}

}
