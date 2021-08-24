package onspot;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an integer array nums and an integer k, return true if nums has a continuous 
subarray of size at least two whose elements sum up to a multiple of k, or false otherwise. 
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 */
public class IsSubArraySumMultipleOfK {

	@Test
	public void test1() {
		int[] nums = {23,7,4,6,7};
		//map = 5,0 and 2,1 and  
		int k = 6;
		Assert.assertTrue(isSumMultiple(nums, k));
	}
	
	//23,2,6,4,7
	@Test
	public void test2() {
		int[] nums = {23,2,4,6,7};
		int k = 13;
		Assert.assertTrue(isSumMultiple(nums, k));
}
	
	@Test
	public void test3() {
		int[] nums = {23,2,6,4,7};
		int k = 13;
		Assert.assertFalse(isSumMultiple(nums, k));
}

	private boolean isSumMultiple(int[] nums, int k) {
		//declare a map of Integer, Integer
		//iterate the input array
		//add the element with previousRemainder and if it is divisible by k return true
		//get the remainder of element and add it to the map with index 
		//check if the remainder is present as key then retrun true
		//if remainder is present check the index is greater than 1 return true
		
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int previousRemainder = 0;
		for (int i = 0; i < nums.length; i++) {
			//find sum of current with next element
			int remainder = nums[i]%k;
			if((nums[i]+previousRemainder)%k == 0) return true;
			else if(remainder == previousRemainder && hm.get(remainder)>1) return true;
			previousRemainder = remainder;
			hm.put(remainder, i);
		}
		
		return false;
	}
}
