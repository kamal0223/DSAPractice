package slidingwindow;

import org.junit.Assert;
import org.junit.Test;



/*A dieter consumes calories[i] calories on the i-th day. For every consecutive sequence of k days, 
they look at T, the total calories consumed during that sequence of k days:

If T < lower, they performed poorly on their diet and lose 1 point;
If T > upper, they performed well on their diet and gain 1 point;
Otherwise, they performed normally and there is no change in points.
Return the total number of points the dieter has after all calories.length days.

Note that: The total points could be negative.

Example 1:
Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
Output: 0
Explaination: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.

Example 2:
Input: calories = [3,2], k = 2, lower = 0, upper = 1
Output: 1
Explaination: calories[0] + calories[1] > upper, total points = 1.

Example 3:
Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
Output: 0
Explaination: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.
*/

/* Problem Solving Techniques :
	 * 1. Do you understand the question? - Yes
	 * 		Yes - Go to next step
	 * 		No - Ask the person to provide more detail with example(s).
	 * 
	 *  ->what is the input(s)? --> int[] input, int k, int lower, int upper
	 * 	->what is the expected output? --> int output
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

public class CaloriesConsumed {

	//positive for 0
	@Test
	public void test1() {
		int[] input = {1,2,3,4,5};
		int k = 1, lower = 3, upper = 3;
		Assert.assertEquals(0, usingWindowSliding(input, k, lower, upper));
		
	}
	
	//positive for different value
	@Test
	public void test2() {
		int[] input = {3,2};
		int k = 2, lower = 0, upper = 1;
		Assert.assertEquals(1, usingWindowSliding(input, k, lower, upper));
		
	}	
		
	//positive for differnt value
	@Test
	public void test3() {
		int[] input = {3,2,1,3,3,2,9};
		int k = 3, lower = 7, upper = 9;
		Assert.assertEquals(-1, usingWindowSliding(input, k, lower, upper));
		
	}
	//negative
	@Test (expected = RuntimeException.class)
	public void test4() {
		int[] input = {};
		int k = 3, lower = 7, upper = 9;
		usingWindowSliding(input, k, lower, upper);
		
	}
	/*
	 *initialize a int variable points
	 *Traverse till length of array
	  intialize sum to zero
	  add each element and store in sum
	  when the i+1 is divisible by k then it is end of window
      when i+1/k == 0 check 
      	if sum is less than lower threshold then add -1 to points
 	  	if sum is greater than upper threshold then add 1 to points
	  	reset sum to 0
	  return points 
	
	*/
	//time complexity = O(n) and space complexity = O(1)
	private int usingWindowSliding(int[] input, int k, int lower, int upper) {
		
		if(input.length == 0) throw new RuntimeException("input array cannot be negative");
		int points = 0;
		int sum = 0;
		for(int i =0 ;i<input.length;i++) {
			sum+=input[i];
			if((i+1)%k == 0) {
				if(sum<lower) points+=-1;
				if(sum>upper) points+=1;
				sum = 0;
			}
		}
		
		System.out.println(points);
		return points;
	}	
		
		

}
