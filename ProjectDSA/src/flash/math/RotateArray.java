package flash.math;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {
	
	@Test
	public void test1() {
		int[]  nums = {1,3,5,7,9};
		int k = 2;
		System.out.println(Arrays.toString(rotateArrayUsingQueue(nums, k)));
		Assert.assertTrue(Arrays.equals(new int[] {7,9,1,3,5}, rotateArrayUsingQueue(nums, k)));
	}
	
	@Test
	public void test2() {
		int[]  nums = {1,2,3,4,5,6,7};
		int k = 2;
		System.out.println(Arrays.toString(rotateArrayUsingQueue(nums, k)));
		Assert.assertTrue(Arrays.equals(new int[] {6,7,1,2,3,4,5}, rotateArrayUsingQueue(nums, k)));
		
	}
	

	private int[] rotateArray(int[] nums, int k) {
		 k = k%nums.length;
	        int[] output = new int[nums.length];
	        for(int i = 0;i<nums.length;i++){
	            if(i<k){
	                output[i] = nums[nums.length+i-k];
	            }else {
	                output[i] = nums[i-k];
	            }
	        }
	        
	        return output;
	}
	
	 public void rotate(int[] nums, int k) {
	        k = k%nums.length;
	        //find the number of arbitrary number of rotations
	        reverse(nums, 0, nums.length-1);
	        reverse(nums, 0, k-1);
	        reverse(nums, k, nums.length-1);
	    }
	    
	    public void reverse(int[] nums, int start, int end){
	        //reverse using 2 pointer
	        while(start<end){
	            int temp = nums[start];
	            nums[start++] = nums[end];
	            nums[end--] = temp;
	        }
	    }

}
