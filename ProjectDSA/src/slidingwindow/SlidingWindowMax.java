package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SlidingWindowMax {
	
	@Test
	public void test1() {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		Assert.assertTrue(Arrays.equals(new int[] {3,3,5,5,6,7}, slidingWindow(nums, k)));
	}

	@Test
	public void test2() {
		int[] nums = {1,-1};
		int k = 1;
		Assert.assertTrue(Arrays.equals(new int[] {1,-1}, slidingWindow(nums, k)));
	}
	
	@Test
	public void test3() {
		int[] nums = {4,-2};
		int k = 2;
		Assert.assertTrue(Arrays.equals(new int[] {4}, slidingWindow(nums, k)));
	}
	private int[] slidingWindow(int[] nums, int k) {
		//add the first k elements in arraylist by iterating till k
        //find max and add it to the nums at 0 index
        //iterate the nums from second index till nums lenght-k
        //remove i-1 element form the list
        //add the i+k-1 element to the list
        //find the max from the list and add it nums at index i
		
		List<Integer> window = new ArrayList<Integer>();
		for(int i =0;i<k;i++) {
			window.add(nums[i]);
		}
		nums[0] = Collections.max(window);
		
		for(int i =1;i<=nums.length-k;i++) {
			window.remove(0);
			window.add(nums[i+k-1]);
			nums[i] = Collections.max(window);
		}
		
		return Arrays.copyOf(nums, nums.length-k+1);
	}

}
