package refresher;

import org.junit.Test;

public class AddItselfToMakePalindrome {

	@Test
	public void test1() {
		int num = 195;
		System.out.println(makePalindrome(num));
		
	}

	@Test
	public void test2() {
		int num = 196;
		System.out.println(makePalindrome(num));
	}

	/*
	 * loop through if not palindrome or 1000 iterationCount or num becomes 4,294,967,295
	 * check if the given num is palindrome, write a function to reverse
	 * yes-> return the number
	 * no-> add the reversedNum with given 
	 * 
	 * if output is 0 then return -1
	 */

	private String makePalindrome(long num) {
		long reverseInt = reverseInt(num);
		long iteration = 0;
		while(num != reverseInt && iteration<=1000 && num<=4294967295L) {
				num+= reverseInt;
				reverseInt = reverseInt(num);
				if(reverseInt>4294967295L) return "No palindrome found";
				iteration++;
			}
		System.out.println("reversed palindrome "+reverseInt);
		return iteration>1000?"No palindrome found":String.valueOf(num);
		}
	
	private long reverseInt(long num) {
		//get the last digit by taking mod of num add to outpu int
		//1234
		long output = 0;
		long remainder = num, quotient = num;
		while(quotient!=0) {
			remainder = quotient%10;
			output = output * 10+remainder;
			quotient = quotient/10;
		}
		return output;
	}

}
