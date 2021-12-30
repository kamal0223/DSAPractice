package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/*Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".*/

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> String input
 * 	->what is the expected output? --> int[] output
 *  ->Do i have constraints to solve the problem? --> solve using O(n) time complexity and O(1) space complexity
 *  ->Do i have all informations to go to next step? -> If all the above mentioned steps (i.e., for Yes) we can proceed
 *  ->How big is your test data will be?
 *  
 *  2. Test Data Set
 *  -> Minimum of 3 data set !! "Positive" , "Edge" and "Negative" 
 *  -> Validate with the interviewer if the data set is fine -> its depends on the interviewer
 *  
 *  3. Do i know how to solve it?
 *  
 *  Yes - Great, is there an alternate? -> Yes
 *  No - Can i break down the problem into sub problems? 
 *  then -> 
 * 
 * 4. Ask for hint (if you do not know how to solve it?) 
 *  		-> Ask one time and thank the interviewer
 *  		-> Worst Case! even after got the hint, we don't know how to solve, then convince them and prove with your confidence 
 *  		   level to get the next question 
 *  
 * 5. Do I know alternate solutions as well? - yes
 * 	
 * 	Yes - What are those?
 *     way of Approach to solve with the following
 *    -> Brute Force (Simple Technique) -->  
 *    -> inbuilt approach --> List
 *  No - Can i break down the problems into sub problems?
 * 
 * 6. If you know alternate solutions-> find out the O notations (performance)
 *  Then explain the both or the best (depends on the time)
 *  
 *  Approach 1-> Start with the worst -> Improve to optimize -> End up with the beset
 *  Approach 2-> Write down the options and benefits and code the best
 *  
 * 7. Start with the Pseudo code
 * 
 * 8. Implement them in the code (editor)
 * 
 * 9. Test against the different data set
 * 
 * 10. If it fails, debug them to solve it
 */

public class AnagramInString {
	
	@Test
	public void test1() {
		String input = "cbaebabacd", p = "abc";
		findAnagrams(input, p);
		//Assert.assertTrue(Arrays.equals(new int[] {0,6}, usingSlidingWindow(input, p)));
	}
	
	@Test
	public void test2() {
		String input = "cbaebabacd", p = "ab";
		findAnagrams(input, p);
		//Assert.assertTrue(Arrays.equals(new int[] {1,5,6}, usingSlidingWindow(input, p)));
	}
	
	@Test
	public void test3() {
		String input = "c", p = "a";
		findAnagrams(input, p);
		//Assert.assertTrue(Arrays.equals(new int[] {}, usingSlidingWindow(input, p)));
	}

	/*
	 * initialize an int output array
	 * initialize an character array list of lenght of p
	 * initialize another arraylist for p string
	 * traverse through the input till length of p
	 * 	add each element to the arraylist
	 * 	add the elements of p to the arraylist of p
	 * 
	 * sort the arraylist and check if equals to sorted arrayP, 
	 * then add the index of charWindow to output int array
	 * Traverse through the input string from index 1 till length of input-length of p
	 * 	to get the next window subtract currentindex-1 element and add i+ lenght of p - 1
	 * 	sort the arraylist of window and match with sorted arraylistP if yes then add index of window to output[i]
	 * 
	 * return the outputarray
	 * 
	
	
	*/
	private int[] usingSlidingWindow(String input, String p) {
		int[] output = new int[input.length()];
		List<Character> arrayP = new ArrayList<Character>();
		List<Character> arrayWindow = new ArrayList<Character>();
		
		for(int i = 0;i<p.length();i++) {
			arrayP.add(p.charAt(i));
			arrayWindow.add(input.charAt(i));
		}
		Collections.sort(arrayP);
		List<Character> tempList = new ArrayList<Character>(arrayWindow);
		Collections.sort(tempList);
		if(arrayP.equals(tempList)) output[0] = 0;
		
		for(int i = 0;i<=input.length()-p.length();i++) {
			
		}
		
		return null;
	}
	
	public void findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<Character, Integer>();
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        
        for(int i = 0;i<p.length();i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i),0)+1);
        }
        
        int left = 0;
        List<Integer> ali = new ArrayList<Integer>();
        for(int right = 0;right<s.length();right++){
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right),0)+1);
            //stop when the window size is greater than 
            if(sMap.size() >= p.length()){
                if(sMap.equals(pMap)) ali.add(left);
                sMap.put(s.charAt(left),pMap.getOrDefault(s.charAt(left),0)-1);
                if(sMap.get(s.charAt(left)) <= 0){
                    sMap.remove(s.charAt(left));
                }
                left++;
            }
        }
        System.out.println(ali);
    }
	
	

}
