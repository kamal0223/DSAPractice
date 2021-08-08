package onspot;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> String input , int k
 * 	->what is the expected output? --> int max
 *  ->Do i have constraints to solve the problem? --> using 2 pointer
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


public class MaxSubtring {
	
	
	//positive
		@Test
		public void test1() {
			String input = "eceba";
			int k = 2;
			Assert.assertEquals(3, usingWindowSliding(input, k));
			//System.out.println("intersetion input1 "+Arrays.toString(usingSet(input1, input2)));
			//Assert.assertEquals(Arrays.toString(intersection), Arrays.toString(bruteForce(input1, input2)));
		}
		
		/*
		 * declare slow = 0, fast = 0, max = 1;
		 * Declare a arraylist
		 * iterate till the fast reaches lenght of string
		 * 	check
		 * 
		
		
		*/		
		
		private int usingWindowSliding(String input, int k) {
			int slow = 0, fast = 0, uniqueCounter = 0, max = 1;
			int[] ascii = new int[128];
			
			for(fast = 0 ; fast<input.length();fast++) {
				
				if(ascii[input.charAt(fast)] == 0) {
					uniqueCounter++;
				}
				ascii[input.charAt(fast)]++;
				if(uniqueCounter>k) {
					while(ascii[input.charAt(fast)]>0) {
						ascii[input.charAt(slow++)]--;
					}
					uniqueCounter--;
				}
				max = Math.max(max, fast-slow+1);
			}
			
			System.out.println();
			return max;
		}

}
