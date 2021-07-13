package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
/*
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *	Input: nums = [8,1,2,2,3]  [9,2,3,3,4,0,0,0,0,0,0,0,0,0,0,0,0,]  [9,11,5,6,7,4,0,0,0,0,0,]
 *  Output: [4,0,1,1,3]
 * 
 * Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] input
 * 	->what is the expected output? --> int[] ouput of same lenght of input
 *  ->Do i have constraints to solve the problem? -->2 <= nums.length <= 500, 0 <= nums[i] <= 100
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
public class SmallerThanCurrentNum {

	//positive
	@Test
	public void test1() {
		int[] input = {8,1,2,2,3,0,0};
		int[] output = {4,0,1,1,3};
		System.out.println(Arrays.toString(usingSort(input)));
		//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
	}


	//@Test
	public void test2() {
		int[] input = {6,5,4,8};
		int[] output = {2,1,0,3};
		Assert.assertTrue(Arrays.equals(usingTwoPass(input), output));
	}

	//@Test
	public void test3() {
		int[] input = {7,7,7,7};
		int[] output = {0,0,0,0};
		Assert.assertTrue(Arrays.equals(usingTwoPass(input), output));
	}

	//a pointer i initialized to zero
	//for each element the loop has to start from 0 and end till the length
	//a iterator starting with zero
	//initialize counter to zero
	//condition to check if input[pointer]>input[iterator] counter++
	//increment the pointer for each looping
	//increment the iterator

	private int[] usingTwoPass(int[] input) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		//make a loop of n^2 times
		while(k < input.length*input.length) {
			if(j == input.length) {
				j = 0;
				i++;
				}
			System.out.println("pointer position of i j "+i+" "+j);
			j++;
			k++;
		}
		return null;
	}
	
	/*
	 * initialize an output array of size of input array
	 * Sort the array using arrays.sort  O(n logn) 
	 * if the 0,0,1,2,2,3,8 value
	 *        0,1,2,3,4,5,6 index
	 * the index of the element is the number of elements less than that => output
	 * if there are duplicates then pick the first occurence index
	 * return output
	*/
	
	private int[] usingSort(int[] input) {
		int[] output = new int[input.length];
		int[] sortedInput = new int[input.length];
		List<Integer> sortedAli = new ArrayList<Integer>();
		for(int i = 0;i<input.length;i++) {
			sortedAli.add(input[i]);
		}
		Collections.sort(sortedAli);
		System.out.println("unsorted input "+Arrays.toString(input));
		System.out.println("sorted input "+sortedAli);
	
		
		//Map<Integer,Integer> hm 
		//add it to hashmap
		//for(int)
		
		return output;
		
	}
	
	//pseudocode
	/*
	 * initialize a array int result of length of input array
	 * initialize a temp array of size 101 as the value can be of 0 to 100
	 * traverse through the input array and set the value of input element as index and increment that index 
	 * the temp array will have the count of the input elements in the index[valueOfInputEle]
	 * the count of each element is now obtained in sorted order
	 * Loop to traverse from 1 to 100
	 * add the previous all element with current element count of numbers that are less than that and store in temp
	 * now the numbers less than that element in position(i) are in position (i-1) 
	 * traverse through the lenght of input and if value of input is 0 then then the elements less than that is 0
	 * or else output is temp[value of input-1]
	 * return output
	*/
	private int[] usingThreePass(int[] nums) {
		int[] result = new int[nums.length];
	       int[] temp = new int[101];
	        
	        for (int i = 0; i < nums.length; i++) {
	            temp[nums[i]]++;
	        }
	        System.out.println(Arrays.toString(temp));
	        for (int i = 1; i < 101; i++) {
	            temp[i] += temp[i-1];
	            
	        }
	        System.out.println(Arrays.toString(temp));
	        
	        
			
			for (int i = 0; i < nums.length; i++) { 
				if(nums[i] == 0)  result[i] = 0; 
			    else  result[i] = temp[nums[i] - 1]; 
			}
			 
	        return result;
	}

}
