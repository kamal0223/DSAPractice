package week1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an array of integers arr, write a function that returns true if and only if 
 * the number of occurrences of each value in the array is unique.
 * 	Input: arr = [1,2,2,1,1,3]
 *	Output: true
 * 
 * Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] arr
 * 	->what is the expected output? --> boolean
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

public class UniqueNumberOfOccurence {

	// positive
	@Test
	public void test1() throws Exception {
		int[] input = { 1,2,3,1,2,1 };
		Assert.assertTrue(usingBruteForce(input));
	}

	// negative	
	@Test
	public void test2() throws Exception {
		int[] input = { 1, 1, 2, 2 };
		Assert.assertFalse(usingBruteForce(input));
	}

	// Negative
	@Test(expected = Exception.class)
	public void test3() throws Exception {
		int[] input = {};
		usingBruteForce(input);
	}

	//edge
	@Test
	public void test4() throws Exception {
		int[] input = { 1 };
		Assert.assertTrue(usingBruteForce(input));
	}

	/*pseudocode brute force
	 * if the array length is 0 then throw exception 
	 * initialize a arraylist of Integer
	 * initialize a int counter to zero
	 * Traverse through the input array from index 0 to length
	 * 		initialize a tempCounter = 0
	 * 		check the element is already visited if not vistied add it to list 
	 * 		already visited pass the control to next element using continue
	 * 		Traverse through input array from index 0 to length
	 * 		check if element at i is equal to element at j
	 * 			if yes increment temptCounter
	 * When came out of loop 2 check if tempCounter equals counter
	 * if yes return false
	 * if not then update the value of counter with current element count
	 * return true at the end
	 *  
	 */

	//time complexity -> o(n^2)
	//space complexity -> O(1)
	public boolean usingBruteForce(int[] input) throws Exception {

		if(input.length == 0) throw new Exception("input array cannot be empty");
		int counter = 0;
		List<Integer> ali = new ArrayList<Integer>();
		for(int i = 0;i<input.length;i++) {
			int tempCounter = 0;
			//add the input[i] in an arrayList
			//check the element is presetn in arraylist if not add else continue
			if(ali.contains(input[i])) continue;
			ali.add(input[i]);
			//if(i == input.length-1 && counter == 1) return false;
			for(int j =0;j<input.length;j++) {
				if(input[i] == input[j]) tempCounter++;		
			}
			if(counter == tempCounter) return false;
			counter = tempCounter;
		}
		return true;
	}

	/*
	 * pseudocode 
	 * if the array length is 0 then throw exception 
	 * create a hashMap of Integers 
	 * check the element is present in map if the element is not present in key,
	 * then add it as key and value as 1 
	 * if the element is present just make increment its corresponding value 
	 * When loop ends we would have the element with its count in value check 
	 * Traverse through the map and add it to a hashset, it returns false if element already present in set
	 * if all the values are unique return true
	 */

	//time complexity-> o(n+n) = o(n)
	//space complexity-> o(1)
	private boolean usingMap(int[] input) throws Exception {

		if (input.length == 0)
			throw new Exception();
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			if (hm.containsKey(input[i])) {
				hm.put(input[i], hm.get(input[i]) + 1);
			} else {
				hm.put(input[i], 1);
			}

		}
		Set<Integer> hs = new HashSet<Integer>();
		for (Map.Entry<Integer, Integer> eachPair : hm.entrySet()) {
			if (!(hs.add(eachPair.getValue())))
				return false;
		}

		return true;
	}

}
