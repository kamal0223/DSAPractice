package map;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import junit.framework.Assert;

/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.*/

public class RomanToInteger {

	@Test
	public void test1() {
		String input = "LVIII";
		Assert.assertEquals(58, romanToIntegers(input));
	}
	
	@Test
	public void test2() {
		String input = "IV";
		Assert.assertEquals(4, romanToIntegers(input));
	}
	
	@Test
	public void test3() {
		String input = "MCMXCIV";
		Assert.assertEquals(1994, romanToIntegers(input));
	}
	
	@Test
	public void test4() {
		String input = "I";
		Assert.assertEquals(1, romanToIntegers(input));
	}
	
	@Test (expected = RuntimeException.class)
	public void test5() {
		String input = "";
		romanToIntegers(input);
	}

	private int romanToIntegers(String input) {
		 //assing the vlaue to all roman
		if(input.length() == 0) throw new RuntimeException("Input string cannnot be empty");
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int sum = 0;
        for(int i=0;i<input.length();i++){
        	if(i == input.length()-1) sum = sum+hm.get(input.charAt(i));
        	else if(hm.get(input.charAt(i))>=hm.get(input.charAt(i+1))){
                sum = sum+hm.get(input.charAt(i));
            } else {
                sum = sum-hm.get(input.charAt(i));
            }
        }
        
        return sum;
	}
}
