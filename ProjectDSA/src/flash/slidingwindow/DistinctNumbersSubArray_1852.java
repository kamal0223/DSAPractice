package flash.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
Given an integer array nums and an integer k, you are asked to construct the array ans of size n-k+1 where ans[i] is the number of distinct numbers in the subarray nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]].

Return the array ans.
 */
public class DistinctNumbersSubArray_1852 {
	
	@Test
	public void test1() {
		int[] nums = {1,2,3,2,2,1,3};
		int k = 3;
		Assert.assertArrayEquals(new int[] {3,2,2,2,3},distinctSubOptimized(nums,k));
		
	}

	@Test
	public void test2() {
		int[] nums = {1,1,1,1,2,3,4};
		int k = 4;
		Assert.assertArrayEquals(new int[] {1,2,3,4},distinctSubOptimized(nums,k));
	}

	/*
	 * brute force
	 * time complexity = O(n^3) and space - O(n)
	 */
	private int[] distinctNumberSubArray(int[] nums, int k) {
		int output[] = new int[nums.length-k+1];
		int a = 0;
		for (int i = 0; i <= nums.length-k; i++) {
			int count = 0;
			for (int j = i; j <= i+k-1; j++) {
				boolean notDistinct = false;
				for (int k1 = j+1; k1 <= i+k-1; k1++) {
					if(nums[j]==nums[k1]) {
						notDistinct = true;
						break;
					}
				}
				if(!notDistinct) count++;
			}
			output[a++] = count;
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
	/*
	 * 8.33 using set
	 * time complexity - O(n^2) and space complexity = O(1)
	 * 
	 */
	private int[] distinctSub(int[] nums, int k) {
		for (int i = 0; i <= nums.length-k; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int j = i; j < i+k; j++) {
				set.add(nums[j]);
			}
			nums[i] = set.size();
		}
		//copy the nums till nums.length-k+1
		int[] arr = Arrays.copyOf(nums, nums.length-k+1);
		System.err.println(Arrays.toString(arr));
		return arr;
	}
	/*
	 * declare a hashmap as key in eachnum, value in occurence
	 * Iterate k times and get the occurence of each element from nums
	 * after the loop find the size of map and update it in nums 0th index
	 * Iterate nums starting from k till nums length
	 *  decrement the i-k index element from map
	 *  if check if that element value is 0 then remove it
	 *  add the kth index element occurence to map
	 *  get the size of map and update i-k th element index 
	 */
	private int[] distinctSubOptimized(int[] nums, int k) {
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int[] output = new int[nums.length-k+1];
		for (int i = 0; i < k; i++) {
			hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
		}
		int prev = nums[0];
		nums[0] = hm.size();
		
		for (int i = k; i < nums.length; i++) {
			hm.put(prev, hm.get(prev)-1);
			if(hm.get(prev) == 0) hm.remove(prev);
			hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
			prev = nums[i-k+1];
			nums[i-k+1] = hm.size();
		}
		System.out.println(Arrays.toString(Arrays.copyOf(nums, nums.length-k+1)));
		return Arrays.copyOf(nums, nums.length-k+1);
	}
}
