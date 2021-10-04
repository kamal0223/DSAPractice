package flash.slidingwindow;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//https://leetcode.com/problems/longest-nice-substring/
public class LongestNiceString_1763 {
	
	@Test
	public void test1() {
		String s = "YazaAay";
		System.out.println(longestNiceSubstringRecursive(s)); //5
	}
	
	@Test
	public void test2() {
		String s = "TacoCat";
		System.out.println(longestNiceSubstringRecursive(s)); //-1
	}
	
	@Test
	public void test3() {
		String s = "AcZCbaBz";
		System.out.println(longestNiceSubstringRecursive(s)); //8
	}
	
	/*
	 * Two loops for getting all the substring
	 * check each substring is nice string and also it is longer than previous nice substring
	 * yes->update nice substring with this string
	 * return this string
	 * O(n^2*m) and space  - o(1)
	 */

	private String longestNiceSubstring(String s) {
		int maxLength = 0;
        String res = "";
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<s.length();j++){
               String temp =  s.substring(i,j+1);
                //check if the substring is creater than previous temp
                //check if the substring is nice substring
                if(temp.length()>res.length() && niceString(temp)){
                    res = temp;
                }
                
            }
        }
        return res;
	}
	
	public boolean niceString(String temp){
        //check if each characters in the string has upper and lower
        for(char each:temp.toCharArray()){
            if(!(temp.contains(Character.toLowerCase(each)+"") && temp.contains(Character.toUpperCase(each)+""))) {
                return false;
            }
        } 
        return true;
    }
	
	private String longestNiceSubstringRecursive(String s) {
		//recursion
		if(s.length()<=1) return "";
		Set<Character> set = new HashSet<Character>();
		for(char eachCh:s.toCharArray()){
		  set.add(eachCh);
		}
		for(int i = 0;i<s.length();i++){
		   //check the case of the charac
		   if(set.contains(Character.toUpperCase(s.charAt(i))) && set.contains(Character.toLowerCase(s.charAt(i)))){
			//append it to temp string
			  continue;
			 }
		   String sub1 = longestNiceSubstringRecursive(s.substring(0, i));
		   String sub2 = longestNiceSubstringRecursive(s.substring(i+1));
		   return sub1.length()>sub2.length()?sub1:sub2;
		   }
		return s;
	}

}
