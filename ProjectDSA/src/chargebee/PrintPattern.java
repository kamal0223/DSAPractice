package chargebee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PrintPattern {

	@Test
	public void test() {
		int[] nums = {3,2,4};
		int target = 6;
		System.out.println(Arrays.toString(twoSum(nums, target)));
		
	}

	/*
	 * using hashmap
	 * iterate the array
	 * check if target-each element is present in array
	 * yes->pair found return new int with value of get(target-each), currentIndex
	 * no-> add the element in 
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(hm.containsKey(target-nums[i])) {
				return new int[] {hm.get(target-nums[i]),i};
			}else hm.put(nums[i], i);
			
		}
		return new int[] {-1,-1};
	}
}
