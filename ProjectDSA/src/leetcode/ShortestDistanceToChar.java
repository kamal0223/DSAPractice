package leetcode;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;



//https://leetcode.com/problems/shortest-distance-to-a-character/

/*Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length 
 * and answer[i] is the distance from index i to the closest occurrence of character c in s.
The distance between two indices i and j is abs(i - j), where abs is the absolute value function.*/

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> String input, Character c
 * 	->what is the expected output? --> int[] output
 *  ->Do i have constraints to solve the problem? --> 1 <= s.length <= 104
 *  													   s[i] and c are lowercase English letters.
 *  													   It is guaranteed that c occurs at least once in s.
 *  
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

public class ShortestDistanceToChar {


	@Test
	public void test1() throws Exception {
		String input = "loveleetcode";
		char c = 'e';
		int[] output = {3,2,1,0,1,0,0,1,2,2,1,0};
		Assert.assertTrue(Arrays.equals(output, usingSlidingWindow(input, c)));
	}

	@Test
	public void test2() throws Exception {
		String input = "e";
		char c = 'e';
		int[] output = {0};
		Assert.assertTrue(Arrays.equals(output, usingSlidingWindow(input, c)));
	}

	@Test
	public void test3() throws Exception {
		String input = "aaab";
		char c = 'b';
		int[] output = {3,2,1,0};
		Assert.assertTrue(Arrays.equals(output, usingSlidingWindow(input, c)));
	}
	
	@Test
	public void test4() throws Exception {
		String input = "aaabab";
		char c = 'b';
		int[] output = {3,2,1,0,1,0};
		Assert.assertTrue(Arrays.equals(output, usingSlidingWindow(input, c)));
	}

	

	/*brute force
	 * initialize an output array of size of string
	 * initialize a int max variable
	 * Traverse the input string from start to end and 
	 * assign values to ouput like int max to 0th index and decrement
	 * assign 0 for character match and increment for next elements
	 * Traverse the input string again from end to start
	 * assign int max from start and get the and 0 when value match and increment for each element
	 * while assinging value to output array, get the minimum of previous and current value and assign to output
	 * return output

		time complexity = O(n)
		space complexity = o(n)
	 */

	private int[] usingBruteForce(String input, char c) {

		int[] output = new int[input.length()];
		int max = input.length();

		for(int i=0;i<input.length();i++) {

			if(input.charAt(i) == c) {
				max = 0;
			}
			output[i] = max++;
		}

		max = input.length();

		for(int i = input.length()-1; i>=0;i--) {
			if(input.charAt(i) == c) {
				max = 0;
			}
			output[i] = Math.min(output[i], max++);
		}

		return output;
	}
	
	/*
	 * initialize pointer slow, fast to zero
	 * initialize an output array of lenght as length of s
	 * traverse till the length of string and set the value as string length for output array
	 * traverse till the fast and slow is less than string length
	 * check if both value at fast and slow not matches the char move fast
	 * check if fast value is Char and slow and fast are not in same index
	 * 		get the min of output array and abs diff of pointers
	 * 		increment slow
	 * check if slow value is Char and fast and slow are not in same index
	 * 		get the min of output array and abs diff of pointers
	 * 		increment fast
	 * when value and index at fast, slow are same then get the min and set in output
	 * 		move fast
	 * return output array
	 * 
	
	*/

	//O(n) time and space is o(n)
	private int[] usingSlidingWindow(String input, char c) {

		int[] output = new int[input.length()];
		int slow = 0, fast = 0;
		
		for(int i = 0;i<output.length;i++) {
			output[i] = input.length();
		}

		while(fast<input.length() && slow<input.length()) {
		
			if(input.charAt(fast)!=c && input.charAt(slow)!=c) fast++;
			if(input.charAt(fast) == c && slow!=fast) {
				output[slow] = Math.min(output[slow], Math.abs(fast-slow));
				slow++; 
			}

			//if(input.charAt(slow) == c && input.charAt(fast) == c) slow = fast;
			if(input.charAt(slow) == c && slow!=fast) {
				output[fast] = Math.min(output[fast], Math.abs(fast-slow));
				fast++;
			}
			
			if(input.charAt(slow) == input.charAt(fast) && slow ==  fast) {
				output[fast] = Math.min(output[fast], Math.abs(fast-slow));
				fast++;
			}

		}
		System.out.println(Arrays.toString(output));
		return output;
	}

}
