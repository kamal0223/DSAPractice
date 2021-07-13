package week1;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/*
 * Given a string s, reverse the only the alpha numeric
 * Example 1:
   Input: s = "ab-cd"
            Output: "dc-ba"
            Example 2:
            Input: s = "a-bC-dEf-ghIj"
            Output: "j-Ih-gfE-dCba"
            Example 3:
            Input: s = "Test1ng-Leet=code-Q!"
            Output: "Qedo1ct-eeLg=ntse-T!"
            
 * 
 * Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> String
 * 	->what is the expected output? --> String
 *  ->Do i have constraints to solve the problem? -->
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

public class ReverseString {
	
	/*
	 * convert the input string to char array
	 * Declare two pointer left = 0 and right = lenght-1
	 * condition to traverse left<right
	 * if condition to swap is both the character are not a alphabets
	 * 		increment left and right decrement
	 * else if when left is not equal to alphabets increment left
	 * else when right is not equal to alphabets decrement right
	 * convert char array to string
	 * return string
	 * 
	 * 
	
	*/
	
	//positive
		@Test
		public void test1() throws Exception {
			String str = "ab-cde";
			String output = "ed-cba";
			Assert.assertEquals(output, UsingTwoPointer(str));
			//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
		}
		
		@Test
		public void test2() throws Exception {
			String str = "a-bC-dEf-ghIj";
			String output = "j-Ih-gfE-dCba";
			Assert.assertEquals(output, UsingTwoPointer(str));
			//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
		}
		
		@Test
		public void test3() throws Exception {
			String str = "Test1ng-Leet=code-Q!";
			String output = "Qedo1ct-eeLg=ntse-T!";
			Assert.assertEquals(output, UsingTwoPointer(str));
			//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
		}
	
		@Test (expected = Exception.class)
		public void test4() throws Exception {
			String str = "";
			String output = "Qedo1ct-eeLg=ntse-T!";
			Assert.assertEquals(output, UsingTwoPointer(str));
			//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
		}
		
		//time complexity = O(n)
		//space complexity = O(n)
	public String UsingTwoPointer(String str) throws Exception {
		
		if(str.length() == 0) throw new Exception("input string cannot be empty");
		
		char[] charArray = str.toCharArray();
		int left = 0, right = str.length()-1;
		//Character.isLett
		while(left<right) {
			if(!(Character.isLetter(charArray[left]))) left++;
			if(!(Character.isLetter(charArray[right]))) right--;
			if(Character.isLetter(charArray[left]) && Character.isLetter(charArray[right])) {
				char temp = charArray[left];
				charArray[left++] = charArray[right];
				charArray[right--] = temp;
			}
		}
		
		return String.valueOf(charArray);
		
	}





}
