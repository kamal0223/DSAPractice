package week2;

import org.junit.Assert;
import org.junit.Test;

/*Valid Palindrome after deleting one or zero character

Given a string s, return true if the s can be palindrome after deleting at most one character from it.
Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
*/

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> String input
 * 	->what is the expected output? --> boolean output
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
public class PalindromeWithRemoval {
	
	@Test
	public void test1() {
		String input = "aba";
		Assert.assertTrue(usingStringBuilder(input));
	}

	@Test
	public void test2() {
		String input = "abca";
		Assert.assertTrue(usingStringBuilder(input));
	}
	@Test
	public void test3() {
		String input = "abc";
		Assert.assertFalse(usingStringBuilder(input));
	}
	@Test (expected = RuntimeException.class)
	public void test4() {
		String input = "";
		Assert.assertTrue(usingStringBuilder(input));
	}
	

	/*
	 * iterate through the string with index i
	 * 	initialize a temp string builder object
	 * 	create another inner loop  to iterate the string with index j
	 * 		don't pick the element when index are same
	 * 		add the current element to the temp 
	 *	when out of the innner loop check temp is equal to reverse of it using reverse function, if yes return true
	 *
	 *return false at the end
	time complexity - O(n^2) space complexity - O(n)
	*/
	private boolean usingBruteForce(String input) {
		
		if(input == null || input == "") throw new RuntimeException();
		
		if(input.equals(new StringBuilder(input).reverse().toString())) return true;
		
		for(int i = 0;i<input.length();i++) {
			StringBuilder sb = new StringBuilder();
			String temp = "";
			for(int j = 0;j<input.length();j++) {
				if(i!=j) {
					sb.append(input.charAt(j));
				}
			}
			temp = sb.toString();
			if(temp.equals(sb.reverse().toString())) return true;
		}
		

		return false;
	}
	
	/*
	 * 
	 * iterate through the lenght of the input
	 * create a string builder with input as constructor
	 * initialize a temp string
	 * remove the current element using string builder method
	 * assign the string builder value to temp
	 * reverse the builder object string and compare with temp
	 * if matches then return true
	 * 
	 * after all iteration return false
	space complexity - O(n) time complexity - O(n^2) since reverse function has O(n)
	*/
	private boolean usingStringBuilder(String input) {
		if(input == null || input == "") throw new RuntimeException();
		if(input.equals(new StringBuilder(input).reverse().toString())) return true;
		for(int i =0;i<input.length();i++) {
			StringBuilder sb = new StringBuilder(input);
			sb.deleteCharAt(i);
			String temp = sb.toString();
			if(temp.equals(sb.reverse().toString())) return true;
		}
		
		return false;
		
	}

}
