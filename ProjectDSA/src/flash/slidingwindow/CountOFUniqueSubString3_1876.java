package flash.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

//https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
public class CountOFUniqueSubString3_1876 {

	@Test
	public void test1() {
		String s = "xyzzaz";
		Assert.assertEquals(1, countOfUniqueSubstring(s));
	}

	@Test
	public void test2() {
		String s = "aababcabc";
		Assert.assertEquals(4, countOfUniqueSubstring(s));
	}

	private int countOfUniqueSubstring(String s) {
		/*
        declare a set of character
        iterate the string for k times
          add each character to the set
        after the loop check if the size set is 3 then make goodSubString++
        iterate from 3 to length-3
        in the set remove the i-3 element from set 
        add current char
        find the size of current set is 3 then goodSubString++
          aababcabc
		 */
		
		if(s.length()<3) return 0; 
		int count = 0;
		Map<Character,Integer> hm = new HashMap<Character,Integer>();


		for(int i = 0;i<3;i++){
			hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
		}
		if(hm.size() == 3) count++;

		for(int i = 3;i<=s.length()-1;i++){

			//get the char at of i-3 and decrement the freq of it in map
			hm.put(s.charAt(i-3),hm.get(s.charAt(i-3))-1);
			hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
			if(Collections.max(hm.values()) == 1) count++;
		}

		return count;
	}

	public int countGoodSubstringsOpt(String s) {
		int count = 0;
		char[] charArr = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for(int i = 0;i<=s.length()-3;i++){
			if(charArr[i] == charArr[i+1] || charArr[i+1] == charArr[i+2] || charArr[i+2] == charArr[i]) continue;
			count++;
		}
		return count;
	}

}
