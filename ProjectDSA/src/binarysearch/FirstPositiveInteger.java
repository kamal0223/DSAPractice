package binarysearch;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/first-missing-positive/


public class FirstPositiveInteger {

	@Test
	public void test1() {
		int[] nums = {1,2,0};
		Assert.assertEquals(3, firstMissingPositive(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {3,4,-1,1};
		Assert.assertEquals(2, firstMissingPositive(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {0,2,2,1,1};
		Assert.assertEquals(3, firstMissingPositive(nums));
	}
	
	@Test
	public void test4() {
		int[] nums = {3,6,-1,0};
		Assert.assertEquals(1, firstMissingPositive(nums));
	}
	
	@Test
	public void test5() {
		int[] nums = {0,-1,3,1};
		Assert.assertEquals(2, firstMissingPositive(nums));
	}
	
	
	//O(n) - time and O(n)
	public int usingBruteForc(int[] nums) {
		//-1, 0, 3, 6
		
		Arrays.sort(nums);
		List<Integer> ali = new ArrayList<Integer>();
		//Set<Integer> set = new LinkedHashSet<Integer>();
		//remove the negative numbers
		for(int i = 0;i<nums.length;i++) {
			if(nums[i]>0) {
				ali.add(nums[i]);
			}
		}
		if(ali.size() == 0) return 1;
		else if(ali.get(0)>1) return 1; 
		
		for(int i = 0;i<ali.size()-1;i++){
			if(ali.get(i)>=0){
				if((ali.get(i+1))-ali.get(i) == 1 || ali.get(i+1)-ali.get(i) == 0) continue;
				else return ali.get(i)+1;
			}
		}

		return nums[nums.length-1]+1;
        
        //if the missing element is before th first least number
        //if the missing element is after the greatest number
        //check if the smallest integer is 1 apart from 0 then return 1
        //get the largest integer and get the 
	}
	
	public int usingBinarySearch(int[] nums) {
		
		/*
		 * sort the array 
		 * declare two pointers low and high
		 * iterate the array till low crosses high
		 *  if the value at mid-mid(index) not equal to zero, there are missing elements at left
		 *  	so move high = mid-1
		 *  if the value at mid - mid equal to zero, there are missing elements at right
		 *  	so move low = mid+1
		 *  
		 */

		List<Integer> ali =  new ArrayList<Integer>();
		Collections.min(ali);
		Collections.max(ali);
		int[] arr = new int[12];
		return 0;
		
	}
	
	 public int firstMissingPositive(int[] nums) {
	        //iterate the array and find the max value in that array
	        //declare an array of size max value with initial values filled with 0
	        //iterate the nums
	        //if current value is positive
	        //   pick currentnums value as index there make it as 1
	        
	        //iterate the array from 1
	        //if value at i is 0 then return that index
	        
	        int max = 0;
	        for(int i = 0;i<nums.length;i++){
	            if(nums[i]>max) max = nums[i];
	        }
	        int[] arr = new int[max];
	         for(int i = 0;i<nums.length;i++){
	             if(nums[i]>0){
	                 arr[nums[i]-1] = 1;
	             }
	         }
	        for(int i = 0;i<arr.length;i++){
	            if(arr[i] == 0) return i+1;
	        }
	        return max+1;
	    }
	
}
