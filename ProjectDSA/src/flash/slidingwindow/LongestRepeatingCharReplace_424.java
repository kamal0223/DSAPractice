package flash.slidingwindow;

import java.util.List;

import org.junit.Test;

public class LongestRepeatingCharReplace_424 {

	@Test
	public void test1() {
		String s = "ABBAEBA";
		int k = 2;
		System.out.println(characterReplacement(s, k));
	}
	
	@Test
	public void test2() {
		String s = "ABBB";
		int k = 1;
		System.out.println(characterReplacement(s, k));
	}
	
	  public int characterReplacement(String s, int k) {
	        //11.30
	        
	        //declare a repeatCounter
	        //declare a pointer left as 0
	        //declare a tempChar as first char of string
	        //traverse the string till end
	        //get the character at i and store it in tempChar
	        //if char at i is not equal to tempchar
	        //yes=> change it to temp char and decrement k
	        //check if the k value becomes negative 
	        //yes=> //window break move left pointer till you find char != tempChar,K=++
	        //No=> do nothing
	        //get the length of substring
	        //check if the obtained length is greater than prevMaxLen
	        //yes=> then update prevMaxLen
	        int len = s.length();
	        int[] count = new int[26];
	        int start = 0, maxCount = 0, maxLength = 0;
	        for (int end = 0; end < len; end++) {
	            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
	            while (end - start + 1 - maxCount > k) {
	                count[s.charAt(start) - 'A']--;
	                start++;
	            }
	            maxLength = Math.max(maxLength, end - start + 1);
	        }
	        return maxLength;
	    }
}
