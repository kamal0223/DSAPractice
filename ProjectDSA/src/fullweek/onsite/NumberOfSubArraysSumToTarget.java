package testleaf.onsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


/*
Given an array of integers nums and an integer k,
return the total number of continuous subarrays whose sum equals to k.
 */
public class NumberOfSubArraysSumToTarget {

	@Test
	public void test1() {
		int[] input = {1,1,1};  //1,2,3
		int k = 2;
		Assert.assertEquals(2, numberOfSubArrayPrefixSumOptimised(input,k));
	}
	
	@Test
	public void test2() {
		int[] input = {1,2,3};
		int k = 3;
		Assert.assertEquals(2, numberOfSubArrayPrefixSumOptimised(input,k));
	}
	
	@Test
	public void test3() {
		int[] input = {-1,-1,1};  //-1,-2,-1
		int k = 0;
		Assert.assertEquals(1, numberOfSubArrayPrefixSumOptimised(input,k));
	}
	@Test
	public void test4() {
		int[] input = {1,2,3};
		int k = 7;
		Assert.assertEquals(0, numberOfSubArrayPrefixSumOptimised(input,k));
	}

	
	/*
	 * bruteforce
	 * declare a maxCount to 0
	 * traverse the input array from left to right 
	 * 	  traverse the input array from left to right
	 * 		check if the sum of values in i and j is equal to k
	 * 		increment th maxcount
	 * 
	 * return the maxcount
	 */
	private int numberOfSubArray(int[] input, int k) {
		int maxCount = 0;
		for (int i = 0; i < input.length; i++) {
			int sum  = 0;
			for (int j = i; j < input.length; j++) {
				sum += input[j];
				if(sum == k) maxCount++;
			}
		}
		
		return maxCount;
	}
	
	/*
	 * declare a sum int to 0
	 * traverse the input array from left to right with index i
	 * replace the current index with the sum of current element and previous element
	 * Now the sum of each of the subarray from 0 to that index is mapped in input array
	 * outer loop to iterate the start index of subarray
	 * declare a tempsum to 0
	 *   inner loop to iterate the end index of subarray
	 *      if start is 0 
	 *      yes- we can directly pickt he end index value from input
	 *      check for k equality, if yes then count increment
	 *      no - we should substart input at end - input at start-1 (input[i,j] = input[j]-input[i-1])
	 * 			 if the subtract equal to k then count increment
	 * return count
	 * 
	 * time complexity - O(n square) and space is O(1)
	 */
	private int numberOfSubArrayPrefixSum(int[] input, int k) {
		int count = 0;
		for (int i = 1; i < input.length; i++) {
			input[i] = input[i]+input[i-1];
		}
		//to find the sum of all subarrays in input array
		for(int start = 0;start<input.length;start++) {
			int tempSum = 0;
			for(int end = start;end<input.length;end++) {
				if(start == 0) {
					if(input[end] == k) count++;
				}
				else {
					if(input[end]-input[start-1] == k) count++;
				}
			}
		}
		return count;
	}
	
	/*
	 * to optimise the above code to decrease the time complexiy
	 * declare a hashmap
	 * Traverse the input array from left to right
	 *   get the sum of the subarray from 0 to current index
	 *   if the end-k(end-start == k) is present in map then count is count+map value of current key
	 *   add the end ie sum to map as key and its occurence as value
	 * return count
	 */
	private int numberOfSubArrayPrefixSumOptimised(int[] input, int k) {
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int count = 0;
		int end = input[0];
		hm.put(input[0], 1);
		for (int i = 1; i < input.length; i++) {
			end = input[i]+input[i-1];
			if(hm.containsKey(end-k)) count += hm.get(end-k);
			hm.put(end, hm.getOrDefault(end, 0)+1);
		}
		return count;
	}
	
	/*
	 * kandane
	 * declare a maxCounter
	 * sort the input array
	 * declare a sum to 0
	 * declare a left pointer at 0 and right at 0
	 * traverse till the left less than length
	 * if the right>lenght-1 move left++ and right = left 
	 * add the current to sum
	 * check if the sum == k yes->then maxCount++ and move left++
	 * 
	 * 			no-> check if sum is less than k yes->right++
	 *               no->left++
	 *               
	 *  
	 *  
	 */
	private int numberOfSubArray2(int[] input, int k) {
		int maxCounter = 0;
		int sum = 0;
		Arrays.sort(input);
		int left = 0, right=0;
		while(left<input.length) {
			
			sum += input[right];
			if(sum == k) {
				maxCounter++;
				left++;
				sum = 0;
			}
			else if(sum<k) right++;
			else {
				left++;
				sum = 0;
			}
			
			if(right>=input.length-1) {
				left++;
				sum = 0;
				right = left;
			}
			
		}
		return maxCounter;
	}
	
}
