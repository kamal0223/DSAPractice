package fullweek.onsite;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.junit.Test;

//Given an array of integers and a k value. Find the max subarray that is less than k
public class MaxSubArrayLessThanK {
	
	@Test
	public void test1() {
		int[] input = {1,-7,-4,2,8,-11,3};
		int k = 16;
		System.out.println(Arrays.toString(maxSubArrayLessThanK2(input, k)));
	}
	
	@Test
	public void test2() {
		int[] input = {1,15,2,11,3};
		int k = 16;
		System.out.println(Arrays.toString(maxSubArrayLessThanK2(input, k)));
	}
	
	private int[] maxSubArrayLessThanK(int[] input, int k) {
		
		int previsouSum = 0;
		int left = -1, right = -1;
		for(int i = 0;i<input.length-1;i++) {
			int sum = input[i];
			for(int j = i+1;j<input.length;j++) {
				sum = sum+input[j];
				if(sum<k && sum>previsouSum) {
					previsouSum = sum;
					left = i;
					right = j;
				}
			}
		}
		
		return Arrays.copyOfRange(input, left, right+1);
	}
	
	/*
	 * kandane algo
	 * declare windowSum, maxSum
	 * Traverse the input array from left to right with variable i
	 * update windowSum by adding value at i index
	 * get the max of current value and windowSum
	 * get the max of widowSum and maxSum
	 * 
	 * return maxSum
	 */
	private int[] maxSubArrayLessThanK2(int[] input, int k) {
		int windowSum = input[0], maxSum = input[0];
		int left = 0, right = 0;
		for (int i = 1; i < input.length; i++) {
			if(windowSum+input[i]<k && windowSum+input[i]>=input[i]) {
				windowSum = windowSum+input[i];
				if(windowSum>maxSum) {
					maxSum = windowSum;
					right = i;
				}
			}
			Collections.sort(null);
			else if(input[i]<k && windowSum+input[i]<=input[i]) {
				windowSum = input[i];
				if(windowSum>maxSum) {
					maxSum = windowSum;
					left = i;
				}
			}
			//windowSum = Math.max(windowSum+input[i], input[i]);

		}
		System.out.println("left "+left+" "+"right "+right);
		System.out.println(maxSum);
		return new int[] {};
		
	}

}
