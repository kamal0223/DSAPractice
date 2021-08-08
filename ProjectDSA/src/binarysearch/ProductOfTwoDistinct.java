package binarysearch;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

//Given a Integer array and a target value, find the closest product of 2 distinct numbers, that matches the target

/*Input: int[] input, int target
Output: int product
constraints: time complexity should be O(logn)


TestData set: Positive
			  Negative
			  Edge
Approaches Known: brute force and binary search
*/
public class ProductOfTwoDistinct {
	
	
	@Test
	public void test1() {
		int[] input = {1,2,3,4};
		int target = 4;
		Assert.assertEquals(3, usingBinarySearch(input, target));
		
	}
	
	@Test
	public void test2() {
		int[] input = {6,2,3,1,4,3};
		int target = 10;
		Assert.assertEquals(12, usingBinarySearch(input, target));
		
	}
	
	@Test
	public void test3() {
		int[] input = {2,2,2,2};
		int target = 4;
		Assert.assertEquals(-1, usingBinarySearch(input, target));
	}
	
	@Test
	public void test4() {
		int[] input = {};
		int target = 4;
		Assert.assertEquals(-1, usingBinarySearch(input, target));
	}
	
	/*
	 * case1: if there is exact match than return that

case2: if product is less than target
	if distance<previousdistance
		previousdistance = distance
		closestProduct = currentProd
case3: if product is greater than target
	if distance<previousdistance
		previousdistance = distance
		closestProduct = currentProd
	
	*/
	private int usingBruteForce(int[] input, int target) {
		
		
		int closestGreaterProd = Integer.MAX_VALUE;
		int closestLowerProd = -1;
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				if(input[i]!=input[j]) {
					int currentProduct = input[i]*input[j];
					if(currentProduct<target) {
						closestLowerProd = Integer.max(closestLowerProd, currentProduct);
					}
					if(currentProduct>target) {
						closestGreaterProd = Integer.min(closestGreaterProd, currentProduct);
						}
					}
			}
		}
		//find the difference between target and closestLowerProd
		//find the diff between target and closestGreaterProd
		//which ever diff is small retrun that prod
		if(target-closestLowerProd > closestGreaterProd-target) return closestGreaterProd;
		else return closestLowerProd;
	}
	private int usingBinarySearch(int[] input, int target) {
		//sort the array 
		/*
		 * sort the array 
		 * declare left at 0 and right at last element
		 * declare previousDiff = max of integer
		 * iterate till the left is less than right
		 * product the element at left and right
		 * check if product > target then move right--
		 * check if product < target then move left++
		 * find the difference of right-left
		 * if diff is 0 then continue
		 * if(diff<previousDiff) previousDiff = absDiff
		 * return previousDiff
		 */
		Arrays.sort(input);
		int left = 0, right = input.length-1;
		int previousDiff = Integer.MAX_VALUE;
		int closestNum = -1;
		while (left<right) {
			if(input[left]!=input[right]) {
			int product  = input[left]*input[right];
			if(product>=target) right--;
			else left++;
			int absDiff = Math.abs(product-target);
			if(absDiff == 0) continue;
			if(absDiff<previousDiff) {
				closestNum = product;
				previousDiff= absDiff;
			}
			}else {
				right--;
			}
		}
		
		return closestNum;
	}
}
