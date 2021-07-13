package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 * 	Input: nums = [3,0,1]   11,6,10,8,7  42/5 quotinet = 8 remain =2   output = 9
 * 4 if 2 is present 6/3 = 3
 *  Output: 2
 * 
 * Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] array
 * 	->what is the expected output? --> int missingNum
 *  ->Do i have constraints to solve the problem? -->
 *  ->Do i have all informations to go to next step? -> If all the above mentioned steps (i.e., for Yes) we can proceed
 *  ->How big is your test data will be? -> 
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

public class DistinctArrayMissingNumber {

	// positive
	@Test
	public void test1() throws Exception {
		int[] input = { 3, 0, 1 };
		int output = 2;
		Assert.assertEquals(output, usingBruteForece(input));
	}
	
	//negative
	@Test (expected = Exception.class)
	public void test2() throws Exception {
		int[] input = { 3, 2, 1 };
		usingBruteForece(input);
	}
	// edge
	@Test (expected = Exception.class)
	public void test3() throws Exception {
		int[] input = { 1 };
		usingBruteForece(input);
	}

	//negative
	@Test (expected = Exception.class)
	public void test4() throws Exception {
		int[] input = {};
		usingBruteForece(input);
	}
	
	
	
	/*
	 * if the input array is empty then throw exception with message
	 * sort the input array in ascending order
	 * Traverse through the length of input array from 0 index
	 * then check the condition that element in position i should be (element in position i+1)+1
	 * if not then (element in position i+1)+1 is the missing element
	 * return that number
	*/
	
	//time complexity -> O(nlogn)
	//space compexity -> o(1)
	private int usingArraySort(int[] input) throws Exception {
		
		if(input.length == 0) throw new Exception("input array cannot be empty");
		
		Arrays.sort(input);
		
		System.out.println("sorted innput array "+Arrays.toString(input));
		
		for(int i=0;i<input.length-1;i++) {
			if(!(input[i]+1 == input[i+1])) return input[i]+1;
		}
		
		throw new Exception("No missing element in array");
		
	}
	
	/*
	 * Traverse through the input array till length-1 of it
	 * 		Again traverse for each element of first loop till length
	 * 			check condition if first element is greater than second element
	 * 			Then perform swap by creating another temp variable
	 * Once all elements are compared we get a array in ascending order
	 * Traverse through the length of input array from 0 index
	 * then check the condition that element in position i should be (element in position i+1)+1
	 * if not then (element in position i+1)+1 is the missing element
	 * return that number 
	*/
	
	//time complexity ->  o(n^2)
	//space complexity -> O(1)
	private int usingBruteForece(int[] input) throws Exception {
		
		if(input.length == 0) throw new Exception("input array cannot be empty");
		
		for(int i =0;i<input.length-1;i++) {
			for(int j=i+1;j<input.length;j++) {
				if(input[i]>input[j]) {
					int temp = 0;
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}		
		}
		
		for(int i = 0;i<input.length;i++) {
			if(!(input[i]+1 == input[i+1])) return input[i]+1;
		}
		
		throw new Exception("no elment is missing");
	}
	
	/*
	 * if the size of input is 1 then return 0 if the last e Traverse through length
	 * of the input using i check i is contained in input array if i is not
	 * contained in input array return i
	 */
	//time complexity = O(n)
	//space complexity = O(1)
	private int bruteForce0ToN(int[] input) throws Exception {
		int missingEle = 0;
		if (input.length == 1)
			return 0;
		Arrays.sort(input);
		if (input[input.length - 1] > input.length)
			throw new Exception("Array has element greater than size");
		for (int i = 0; i < input.length; i++) {
			if (!(i == input[i])) {
				missingEle = i;
				break;
			}
		}
		return missingEle;
	}

}
