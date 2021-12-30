package twopointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MoveZeroes {

	//@Test
	public void test1() {
		int[] nums = {0,1,0,3,12};
		Assert.assertTrue(Arrays.equals(new int[] {1,3,12,0,0}, moveZeroes(nums)));
	}

	@Test
	public void test2() {
		int[] nums1 = {0};
		int m = 0;
		int[] nums2 = {1};
		int n = 1;
		mergeSort(nums1, m, nums2, n);
	}
	 public int[] moveZeroes(int[] nums) {
	        int left = 0;
	        for(int right = 0;right<nums.length;right++){
	            if(nums[left] == 0 && nums[right] != 0){
	                int temp = nums[right];
	                nums[right] = nums[left];
	                nums[left++] = temp;
	            }else if(nums[left] != 0) left++;   
	        }
	        System.out.println(Arrays.toString(nums));
	        return nums;
	    }
	 
	 public void mergeSort(int[] nums1, int m, int[] nums2, int n) {
		//declare an output
	        //if(n == 0) return nums1;
	        if(m == 0) nums1 = nums2;
	        //declare two pointers left at m and right at n
	        int left = m-1, right = n-1, k=(m+n)-1;
	        while(m != 0 && n != 0 && left>=0 && right>=0){
	            if(nums1[left]>nums2[right]) nums1[k--] = nums1[left--];
	            else nums1[k--] = nums2[right--];
	        }
	        System.out.println(Arrays.toString(nums1));
	 }
}
