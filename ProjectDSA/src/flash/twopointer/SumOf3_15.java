package flash.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SumOf3_15 {

	@Test
	public void test1() {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,-1,-1,0};
		System.out.println(threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		//two pointer - the array has to be sorted for 2 pointers
		//sort the array in ascending
		//iterate the array to get the x value from - to 0
		//if y+Z	plus x	equal to 0	triplet found
		//
		//if y+Z	less than abs(x) increment x
		//if y+Z	greater than abs(x)	decrement z

		Arrays.sort(nums);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for(int i  = 0;i<nums.length-2;i++){
			if(nums[i]>0) break;
			if(i == 0 || i>0 && nums[i] != nums[i-1]) {
				int left  = i+1, right = nums.length-1;
				while(left<right){
					int value = nums[left]+nums[right]; 
					if(nums[i]+value == 0) {
						output.add(Arrays.asList(nums[i], nums[left], nums[right]));

						while(left<right && nums[left] == nums[left+1]) left++;
						while(left<right && nums[right] == nums[right-1]) right--;
						left++;
						right--;
					}else if(nums[i]+value < 0) left++;
					else right--;
				}
			}
		}
		return output;
	}

}
