package palo.alto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import junit.framework.Assert;

public class SumOfdigitsMax {

	@Test
	public void test1() {
		int[] input = {51,71,17,42};
		Assert.assertEquals(93, sumOfDigits(input));
	}

	@Test
	public void test2() {
		int[] input = {42,33,60};
		Assert.assertEquals(102, sumOfDigits(input));
	}

	@Test
	public void test3() {
		int[] input = {51,32,43};
		Assert.assertEquals(-1, sumOfDigits(input));
	}

	/*
	 * declare a map of key as digitSum and number as value
	 * traverse the input array from left to right
	 * find the sum of its digits
	 * check if the digitSum is present in map
	 * 	yes->get the value of the digitSum and add to the current number
	 * 		 check if the sum is greater than maxSum then
	 * 			yes-> update maxSum with this sum
	 * 				  check the currentNum is greater than map num
	 * 					yes-> update the map with this sum and num
	 * 			no-> do nothing
	 * no->just add the digitSum as key and number as value
	 * 
	 * return maxSum
	 * 
	 * timeComplexity - O(n*m) digitSum loops at max 10 times, neglecting it we got O(n)
	 * space complexity - O(n)
	 * 6,42
	 * maxsum = 42+33 = 75
	 * 42<33 
	 * 
	 * 
	 */

	private int sumOfDigits(int[] input) {
		//traverse the input array
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int maximumSum = -1;
		for (int i = 0; i < input.length; i++) {
			//find the sum of digits
			//check if the map contains the digitSum
			int digitSum = sumOfDigits(input[i]);
			if(hm.containsKey(digitSum)) {
				maximumSum = Math.max(hm.get(digitSum)+input[i], maximumSum);
				//update the num that is greater to the corresponding digitSum
				if(input[i]>hm.get(digitSum)) hm.put(digitSum, input[i]);
			}else hm.put(digitSum,input[i]);

		}
		return maximumSum;
	}

	public int sumOfDigits(int n) {
		int digitSum = 0;
		while(n>0) {
			digitSum += n%10;
			n = n/10;
		}
		return digitSum;
	}

	/*
	 * Pseudo code
	 * Create a hash map
	 * Traverse through the array
	 *         Find sum of the digits of each element
	 *         Add the sum as key and add/update the values[store it as a list]
	 * Initialize max as -1
	 * Traverse through the map
	 *         For each entry, if the list size is greater than 1
	 *             Sort the list
	 *             Find max between max & sum of last 2 elements
	 *  Return max
	 */

	private int findEqualSum(int[] arr) { //51,71,17,42
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < arr.length; i++) {
			int sum = 0, n = arr[i];
			List<Integer> list = new ArrayList<Integer>();
			while(n > 0) {
				sum += n%10;
				n = n/10;
			}
			if(map.containsKey(sum)) {
				list.addAll(map.get(sum));
				list.add(arr[i]);
				map.put(sum, list);
			}
			else {
				list.add(arr[i]);   //51
				map.put(sum, list);   //6, [51], 8 [71]
			}
		}
		int max = -1;

		for(Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = new ArrayList<Integer>();
			list.addAll(entry.getValue());
			if(list.size() > 1) {
				Collections.sort(list);
				max = Math.max(max, list.get(list.size()-1) + list.get(list.size()-2));
			}
		}
		return max;
	}

}
