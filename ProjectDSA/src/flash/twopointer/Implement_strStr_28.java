package flash.twopointer;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/implement-strstr/
public class Implement_strStr_28 {

	@Test
	public void test1() {
		String haystack = "mississippi";
		String needle = "issip";
		Assert.assertEquals(4, matchingNeedle(haystack,needle));
	}

	@Test
	public void test2() {
		String haystack = "aaaaa";
		String needle = "bba";
		Assert.assertEquals(-1, matchingNeedle(haystack,needle));
	}
	
	@Test
	public void test3() {
		String haystack = "aaa";
		String needle = "aaaa";
		Assert.assertEquals(-1, matchingNeedle(haystack,needle));
	}

	//declare 2 pointers i at haystack start and j at start of needle
	//check if the char at i and j are equal increment i and j
	//  yes-> int temp = i
	//iterate the size of needle say k
	//check value at temp not equal to k break
	//output of the loop return i
	//if the char are not matching and j is at 0 index increment i
	//if the char are not matching and j is not at 0 index 

	private int matchingNeedle(String haystack, String needle) {
		if(needle.length() == 0) return 0;
		int i = 0, j = 0;
		while(i<haystack.length()){
			if(haystack.charAt(i) == needle.charAt(j)) {
				int temp = i+1, k = 1;
				while(k<needle.length() && temp<haystack.length()) {
					if(haystack.charAt(temp++) == needle.charAt(k)) k++;
				}
				if(k == needle.length()) return i;
				//reset j
				//j = 0;
			}
			i++;
		}
		return -1;
	}
	
	private int matchingNeedleOptimized(String haystack, String needle) {
		if(needle.length() == 0) return 0;
		return haystack.indexOf(needle);
	}
	
	 public int strStr(String haystack, String needle) {
	       //get the size of needle
	        int windowSize = needle.length();
	        for(int i =0;i<haystack.length()-windowSize+1;i++){
	            if(haystack.substring(i,i+windowSize).equals(needle)) return i;
	        }
	        return -1;
	    }
}