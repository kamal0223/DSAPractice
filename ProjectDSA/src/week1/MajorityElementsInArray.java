package week1;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an array nums of size n, return the majority element. 
 * you may assume that the majority element always exists in the array.
 * The majority element is the element that appears more than n/2 times. 
 * 
 * Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] array
 * 	->what is the expected output? --> int output (majority element)
 *  ->Do i have constraints to solve the problem? --> majority element always exist in array
 *  ->Do i have all informations to go to next step? -> If all the above mentioned steps (i.e., for Yes) we can proceed
 *  ->How big is your test data will be? -> 
 *  
 *  2. Test Data Set
 *  -> Minimum of 3 data set !! "Positive" , "Edge" and "Negative" 
 *  ----> Positive - {2,3,4,3,3}, output = 3, {4,4,4,4,4} output = 4
 *  ----> Negative - {1}, outuput  = exception
 *  ----> Edge - no case found
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
 * 5. Do I know alternate solutions as well?
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

public class MajorityElementsInArray {

	@Test
	public void test1() {
		int[] input = { 4, 5, 5, 5, 5, 5, 5, 1, 2, 3 };
		int output = 5;
		System.out.println(usingMap(input));
		Assert.assertEquals(output, usingMap(input));

	}

	@Test
	public void test2() {
		int[] input = { 4, 4, 4 };
		int output = 4;
		System.out.println(usingMap(input));
		Assert.assertEquals(output, usingMap(input));

	}

	/*
	 * initialize maxcounter to zero initialize maxElement Traverse through the
	 * array using index i to set the first pointer Inside first loop Traverse
	 * through each element of the array starting from i+1 if element at i and i+1
	 * match then increment maxCounter After the second loop, then check
	 * array[i]>maxCounter then reassing maxElement = array[i]
	 * O(n^2) time
	 */
	private int bruteForce(int[] input) {

		int previousCounter = 0;
		int majorityElement = 0;
		for (int i = 0; i < input.length - 2; i++) {
			int maxCounter = 1;
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] == input[j]) {
					maxCounter++;
				}

				if (previousCounter < maxCounter) {
					previousCounter = maxCounter;
					majorityElement = input[i];
				}
			}
		}

		return majorityElement;
	}

	/*
	 * Count of any element > size/2 Get the count of element using nested for loop
	 * Traverse the element from 0 index till the last before element initialize
	 * maxCounter to one another nested loop staring point of i+1 to traverse for
	 * each element from loop 1 if array[i] == array[j] maxCounter++; maxCounter>
	 * size of array/2 then return array[i]
	 * 
	 */
	private int usingFormula(int[] input) {
		int majorityElement = 0;
		for (int i = 0; i < input.length - 2; i++) {
			int maxCounter = 1;
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] == input[j]) {
					maxCounter++;
					if (maxCounter > (input.length) / 2)
						majorityElement =  input[i];
				}

			}

		}
		return majorityElement;
	}
	
	/*
	 * Create a Map using 
	 * For loop to iterate over the array 
	 * if key is already present in map then increment the value in counter
	 * if not present then put the value as 1 to corresponding key
	 *  check if value 
	*/
	private int usingMap(int[] input) {
		//{1,2,3,3,3}
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		int counter = 0;
		int majorElement = 0;
		for(int i=0;i<input.length;i++) {
			//check if the element is already present in array
			if(hm.containsKey(input[i])) {
				counter++;
				//hm.put(input[i], counter);
			} else {
				counter = 1;
			}
			hm.put(input[i], counter);
			if (counter>(input.length)/2) majorElement = input[i];
		}
		
		return majorElement;
	}

}
