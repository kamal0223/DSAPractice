package twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseVowelsInString {
	
	@Test
	public void test1() {
		String s = "hello";
		Assert.assertEquals("holle", reverseVowelString(s));
	}
	
	@Test
	public void test2() {
		String s = "hllmc";
		Assert.assertEquals("hllmc", reverseVowelString(s));
	}

	@Test
	public void test3() {
		String s = "aaioe";
		Assert.assertEquals("eoiaa", reverseVowelString(s));
	}
	
	
	private String reverseVowelString(String s) {
		int start = 0, end = s.length()-1;
        Set<Character> set = new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] charArray = s.toCharArray();
        while(start<end){
            //if(!set.contains(s.charAt(start))) start++;
            //if(!set.contains(s.charAt(end))) end++;
            if(set.contains(charArray[start]) && set.contains(charArray[end])) {
            	//swap
            	char temp = charArray[start];
            	charArray[start] = charArray[end];
            	charArray[end] = temp;
            	start++;
            	end--;
            	
            }else if(!set.contains(charArray[start])) start++;
            else end--;
            
        }
        char[] copyOf = Arrays.copyOf(charArray, charArray.length-1);
        String replaceAll = Arrays.toString(charArray).replaceAll("[^a-zA-Z]", "");
		return replaceAll;
		System.out.print(false);
	}

}
