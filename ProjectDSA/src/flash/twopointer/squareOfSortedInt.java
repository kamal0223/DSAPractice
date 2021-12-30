package flash.twopointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class squareOfSortedInt {
	
	@Test
	public void test1() {
		int[] nums = {-4,-1,0,3,10};
		Assert.assertTrue(Arrays.equals(new int[] {0,1,9,16,100}, squareOfSorted(nums)));
	}
	
	@Test
	public void test2() {
		int[] nums = {-2,-2};
		Assert.assertTrue(Arrays.equals(new int[] {4,4}, squareOfSorted(nums)));
	}

	private int[] squareOfSorted(int[] nums) {
		//declare an output array of same size as input
        //Traverse the array from left to right with index i
		//update nums with square of each
		//delcare left at 0 and right at end of array
		//declare k as last index of nums
        //iterate till left<=right
        //check if(leftValue<rightValue) add the right value to output_last & decrement right pointer
        //check if(leftValue>=rightValue) add the left value to output_last & increment left pointer
		//return output
		
       
        
        
        int[] output = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        int left = 0, right=nums.length-1, k = nums.length-1;
        while(left<=right){
            if(nums[left]<nums[right]) output[k--] = nums[right--];
            else  output[k--] = nums[left++];
        }
        return output;
	}
	
	/*
	 *In onepass two pointer
	 *declare k as last index of nums
	 *declare two pointer left at 0 and right at end
	 *declare output array of same size as nums
	 *iterate till left<=right
	  check if(abs.leftValue<abs.rightValue) add the square of right value to output_last & decrement right pointer
        //check if(leftValue>=rightValue) add the square of left value to output_last & increment left pointer
		//return output
	 * for each element get the abs
       traverse the array from the element to end with indexj
       check if the abs value of i is greater than or equal
         yes-> add the square of this value at i in output[j-1] and break inner loop 
	 */
	
	private int[] squareOfSortedOptimized(int[] nums) {
		
		int[] output = new int[nums.length];
		int left = 0, right = nums.length-1, k = nums.length-1;
		while (left<=right) {
			if(Math.abs(nums[left])<Math.abs(nums[right])) output[k--] = (int) Math.pow(nums[right--], 2);
			else output[k--] = (int) Math.pow(nums[left++], 2);
		}
		
		
		return output;
	}
}
