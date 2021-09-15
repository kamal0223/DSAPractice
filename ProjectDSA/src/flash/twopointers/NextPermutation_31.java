package flash.twopointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


//https://leetcode.com/problems/next-permutation/
public class NextPermutation_31 {
	
	@Test
	public void test1() {
		int[] nums = {1,3,2};
		nextPermutation(nums);
		//Assert.assertTrue(Arrays.equals(new int[] {1,3,2}, nextPermutation(nums)));
	}
	
	@Test
	public void test2() {
		int[] nums = {2,3,1,3,3};
		nextPermutation(nums);
		//Assert.assertTrue(Arrays.equals(new int[] {1,3,2}, nextPermutation(nums)));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,1,5};
		nextPermutation(nums);
		//Assert.assertTrue(Arrays.equals(new int[] {1,3,2}, nextPermutation(nums)));
	}
	@Test
	public void test4() {
		int[] nums = {1};
		nextPermutation(nums);
		//Assert.assertTrue(Arrays.equals(new int[] {1,3,2}, nextPermutation(nums)));
	}

	/*
int k = 0
int output = -1
check if the left<right
yes->int temp  = left+1
     int prevMin = Integer.max
     traverse from temp to right till temp reaches end of array
       tempvalue > valueATleft and tempValue<prevMin 
       prevMin = tempValue
       prevMinIndex = temp_index
     swap leftvalue and tempindexvalue

     sort the array after left
     using arrays.copyof get the array to another array
     sort the new array
     K++
     check k == given k
	output = nums
no->no if left>right->move left-- 


no if left>right->move left-- 
	 */
	private void nextPermutation(int[] nums) {
		int lastIndex = nums.length-1;
		boolean isMaxPermutation = true;
		int left = lastIndex-1, right = lastIndex;
		while(left>=0) {
			if(nums[left]<nums[right]) {
				int prevMin = Integer.MAX_VALUE;
				int temp = left+1, prevMinIndex = -1;
				for (int i = temp; i < nums.length; i++) {
					if(nums[i]>nums[left] && nums[i]<=prevMin) {
						prevMin = nums[i];
						prevMinIndex = i;
					}
				}
				//swap left index and prevIndex
				int swapper = nums[left];
				nums[left] = nums[prevMinIndex];
				nums[prevMinIndex] = swapper;
				//revese the elements after left index
				reverse(nums,left+1);
				isMaxPermutation = false;
				break;
			} else {
				left--;
				right--;
			}
		}
		 if(isMaxPermutation) reverse(nums,0);
		 System.out.println(Arrays.toString(nums));
	}
	
	int[] reverse(int[] nums,int start) {
		int left = start, right = nums.length-1;
		while(left<right) {
			int temp = nums[left];
			nums[left++] = nums[right];
			nums[right--] = temp;
		}
		return nums;
	}
	

}
