package slidingwindow;

import org.junit.Assert;
import org.junit.Test;

/*Today, the bookstore owner has a store open for customers.length minutes.
Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
On some minutes, the bookstore owner is grumpy.  If the bookstore owner is 
grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  
When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
Return the maximum number of customers that can be satisfied throughout the day.

Example 1:
Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
*/

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] customers, int x, int[] grumpy
 * 	->what is the expected output? --> int maxSatisfied
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
public class GrumpyBookStore {
	
	//positive for differnt value
		@Test
		public void test1() {
			int[] customers = {1,0,1,2,1,1,7,5};
			int[] grumpy =    {0,1,0,1,0,1,0,1};
			int x = 3;
			Assert.assertEquals(16, usingWindowSliding(customers, grumpy, x));
			
		}
		
		//if 2 window the number of customers in grumpy 
		@Test
		public void test2() {
			int[] customers = {1,5,1,2,1,1,1,5};
			int[] grumpy =    {0,1,0,1,0,1,0,1};
			int x = 2;
			Assert.assertEquals(9, usingWindowSliding(customers, grumpy, x));
			
		}
		
		//negative
		@Test
		public void test3() {
			int[] customers = {0,0,0,0};
			int[] grumpy = {0,1,0,1};
			int x = 0;
			Assert.assertEquals(0, usingWindowSliding(customers, grumpy, x));
			
		}
		
		/*
		 * intialize previousSum to zero
		 * intialize maxSum to zero
		 * initialize totalCustomers to zero
		 * initialize totalUnsatisfied to zero
		 * traverse through the customer array till x with i being index
		 * 	multiple index i elements of customers and grumpyt and find the sum
		 * 	totalUnsatisfied = previousSum;
		 * 	totalCustomers+ = customer[i]
		 * 	assign maxSum = previousSum
		 * traverse through the length of the customers frome index 1 till length-x
		 *   multiple index i elements of both customers and grumpy
		 * 	 subtract the index-1 element from the previousSum and add index-1+k and assign to previousSum
		 * 	 update maxSum by finding max of previousSum and maxSum
		 *   totalUnsatisfied+ = previousSum;
		 *   totalCustomers+ = customer[i]
		 * to get total satisfied customers:
		 * totalsatisfiedInWindow =totalwindowCustomer-unsatisfiedInWindow
		 * totalSatisfied = totalCustomers-totalUnsatisfied
		 * output = totalSatisfied-totalSatisfiedInWindow+totalWindowCutomers
		 * 

		*/
		
		private int usingWindowSliding(int[] customers, int[] grumpy, int x) {
			int previousSum = 0, unsatisfiedInwindow = 0, totalCustomers = 0, totalUnsatisfied = 0;
			
			
			for(int i = 0;i<x;i++) {
				previousSum+= customers[i]*grumpy[i];
				totalCustomers+= customers[i];
				totalUnsatisfied = previousSum;
				unsatisfiedInwindow = previousSum;
			}
			
			int totalwindowCustomer = totalCustomers;
			
			for(int i = 1;i<=customers.length-x;i++) {
				previousSum+= customers[i-1+x]*grumpy[i-1+x]-customers[i-1]*grumpy[i-1];
				if(previousSum>unsatisfiedInwindow) {
					totalwindowCustomer+= customers[i-1+x]-customers[i-1];
				}
				unsatisfiedInwindow = Math.max(unsatisfiedInwindow, previousSum);
				
			}
			
			for(int i = x;i<customers.length;i++) {
				totalUnsatisfied+= customers[i]*grumpy[i];
				totalCustomers+= customers[i];
			}
			
			int totalsatisfiedInWindow = totalwindowCustomer-unsatisfiedInwindow;
			int totalSatisfied = totalCustomers-totalUnsatisfied;
			
			return totalSatisfied-totalsatisfiedInWindow+totalwindowCustomer;
		}

}
