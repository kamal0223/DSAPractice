package flash.twopointers;

import java.util.Arrays;

import org.junit.Test;

/*
Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */

public class RemoveDuplicatesSortedArr_80 {
	
	@Test
	public void test1() {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {1};
		System.out.println(removeDuplicates(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {-3,-3,-3,-1,-1,0,2,2,2,5};
		System.out.println(removeDuplicates(nums));
	}
	
	 //start time - 23.00 endtime - 23.35
    /*declare count as 0
    declare left and right at 0
    iterate till right is less than nums length
    if the value at left is equal to right
    yes->
        increment count
        check if the count is greater than 2
        yes->
            make the value at right to 100001 and get the count of duplicates
        no-> do nothing
        increment right
    No->
        left = right
        count = 0
    sort the array in natural order
    return nums lenght - duplicatesCount
    */

	private int removeDuplicates(int[] nums) {
		int count = 0, duplicatesCount = 0;
        int left = 0, right = 0;
        while(right<nums.length){
            if(nums[left] == nums[right]){
                count++;
                if(count>2){
                    nums[right] = 100001;
                    duplicatesCount++;
                }
                right++;
            } else {
                left = right;
                count = 0;
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums.length-duplicatesCount;
	}

}
