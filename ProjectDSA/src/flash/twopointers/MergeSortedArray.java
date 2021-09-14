package flash.twopointers;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortedArray {
	
	@Test
	public void test1() {
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int n = 3;
		int[] nums2 = {2,5,6};
		System.out.println(Arrays.toString(merge(nums1,m,nums2,n)));
	}
	
	@Test
	public void test2() {
		int[] nums1 = {1};
		int m = 1;
		int n = 0;
		int[] nums2 = {};
		System.out.println(Arrays.toString(merge(nums1,m,nums2,n)));
	}
	
	@Test
	public void test3() {
		int[] nums1 = {0};
		int m = 0;
		int n = 1;
		int[] nums2 = {1};
		System.out.println(Arrays.toString(merge(nums1,m,nums2,n)));
	}
	
	
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        //using two pointers
        //start time - 8.25
        
        //copy nums2 to nums1 to the 0 in nums1
        //declare pointer left at m-1 and right at n-1 and k at m+n-1
        //if m is 0 then return nums2
        //if n is 0 then return nums1
        //iterate till left or right less than 0
        //check if value at left > value at right 
        //yes-> add the value at left to nums1 at index k and left--
        //no-> add the value at right to nums1 at index k and right--
        
		
        for(int i = m;i<m+n;i++){
        	if(m!=0) nums1[i] = nums2[i-n];
        	else nums1 = nums2;
        }
        int left = m-1, right = (m+n)-1;
        while(left<right && left>=0){
            if(nums1[left]>nums1[right]){
                int temp  = nums1[left];
                nums1[left--] = nums1[right];
                nums1[right] = temp;
            } 
            else right--;
        }
	return nums1;	
    }

}
