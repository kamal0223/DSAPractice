package binarysearch;

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
		Assert.assertEquals(3, usingBruteForce(input, target));
		
	}
	
	@Test
	public void test2() {
		int[] input = {6,2,3,1,4,3};
		int target = 10;
		Assert.assertEquals(12, usingBruteForce(input, target));
		
	}
	
	@Test
	public void test3() {
		int[] input = {2,2,2,2};
		int target = 4;
		Assert.assertEquals(-1, usingBruteForce(input, target));
		
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
		
		
		int previousDistance = 0;
		int closestProduct = 0;
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if(i!=j) {
					int currentDistance = 0;
					int currentProduct = -1; 
					currentProduct = input[i]*input[j];
					if(currentProduct == target) return currentProduct;
					if(currentProduct<target) {
						targ
						if(previousDistance)
					}
					
				}
			}
		}
		
		return null;
	}

}
