package week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*Given two strings s1 and s2, return true if s2 contains the permutation of s1.

In other words, one of s1's permutations is the substring of s2.
*/

/*Input: String s1, String s2
Output: boolean
constraints: 1 <= s1.length, s2.length <= 104
			 s1 and s2 consist of lowercase English letters.
TestData set: Positive
			  Negative
			  Edge
Approaches Known: BruteForce
				  Slidingwindow
*/

public class PermutationsInString {
	
	@Test //positive
	public void test1() {
		String s1 = "abd";
		String s2 = "eidbadoo";
		Assert.assertTrue(permutationUsingWindowSliding(s1,s2));
	}
	
	@Test //Negative
	public void test2() {
		String s1 = "ab";
		String s2 = "eidboaoo";
		Assert.assertFalse(permutationUsingWindowSliding(s1,s2));
	}
	
	@Test //Edge
	public void test3() {
		String s1 = "a";
		String s2 = "a";
		Assert.assertTrue(permutationUsingWindowSliding(s1,s2));
	}
	
	@Test //Edge
	public void test4() {
		String s1 = "adc";
		String s2 = "dcda";
		Assert.assertTrue(permutationUsingWindowSliding(s1,s2));
	}
	
	/*brute force
	 * declare one character array of length as s1
	 * convert s1 to character array and sort it
	 * iterate through the the s2 till length-s1.length with index i
	 * 	iterate from poistion as i and till lenght of s1 + i
	 * 		add the elements to char array
	 * 	sort the char array and check if equals with char array of s1
	 * 		return true
	 * 	
	 * when out of the loops return false
	 * 
	 * 
	
	
	*/
	private boolean permutationUsingBruteForce(String s1, String s2) {
		
		if(s2.length() == 1 && !s1.equals(s2)) return false;
		
		char[] windowArray = new char[s1.length()];
		char[] targetSubArray = s1.toCharArray();
		Arrays.sort(targetSubArray);
		for(int i = 0;i<=s2.length()-s1.length();i++) {
			int k = 0;
			for(int j =i;j<i+s1.length();j++) {
				windowArray[k++]= s2.charAt(j);
			}
			Arrays.sort(windowArray);
			if(Arrays.equals(windowArray, targetSubArray)) return true;
		}
		
		return false;
	}
	
	/*
	  declare left and  right to 0
	  initialize a int array of for s1Counter of 128 size
      initialize a int array of for s2Counter of 128 size
      iterate the string s1 and add increment ascii values of characters to s1Counter
      iterate s2 using fast pointer
      	increment the ascii values of characters to s2Counter
      	if difference of right and left is equal to s1 length then
			check the ascii arrays of s1 and s2 are equal, if yes then return true
			iterate till asciivalue of fast>1
				decrement s2 ascii count and increment left
			decrement right and left when left == right	
		
		return false
	
	Time - O(n)
	Space - O(n)
	*/
	
	private boolean permutationUsingWindowSliding(String s1, String s2) {
		
		if(s2.length() == 1 ) {
			if(s1.equals(s2)) return true;
			else return false;
		}
		int left = 0, right = 0;
		int[] s1Counter = new int[128];
		int[] s2Windowcounter = new int[128];
		
		for(int i = 0;i<s1.length();i++) s1Counter[s1.charAt(i)]++;
		
		for(right = 0;right<s2.length();right++) {
			s2Windowcounter[s2.charAt(right)]++;
			if(right-left == s1.length()-1) {
				if(Arrays.equals(s1Counter, s2Windowcounter)) return true;
				while(s2Windowcounter[s2.charAt(right)]>0) {
					s2Windowcounter[s2.charAt(left)]--;
					left++;
				}
				right=right-(s1.length()-1);
				left = left-(s1.length()-1);
			}
		}
		
		return false;
		
	}
}
