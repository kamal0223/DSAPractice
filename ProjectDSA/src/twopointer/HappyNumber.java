package twopointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*Write an algorithm to determine if a number n is happy. A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 19

1^2 + 9^2 =       82   29
8^2 + 2^2 =       68
6^2 + 8^2 =      100
1^2 + 0^2+ 0^2 =   1*/

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int input
 * 	->what is the expected output? --> boolean output
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
public class HappyNumber {

	@Test
	public void test1() throws Exception {
		int input = 19;
		boolean output = true;
		System.out.println(usingTwoPointer(input));
		//Assert.assertEquals(output, usingTwoPointer(input));
		//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
	}

	@Test
	public void test2() throws Exception {
		int input = 20;
		boolean output = true;
		System.out.println(usingTwoPointer(input));
		//Assert.assertEquals(output, usingTwoPointer(input));
		//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
	}

	//@Test (expected = Exception.class)
	public void test3() throws Exception {
		int input = 0;
		System.out.println(usingTwoPointer(input));
		//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
	}

	/*using brute force
	 * initialize a sum =0
	 * initialize a arraylist
	 * Traverse a loop with condition that does not contain the sum in set
	 * 		traverse through the each digits in the number till the digits are exhausted ((remainder<1))
	 * 		Get each digit of the input number and square it and store it in sum
	 * 		sum+(eachDigit)^2 till all digits are summed up
	 * Add the sum of all square of digits to the arrayList
	 * check if that sum of all square of digits == 1 if true return true
	 * once out of outer loop return false 
	 * 
	 * 

	 */

	private boolean usingBruteForce(int input) {
		List<Integer> ali = new ArrayList<Integer>();
		int n = input;
		while(true) {
			//to get each digit and calculate sum of square
			int tempSum = 0;
			while(n!=0) {
				tempSum = tempSum+(n%10)*(n%10);
				n = n/10;
			}
			n = tempSum;
			if(tempSum == 1) return true;
			if(ali.contains(tempSum)) return false;
			ali.add(tempSum);
		}
	}


	/*using two pointer
	 * create a method that can do the following:
	 * 		convert into a single digit
	 * 		find the remainder and quotient
	 * 		square the digit and add to the total
	 * 
	 * Happy method:
	 * if the number is not 1 and 4
	 * find the square sum
	 * continue untill the condition is satisfied
	 * if the number is 1 then return true
	 * else return false
	 * 
	 * 

	 */


	private int squareSum(int n) {
		
		int tempSum = 0;
		while(n!=0) {
			tempSum = tempSum+(n%10)*(n%10);
			n = n/10;
		}	
		return tempSum;

	}

	private boolean usingTwoPointer(int input) {
		
		while(input != 1 && input != 4) {   // 1 or 4 then continue the loop
			input = squareSum(input);
		}
		return input == 1;
		

	}















}
