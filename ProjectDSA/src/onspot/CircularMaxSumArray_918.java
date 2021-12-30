package onspot;

import org.junit.Assert;
import org.junit.Test;

public class CircularMaxSumArray_918 {

	@Test
	public void test1() {
		int[] nums = {-2,-3,-1};
		Assert.assertEquals(-1, maxSumSubArray(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {5,-3,5};
		Assert.assertEquals(10, maxSumSubArray(nums));
	}

	private int maxSumSubArray(int[] nums) {
		int n = nums.length;

		int windowSum = nums[0], maxSum = nums[0];
		//iterate the array
		for(int i = 1;i<nums.length;i++){
			//max/ min,  totalSum
			windowSum = Math.max(nums[i],windowSum+nums[i]);  //1,-1,3, 3,
			maxSum = Math.max(windowSum,maxSum);   //1, 1, ,3,3,3
		}
		windowSum = nums[0]+windowSum;
		maxSum = Math.max(windowSum,maxSum); 
		return maxSum;
	}

}
